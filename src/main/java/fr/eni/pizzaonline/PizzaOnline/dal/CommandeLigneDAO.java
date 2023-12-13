package fr.eni.pizzaonline.PizzaOnline.dal;

import fr.eni.pizzaonline.PizzaOnline.bo.CommandeLigne;
import org.springframework.data.repository.CrudRepository;

public interface CommandeLigneDAO extends CrudRepository<CommandeLigne, Integer> {
}
