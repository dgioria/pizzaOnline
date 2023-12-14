package fr.eni.pizzaonline.PizzaOnline.dal;

import fr.eni.pizzaonline.PizzaOnline.bo.Client;
import fr.eni.pizzaonline.PizzaOnline.bo.Commande;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommandeDAO extends CrudRepository<Commande, Integer> {
    List<Commande> findByClient(Client client);
}
