package com.sagsa.api.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "modulos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plano_curso_id", nullable = false)
    private PlanoCurso planoCurso;

    @Column(nullable = false, length = 100)
    private String nome;

    // Tipo: BASICO, INTRODUTORIO, ESPECIFICO, INTEGRADOR
    @Column(name = "tipo_modulo", nullable = false, length = 30)
    private String tipoModulo;

    @Column(nullable = false)
    private Integer ordem = 1;

    // Carga horária total do módulo (utilizada na validação de limite da RN10)
    @Column(name = "carga_horaria", nullable = false)
    private Integer cargaHoraria;
}