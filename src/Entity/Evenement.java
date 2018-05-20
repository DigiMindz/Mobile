/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

/**
 *
 * @author Ons Ben Othmen
 */
public class Evenement {
    private int id;
    private Etablissement id_etablissement;
    private Date date;
    private String description;
    private String nom;
    private int nbr_personnes;
    private int interesses;

    public Evenement(Date date, String description, String nom) {
        this.date = date;
        this.description = description;
        this.nom = nom;
    }

    public Evenement() {
    }

    public Evenement(int id,Etablissement id_etablissement, Date date, String description, String nom, int nbr_personnes, int interesses) {
        this.id_etablissement = id_etablissement;
        this.date = date;
        this.description = description;
        this.nom = nom;
        this.nbr_personnes = nbr_personnes;
        this.interesses = interesses;
        this.id=id;
    }

    public Evenement(Etablissement id_etablissement, Date date, String description, String nom, int nbr_personnes, int interesses) {
        this.id_etablissement = id_etablissement;
        this.date = date;
        this.description = description;
        this.nom = nom;
        this.nbr_personnes = nbr_personnes;
        this.interesses = interesses;
    }

    public Evenement(Etablissement id_etablissement, Date date, String description, String nom) {
        this.id_etablissement = id_etablissement;
        this.date = date;
        this.description = description;
        this.nom = nom;
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


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbr_personnes() {
        return nbr_personnes;
    }

    public void setNbr_personnes(int nbr_personnes) {
        this.nbr_personnes = nbr_personnes;
    }

    public int getInteresses() {
        return interesses;
    }

    public void setInteresses(int interesses) {
        this.interesses = interesses;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", id_etablissement=" + id_etablissement + ", date=" + date + ", description=" + description + ", nom=" + nom + ", nbr_personnes=" + nbr_personnes + ", interesses=" + interesses + '}';
    }



   
    
}
