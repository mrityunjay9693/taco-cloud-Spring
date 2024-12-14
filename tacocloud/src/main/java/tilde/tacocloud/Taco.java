package tilde.tacocloud;

import java.util.List;
import lombok.Data;

@Data
public class Taco {                         // Domain class(data related) / Model class, Taco : It is the collection of ingredient.
    private String name;                    //name : It can be unique, can be worked as identity
    private List<String> ingredients;       //ingredient: All ingredients are string i.e., here List is of type String.
} 

//We can also create a "record"
// public record Taco{
//    //It wil automatically create getter and setter method and others required constructors, if needed. 
// s}