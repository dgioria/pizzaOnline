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
import fr.eni.pizzaonline.PizzaOnline.bo.OrderRow;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	PizzaManager pizzaManager;
	
	
	private List<OrderRow> order= new ArrayList<>();
	
	@GetMapping("")
	public String showAll(HttpServletRequest request, Model model) {
		
		List<OrderRow> orderList = (List<OrderRow>) request.getSession().getAttribute("order");
		if(orderList != null) {
			
			Double total = pizzaManager.computFinalPrice(orderList);
			model.addAttribute("total", total);
		}
	
		model.addAttribute("orderList", orderList);
		
		
		
		return "cart";
	}
	
	@PostMapping("/add")
	public String addPizza(@RequestBody OrderRow orderRow, HttpServletRequest request) {
		
		if(orderRow != null) {
			order.add(orderRow);
		}
		
		
		request.getSession().setAttribute("order", order);
		return "all_pizza";
	}
	
	
}
