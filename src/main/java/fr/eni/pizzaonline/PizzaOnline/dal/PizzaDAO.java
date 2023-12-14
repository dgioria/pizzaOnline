package fr.eni.pizzaonline.PizzaOnline.dal;

import fr.eni.pizzaonline.PizzaOnline.bo.Pizza;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PizzaDAO extends CrudRepository<Pizza, Integer> {

	Pizza findByNom(String name);

    List<Pizza> findAllByCustomFalse();
}
