/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import com.codename1.l10n.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Reservation {
    private int id;
    private Etablissement id_etablissement;
    private int id_user;
    private Date date;
    private String heure;
    private String nom;
    private String prenom;
    private String num_tel;
    private int nbr_personnes;
    
   
    
    


  
    //Les attributs DB
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formater1 = new SimpleDateFormat ("HH:mm:ss");
    
    public Reservation(Etablissement id_etablissement, int id_user, Date date, String nom, String prenom, String num_tel, int nbr_personnes) {
        
        this.id_etablissement = id_etablissement;
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel = num_tel;
        this.nbr_personnes = nbr_personnes;
        this.date=date;       
    }

    public Reservation(int id, Etablissement id_etablissement, int id_user, Date date, String nom, String prenom, 
            String num_tel, int nbr_personnes) 
    {
        this.id = id;
        this.id_etablissement = id_etablissement;
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel = num_tel;
        this.nbr_personnes = nbr_personnes; 
        this.date=date;
       
    }


    
    
    public Reservation()
    {
        
    }
   
    public Date getDate(){
        return date; 
    }
     
    public void setDate(Date date) {
        this.date=date;
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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNbr_personnes() {
        return nbr_personnes;
    }

    public void setNbr_personnes(int nbr_personnes) {
        this.nbr_personnes = nbr_personnes;
    }
  

        @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", id_etablissement=" + id_etablissement + ", id_user=" + id_user + ", date=" + date + ", nom=" + nom + ", prenom=" + prenom + ", num_tel=" + num_tel + ", nbr_personnes=" + nbr_personnes + '}';
    }
    
    
}
