package admin.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "client")
public class Client extends Personne {
    private String adresse ;
    private String file;
    private int etat;
    private String notif;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    public List<Commande> commande;

    @OneToMany(cascade=CascadeType.REMOVE, fetch=FetchType.EAGER ,mappedBy = "client",orphanRemoval=true)
    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    public List<Rec> recs;

    public Client() {
    }

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

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getNotif() {
        return notif;
    }

    public void setNotif(String notif) {
        this.notif = notif;
    }

    public List<Commande> getCommande() {
        return commande;
    }

    public void setCommande(List<Commande> commande) {
        this.commande = commande;
    }

    public List<Rec> getRecs() {
        return recs;
    }

    public void setRecs(List<Rec> recs) {
        this.recs = recs;
    }

    public Client(String adresse, String file, int etat, String notif, List<Commande> commande, List<Rec> recs) {
        this.adresse = adresse;
        this.file = file;
        this.etat = etat;
        this.notif = notif;
        this.commande = commande;
        this.recs = recs;
    }

    public Client(String first_name, String last_name, String phone, String login, String psw, Date createdAt, Date updatedAt, String adresse, String file, int etat, String notif, List<Commande> commande, List<Rec> recs) {
        super(first_name, last_name, phone, login, psw, createdAt, updatedAt);
        this.adresse = adresse;
        this.file = file;
        this.etat = etat;
        this.notif = notif;
        this.commande = commande;
        this.recs = recs;
    }
}
