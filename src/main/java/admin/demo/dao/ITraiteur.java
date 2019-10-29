package admin.demo.dao;

import admin.demo.models.Traiteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ITraiteur extends JpaRepository <Traiteur,Long> {
}
