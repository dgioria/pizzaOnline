package fr.eni.pizzaonline.PizzaOnline.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long noCommande;
    public String date;
    public double prix;
    @OneToMany
    public List<CommandeLigne> commandeLignes = new ArrayList<>();
    @ManyToOne
    Client client;
    public Commande(String date,Client client) {
        this.date = date;
        this.client = client;
    }
}
