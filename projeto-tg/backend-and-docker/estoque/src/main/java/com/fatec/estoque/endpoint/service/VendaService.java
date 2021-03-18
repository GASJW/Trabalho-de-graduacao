package com.fatec.estoque.endpoint.service;

import com.fatec.estoque.endpoint.exception.RecursoNaoEncontradoException;
import com.fatec.estoque.endpoint.model.ItemVenda;
import com.fatec.estoque.endpoint.model.Venda;
import com.fatec.estoque.endpoint.repository.ItemVendaRepository;
import com.fatec.estoque.endpoint.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ItemVendaRepository itemVendaRepository;

    public Venda buscarPorId(Long id){
        Optional<Venda> venda = vendaRepository.findById(id);
        if(venda.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        return venda.get();
    }

    public List<Venda> listar(){
        return vendaRepository.findAll();
    }

    public Venda atualizar(Long id){
        Optional<Venda> venda = vendaRepository.findById(id);
        if(venda.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        List<ItemVenda> itens = itemVendaRepository.findAll();
        Double valor = 0.0;

        for (ItemVenda item : itens){
            if(item.getVenda().getId()==id) {
                valor = valor + (Double.parseDouble(item.getValorParcial().toString())*item.getQuantidade());
            }
        }
        venda.get().setValorTotal(BigDecimal.valueOf(valor));
        return vendaRepository.save(venda.get());
    }

    public Venda salvar(Venda venda){

        return vendaRepository.save(venda);
    }

    public Venda excluir(Long id){
        Optional<Venda> venda = vendaRepository.findById(id);
        if(venda.isEmpty()){
            throw new RecursoNaoEncontradoException();
        }
        vendaRepository.delete(venda.get());
        return venda.get();
    }

    public Venda editar(Venda venda){

        return vendaRepository.save(venda);
    }
}
