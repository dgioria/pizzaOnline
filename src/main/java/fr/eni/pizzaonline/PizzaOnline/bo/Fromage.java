package fr.eni.pizzaonline.PizzaOnline.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Fromage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long noFromage;
    public String libelle;
    
	public Fromage(String libelle) {
		super();
		this.libelle = libelle;
	}
    
}
