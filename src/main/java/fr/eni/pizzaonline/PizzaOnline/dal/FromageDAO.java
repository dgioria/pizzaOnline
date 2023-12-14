package fr.eni.pizzaonline.PizzaOnline.dal;

import fr.eni.pizzaonline.PizzaOnline.bo.Fromage;
import org.springframework.data.repository.CrudRepository;

public interface FromageDAO extends CrudRepository<Fromage, Integer> {
	public Fromage findByLibelle(String libelle);
}
