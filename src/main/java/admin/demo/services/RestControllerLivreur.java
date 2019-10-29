package admin.demo.services;

import admin.demo.dao.ILivreur;
import admin.demo.models.Livreur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/livreur")
public class RestControllerLivreur {
    @Autowired

    private ILivreur iLivreur;

    @GetMapping("/")
    public String livreur() {
        return "bienvenue livreur";
    }

    @GetMapping("/all")
    public List<Livreur> getAllLivreur() {
        return iLivreur.findAll();
    }

    @PostMapping("/add")
    public Livreur AddLivreur(@RequestBody Livreur livreur) {
        return iLivreur.saveAndFlush(livreur);
    }

    @DeleteMapping("/remove")
    public String removeLivreur(long livreur) {
        try {
            iLivreur.deleteById(livreur);
            return "yes";

        } catch (Exception e) {
            return "no";
        }
    }
}
