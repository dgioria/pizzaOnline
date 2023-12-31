package fr.eni.pizzaonline.PizzaOnline.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long noPizza;
    public String nom;
    @ManyToOne
    public Base base;
    @ManyToMany
    public List<Ingredient> ingredients = new ArrayList<Ingredient>();
    @ManyToMany
    public List<Fromage> fromages = new ArrayList<Fromage>();
    public double prix;
    boolean custom;

    public Pizza(String nom, Base base, double prix, boolean custom) {
        super();
        this.nom = nom;
        this.base = base;
        this.prix = prix;
        this.custom = custom;
    }
}
