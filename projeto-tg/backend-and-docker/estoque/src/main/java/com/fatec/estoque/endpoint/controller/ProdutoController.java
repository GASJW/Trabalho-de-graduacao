package com.fatec.estoque.endpoint.controller;

import com.fatec.estoque.endpoint.exception.RecursoNaoEncontradoException;
import com.fatec.estoque.endpoint.model.Produto;
import com.fatec.estoque.endpoint.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listar(){

        return produtoService.listar();
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id){
        try{
            return produtoService.buscarPorId(id);
        }catch (RecursoNaoEncontradoException exc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!", exc);
        }
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){

        return produtoService.salvar(produto);
    }

    @DeleteMapping("/{id}")
    public Produto excluir(@PathVariable Long id){
        try{
            return produtoService.excluir(id);
        }catch (RecursoNaoEncontradoException exc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!", exc);
        }
    }

    @PutMapping
    public Produto editar(@RequestBody Produto produto){

        return produtoService.editar(produto);
    }
}
