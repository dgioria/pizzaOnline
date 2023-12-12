package fr.eni.pizzaonline.PizzaOnline.bll;

import fr.eni.pizzaonline.PizzaOnline.bo.Client;
import fr.eni.pizzaonline.PizzaOnline.dal.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientManagerImpl implements ClientManager {
    @Autowired
    ClientDAO dao;

    @Override
    public void addClient(Client client) {
        dao.save(client);
    }

    @Override
    public Client getByEmail(String email) {
        return dao.findByEmail(email);
    }
}
