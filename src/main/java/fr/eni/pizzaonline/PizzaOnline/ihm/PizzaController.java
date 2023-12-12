package fr.eni.pizzaonline.PizzaOnline.ihm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.pizzaonline.PizzaOnline.bll.PizzaManager;
import fr.eni.pizzaonline.PizzaOnline.bo.Pizza;

@Controller
@RequestMapping("/pizza")
public class PizzaController {
	
	@Autowired
	PizzaManager manager;
	
	@GetMapping("")
	public String showAll(@RequestParam(name = "menu", defaultValue = "all") String menu, Model model) {
		List<Pizza> listPizzas = manager.getAllPizzas();
		
		 switch (menu) {
         case "to-go":
             model.addAttribute("pageTitle", "To Go");
             break;
         case "on-site":
             model.addAttribute("pageTitle", "On Site");
             break;
         default:
             model.addAttribute("pageTitle", "All Pizzas");
             break;
     }
		 
		model.addAttribute("listPizzas", listPizzas);
		return "all_pizza";
	}
	
	
	@GetMapping("/cart")
	public String showAll() {
		
		return "cart";
	}
}
