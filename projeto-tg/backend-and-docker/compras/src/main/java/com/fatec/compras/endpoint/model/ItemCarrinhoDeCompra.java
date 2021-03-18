package com.fatec.compras.endpoint.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ItemCarrinhoDeCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private CarrinhoDeCompra carrinhoDeCompra;
    @Column(nullable = false)
    private Long produto_id;
    @Column(nullable = false)
    private Short quantidade;
    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal valorParcial;
}
