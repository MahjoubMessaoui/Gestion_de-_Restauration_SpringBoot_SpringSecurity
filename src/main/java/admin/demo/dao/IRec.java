package admin.demo.dao;

import admin.demo.models.Rec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRec extends JpaRepository<Rec,Long> {
}
