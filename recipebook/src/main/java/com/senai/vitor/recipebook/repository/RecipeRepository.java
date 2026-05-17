package com.senai.vitor.recipebook.repository;

import com.senai.vitor.recipebook.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    boolean existsByNome(String nome);

    List<Recipe> findByNomeContainingIgnoreCase(String nome);
}
