package com.ahmn.tacoonline.web;

import com.ahmn.tacoonline.data.IngredientRepository;
import com.ahmn.tacoonline.model.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IngredienteByIdConverter implements Converter<String, Ingredient> {

    final IngredientRepository ingredientRepository;

    public Ingredient convert(String source) {
        return ingredientRepository.findOne(source);
    }
}
