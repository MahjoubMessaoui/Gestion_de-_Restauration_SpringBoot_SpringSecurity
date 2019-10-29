package admin.demo.services;

import admin.demo.dao.IClient;
import admin.demo.dao.ICommande;
import admin.demo.models.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/commande")
public class RestControllerCommande {
    @Autowired
    private ICommande iCommande;
    @Autowired
    private IClient iClient;
    @GetMapping("/")
    public String commande(){
        return "cmd";
    }
    @GetMapping("/all")
    public List<Commande> getALLCommande(){
        return iCommande.findAll();
    }
@PostMapping("/add")
    public Commande AddCommande(@RequestBody Commande commande){
        return iCommande.saveAndFlush(commande);
}
@DeleteMapping("/remove")
    public String removeCommande(Long commande){
       try{
        iCommande.deleteById(commande);
        return "yes"; }
catch (Exception e){
           return "no";
}
}
@GetMapping("/orderOfClient")
    public List<Commande>getOrdrOfClient(Long id){
        return iCommande.getCOfClient(iClient.getOne(id));
}

}
