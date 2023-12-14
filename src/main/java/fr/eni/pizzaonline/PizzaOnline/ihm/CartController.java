package fr.eni.pizzaonline.PizzaOnline.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.pizzaonline.PizzaOnline.bll.CommandeManager;
import fr.eni.pizzaonline.PizzaOnline.bll.PizzaManager;
import fr.eni.pizzaonline.PizzaOnline.bo.Commande;
import fr.eni.pizzaonline.PizzaOnline.bo.CommandeLigne;
import fr.eni.pizzaonline.PizzaOnline.bo.OrderRow;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	PizzaManager pizzaManager;
	
	@Autowired
	CommandeManager commandeManager;

	@GetMapping("")
	public String showAll(HttpServletRequest request, HttpSession session, Model model) {

		if (session.getAttribute("client") == null)
			return "redirect:/client/connexion";

		Commande commande = (Commande) request.getSession().getAttribute("commande");
		if (commande.getCommandeLignes().size() > 0) {
			Double total = pizzaManager.computFinalPrice(commande.getCommandeLignes());
			model.addAttribute("total", total);
		}

		model.addAttribute("orderList", commande.getCommandeLignes());

		return "cart";
	}

	@PostMapping("/add")
	public String addPizza(@RequestBody OrderRow orderRow, HttpServletRequest request, HttpSession session) {

		if (session.getAttribute("client") == null)
			return "redirect:/client/connexion";
		
		// si la pizza est deja dans la commande -> je modifie la quantite, sinon -> je cree une nouvelle ligne de la commande
		Commande commande = (Commande) session.getAttribute("commande");
		commandeManager.updateCommande(commande, orderRow);

		session.setAttribute("commande", commande);
		
		return "all_pizza";
	}

}
