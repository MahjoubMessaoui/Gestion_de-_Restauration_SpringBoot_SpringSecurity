package admin.demo.dao;


import admin.demo.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClient extends JpaRepository<Client,Long> {

    @Query("select c from Client c where c.notif='true'")
    List<Client> getAllBybynotif();

    @Query("select c from Client c where c.etat=0 ")
    List<Client> getAllBybyetat();

}
