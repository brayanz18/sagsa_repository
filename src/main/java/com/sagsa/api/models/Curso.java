package com.sagsa.api.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cursos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "area_tecnologica_id")
    private AreaTecnologica areaTecnologica;

    @Column(nullable = false, length = 150)
    private String nome;

    // Tipo do curso: HABILITACAO_TECNICA, QUALIFICACAO_PROFISSIONAL, etc.
    @Column(name = "tipo_curso", nullable = false, length = 50)
    private String tipoCurso;

    @Column(nullable = false)
    private Boolean ativo = true;
}