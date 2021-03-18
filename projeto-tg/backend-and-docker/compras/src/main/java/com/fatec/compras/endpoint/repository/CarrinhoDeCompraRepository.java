package com.fatec.compras.endpoint.repository;

import com.fatec.compras.endpoint.model.CarrinhoDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoDeCompraRepository extends JpaRepository<CarrinhoDeCompra, Long> {
}
