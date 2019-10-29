package admin.demo.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "commande")
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double prixC;

    public Commande() {
    }

    public Commande(double prixC, Client client, List<Plat> plat) {
        this.prixC = prixC;
        this.client = client;
        this.plat = plat;
    }
    @ManyToOne
    @JoinColumn(name = "livreur_id",nullable = false)
    private Livreur livreur;

    @ManyToOne
    private Client client;
    public List<Plat> getPlat() {
        return plat;
    }

    public void setPlat(List<Plat> plat) {
        this.plat = plat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
@ManyToMany
   @JoinTable (name = "cmd_plat",
           joinColumns =@JoinColumn(name = "Commande_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "Plat_ID",referencedColumnName = "refP"))
    List<Plat> plat;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrixC() {
        return prixC;
    }

    public void setPrixC(double prixC) {
        this.prixC = prixC;
    }


}
