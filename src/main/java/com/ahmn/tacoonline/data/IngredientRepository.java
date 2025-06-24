package com.ahmn.tacoonline.data;

import com.ahmn.tacoonline.model.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Ingredient findOne(String id);
}
