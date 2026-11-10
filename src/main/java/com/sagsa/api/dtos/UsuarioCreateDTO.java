package com.sagsa.api.dtos;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UsuarioCreateDTO {

    // Nome: Mínimo 3 caracteres, Máximo 100 caracteres
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    @Size(max = 150, message = "O e-mail não pode exceder 150 caracteres")
    private String email;

    // Senha: Mínimo 6 caracteres, Máximo 30 caracteres
    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, max = 30, message = "A senha deve ter entre 6 e 30 caracteres")
    private String senha;

    @NotNull(message = "O ID do perfil é obrigatório")
    private Long perfilId;
}