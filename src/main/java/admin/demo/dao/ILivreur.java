package admin.demo.dao;

import admin.demo.models.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILivreur extends JpaRepository <Livreur,Long> {
}
