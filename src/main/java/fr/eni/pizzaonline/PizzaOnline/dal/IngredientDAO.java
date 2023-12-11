package fr.eni.pizzaonline.PizzaOnline.dal;

import fr.eni.pizzaonline.PizzaOnline.bo.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientDAO extends CrudRepository<Ingredient, Integer> {
}
