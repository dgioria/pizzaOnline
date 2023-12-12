package fr.eni.pizzaonline.PizzaOnline.ihm;

import fr.eni.pizzaonline.PizzaOnline.bll.ClientManager;
import fr.eni.pizzaonline.PizzaOnline.bo.Client;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String getInscriptionPage(HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        request.getSession().setAttribute("previousPage", referer);
        return "inscription";
    }

    @GetMapping("/connexion")
    public String getConnexionPage(HttpServletRequest request) {
        String referer = request.getHeader("Referer");
        request.getSession().setAttribute("previousPage", referer);
        return "connexion";
    }

    @GetMapping("/cancel")
    public String cancel(HttpServletRequest request) {
        //return "redirect:" + request.getSession().getAttribute("previousPage");
        return "redirect:/";
    }

    @PostMapping("/inscription")
    public String handleInscriptionForm(@RequestParam("email") String email,
                                        @RequestParam("password") String password,
                                        RedirectAttributes redirectAttributes) {
        Client client = manager.getByEmail(email);
        if (client == null) {
            manager.addClient(new Client(email, password));
            redirectAttributes.addFlashAttribute("message", "Vous êtes ajouté");
        } else {
            redirectAttributes.addFlashAttribute("message", "Utilisateur existant");
        }
        return "redirect:/client/inscription";
    }

    @PostMapping("/connexion")
    public String handleConnexionForm(@RequestParam("email") String email,
                                      @RequestParam("password") String password,
                                      RedirectAttributes redirectAttributes) {
        Client client = manager.getByEmail(email);
        if (client == null) {
            redirectAttributes.addFlashAttribute("message", "Utilisateur introuvable");
        } else if (client.password.equals(password)) {
            redirectAttributes.addFlashAttribute("message", "Vous êtes connecté");
        } else {
            redirectAttributes.addFlashAttribute("message", "Mot de passe incorrect");
        }
        return "redirect:/client/connexion";
    }
}

