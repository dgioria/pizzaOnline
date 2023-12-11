package fr.eni.pizzaonline.PizzaOnline.bll;

import fr.eni.pizzaonline.PizzaOnline.bo.Fromage;
import fr.eni.pizzaonline.PizzaOnline.dal.FromageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FromageManagerImpl implements FromageManager {
    @Autowired
    FromageDAO dao;

    @Override
    public List<Fromage> getAllFromages() {
        return (List<Fromage>) dao.findAll();
    }

}
