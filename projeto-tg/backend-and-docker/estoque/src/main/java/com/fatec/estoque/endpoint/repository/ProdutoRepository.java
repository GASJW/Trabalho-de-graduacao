package com.fatec.estoque.endpoint.repository;

import com.fatec.estoque.endpoint.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
