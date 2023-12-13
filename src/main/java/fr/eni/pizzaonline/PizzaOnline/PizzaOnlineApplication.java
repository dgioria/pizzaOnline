package fr.eni.pizzaonline.PizzaOnline;

import fr.eni.pizzaonline.PizzaOnline.bll.ClientManager;
import fr.eni.pizzaonline.PizzaOnline.bo.*;
import fr.eni.pizzaonline.PizzaOnline.dal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.pizzaonline.PizzaOnline.bll.PizzaManager;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class PizzaOnlineApplication {
	
	@Autowired
	PizzaManager pizzaManager;
	@Autowired
	IngredientDAO ingredientDAO;
	@Autowired
	FromageDAO fromageDAO;
	@Autowired
	BaseDAO baseDAO;
	@Autowired
	CommandeDAO commandeDAO;
	@Autowired
	CommandeLigneDAO commandeLigneDAO;
	@Autowired
	ClientManager clientManager;
	
	@PostConstruct
	@Transactional
	private void init() {

		Fromage f1 = new Fromage("Mozzarella",2.0);
		Fromage f2 = new Fromage("Cheddar",3.2);
		Fromage f3 = new Fromage("Camambert",2.2);
		Fromage f4 = new Fromage("Emmental",2.3);
		Fromage f5 = new Fromage("Tome",3.2);
		fromageDAO.save(f1);
		fromageDAO.save(f2);
		fromageDAO.save(f3);
		fromageDAO.save(f4);
		fromageDAO.save(f5);

		Base b1 = new Base("Sauce Tomate",2.2);
		Base b2 = new Base("Creme",1.0);
		Base b3 = new Base("Sauce Barbecue",1.0);
		baseDAO.save(b1);
		baseDAO.save(b2);
		baseDAO.save(b3);

		Ingredient i1 = new Ingredient("Ananas", 20.0);
		Ingredient i2 = new Ingredient("Viande Haché", 3.0);
		Ingredient i3 = new Ingredient("Miel", 4.5);
		Ingredient i4 = new Ingredient("Avocat", 4.5);
		Ingredient i5 = new Ingredient("Poivrons", 4.5);
		Ingredient i6 = new Ingredient("Salami", 4.5);
		Ingredient i7 = new Ingredient("Kebab", 4.5);
		Ingredient i8 = new Ingredient("Poulet", 4.5);
		Ingredient i9 = new Ingredient("Olives", 4.5);
		ingredientDAO.save(i1);
		ingredientDAO.save(i2);
		ingredientDAO.save(i3);
		ingredientDAO.save(i4);
		ingredientDAO.save(i5);
		ingredientDAO.save(i6);
		ingredientDAO.save(i7);
		ingredientDAO.save(i8);
		ingredientDAO.save(i9);;

		Pizza p1 = new Pizza("Hawai", b1);
		p1.getIngredients().add(i1);
		p1.getIngredients().add(i2);
		p1.getIngredients().add(i3);
		p1.getFromages().add(f3);
		p1.getFromages().add(f2);
		pizzaManager.addPizza(p1);

		Pizza p2 = new Pizza("Burger", b1);
		p2.getIngredients().add(i1);
		p2.getIngredients().add(i2);
		p2.getIngredients().add(i3);
		p2.getFromages().add(f3);
		p2.getFromages().add(f2);
		pizzaManager.addPizza(p2);

		Pizza p3 = new Pizza("Kebab", b2);
		p3.getIngredients().add(i2);
		p3.getIngredients().add(i3);
		p3.getIngredients().add(i5);
		p3.getFromages().add(f2);
		pizzaManager.addPizza(p3);

		CommandeLigne c1l1 = new CommandeLigne(p1,2);
		CommandeLigne c1l2 = new CommandeLigne(p2,2);
		CommandeLigne c2l1 = new CommandeLigne(p1,2);
		commandeLigneDAO.save(c1l1);
		commandeLigneDAO.save(c1l2);
		commandeLigneDAO.save(c2l1);

		Client client = new Client("root@gmail.com","root");
		clientManager.addClient(client);

		Commande c1 = new Commande("20/02/2022",client,40.2);
		c1.getCommandeLignes().add(c1l1);
		c1.getCommandeLignes().add(c1l2);
		commandeDAO.save(c1);

		Commande c2 = new Commande("24/02/2022",client,27.2);
		c2.getCommandeLignes().add(c2l1);
		commandeDAO.save(c2);
	}
	
    public static void main(String[] args) {
        SpringApplication.run(PizzaOnlineApplication.class, args);
    }

}
