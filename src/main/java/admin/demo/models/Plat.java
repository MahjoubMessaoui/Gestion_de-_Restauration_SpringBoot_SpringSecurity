package admin.demo.models;

import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "plat")
public class Plat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long refP;
    private String nom;
    private int stock;
    private boolean disponibilite ;
    private double prix;
    private String file ;
    @ManyToOne
    @JoinColumn(name = "specialiteT_id",nullable = false)
    private SpecialiteT specialiteT;
    @ManyToMany(mappedBy = "plat")
    private List<Commande> commande;

    @ManyToOne
    @JoinColumn(name = "traiteur_id",nullable = false)

    private Traiteur traiteur;

    public Plat() {
    }

    public Plat(String nom, int stock, boolean disponibilite, double prix, String file, SpecialiteT specialiteT, List<Commande> commande, Traiteur traiteur) {
        this.nom = nom;
        this.stock = stock;
        this.disponibilite = disponibilite;
        this.prix = prix;
        this.file = file;
        this.specialiteT = specialiteT;
        this.commande = commande;
        this.traiteur = traiteur;
    }

    public Long getRefP() {
        return refP;
    }

    public void setRefP(Long refP) {
        this.refP = refP;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public SpecialiteT getSpecialiteT() {
        return specialiteT;
    }

    public void setSpecialiteT(SpecialiteT specialiteT) {
        this.specialiteT = specialiteT;
    }

    public List<Commande> getCommande() {
        return commande;
    }

    public void setCommande(List<Commande> commande) {
        this.commande = commande;
    }

    public Traiteur getTraiteur() {
        return traiteur;
    }

    public void setTraiteur(Traiteur traiteur) {
        this.traiteur = traiteur;
    }
}
