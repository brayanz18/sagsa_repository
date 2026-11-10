package com.sagsa.api.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "capacidades")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Capacidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Vínculo obrigatório com a Unidade Curricular pertencente ao PPC
    @ManyToOne
    @JoinColumn(name = "unidade_curricular_id", nullable = false)
    private UnidadeCurricular unidadeCurricular;

    // Tipo: BASICA, TECNICA, SOCIOEMOCIONAL
    @Column(nullable = false, length = 30)
    private String tipo;

    // Domínio pedagógico: COGNITIVO, PSICOMOTOR, AFETIVO
    @Column(nullable = false, length = 30)
    private String dominio;

    // Descrição textual da capacidade exigida no PPC
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;
}