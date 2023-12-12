package fr.eni.pizzaonline.PizzaOnline.bo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long noPizza;
    public String nom;
    public Double prix;
    
	@OneToOne
    public Base base;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Ingredient> ingredients = new ArrayList<Ingredient>();
    @OneToOne
    public Fromage fromage;
    
    
    public Pizza(String nom) {
		super();
		this.nom = nom;
	}

	public Pizza(String nom, Base base, Fromage fromage, Double prix) {
		super();
		this.nom = nom;
		this.base = base;
		this.fromage = fromage;
		this.prix = prix;
	}
    
    
}
