package fr.eni.pizzaonline.PizzaOnline.ihm;

import fr.eni.pizzaonline.PizzaOnline.bll.ClientManager;
import fr.eni.pizzaonline.PizzaOnline.bo.Client;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientManager manager;

    @GetMapping("/inscription")
    public String getInscriptionPage() {
        return "inscription";
    }

    @GetMapping("/connexion")
    public String getConnexionPage() {
        return "connexion";
    }

    @GetMapping("/compte")
    public String getComptePage(Model model, HttpSession session) {
        Client client = (Client) session.getAttribute("client");
        model.addAttribute("client", client);
        return "compte";
    }

    @GetMapping("/disconnexion")
    public String disconnexion(HttpSession session,
                               RedirectAttributes redirectAttributes) {
        session.removeAttribute("client");
        redirectAttributes.addFlashAttribute("message", "Vous êtes déconnecté");
        return "redirect:/";
    }

    @PostMapping("/inscription")
    public String handleInscriptionForm(@RequestParam("email") String email,
                                        @RequestParam("password") String password,
                                        RedirectAttributes redirectAttributes) {
        if (manager.getByEmail(email) == null) {
            manager.addClient(new Client(email, password));
            redirectAttributes.addFlashAttribute("message", "Vous êtes ajouté");
            return "redirect:/client/connexion";
        } else {
            redirectAttributes.addFlashAttribute("message", "Utilisateur existant");
            return "redirect:/client/inscription";
        }
    }

    @PostMapping("/connexion")
    public String handleConnexionForm(@RequestParam("email") String email,
                                      @RequestParam("password") String password,
                                      RedirectAttributes redirectAttributes,
                                      HttpSession session) {
        Client client = manager.getByEmail(email);
        if (client == null) {
            redirectAttributes.addFlashAttribute("message", "Utilisateur introuvable");
            return "redirect:/client/connexion";
        } else if (client.password.equals(password)) {
            session.setAttribute("client", client);
            redirectAttributes.addFlashAttribute("message", "Vous êtes connecté");
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("message", "Mot de passe incorrect");
            return "redirect:/client/connexion";
        }
    }
}