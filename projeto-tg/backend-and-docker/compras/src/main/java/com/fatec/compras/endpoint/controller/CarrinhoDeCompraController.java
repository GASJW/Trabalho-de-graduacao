package com.fatec.compras.endpoint.controller;

import com.fatec.compras.endpoint.exception.RecursoNaoEncontradoException;
import com.fatec.compras.endpoint.model.CarrinhoDeCompra;
import com.fatec.compras.endpoint.service.CarrinhoDeCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoDeCompraController {
    @Autowired
    private CarrinhoDeCompraService carrinhoDeCompraService;

    @GetMapping
    public List<CarrinhoDeCompra> listar(){
        return carrinhoDeCompraService.listar();
    }

    @GetMapping("/{id}")
    public CarrinhoDeCompra buscar(@PathVariable Long id){
        try{
            return carrinhoDeCompraService.buscarPorId(id);
        }catch (RecursoNaoEncontradoException exc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrinho de Compras não encontrado!", exc);
        }
    }

    @GetMapping("/atualizar/{id}")
    public CarrinhoDeCompra atualizar(@PathVariable Long id){
        try{
            return carrinhoDeCompraService.atualizar(id);
        }catch (RecursoNaoEncontradoException exc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrinho de Compras não encontrado!", exc);
        }
    }

    @PostMapping
    public CarrinhoDeCompra salvar(@RequestBody CarrinhoDeCompra carrinhoDeCompra){
        return carrinhoDeCompraService.salvar(carrinhoDeCompra);
    }

    @DeleteMapping("/{id}")
    public CarrinhoDeCompra excluir(@PathVariable Long id){
        try{
            return carrinhoDeCompraService.excluir(id);
        }catch (RecursoNaoEncontradoException exc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carrinho de Compras não encontrado!", exc);
        }
    }

    @PutMapping
    public CarrinhoDeCompra editar(@RequestBody CarrinhoDeCompra carrinhoDeCompra){
        return carrinhoDeCompraService.editar(carrinhoDeCompra);
    }
}
