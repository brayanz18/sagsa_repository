package com.sagsa.api.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class CapacidadeDTO {

    @NotNull(message = "A Unidade Curricular é obrigatória")
    private Long unidadeCurricularId;

    // Tipo: BASICA, TECNICA, SOCIOEMOCIONAL
    @NotBlank(message = "O tipo da capacidade é obrigatório")
    private String tipo;

    // Domínio pedagógico: COGNITIVO, PSICOMOTOR, AFETIVO
    @NotBlank(message = "O domínio é obrigatório")
    private String dominio;

    // Descrição textual da capacidade (1 a 10 linhas)
    @NotBlank(message = "A descrição da capacidade é obrigatória")
    @Size(min = 10, max = 1000, message = "A descrição deve ter entre 10 e 1000 caracteres (aprox. 1 a 10 linhas)")
    private String descricao;
}