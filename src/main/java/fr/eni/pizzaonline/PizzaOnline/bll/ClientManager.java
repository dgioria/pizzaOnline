package fr.eni.pizzaonline.PizzaOnline.bll;

import fr.eni.pizzaonline.PizzaOnline.bo.Client;


public interface ClientManager {
    public void addClient(Client client);
    public Client getByEmail(String email);
}
