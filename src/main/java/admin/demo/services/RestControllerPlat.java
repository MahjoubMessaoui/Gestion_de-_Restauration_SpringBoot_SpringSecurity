package admin.demo.services;

import admin.demo.dao.IPlat;
import admin.demo.dao.ISpecialiteT;
import admin.demo.dao.ITraiteur;
import admin.demo.models.Plat;

import admin.demo.utlis.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
@RequestMapping("/plat")
public class RestControllerPlat {
    @Autowired
    private IPlat iPlat;

    @Autowired
    private ISpecialiteT iSpecialiteT;
@Autowired  ITraiteur iTraiteur;

    @Autowired
    StorageService storageService;
    @GetMapping("/")
    public String plat() {
        return " plat";
    }

    @GetMapping("/all")
    public List<Plat> getAllPlat() {
        return iPlat.findAll();
    }

    @PostMapping("/add")
    public Plat addPlat (Plat plat, @RequestParam("img") MultipartFile img,Long idtraiteur,Long idS) {
        try {
            storageService.store(img);
           plat.setFile(img.getOriginalFilename());
           plat.setTraiteur(iTraiteur.getOne(idtraiteur));
           plat.setSpecialiteT(iSpecialiteT.getOne(idS));
            return iPlat.saveAndFlush(plat) ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @DeleteMapping("/remove")
    public String removePlat(long plat) {
        try {
            iPlat.deleteById(plat);
            return "yes";

        } catch (Exception e) {
            return "no";
        }
    }
}
