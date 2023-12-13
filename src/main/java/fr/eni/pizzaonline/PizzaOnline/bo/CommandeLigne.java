package fr.eni.pizzaonline.PizzaOnline.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CommandeLigne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noCommandeLigne;
    private int quantite;
    @ManyToOne
    public Pizza pizza;

    public CommandeLigne(Pizza pizza, int quantite) {
        this.pizza = pizza;
        this.quantite = quantite;
    }
}
