package fr.eni.pizzaonline.PizzaOnline.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Fromage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long noFromage;
    public String libelle;
}
