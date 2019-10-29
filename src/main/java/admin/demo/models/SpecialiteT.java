package admin.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "specialiteT")
public class SpecialiteT implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idS;
    private String nomS;

    @OneToMany(mappedBy = "specialiteT")
    @JsonIgnore
    public List<Plat> plat;
    @ManyToMany(mappedBy = "specialiteT")
    @JsonIgnore
    private List<Traiteur> traiteur ;

    public SpecialiteT() {
    }

    public long getIdS() {
        return idS;
    }

    public void setIdS(long idS) {
        this.idS = idS;
    }

    public String getNomS() {
        return nomS;
    }

    public void setNomS(String nomS) {
        this.nomS = nomS;
    }

    public List<Plat> getPlat() {
        return plat;
    }

    public void setPlat(List<Plat> plat) {
        this.plat = plat;
    }

    public List<Traiteur> getTraiteur() {
        return traiteur;
    }

    public void setTraiteur(List<Traiteur> traiteur) {
        this.traiteur = traiteur;
    }

    public SpecialiteT(String nomS, List<Plat> plat, List<Traiteur> traiteur) {
        this.nomS = nomS;
        this.plat = plat;
        this.traiteur = traiteur;
    }
}
