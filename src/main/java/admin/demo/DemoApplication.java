package admin.demo;

import admin.demo.utlis.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.Resource;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class DemoApplication implements CommandLineRunner {
    @Resource
    StorageService storageService;

public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
       // storageService.deleteAll();
      //  storageService.init();
        }
}
