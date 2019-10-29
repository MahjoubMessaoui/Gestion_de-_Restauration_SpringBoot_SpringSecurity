package admin.demo.dao;

import admin.demo.models.SpecialiteT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISpecialiteT extends JpaRepository <SpecialiteT,Long> {
}
