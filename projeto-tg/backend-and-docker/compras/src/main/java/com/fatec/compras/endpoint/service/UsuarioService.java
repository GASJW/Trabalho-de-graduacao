package com.fatec.compras.endpoint.service;

import com.fatec.compras.endpoint.exception.RecursoNaoEncontradoException;
import com.fatec.compras.endpoint.model.CarrinhoDeCompra;
import com.fatec.compras.endpoint.model.Usuario;
import com.fatec.compras.endpoint.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarPorId(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        return usuario.get();
    }

    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    public Usuario salvar(Usuario usuario){

        return usuarioRepository.save(usuario);
    }

    public Usuario excluir(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        usuarioRepository.delete(usuario.get());
        return usuario.get();
    }

    public Usuario editar(Usuario usuario){

        return usuarioRepository.save(usuario);
    }
}
