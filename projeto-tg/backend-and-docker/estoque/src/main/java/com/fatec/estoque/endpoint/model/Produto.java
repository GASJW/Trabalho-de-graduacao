package com.fatec.estoque.endpoint.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 30)
    private String nome;
    @Column(length = 50)
    private String descricao;
    @Column(nullable = false, length = 30)
    private String fabricante;
    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal preco;
    @Column(nullable = false)
    private Short quantidade;
}
