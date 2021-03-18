package com.fatec.estoque.endpoint.service;

import com.fatec.estoque.endpoint.exception.RecursoNaoEncontradoException;
import com.fatec.estoque.endpoint.model.Produto;
import com.fatec.estoque.endpoint.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto buscarPorId(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        return produto.get();
    }

    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    public Produto salvar(Produto produto){

        return produtoRepository.save(produto);
    }

    public Produto excluir(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        produtoRepository.delete(produto.get());
        return produto.get();
    }

    public Produto editar(Produto produto){

        return produtoRepository.save(produto);
    }
}
