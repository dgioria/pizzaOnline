package fr.eni.pizzaonline.PizzaOnline.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.pizzaonline.PizzaOnline.bo.Client;
import fr.eni.pizzaonline.PizzaOnline.bo.Commande;
import fr.eni.pizzaonline.PizzaOnline.bo.CommandeLigne;
import fr.eni.pizzaonline.PizzaOnline.bo.OrderRow;
import fr.eni.pizzaonline.PizzaOnline.bo.Pizza;
import fr.eni.pizzaonline.PizzaOnline.dal.BaseDAO;
import fr.eni.pizzaonline.PizzaOnline.dal.CommandeDAO;
import fr.eni.pizzaonline.PizzaOnline.dal.FromageDAO;
import fr.eni.pizzaonline.PizzaOnline.dal.IngredientDAO;

@Service
public class CommandeManagerImpl implements CommandeManager {
	@Autowired
	CommandeDAO dao;
	
	@Autowired
	IngredientDAO ingredientDao;
	
	@Autowired
	FromageDAO fromageDao;
	
	@Autowired
	BaseDAO baseDao;

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

		Pizza pizza;
		if(pizzaManager.getByNom(orderRow.getPizzaName()) == null) {
			pizza = new Pizza(orderRow.getPizzaName(), null, orderRow.getPrice(),true);
			populatePizza(pizza, orderRow);
			pizzaManager.addPizza(pizza);
		}else {
			pizza = pizzaManager.getByNom(orderRow.getPizzaName());
		}
		
		CommandeLigne commandeLigne = new CommandeLigne(pizza, orderRow.getQuantity());
		commande.getCommandeLignes().add(commandeLigne);

	}

	private void populatePizza(Pizza pizza, OrderRow orderRow) {
		for(String ingredient : orderRow.getIngredients()) {
			pizza.getIngredients().add(ingredientDao.findByLibelle(ingredient));
		}
		for(String fromage : orderRow.getFromages()) {
			pizza.getFromages().add(fromageDao.findByLibelle(fromage));
		}
		
		pizza.setBase(baseDao.findByLibelle(orderRow.getBase()));
		
	}

	@Override
	public void deleteLigne(Commande commande, String nomPizza) {
		
		for (CommandeLigne ligne : commande.getCommandeLignes()) {
			if (ligne.pizza.getNom().equals(nomPizza)) {
				commande.getCommandeLignes().remove(ligne);
				return;
			}
		}
	}
}