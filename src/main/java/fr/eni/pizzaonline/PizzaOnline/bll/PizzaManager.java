package fr.eni.pizzaonline.PizzaOnline.bll;

import fr.eni.pizzaonline.PizzaOnline.bo.CommandeLigne;
import fr.eni.pizzaonline.PizzaOnline.bo.Pizza;
import jakarta.transaction.Transactional;

import java.util.List;

public interface PizzaManager {
    @Transactional
    public void addPizza(Pizza pizza);

    public List<Pizza> getAllPizzas();
    public Double computFinalPrice(List<CommandeLigne> order);
}
