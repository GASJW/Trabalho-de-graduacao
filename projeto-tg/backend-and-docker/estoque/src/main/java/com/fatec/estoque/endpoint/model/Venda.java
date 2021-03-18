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
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long usuario_id;
    @Column(nullable = false)
    private LocalDate data;
    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal valorTotal;
}
