package com.sagsa.api.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "conhecimentos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Conhecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "unidade_curricular_id", nullable = false)
    private UnidadeCurricular unidadeCurricular;

    // Tópico principal da base tecnológica
    @Column(nullable = false, length = 200)
    private String topico;

    // Detalhamento dos conteúdos e saberes
    @Column(columnDefinition = "TEXT")
    private String detalhamento;
}