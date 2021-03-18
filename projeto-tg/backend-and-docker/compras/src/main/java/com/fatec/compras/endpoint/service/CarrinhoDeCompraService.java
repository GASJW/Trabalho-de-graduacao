package com.fatec.compras.endpoint.service;

import com.fatec.compras.endpoint.exception.RecursoNaoEncontradoException;
import com.fatec.compras.endpoint.model.CarrinhoDeCompra;
import com.fatec.compras.endpoint.model.ItemCarrinhoDeCompra;
import com.fatec.compras.endpoint.repository.CarrinhoDeCompraRepository;
import com.fatec.compras.endpoint.repository.ItemCarrinhoDeCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoDeCompraService {

    @Autowired
    private CarrinhoDeCompraRepository carrinhoDeCompraRepository;
    @Autowired
    private ItemCarrinhoDeCompraRepository itemCarrinhoDeCompraRepository;

    public CarrinhoDeCompra buscarPorId(Long id){
        Optional<CarrinhoDeCompra> carrinhoDeCompras = carrinhoDeCompraRepository.findById(id);
        if(carrinhoDeCompras.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        return carrinhoDeCompras.get();
    }

    public List<CarrinhoDeCompra> listar(){

        return carrinhoDeCompraRepository.findAll();
    }

    public CarrinhoDeCompra atualizar(Long id){
        Optional<CarrinhoDeCompra> carrinhoDeCompra = carrinhoDeCompraRepository.findById(id);
        if(carrinhoDeCompra.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        List<ItemCarrinhoDeCompra> itens = itemCarrinhoDeCompraRepository.findAll();
        Double valor = 0.0;

        for (ItemCarrinhoDeCompra item : itens){
            if(item.getCarrinhoDeCompra().getId()==id) {
                valor = valor + (Double.parseDouble(item.getValorParcial().toString())*item.getQuantidade());
            }
        }
        carrinhoDeCompra.get().setValorTotal(BigDecimal.valueOf(valor));
        return carrinhoDeCompraRepository.save(carrinhoDeCompra.get());
    }

    public CarrinhoDeCompra salvar(CarrinhoDeCompra carrinhoDeCompras){

        return carrinhoDeCompraRepository.save(carrinhoDeCompras);
    }

    public CarrinhoDeCompra excluir(Long id){
        Optional<CarrinhoDeCompra> carrinhoDeCompras = carrinhoDeCompraRepository.findById(id);
        if(carrinhoDeCompras.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        carrinhoDeCompraRepository.delete(carrinhoDeCompras.get());
        return carrinhoDeCompras.get();
    }

    public CarrinhoDeCompra editar(CarrinhoDeCompra carrinhoDeCompras){

        return carrinhoDeCompraRepository.save(carrinhoDeCompras);
    }
}
