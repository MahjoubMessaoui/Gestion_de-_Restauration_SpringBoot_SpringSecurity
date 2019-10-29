package admin.demo.services;

import admin.demo.dao.IClient;
import admin.demo.models.Client;
import admin.demo.models.Mail;
import admin.demo.models.Response;
import admin.demo.utlis.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin("*")
public class RestControllerClient {
@Autowired
private RestControllerMailService restControllerMailService;
    @Autowired
    private IClient iClient;
    @Autowired
    StorageService storageService;

    @GetMapping("/")
    public String client() {
        return "bienvenue client";
    }

    @GetMapping("/all")
    public List<Client> getAllClient() {
        return iClient.findAll();
    }


    @PostMapping("/add")
    public Client addClient(Client client, @RequestParam("img") MultipartFile img) {
        try {

            storageService.store(img);
            client.setFile(storageService.store(img));
            client.setNotif("true");
            client.setEtat(1);
            return iClient.saveAndFlush(client);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/notifi")
    public Client upnotif( Long id) {
        Client c = iClient.getOne(id);
        c.setNotif("false");
return iClient.save(c);
    }

    @RequestMapping(value="/sendMail",method= RequestMethod.POST)
    public String sendMail(){
        System.out.println("Spring Mail - Sending Simple Email with JavaMailSender Example");

        Mail mail = new Mail();
        mail.setFrom("ad.mon.traiteur@gmail.com");
        mail.setTo("ad.mon.traiteur@gmail.com");
        mail.setSubject("Sending Simple Email with JavaMailSender Example");
        mail.setContent("This tutorial demonstrates how to send a simple email using Spring Framework.");

       restControllerMailService.sendSimpleMessage(mail);
        return "ok";
    }

    @RequestMapping(value="/etat",method= RequestMethod.POST)
        public Client upEtat( Long id ) {
            Client c = iClient.getOne(id);
            c.setEtat(0);
        System.out.println("Spring Mail - Sending Simple Email with JavaMailSender Example");

        Mail mail = new Mail();
        mail.setFrom("ad.mon.traiteur@gmail.com");
        mail.setTo(c.getLogin());
        mail.setSubject(" Confirmation email");
        mail.setContent("Dear user " +c.getFirst_name()+" have a great user experience");

        restControllerMailService.sendSimpleMessage(mail);
            return iClient.save(c);
    }
    @GetMapping("/alletat")
    public List<Client> alletat()
    { return iClient.getAllBybyetat();}

    @GetMapping("/allnotif")
    public List<Client> allnotif()
        { return iClient.getAllBybynotif();}
////@GetMapping("/allnotification")
//   // public List<Client> getAllByNotif() {
//       // ArrayList<Client> clients = new ArrayList<>();
//
//        for (Client client : iClient.findAll()) {
//            if (client.getNotif().equals("true")) {
//                clients.add(client);
//            }
//        }
//        System.out.println("list "+ clients);
//        return clients;
//    }

    @PutMapping("/update/{id}")
    public Client updateClient(Client client, @RequestParam("img") MultipartFile img, @PathVariable long id) {
        try {

            storageService.store(img);
            client.setFile(storageService.store(img));

            return iClient.saveAndFlush(client);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }


    @GetMapping("/files/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Object fileStorageService;
        Resource resource = storageService.loadFile(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            // logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @DeleteMapping("/remove")
    public Response removeClient(@RequestParam Long id) {
        Response r = new Response();
        try {
            r.setMsg("suppressin avec succée");

            iClient.deleteById(id);
            return r;

        } catch (Exception e) {
            r.setMsg("erreur");
            System.out.println();
            return r;
        }
    }
}


