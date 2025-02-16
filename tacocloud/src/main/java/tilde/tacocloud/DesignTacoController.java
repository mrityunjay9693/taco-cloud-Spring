package tilde.tacocloud;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

import tilde.tacocloud.Ingredient.Type;
import tilde.tacocloud.data.IngredientRepository;
import tilde.tacocloud.data.TacoRepository;

@Slf4j // Use for logging
@Controller // It will tell that it is a controller
@RequestMapping("/design") // It will respond to the specified url.
@SessionAttributes("order")
public class DesignTacoController {
    private final IngredientRepository ingredientRepo;
    private TacoRepository designRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository designRepo) {
        this.ingredientRepo = ingredientRepo;
        this.designRepo = designRepo;
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>(); // Returns : It returns a list view of the specified array
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));
        
        Type[] types = Ingredient.Type.values();

        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        return "design"; // view "design" is returned.

    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors) { // return : String , whenever, Whenever a URL or
                                                                     // view returns here,So return type is always
                                                                     // "String".
        if (errors.hasErrors()) {
            return "";
        }
        // Save the taco design...
        // W'll do later.
        log.info("Processing design:" + design);
        log.info("Testing logger");
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
