package admin.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "traiteur")
public class Traiteur extends Personne {
    private String adresse ;
    private String file;

    @ManyToOne
    @JoinColumn(name = "region_id",nullable = false)

    private Region region;

    @OneToMany(mappedBy = "traiteur")
    @JsonIgnore
    public List<Plat> plat;

    @ManyToMany
    @JoinTable (name = "traiteur_spec",
            joinColumns =@JoinColumn(name = "traiteurId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "specId",referencedColumnName = "idS"))
private List<SpecialiteT>specialiteT;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Plat> getPlat() {
        return plat;
    }

    public void setPlat(List<Plat> plat) {
        this.plat = plat;
    }

    public List<SpecialiteT> getSpecialiteT() {
        return specialiteT;
    }

    public void setSpecialiteT(List<SpecialiteT> specialiteT) {
        this.specialiteT = specialiteT;
    }

    public Traiteur() {
    }

    public Traiteur(String first_name, String last_name, String phone, String login, String psw, Date createdAt, Date updatedAt) {
        super(first_name, last_name, phone, login, psw, createdAt, updatedAt);
    }

    public Traiteur(String adresse, String file, Region region, List<Plat> plat, List<SpecialiteT> specialiteT) {
        this.adresse = adresse;
        this.file = file;
        this.region = region;
        this.plat = plat;
        this.specialiteT = specialiteT;
    }

    public Traiteur(String first_name, String last_name, String phone, String login, String psw, Date createdAt, Date updatedAt, String adresse, String file, Region region, List<Plat> plat, List<SpecialiteT> specialiteT) {
        super(first_name, last_name, phone, login, psw, createdAt, updatedAt);
        this.adresse = adresse;
        this.file = file;
        this.region = region;
        this.plat = plat;
        this.specialiteT = specialiteT;
    }
}
