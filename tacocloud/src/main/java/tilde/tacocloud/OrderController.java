package tilde.tacocloud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/orders")      //This controller will handle any request whose path begins with "/orders"
public class OrderController {
    public String orderForm(Model model){   // here, model will have all the datas of the form inside it.
        log.info("Testing!");
        return "";
    }
}
