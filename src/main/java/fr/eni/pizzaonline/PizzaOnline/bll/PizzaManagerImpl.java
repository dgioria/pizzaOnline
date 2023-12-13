package fr.eni.pizzaonline.PizzaOnline.bll;

import fr.eni.pizzaonline.PizzaOnline.bo.CommandeLigne;
import fr.eni.pizzaonline.PizzaOnline.bo.Pizza;
import fr.eni.pizzaonline.PizzaOnline.dal.PizzaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
	public Double computFinalPrice(List<CommandeLigne> order) {
		
		Double total= 0.0;
		for(CommandeLigne row : order) {
			//total+= row.getPrice()*row.getQuantity();
		}
		return total;
	}

}
