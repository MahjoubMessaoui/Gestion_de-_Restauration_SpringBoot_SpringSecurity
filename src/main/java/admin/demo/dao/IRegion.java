package admin.demo.dao;

import admin.demo.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegion extends JpaRepository<Region,Long> {
}
