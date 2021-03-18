package com.fatec.compras.endpoint.controller;

import com.fatec.compras.endpoint.exception.RecursoNaoEncontradoException;
import com.fatec.compras.endpoint.model.Usuario;
import com.fatec.compras.endpoint.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar(){

        return usuarioService.listar();
    }
    
    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id){
        try{
            return usuarioService.buscarPorId(id);
        }catch (RecursoNaoEncontradoException exc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!", exc);
        }
    }

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario){

        return usuarioService.salvar(usuario);
    }

    @DeleteMapping("/{id}")
    public Usuario excluir(@PathVariable Long id){
        try{
            return usuarioService.excluir(id);
        }catch (RecursoNaoEncontradoException exc){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!", exc);
        }
    }

    @PutMapping
    public Usuario editar(@RequestBody Usuario usuario){

        return usuarioService.editar(usuario);
    }
}
