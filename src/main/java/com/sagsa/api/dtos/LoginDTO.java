package com.sagsa.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class LoginDTO {

    // E-mail corporativo do usuário
    @NotBlank(message = "O e-mail é de preenchimento obrigatório")
    @Email(message = "Informe um e-mail válido no formato usuario@dominio.com")
    @Size(max = 150, message = "O e-mail não pode ultrapassar 150 caracteres")
    private String email;

    // Senha em texto plano para autenticação
    @NotBlank(message = "A senha é de preenchimento obrigatório")
    @Size(min = 6, max = 30, message = "A senha deve ter entre 6 e 30 caracteres")
    private String senha;
}