package fr.eni.pizzaonline.PizzaOnline.bll;

import java.util.List;

import fr.eni.pizzaonline.PizzaOnline.bo.CommandeLigne;
import fr.eni.pizzaonline.PizzaOnline.bo.Pizza;

public interface PizzaManager {
    public void addPizza(Pizza pizza);

    public List<Pizza> getAllPizzas();
    public Double computFinalPrice(List<CommandeLigne> commandeLignes);
    public Pizza getByNom(String name);
    
}
