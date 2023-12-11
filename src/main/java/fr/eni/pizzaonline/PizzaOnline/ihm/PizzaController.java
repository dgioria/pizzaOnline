package fr.eni.pizzaonline.PizzaOnline.ihm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.pizzaonline.PizzaOnline.bll.PizzaManager;
import fr.eni.pizzaonline.PizzaOnline.bo.Pizza;

@Controller
@RequestMapping("/pizza")
public class PizzaController {
	
	@Autowired
	PizzaManager manager;
	
	@GetMapping("")
	public String showAll(Model model) {
		List<Pizza> listPizzas = manager.getAllPizzas();
		
		model.addAttribute("listPizzas", listPizzas);
		return "all_pizza";
	}
}
