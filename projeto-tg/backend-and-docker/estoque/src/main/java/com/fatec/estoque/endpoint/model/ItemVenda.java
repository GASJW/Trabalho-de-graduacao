package com.fatec.estoque.endpoint.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produto;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Venda venda;
    @Column(nullable = false)
    private Short quantidade;
    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal valorParcial;
}
