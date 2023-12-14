package fr.eni.pizzaonline.PizzaOnline.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.pizzaonline.PizzaOnline.bo.CommandeLigne;
import fr.eni.pizzaonline.PizzaOnline.bo.Pizza;
import fr.eni.pizzaonline.PizzaOnline.dal.PizzaDAO;

@Service
public class PizzaManagerImpl implements PizzaManager {
    @Autowired
    PizzaDAO dao;

    @Override
    public void addPizza(Pizza pizza) {
        dao.save(pizza);
    }

    @Override
    public List<Pizza> getAllPizzas() {
        return (List<Pizza>) dao.findAll();
    }

	@Override
	public Double computFinalPrice(List<CommandeLigne> commandeLignes) {
		
		Double total= 0.0;
		for(CommandeLigne ligne : commandeLignes) {
			total+= ligne.getPizza().getPrix()*ligne.getQuantite();
		}
		return Math.floor(total * 100) / 100;
	}

	@Override
	public Pizza getByNom(String name) {
		
		return dao.findByNom(name);
	}

}
