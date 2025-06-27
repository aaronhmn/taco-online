package com.ahmn.tacoonline.data;

import com.ahmn.tacoonline.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
