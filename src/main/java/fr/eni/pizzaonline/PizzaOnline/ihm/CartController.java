package fr.eni.pizzaonline.PizzaOnline.ihm;

import fr.eni.pizzaonline.PizzaOnline.bll.CommandeManager;
import fr.eni.pizzaonline.PizzaOnline.bll.PizzaManager;
import fr.eni.pizzaonline.PizzaOnline.bo.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		if (!commande.getCommandeLignes().isEmpty()) {
			Double total = pizzaManager.computFinalPrice(commande.getCommandeLignes());
			model.addAttribute("total", total);
			commande.prix = total;
		}
		model.addAttribute("orderList", commande.getCommandeLignes());
		session.setAttribute("commande", commande);
		return "cart";
	}

	@PostMapping("/add")
	public String addPizza(@RequestBody OrderRow orderRow, HttpServletRequest request, HttpSession session) {

		if (session.getAttribute("client") == null)
			return "redirect:/client/connexion";

		// si la pizza est deja dans la commande -> je modifie la quantite, sinon -> je
		// cree une nouvelle ligne de la commande
		Commande commande = (Commande) session.getAttribute("commande");
		commandeManager.updateCommande(commande, orderRow);

		session.setAttribute("commande", commande);
		return "all_pizza";
	}

	@PostMapping("/confirmation")
	public String confirmation(HttpSession session, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Commande commande = (Commande) request.getSession().getAttribute("commande");
		commandeManager.addCommande(commande);
		session.removeAttribute("commande");
		redirectAttributes.addFlashAttribute("message", "Commande confirmée");
		Client client = (Client) request.getSession().getAttribute("client");
		commande = new Commande(client);
		session.setAttribute("commande", commande);
		return "redirect:/";
	}

	@PostMapping("/delete")
	public String deletePizza(@RequestBody OrderRow orderRow, HttpSession session, RedirectAttributes redirectAttributes, Model model) {

		Commande commande = (Commande) session.getAttribute("commande");
		commandeManager.deleteLigne(commande, orderRow.getPizzaName());
		session.setAttribute("commande", commande);
		redirectAttributes.addFlashAttribute("orderList", commande.getCommandeLignes());
		
		return "/cart";
		
	}

}
