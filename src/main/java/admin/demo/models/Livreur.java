package admin.demo.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "livreur")
public class Livreur extends Personne{
    private String position;
    private String adresse ;
private boolean disponibilite;

    @ManyToOne
    @JoinColumn(name = "region_id",nullable = false)
    private Region region;
    @OneToMany(mappedBy = "livreur")
    public List<Commande> commande ;

    public Livreur() {
    }

    public Livreur(String position, String adresse, boolean disponibilite, Region region, List<Commande> commande) {
        this.position = position;
        this.adresse = adresse;
        this.disponibilite = disponibilite;
        this.region = region;
        this.commande = commande;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilité(boolean disponibilité) {
        this.disponibilite = disponibilite;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Commande> getCommande() {
        return commande;
    }

    public void setCommande(List<Commande> commande) {
        this.commande = commande;
    }

    public Livreur(String first_name, String last_name, String phone, String login, String psw, Date createdAt, Date updatedAt, String position, String adresse, boolean disponibilité, Region region, List<Commande> commande) {
        super(first_name, last_name, phone, login, psw, createdAt, updatedAt);
        this.position = position;
        this.adresse = adresse;
        this.disponibilite = disponibilite;
        this.region = region;
        this.commande = commande;

    }
}

