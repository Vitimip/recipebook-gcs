package com.senai.vitor.recipebook.service;

import com.senai.vitor.recipebook.entity.Recipe;
import com.senai.vitor.recipebook.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;


    public Recipe save(Recipe recipes) {
        return recipeRepository.save(recipes);
    }

    public Recipe findById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    public Recipe update(Long id, Recipe updatedRecipe) {
        return recipeRepository.findById(id)
                .map(recipe -> {
                    recipe.setName(updatedRecipe.getName());
                    recipe.setCategoria(updatedRecipe.getCategoria());
                    recipe.setTempoPreparo(updatedRecipe.getTempoPreparo());
                    recipe.setPorcoes(updatedRecipe.getPorcoes());
                    recipe.setIngredientes(updatedRecipe.getIngredientes());
                    recipe.setModoPreparo(updatedRecipe.getModoPreparo());
                    recipe.setDataCadastro(updatedRecipe.getDataCadastro());
                    return recipeRepository.save(recipe);
                })
                .orElse(null);
    }
}
