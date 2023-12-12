package fr.eni.pizzaonline.PizzaOnline.dal;

import fr.eni.pizzaonline.PizzaOnline.bo.Client;
import fr.eni.pizzaonline.PizzaOnline.bo.Fromage;
import org.springframework.data.repository.CrudRepository;

public interface ClientDAO extends CrudRepository<Client, Integer> {
    Client findByEmail(String email);
}

