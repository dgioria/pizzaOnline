package fr.eni.pizzaonline.PizzaOnline;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.pizzaonline.PizzaOnline.bll.PizzaManager;
import fr.eni.pizzaonline.PizzaOnline.bo.Base;
import fr.eni.pizzaonline.PizzaOnline.bo.Fromage;
import fr.eni.pizzaonline.PizzaOnline.bo.Ingredient;
import fr.eni.pizzaonline.PizzaOnline.bo.Pizza;
import fr.eni.pizzaonline.PizzaOnline.dal.BaseDAO;
import fr.eni.pizzaonline.PizzaOnline.dal.FromageDAO;
import fr.eni.pizzaonline.PizzaOnline.dal.IngredientDAO;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class PizzaOnlineApplication {
	
	@Autowired
	PizzaManager pizzaManager;
	@Autowired
	IngredientDAO ingredientDAO;
	@Autowired
	FromageDAO fromageDAO;
	@Autowired
	BaseDAO baseDAO;
	
	@PostConstruct
	@Transactional
	private void init() {
		
		Fromage f1 = new Fromage("Mozzarella");
		Fromage f2 = new Fromage("Cheddar");
		Fromage f3 = new Fromage("Camambert");
		Fromage f4 = new Fromage("Emmental");
		Fromage f5 = new Fromage("Tome");
//		fromageDAO.save(f1);
//		fromageDAO.save(f2);
//		fromageDAO.save(f3);
//		fromageDAO.save(f4);
//		fromageDAO.save(f5);
		
		Base b1 = new Base("Sauce Tomate");
		Base b2 = new Base("Creme");
		Base b3 = new Base("Sauce Barbecue");
		baseDAO.save(b1);
		baseDAO.save(b2);
		baseDAO.save(b3);
		
		Ingredient i1 = new Ingredient("Ananas", 20.0);
		Ingredient i2 = new Ingredient("Viande Haché", 3.0);
		Ingredient i3 = new Ingredient("Miel", 4.5);
		Ingredient i4 = new Ingredient("Avocat", 4.5);
		Ingredient i5 = new Ingredient("Poivrons", 4.5);
		Ingredient i6 = new Ingredient("Salami", 4.5);
		Ingredient i7 = new Ingredient("Kebab", 4.5);
		Ingredient i8 = new Ingredient("Poulet", 4.5);
		Ingredient i9 = new Ingredient("Olives", 4.5);

		Pizza p1 = new Pizza("Hawai", b2, 8.50);
		p1.getIngredients().add(i6);
		p1.getIngredients().add(i5);
		p1.getIngredients().add(i4);
		p1.getFromages().add(f3);
		p1.getFromages().add(f2);
		pizzaManager.addPizza(p1);
		
		Pizza p2 = new Pizza("Burger", b1, 15.80);
		p2.getIngredients().add(i1);
		p2.getIngredients().add(i2);
		p2.getIngredients().add(i3);
		p2.getFromages().add(f4);
		p2.getFromages().add(f1);
		pizzaManager.addPizza(p2);
		
		Pizza p3 = new Pizza("Kebab", b3, 20.50);
		p3.getIngredients().add(i7);
		p3.getIngredients().add(i8);
		p3.getIngredients().add(i9);
		p3.getFromages().add(f5);
		pizzaManager.addPizza(p3);
		
	}
	
    public static void main(String[] args) {
        SpringApplication.run(PizzaOnlineApplication.class, args);
    }

}
