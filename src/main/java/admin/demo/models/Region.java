package admin.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "region")
public class Region {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nomR;
    @OneToMany(mappedBy = "region")
    @JsonIgnore
    public List<Livreur> livreur;

    @OneToMany(mappedBy = "region")
    @JsonIgnore
    public List<Traiteur> traiteur;

    public Region() {
    }

    public Region(String nomR, List<Livreur> livreur, List<Traiteur> traiteur) {
        this.nomR = nomR;
        this.livreur = livreur;
        this.traiteur = traiteur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomR() {
        return nomR;
    }

    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

    public List<Livreur> getLivreur() {
        return livreur;
    }

    public void setLivreur(List<Livreur> livreur) {
        this.livreur = livreur;
    }

    public List<Traiteur> getTraiteur() {
        return traiteur;
    }

    public void setTraiteur(List<Traiteur> traiteur) {
        this.traiteur = traiteur;
    }
}
