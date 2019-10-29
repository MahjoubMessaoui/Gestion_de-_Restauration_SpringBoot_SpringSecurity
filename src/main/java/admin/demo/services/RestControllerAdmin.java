package admin.demo.services;

import admin.demo.dao.IAdmin;
import admin.demo.models.Admin;
import admin.demo.utlis.StorageService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin")

@CrossOrigin("*")
public class RestControllerAdmin {
    @Autowired
    private IAdmin iAdmin;
    @Autowired
    StorageService storageService;


    @GetMapping("/")
    public String admin() {
        return "bienvenue";
    }

    @GetMapping("/all")
    public List<Admin> getALLAdmin() {
        return iAdmin.findAll();
    }

    @PostMapping("/login")
    public Admin login (@RequestBody Admin a)
    {
        return iAdmin.login(a.getLogin(),a.getPsw());
    }
    @DeleteMapping("/remove")
    public String removeAdmin(Long admin) {
        try {
            iAdmin.deleteById(admin);
            return "yes";
        } catch (Exception e) {
            return "no";
        }

    }
    @GetMapping("/byid")
    public Admin getbyid(Long id)
    {
        return iAdmin.getOne(id);
    }

    @PostMapping("/add")
    public Admin addAdmin(Admin admin, @RequestParam("img") MultipartFile img) {
        try {

            storageService.store(img);
            admin.setFile(storageService.store(img));

            return iAdmin.saveAndFlush(admin) ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/files/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = storageService.loadFile(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            //  logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
