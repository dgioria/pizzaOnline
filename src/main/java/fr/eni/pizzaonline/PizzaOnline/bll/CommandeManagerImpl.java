package fr.eni.pizzaonline.PizzaOnline.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.pizzaonline.PizzaOnline.bo.Client;
import fr.eni.pizzaonline.PizzaOnline.bo.Commande;
import fr.eni.pizzaonline.PizzaOnline.bo.CommandeLigne;
import fr.eni.pizzaonline.PizzaOnline.bo.OrderRow;
import fr.eni.pizzaonline.PizzaOnline.bo.Pizza;
import fr.eni.pizzaonline.PizzaOnline.dal.CommandeDAO;

@Service
public class CommandeManagerImpl implements CommandeManager {
	@Autowired
	CommandeDAO dao;

	@Autowired
	PizzaManager pizzaManager;

	public List<Commande> getCommandesByClient(Client client) {
		return dao.findByClient(client);
	}

	@Override
	public void addCommande(Commande commande) {
		dao.save(commande);
	}

	@Override
	public void updateCommande(Commande commande, OrderRow orderRow) {
		for (CommandeLigne ligne : commande.getCommandeLignes()) {
			if (ligne.pizza.getNom().equals(orderRow.getPizzaName())) {
				ligne.setQuantite(ligne.getQuantite() + orderRow.getQuantity());
				return;
			}
		}

		Pizza pizza = pizzaManager.getByNom(orderRow.getPizzaName());
		CommandeLigne commandeLigne = new CommandeLigne(pizza, orderRow.getQuantity());
		commande.getCommandeLignes().add(commandeLigne);

	}
}