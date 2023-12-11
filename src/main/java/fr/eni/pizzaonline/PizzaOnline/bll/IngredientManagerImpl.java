package fr.eni.pizzaonline.PizzaOnline.bll;

import fr.eni.pizzaonline.PizzaOnline.bo.Ingredient;
import fr.eni.pizzaonline.PizzaOnline.dal.IngredientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientManagerImpl implements IngredientManager {
    @Autowired
    IngredientDAO dao;

    @Override
    public List<Ingredient> getAllIngredients() {
        return (List<Ingredient>) dao.findAll();
    }

}
