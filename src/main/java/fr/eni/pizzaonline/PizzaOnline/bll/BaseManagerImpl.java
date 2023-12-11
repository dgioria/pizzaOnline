package fr.eni.pizzaonline.PizzaOnline.bll;

import fr.eni.pizzaonline.PizzaOnline.bo.Base;
import fr.eni.pizzaonline.PizzaOnline.dal.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseManagerImpl implements BaseManager {
    @Autowired
    BaseDAO dao;

    @Override
    public List<Base> getAllBases() {
        return (List<Base>) dao.findAll();
    }

}
