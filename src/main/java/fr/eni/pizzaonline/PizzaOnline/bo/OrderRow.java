package fr.eni.pizzaonline.PizzaOnline.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderRow {

	private String pizzaName;
	private Integer quantity;
	private Double price;
	
	
}
