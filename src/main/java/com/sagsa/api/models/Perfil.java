package com.sagsa.api.models;

import jakarta.persistence.*;
import jakarta.*;
import lombok.*;

@Entity
@Table(name = "perfis")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String nome;

    // Validação de mínimo e máximo de caracteres/linhas para a descrição
    @Column(length = 255)
    private String descricao;
}