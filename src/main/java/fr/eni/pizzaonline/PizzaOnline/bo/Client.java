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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long noClient;
    String email;
    String password;

    public Client(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
