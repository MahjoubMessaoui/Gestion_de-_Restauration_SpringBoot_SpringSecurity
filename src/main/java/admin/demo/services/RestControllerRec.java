package admin.demo.services;

import admin.demo.dao.IClient;
import admin.demo.dao.IRec;
import admin.demo.models.Client;
import admin.demo.models.Rec;
import admin.demo.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rec")
@CrossOrigin("*")
public class RestControllerRec {
@Autowired
    private IRec iRec;
@Autowired
private IClient iClient;
    @GetMapping("/")
    public String rec() {
        return " rec";
    }
    @GetMapping("/all")
    public List<Rec> getAllRec() {
        return iRec.findAll();
    }

    @PostMapping("/add")
    public Rec addRec(@RequestBody Rec rec, Long idC) {

        for ( Client client : iClient.findAll()) {
            if (client.getId() == idC ) {
                rec.setClient(iClient.getOne(idC));
                rec.setEtat("unread");
                System.out.println("id "+idC);
            }
        }
        return iRec.saveAndFlush(rec);

    }
    @GetMapping("/etat")
    public Rec upRec( Long id) {
        Rec r = iRec.getOne(id);
        r.setEtat("read");
        return iRec.save(r);
    }

    @DeleteMapping("/remove")
    public Response removeRec(@RequestParam Long id) {
        Response r = new Response();
        try {
            r.setMsg("suppressin avec succée");

           iRec.deleteById(id);
            return r;

        } catch (Exception e) {
            r.setMsg("erreur");
            System.out.println();
            return r;
        }
    }
}
