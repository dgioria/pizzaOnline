package fr.eni.pizzaonline.PizzaOnline.bo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderRow {

	private String pizzaName;
	private Integer quantity;
	private Double price;
	
	private String base;
	private List<String> ingredients = new ArrayList<>();
	private List<String> fromages = new ArrayList<>();
}
