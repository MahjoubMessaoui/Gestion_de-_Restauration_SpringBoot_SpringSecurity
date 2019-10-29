package admin.demo.dao;

import admin.demo.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdmin extends JpaRepository <Admin,Long> {
    @Query("select a from Admin a where  a.login= :login and a.psw= :psw")
    Admin login(@Param("login") String login, @Param("psw") String psw);
}
