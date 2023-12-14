package fr.eni.pizzaonline.PizzaOnline.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.pizzaonline.PizzaOnline.bo.Client;

public interface ClientDAO extends CrudRepository<Client, Integer> {
    Client findByEmail(String email);
}

