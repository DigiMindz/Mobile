/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Ons Ben Othmen
 */
public class Offre {
    private int id;
    private Etablissement id_etablissement;
    private Date date_debut;
    private Date date_fin;
    private String description;
    private String offre;
    private String code;
    private double pourcentage;

    public Offre(Etablissement id_etablissement, Date date_debut, Date date_fin, String description, String offre, String code, double pourcentage) {
        this.id_etablissement = id_etablissement;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
        this.offre = offre;
        this.code = code;
        this.pourcentage = pourcentage;
    }
        public Offre(Etablissement id_etablissement, Date date_debut, Date date_fin, String description, String offre) {
        this.id_etablissement = id_etablissement;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
        this.offre = offre;
    }


    public Offre(int id, Etablissement id_etablissement, Date date_debut, Date date_fin, String description, String offre, String code, double pourcentage) {
        this.id = id;
        this.id_etablissement = id_etablissement;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
        this.offre = offre;
        this.code = code;
        this.pourcentage = pourcentage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }
   

    public Offre(Date date_debut, Date date_fin, String description, String offre) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
        this.offre = offre;
    }

    public Offre() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Etablissement getId_etablissement() {
        return id_etablissement;
    }

    public void setId_etablissement(Etablissement id_etablissement) {
        this.id_etablissement = id_etablissement;
    }



    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOffre() {
        return offre;
    }

    public void setOffre(String offre) {
        this.offre = offre;
    }

    

    @Override
    public String toString() {
        return "Offre{" + "id=" + id + ", id_etablissement=" + id_etablissement + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", description=" + description + ", offre=" + offre + '}';
    }
}
