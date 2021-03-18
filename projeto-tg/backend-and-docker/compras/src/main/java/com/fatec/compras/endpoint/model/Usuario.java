package com.fatec.compras.endpoint.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 50)
    private String logradouro;
    @Column(nullable = false)
    private Short numero;
    @Column(nullable = false, length = 30)
    private String bairro;
    @Column(nullable = false, length = 10)
    private String cep;
    @Column(nullable = false, length = 30)
    private String cidade;
    @Column(nullable = false, length = 2)
    private String estado;
    @Column(length = 50)
    private String email;
    @Column(nullable = false, length = 15)
    private String celular;
}
