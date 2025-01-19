package tilde.tacocloud;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {  // A model class, which define our data.
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type { // enum : It is a group of constant
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE   // constant is written is captital case
    }
}
