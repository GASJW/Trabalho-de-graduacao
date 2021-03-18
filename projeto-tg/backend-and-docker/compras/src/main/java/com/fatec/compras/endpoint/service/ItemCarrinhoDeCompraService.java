package com.fatec.compras.endpoint.service;

import com.fatec.compras.endpoint.exception.RecursoNaoEncontradoException;
import com.fatec.compras.endpoint.model.CarrinhoDeCompra;
import com.fatec.compras.endpoint.model.ItemCarrinhoDeCompra;
import com.fatec.compras.endpoint.repository.CarrinhoDeCompraRepository;
import com.fatec.compras.endpoint.repository.ItemCarrinhoDeCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemCarrinhoDeCompraService {

    @Autowired
    private ItemCarrinhoDeCompraRepository itemCarrinhoDeCompraRepository;

    @Autowired
    private CarrinhoDeCompraService carrinhoDeCompraService;

    public ItemCarrinhoDeCompra buscarPorId(Long id){
        Optional<ItemCarrinhoDeCompra> itemCarrinhoDeCompra = itemCarrinhoDeCompraRepository.findById(id);
        if(itemCarrinhoDeCompra.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        return itemCarrinhoDeCompra.get();
    }

    public List<ItemCarrinhoDeCompra> listar(){

        return itemCarrinhoDeCompraRepository.findAll();
    }

    public ItemCarrinhoDeCompra salvar(ItemCarrinhoDeCompra itemCarrinhoDeCompra){
        ItemCarrinhoDeCompra item = itemCarrinhoDeCompraRepository.save(itemCarrinhoDeCompra);
        carrinhoDeCompraService.atualizar(item.getCarrinhoDeCompra().getId());
        return item;
    }

    public ItemCarrinhoDeCompra excluir(Long id){
        Optional<ItemCarrinhoDeCompra> itemCarrinhoDeCompra = itemCarrinhoDeCompraRepository.findById(id);
        if(itemCarrinhoDeCompra.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        itemCarrinhoDeCompraRepository.delete(itemCarrinhoDeCompra.get());
        carrinhoDeCompraService.atualizar(itemCarrinhoDeCompra.get().getCarrinhoDeCompra().getId());
        return itemCarrinhoDeCompra.get();
    }

    public ItemCarrinhoDeCompra editar(ItemCarrinhoDeCompra itemCarrinhoDeCompra){

        ItemCarrinhoDeCompra item = itemCarrinhoDeCompraRepository.save(itemCarrinhoDeCompra);
        carrinhoDeCompraService.atualizar(item.getCarrinhoDeCompra().getId());
        return item;
    }
}
