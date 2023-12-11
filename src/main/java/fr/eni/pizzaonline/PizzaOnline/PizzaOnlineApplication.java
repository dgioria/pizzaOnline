package fr.eni.pizzaonline.PizzaOnline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.pizzaonline.PizzaOnline.bll.PizzaManager;
import fr.eni.pizzaonline.PizzaOnline.bo.Pizza;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class PizzaOnlineApplication {
	
	@Autowired
	PizzaManager manager;
	
	@PostConstruct
	private void init() {
		manager.addPizza(new Pizza("Hawai"));
		manager.addPizza(new Pizza("Burger"));
		manager.addPizza(new Pizza("Kebab"));
	}
	
    public static void main(String[] args) {
        SpringApplication.run(PizzaOnlineApplication.class, args);
    }

}
