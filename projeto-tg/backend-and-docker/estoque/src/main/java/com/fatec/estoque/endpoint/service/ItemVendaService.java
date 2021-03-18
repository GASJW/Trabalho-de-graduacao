package com.fatec.estoque.endpoint.service;

import com.fatec.estoque.endpoint.exception.IndisponivelException;
import com.fatec.estoque.endpoint.exception.RecursoNaoEncontradoException;
import com.fatec.estoque.endpoint.model.ItemVenda;
import com.fatec.estoque.endpoint.model.Produto;
import com.fatec.estoque.endpoint.repository.ItemVendaRepository;
import com.fatec.estoque.endpoint.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public ItemVenda buscarPorId(Long id){
        Optional<ItemVenda> itemVenda = itemVendaRepository.findById(id);
        if(itemVenda.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        return itemVenda.get();
    }

    public List<ItemVenda> listar(){
        return itemVendaRepository.findAll();
    }

    public ItemVenda salvar(ItemVenda itemVenda){
        List<Produto> produtos = produtoRepository.findAll();
        for (Produto produto : produtos){
            if(produto.getId() == itemVenda.getProduto().getId()){
                if(produto.getQuantidade() < itemVenda.getQuantidade()){
                    throw new IndisponivelException();
                }
                produto.setQuantidade((short) (produto.getQuantidade() - itemVenda.getQuantidade()));
                produtoRepository.save(produto);
            }
        }
        ItemVenda item = itemVendaRepository.save(itemVenda);
        return item;
    }

    public ItemVenda excluir(Long id){
        Optional<ItemVenda> itemVenda = itemVendaRepository.findById(id);
        if(itemVenda.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        itemVendaRepository.delete(itemVenda.get());
        return itemVenda.get();
    }

    public ItemVenda editar(ItemVenda itemVenda){

        return itemVendaRepository.save(itemVenda);
    }
}
