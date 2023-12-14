package fr.eni.pizzaonline.PizzaOnline.bll;

import fr.eni.pizzaonline.PizzaOnline.bo.Client;
import fr.eni.pizzaonline.PizzaOnline.bo.Commande;
import fr.eni.pizzaonline.PizzaOnline.bo.OrderRow;

import java.util.List;

public interface CommandeManager {
    public List<Commande> getCommandesByClient(Client client);
    public void addCommande(Commande commande);
    public void updateCommande(Commande commande, OrderRow orderRow);
}
