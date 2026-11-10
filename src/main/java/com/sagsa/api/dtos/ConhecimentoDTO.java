package com.sagsa.api.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class ConhecimentoDTO {

    @NotNull(message = "A Unidade Curricular é obrigatória")
    private Long unidadeCurricularId;

    // Tópico da base tecnológica (1 a 2 linhas)
    @NotBlank(message = "O tópico do conhecimento é obrigatório")
    @Size(min = 3, max = 200, message = "O tópico deve ter entre 3 e 200 caracteres")
    private String topico;

    // Detalhamento dos conteúdos (até 15 linhas)
    @Size(max = 1500, message = "O detalhamento não pode ultrapassar 1500 caracteres (aprox. 15 linhas)")
    private String detalhamento;
}