package com.sagsa.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class UsuarioUpdateDTO {
    @NotBlank(message = "O nome é de preenchimento obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "O e-mail é de preenchimento obrigatório")
    @Email(message = "Informe um e-mail válido")
    @Size(max = 150, message = "O e-mail não pode ultrapassar 150 caracteres")
    private String email;

    // Senha opcional para alteração
    @Size(min = 6, max = 30, message = "Caso informada, a senha deve ter entre 6 e 30 caracteres")
    private String senha;

    @NotNull(message = "O ID do perfil é obrigatório")
    private Long perfilId;

    @NotNull(message = "O status de ativação da conta é obrigatório")
    private Boolean ativo;
}