package fr.eni.pizzaonline.PizzaOnline.bll;

import fr.eni.pizzaonline.PizzaOnline.bo.Client;
import fr.eni.pizzaonline.PizzaOnline.bo.Commande;
import fr.eni.pizzaonline.PizzaOnline.dal.CommandeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeManagerImpl implements CommandeManager{
    @Autowired
    CommandeDAO dao;
    public List<Commande> getCommandesByClient(Client client){
        return dao.findByClient(client);
    }

    @Override
    public void addCommande(Commande commande) {
        dao.save(commande);
    }
}