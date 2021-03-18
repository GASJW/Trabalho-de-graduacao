package com.fatec.compras.endpoint.controller;

import com.fatec.compras.endpoint.exception.RecursoNaoEncontradoException;
import com.fatec.compras.endpoint.model.ItemCarrinhoDeCompra;
import com.fatec.compras.endpoint.service.ItemCarrinhoDeCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/itens-carrinhos")
public class ItemCarrinhoDeCompraController {
    @Autowired
    private ItemCarrinhoDeCompraService itemCarrinhoDeCompraService;

    @GetMapping
    public List<ItemCarrinhoDeCompra> listar(){
        return itemCarrinhoDeCompraService.listar();
    }

    @GetMapping("/{id}")
    public ItemCarrinhoDeCompra buscar(@PathVariable Long id){
        try{
            return itemCarrinhoDeCompraService.buscarPorId(id);
        }catch (RecursoNaoEncontradoException exc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Carrinho de Compras não encontrado!", exc);
        }
    }

    @PostMapping
    public ItemCarrinhoDeCompra salvar(@RequestBody ItemCarrinhoDeCompra itemCarrinhoDeCompra){
        return itemCarrinhoDeCompraService.salvar(itemCarrinhoDeCompra);
    }

    @DeleteMapping("/{id}")
    public ItemCarrinhoDeCompra excluir(@PathVariable Long id){
        try{
            return itemCarrinhoDeCompraService.excluir(id);
        }catch (RecursoNaoEncontradoException exc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item Carrinho de Compras não encontrado!", exc);
        }
    }

    @PutMapping
    public ItemCarrinhoDeCompra editar(@RequestBody ItemCarrinhoDeCompra itemCarrinhoDeCompra){
        return itemCarrinhoDeCompraService.editar(itemCarrinhoDeCompra);
    }
}
