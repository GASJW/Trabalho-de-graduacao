package com.fatec.estoque.endpoint.repository;

import com.fatec.estoque.endpoint.model.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {
}
