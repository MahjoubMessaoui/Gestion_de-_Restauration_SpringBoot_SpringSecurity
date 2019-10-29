package admin.demo.services;


import admin.demo.dao.ISpecialiteT;

import admin.demo.models.SpecialiteT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialite")
public class RestControllerSpecialite {
    @Autowired

    private ISpecialiteT iSpecialiteT;

    @GetMapping("/")
    public String spécialiteT() {
        return "spécialite";
    }

    @GetMapping("/all")
    public List<SpecialiteT> getAllSpécialitéT() {
        return iSpecialiteT.findAll();
    }

    @PostMapping("/add")
    public SpecialiteT AddSpecialite(@RequestBody SpecialiteT specialiteT) {
        return iSpecialiteT.saveAndFlush(specialiteT);
    }

    @DeleteMapping("/remove")
    public String removeSpecialite(long specialite ) {
        try {
            iSpecialiteT.deleteById(specialite);
            return "yes";

        } catch (Exception e) {
            return "no";
        }
    }

}
