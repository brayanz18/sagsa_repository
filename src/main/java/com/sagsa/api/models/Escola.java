package com.sagsa.api.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "escolas")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome completo da unidade operacional SENAI
    @Column(nullable = false, length = 150)
    private String nome;

    // Código identificador da unidade
    @Column(name = "codigo_unidade", unique = true, length = 20)
    private String codigoUnidade;

    @Column(nullable = false, length = 100)
    private String cidade;

    // Sigla do estado (padrão 'RS')
    @Column(nullable = false, length = 2)
    private String estado = "RS";

    @Column(nullable = false)
    private Boolean ativo = true;
}