/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


/**
 *
 * @author Ons Ben Othmen
 */
public class LikedEtablissement {
    private int id;
    private Etablissement etab;
    private int user;

    public LikedEtablissement(Etablissement etab, int user) {
        this.etab = etab;
        this.user = user;
    }

    public LikedEtablissement(int id, Etablissement etab, int user) {
        this.id = id;
        this.etab = etab;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Etablissement getEtab() {
        return etab;
    }

    public void setEtab(Etablissement etab) {
        this.etab = etab;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }


  
    @Override
    public String toString() {
        return "LikedEtablissement{" + "id=" + id + ", etab=" + etab + ", user=" + user + '}';
    }

    public LikedEtablissement() {
    }
    
}
