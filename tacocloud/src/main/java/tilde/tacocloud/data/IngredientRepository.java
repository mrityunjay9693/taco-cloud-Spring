package tilde.tacocloud.data;

import tilde.tacocloud.Ingredient;

public interface IngredientRepository {
    // Declaration. 
    Iterable<Ingredient> findAll();     // It will return a list of ingredients.
    Ingredient findOne(String id);
    Ingredient save(Ingredient ingredient);

    //We have to create the body for the above methods somewhere in any class.
}
