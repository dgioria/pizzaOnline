package fr.eni.pizzaonline.PizzaOnline.bll;

import fr.eni.pizzaonline.PizzaOnline.bo.Pizza;

import java.util.List;

public interface PizzaManager {
    public void addPizza(Pizza pizza);

    public List<Pizza> getAllPizzas();
}
