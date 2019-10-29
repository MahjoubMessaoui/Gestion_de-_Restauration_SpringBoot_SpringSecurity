package admin.demo.services;

import admin.demo.dao.IRegion;

import admin.demo.dao.ISpecialiteT;
import admin.demo.dao.ITraiteur;

import admin.demo.models.SpecialiteT;
import admin.demo.models.Traiteur;
import admin.demo.utlis.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
@RequestMapping("/traiteur")
public class RestControllerTraiteur {
    @Autowired

    private ITraiteur iTraiteur;
    @Autowired
    private IRegion iRegion;
    @Autowired
    private ISpecialiteT iSpecialiteT;

    @Autowired
    StorageService storageService;

    @GetMapping("/")
    public String traiteur() {
        return "bienvenue traiteur";
    }

    @GetMapping("/all")
    public List<Traiteur> getAllTraiteur() {
        return iTraiteur.findAll();
    }

    @PostMapping("/add")
    public Traiteur addTraiteur (Traiteur traiteur, @RequestParam("img") MultipartFile img, Long idregion) {
        try {

            storageService.store(img);
            traiteur.setFile(storageService.store(img));
            traiteur.setRegion(iRegion.getOne(idregion));

            return iTraiteur.saveAndFlush(traiteur);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

        @DeleteMapping("/remove")
    public String removeTraiteur(long traiteur) {
        try {
            iTraiteur.deleteById(traiteur);
            return "yes";

        } catch (Exception e) {
            return "no";
        }
    }


    @PutMapping("/addSpec")
    public Traiteur addSpec(@RequestBody Traiteur traiteur){
     Traiteur   lastTraiteur=iTraiteur.getOne(traiteur.getId());
        lastTraiteur.setSpecialiteT(traiteur.getSpecialiteT());
        return iTraiteur.save(lastTraiteur);
    }
}
