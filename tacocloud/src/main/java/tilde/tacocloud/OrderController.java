package tilde.tacocloud;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders") // This controller will handle any request whose path begins with "/orders" and
                           // it is a part of route to an extent.
public class OrderController {
    @GetMapping("/current")
    public String orderForm(Model model) { // here, model will have all the datas of the form inside it.
        model.addAttribute("order", new Order());
        // log.info("Testing!");
        return "orderForm"; // returning a logical view name of orderForm.
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        log.info("Order submitted: " + order);
        return "redirect:/";
    }
}
