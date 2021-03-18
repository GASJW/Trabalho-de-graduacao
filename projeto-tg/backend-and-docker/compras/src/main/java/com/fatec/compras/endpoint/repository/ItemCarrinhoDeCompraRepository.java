package com.fatec.compras.endpoint.repository;

import com.fatec.compras.endpoint.model.ItemCarrinhoDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCarrinhoDeCompraRepository extends JpaRepository<ItemCarrinhoDeCompra, Long> {
}
