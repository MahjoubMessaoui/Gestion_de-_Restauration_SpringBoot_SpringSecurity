package admin.demo.dao;

import admin.demo.models.Client;
import admin.demo.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommande extends JpaRepository <Commande,Long> {

    //Get order of one client
    @Query("select c from Commande c where c.client= :client")
    List<Commande>getCOfClient(@Param("client")Client client);
}
