package com.sagsa.api.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class PerfilDTO {

    // Nome único do perfil (ex: ADMINISTRADOR, COORDENADOR, INSTRUTOR)
    @NotBlank(message = "O nome do perfil é obrigatório")
    @Size(min = 3, max = 50, message = "O nome do perfil deve ter entre 3 e 50 caracteres")
    private String nome;

    // Descrição do nível de permissão (1 a 3 linhas)
    @NotBlank(message = "A descrição do perfil é obrigatória")
    @Size(min = 10, max = 255, message = "A descrição deve conter entre 10 e 255 caracteres (aprox. 1 a 3 linhas)")
    private String descricao;
}