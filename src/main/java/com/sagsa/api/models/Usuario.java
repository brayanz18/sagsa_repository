package com.sagsa.api.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome completo do docente ou administrador
    @Column(nullable = false, length = 100)
    private String nome;

    // E-mail corporativo único para realização do login
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    // Senha criptografada utilizando o algoritmo BCrypt
    @Column(name = "senha_hash", nullable = false)
    private String senhaHash;

    // Perfil de acesso vinculado (EAGER para carregar as permissões no login)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "perfil_id", nullable = false)
    private Perfil perfil;

    // Status da conta (ativo/inativo) para controle de acesso
    @Column(nullable = false)
    private Boolean ativo = true;

    // Data de criação do registro (gerada automaticamente pelo banco)
    @Column(name = "data_criacao", insertable = false, updatable = false)
    private LocalDateTime dataCriacao;

    // Data de atualização da conta (atualizada automaticamente pelo banco)
    @Column(name = "data_atualizacao", insertable = false, updatable = false)
    private LocalDateTime dataAtualizacao;
}