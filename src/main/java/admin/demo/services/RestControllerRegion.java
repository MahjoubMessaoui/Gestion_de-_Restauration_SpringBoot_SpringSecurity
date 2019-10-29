package admin.demo.services;

import admin.demo.dao.IRegion;
import admin.demo.models.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/region")

public class RestControllerRegion {
    @Autowired

    private IRegion iRegion;

    @GetMapping("/")
    public String region() {
        return "bienvenue region";
    }

    @GetMapping("/all")
    public List<Region> getAllRégion() {
        return iRegion.findAll();
    }

    @PostMapping("/add")
    public Region AddRegion(@RequestBody Region region) {
        return iRegion.saveAndFlush(region);
    }

    @DeleteMapping("/remove")
    public String removeRegion(long region) {
        try {
            iRegion.deleteById(region);
            return "yes";

        } catch (Exception e) {
            return "no";
        }
    }
}

