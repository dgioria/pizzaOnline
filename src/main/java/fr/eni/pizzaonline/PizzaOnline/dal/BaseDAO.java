package fr.eni.pizzaonline.PizzaOnline.dal;

import fr.eni.pizzaonline.PizzaOnline.bo.Base;
import org.springframework.data.repository.CrudRepository;

public interface BaseDAO extends CrudRepository<Base, Integer> {
}
