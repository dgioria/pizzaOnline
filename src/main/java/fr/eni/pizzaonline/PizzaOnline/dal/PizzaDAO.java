package fr.eni.pizzaonline.PizzaOnline.dal;

import fr.eni.pizzaonline.PizzaOnline.bo.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaDAO extends CrudRepository<Pizza, Integer> {
}
