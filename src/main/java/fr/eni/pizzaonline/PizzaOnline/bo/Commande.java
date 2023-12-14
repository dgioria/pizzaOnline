package fr.eni.pizzaonline.PizzaOnline.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
    @OneToMany(cascade = CascadeType.ALL)
    public List<CommandeLigne> commandeLignes = new ArrayList<>();
    @ManyToOne
    Client client;
    public Commande(Client client) {
        this.date = LocalDateTime.now().toString();
        this.client = client;
    }
}
