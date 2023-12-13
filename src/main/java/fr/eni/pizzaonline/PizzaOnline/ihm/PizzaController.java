package fr.eni.pizzaonline.PizzaOnline.ihm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.pizzaonline.PizzaOnline.bll.BaseManager;
import fr.eni.pizzaonline.PizzaOnline.bll.FromageManager;
import fr.eni.pizzaonline.PizzaOnline.bll.IngredientManager;
import fr.eni.pizzaonline.PizzaOnline.bll.PizzaManager;
import fr.eni.pizzaonline.PizzaOnline.bo.Base;
import fr.eni.pizzaonline.PizzaOnline.bo.Pizza;
import fr.eni.pizzaonline.PizzaOnline.bo.Fromage;
import fr.eni.pizzaonline.PizzaOnline.bo.Ingredient;

@Controller
@RequestMapping("/pizza")
public class PizzaController {
	//
	@Autowired
	PizzaManager manager;
	
	@Autowired
	BaseManager baseManager;
	
	@Autowired
	FromageManager fromManager;
	
	@Autowired
	IngredientManager ingredientManager;
	
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
	
	
	
	
	@GetMapping("/custom")
	public String createPizza(Model model) {
		List<Base> listBases = baseManager.getAllBases();
		List<Fromage> listFromages = fromManager.getAllFromages();
		List<Ingredient> listIngredients = ingredientManager.getAllIngredients();
		
		
		model.addAttribute("listBases", listBases);
		model.addAttribute("listFromages", listFromages);
		model.addAttribute("listIngredients", listIngredients);
		
		return "custom_pizza";
	}

	@GetMapping("/restaurant")
	public String showRestaurant(Model model) {
		model.addAttribute("pageTitle", "Restaurant");
		return "restaurant";
	}
 
}
