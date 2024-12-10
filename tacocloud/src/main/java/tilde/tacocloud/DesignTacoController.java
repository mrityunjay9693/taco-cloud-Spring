package tilde.tacocloud;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tilde.tacocloud.Ingredients.Type;

@Slf4j                                    // Use for logging
@Controller                              // It will tell that it is a controller
@RequestMapping("/design")              // It will respond to the specified url.
public class DesignTacoController {
    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredients> ingredients = Arrays.asList( // Returns : It returns a list view of the specified array
                new Ingredients("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredients("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredients("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredients("CARN", "Carnitas", Type.PROTEIN),
                new Ingredients("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredients("LETC", "Lettuce", Type.VEGGIES),
                new Ingredients("CHED", "Cheddar", Type.CHEESE),
                new Ingredients("JACK", "Monterrey", Type.CHEESE),
                new Ingredients("SLSA", "Salsa", Type.SAUCE),
                new Ingredients("SRCR", "Sour Cream", Type.SAUCE));

        Type[] types = Ingredients.Type.values();

        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        return "design";    // view "design" is returned.

    }
    @PostMapping
    public String processDesign(Design design){ // return : String , whenever, Whenever a URL or view returns here,So return type is always "String".
        //Save the taco design...
        //W'll do later.
        log.info("Processing design:"+design);
        log.info("Testing logger");
        return "redirect:/orders/current";
    }  

    private List<Ingredients> filterByType(List<Ingredients> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
