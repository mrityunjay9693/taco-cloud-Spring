package tilde.tacocloud;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {                         // Domain class(data related) / Model class, Taco : It is the collection of ingredient.
    private Long id; 
    private Date createdAt;
 
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;                    //name : It can be unique, can be worked as identity
    @Size(min=1, message="You must choose at least 1 ingredient.")
    private List<String> ingredients;       //ingredient: All ingredients are string i.e., here List is of type String.
} 

//We can also create a "record"
// public record Taco{
//    //It wil automatically create getter and setter method and others required constructors, if needed. 
// }