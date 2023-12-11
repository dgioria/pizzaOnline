package fr.eni.pizzaonline.PizzaOnline.bll;

import java.util.List;

import fr.eni.pizzaonline.PizzaOnline.bo.Pizza;

public interface PizzaManager {
	public void addPizza(Pizza voiture);
	public List<Pizza> getAllPizzas();
}
