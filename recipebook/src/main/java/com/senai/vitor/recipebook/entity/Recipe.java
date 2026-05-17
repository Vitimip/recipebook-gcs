package com.senai.vitor.recipebook.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "TB_RECIPE")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(nullable = false)
    private Integer tempoPreparo;

    @Column(nullable = false)
    private Integer porcoes;

    @Column(nullable = false)
    private List<String> ingredientes;

    @Column(nullable = false)
    private String modoPreparo;

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private LocalDateTime dataCadastro;
}
