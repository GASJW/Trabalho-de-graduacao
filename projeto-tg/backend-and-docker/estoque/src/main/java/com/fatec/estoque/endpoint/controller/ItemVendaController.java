package com.fatec.estoque.endpoint.controller;

import com.fatec.estoque.endpoint.exception.IndisponivelException;
import com.fatec.estoque.endpoint.exception.RecursoNaoEncontradoException;
import com.fatec.estoque.endpoint.model.ItemVenda;
import com.fatec.estoque.endpoint.service.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/item-vendas")
public class ItemVendaController {
    @Autowired
    private ItemVendaService itemVendaService;

    @GetMapping
    public List<ItemVenda> listar(){

        return itemVendaService.listar();
    }

    @GetMapping("/{id}")
    public ItemVenda buscar(@PathVariable Long id){
        try{
            return itemVendaService.buscarPorId(id);
        }catch (RecursoNaoEncontradoException exc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ItemVenda não encontrado!", exc);
        }
    }

    @PostMapping
    public ItemVenda salvar(@RequestBody ItemVenda itemVenda){
        try{
            return itemVendaService.salvar(itemVenda);
        }catch (IndisponivelException exc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quantidade de Produtos não disponível!", exc);
        }
    }

    @DeleteMapping("/{id}")
    public ItemVenda excluir(@PathVariable Long id){
        try{
            return itemVendaService.excluir(id);
        }catch (RecursoNaoEncontradoException exc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ItemVenda não encontrado!", exc);
        }
    }

    @PutMapping
    public ItemVenda editar(@RequestBody ItemVenda itemVenda){

        return itemVendaService.editar(itemVenda);
    }
}
