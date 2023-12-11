package fr.eni.pizzaonline.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long noPizza;
    public String nom;
    @OneToOne
    public Base base;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Ingredient> ingredients;
    @OneToOne
    public Fromage fromage;
}
