package fr.eni.pizzaonline.PizzaOnline.dal;

import fr.eni.pizzaonline.PizzaOnline.bo.Commande;
import org.springframework.data.repository.CrudRepository;

public interface CommandeDAO extends CrudRepository<Commande, Integer> {
}
