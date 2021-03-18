package com.fatec.estoque.endpoint.controller;

import com.fatec.estoque.endpoint.exception.RecursoNaoEncontradoException;
import com.fatec.estoque.endpoint.model.Venda;
import com.fatec.estoque.endpoint.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/vendas")
public class VendaController {
    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> listar(){

        return vendaService.listar();
    }

    @GetMapping("/{id}")
    public Venda buscar(@PathVariable Long id){
        try{
            return vendaService.buscarPorId(id);
        }catch (RecursoNaoEncontradoException exc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrada!", exc);
        }
    }

    @GetMapping("/atualizar/{id}")
    public Venda atualizar(@PathVariable Long id){
        try{
            return vendaService.atualizar(id);
        }catch (RecursoNaoEncontradoException exc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrada!", exc);
        }
    }

    @PostMapping
    public Venda salvar(@RequestBody Venda venda){

        return vendaService.salvar(venda);
    }

    @DeleteMapping("/{id}")
    public Venda excluir(@PathVariable Long id){
        try{
            return vendaService.excluir(id);
        }catch (RecursoNaoEncontradoException exc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrada!", exc);
        }
    }

    @PutMapping
    public Venda editar(@RequestBody Venda venda){

        return vendaService.editar(venda);
    }
}
