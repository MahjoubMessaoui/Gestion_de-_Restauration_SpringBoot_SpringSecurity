package admin.demo.dao;


import admin.demo.models.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlat extends JpaRepository <Plat ,Long>{
}
