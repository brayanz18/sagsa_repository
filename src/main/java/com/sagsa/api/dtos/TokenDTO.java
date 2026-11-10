package com.sagsa.api.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor 
@NoArgsConstructor
public class TokenDTO {

    private String token;      // Token JWT gerado e assinado
    private String tipo;       // Tipo do cabeçalho HTTP (padrão "Bearer")
    private String email;      // E-mail do usuário autenticado
    private String perfil;     // Perfil de acesso (ADMINISTRADOR, COORDENADOR, INSTRUTOR)
}
