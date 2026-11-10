package com.sagsa.api.dtos;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter 
@Setter
public class SituacaoAprendizagemDTO {

    // Título da SAPZ (1 a 2 linhas)
    @NotBlank(message = "O título da SAPZ é de preenchimento obrigatório")
    @Size(min = 5, max = 200, message = "O título deve ter entre 5 e 200 caracteres (aprox. 1 a 2 linhas)")
    private String titulo;

    // Vínculo obrigatório com a Unidade Curricular do PPC selecionado
    @NotNull(message = "A Unidade Curricular é obrigatória")
    private Long unidadeCurricularId;

    // Instrutor/Docente responsável pela elaboração
    @NotNull(message = "O ID do instrutor é obrigatório")
    private Long instrutorId;

    // Turma de aplicação (opcional; se nulo, atua como modelo/template)
    private Long turmaId;

    // Tipo de estratégia desafiadora (SITUACAO_PROBLEMA, ESTUDO_CASO, PROJETO, etc.)
    @NotBlank(message = "O tipo de estratégia pedagógica é obrigatório")
    private String tipoEstrategia;

    // Contextualização (2 a 35 linhas)
    @NotBlank(message = "A contextualização é obrigatória")
    @Size(min = 30, max = 3000, message = "A contextualização deve ter entre 30 e 3000 caracteres (aprox. 2 a 35 linhas)")
    private String contextualizacao;

    // Desafio proposto aos estudantes (2 a 35 linhas)
    @NotBlank(message = "O desafio é obrigatório")
    @Size(min = 30, max = 3000, message = "O desafio deve ter entre 30 e 3000 caracteres (aprox. 2 a 35 linhas)")
    private String desafio;

    // Resultados esperados e entregáveis (2 a 20 linhas)
    @NotBlank(message = "Os resultados esperados são obrigatórios")
    @Size(min = 20, max = 2000, message = "Os resultados esperados devem ter entre 20 e 2000 caracteres (aprox. 2 a 20 linhas)")
    private String resultadosEsperados;

    // Carga horária estipulada para a SAPZ (trava RN10)
    @NotNull(message = "A carga horária da SAPZ é obrigatória")
    @Min(value = 1, message = "A carga horária mínima deve ser de 1 hora")
    @Max(value = 400, message = "A carga horária da SAPZ não pode ultrapassar 400 horas (RN10)")
    private Integer cargaHorariaSa;

    // Permissão de compartilhamento com outros docentes
    private Boolean compartilhada = false;

    // IDs das Capacidades selecionadas da UC (RN02/RN04)
    @NotEmpty(message = "Selecione ao menos uma capacidade técnica ou socioemocional")
    private Set<Long> capacidadesIds;

    // IDs dos Conhecimentos/Bases Tecnológicas selecionados da UC
    @NotEmpty(message = "Selecione ao menos um conhecimento ou base tecnológica")
    private Set<Long> conhecimentosIds;
}