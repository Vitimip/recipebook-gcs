package com.senai.vitor.recipebook.controller;

import com.senai.vitor.recipebook.entity.Recipe;
import com.senai.vitor.recipebook.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receitas")
@CrossOrigin(origins = "*")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> findAll() {
        return recipeService.findAll();
    }

    @GetMapping("/{id}")
    public Recipe findById(@PathVariable Long id) {
        return recipeService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Recipe save(@RequestBody Recipe recipes) {
        return recipeService.save(recipes);
    }

    @PutMapping("/{id}")
    public Recipe update(@PathVariable Long id, @RequestBody Recipe recipes) {
        return recipeService.update(id, recipes);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        recipeService.deleteById(id);
    }

}
