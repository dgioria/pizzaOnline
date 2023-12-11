package fr.eni.pizzaonline.PizzaOnline.ihm;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ihm")
public class controllerTest {

	@GetMapping("")
	public String showAll() {
		
		return "index";
	}
}
