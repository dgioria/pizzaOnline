package fr.eni.pizzaonline.PizzaOnline.ihm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pizza")
public class PizzaController {
	
	@GetMapping("/all")
	public String hellotous() {
		return "all_pizza";
	}
}
