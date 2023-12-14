package fr.eni.pizzaonline.PizzaOnline.ihm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.pizzaonline.PizzaOnline.bll.PizzaManager;
import fr.eni.pizzaonline.PizzaOnline.bo.Commande;
import fr.eni.pizzaonline.PizzaOnline.bo.CommandeLigne;
import fr.eni.pizzaonline.PizzaOnline.bo.OrderRow;
import fr.eni.pizzaonline.PizzaOnline.bo.Pizza;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	PizzaManager pizzaManager;

	private List<OrderRow> order = new ArrayList<>();

	@GetMapping("")
	public String showAll(HttpServletRequest request, HttpSession session, Model model) {

		if (session.getAttribute("client") == null)
			return "redirect:/client/connexion";

		List<OrderRow> orderList = (List<OrderRow>) request.getSession().getAttribute("order");
		if (orderList != null) {

			Double total = pizzaManager.computFinalPrice(orderList);
			model.addAttribute("total", total);
		}

		model.addAttribute("orderList", orderList);

		return "cart";
	}

	@PostMapping("/add")
	public String addPizza(@RequestBody OrderRow orderRow, HttpServletRequest request, HttpSession session) {

		if (session.getAttribute("client") == null)
			return "redirect:/client/connexion";
		
		Pizza pizza = pizzaManager.getByNom(orderRow.getPizzaName());
		CommandeLigne commandeLigne = new CommandeLigne(pizza, orderRow.getQuantity());
		Commande commande = (Commande) session.getAttribute("commande");
		commande.getCommandeLignes().add(commandeLigne);

		request.getSession().setAttribute("order", order);
		return "all_pizza";
	}

}
