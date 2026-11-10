package com.sagsa.api.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "situacoes_aprendizagem")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class SituacaoAprendizagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Título descritivo da Situação de Aprendizagem
    @Column(nullable = false, length = 200)
    private String titulo;

    // Unidade Curricular a qual a SAPZ pertence
    @ManyToOne
    @JoinColumn(name = "unidade_curricular_id", nullable = false)
    private UnidadeCurricular unidadeCurricular;

    // Instrutor/Docente responsável pela criação do documento
    @ManyToOne
    @JoinColumn(name = "instrutor_id", nullable = false)
    private Usuario instrutor;

    // Turma na qual a SAPZ é aplicada (opcional: se nulo, atua como template/modelo)
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    // Estratégia desafiadora: SITUACAO_PROBLEMA, ESTUDO_CASO, PROJETO, etc.
    @Column(name = "tipo_estrategia", nullable = false, length = 50)
    private String tipoEstrategia;

    // Contextualização do desafio pedagógico
    @Column(columnDefinition = "TEXT", nullable = false)
    private String contextualizacao;

    // Descrição textual do desafio proposto aos alunos
    @Column(columnDefinition = "TEXT", nullable = false)
    private String desafio;

    // Resultados esperados da atividade
    @Column(name = "resultados_esperados", columnDefinition = "TEXT", nullable = false)
    private String resultadosEsperados;

    // Carga horária estipulada para a SAPZ (sujeita à regra de validação da RN10)
    @Column(name = "carga_horaria_sa", nullable = false)
    private Integer cargaHorariaSa;

    // Indica se a SAPZ está disponível para compartilhamento
    @Column(nullable = false)
    private Boolean compartilhada = false;

    // Carimbo de data de criação
    @Column(name = "data_criacao", insertable = false, updatable = false)
    private LocalDateTime dataCriacao;

    // Carimbo de data de atualização
    @Column(name = "data_atualizacao", insertable = false, updatable = false)
    private LocalDateTime dataAtualizacao;

    // Tabela intermediária: sapz_capacidades (Associação N:M)
    @ManyToMany
    @JoinTable(
        name = "sapz_capacidades",
        joinColumns = @JoinColumn(name = "situacao_aprendizagem_id"),
        inverseJoinColumns = @JoinColumn(name = "capacidade_id")
    )
    private Set<Capacidade> capacidades = new HashSet<>();

    // Tabela intermediária: sapz_conhecimentos (Associação N:M)
    @ManyToMany
    @JoinTable(
        name = "sapz_conhecimentos",
        joinColumns = @JoinColumn(name = "situacao_aprendizagem_id"),
        inverseJoinColumns = @JoinColumn(name = "conhecimento_id")
    )
    private Set<Conhecimento> conhecimentos = new HashSet<>();
}