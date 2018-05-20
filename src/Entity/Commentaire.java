/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Maissa
 */
public class Commentaire {
    
    private int id;  
    private String comment;
    private String created;
    private int etablissement_id;
    private int user_id;
    private String updatedAt;
    private String photo;
    

    public Commentaire() {
    }

    
    public Commentaire(int id, String comment) {
        this.id = id;
        this.comment = comment;
        
    }
    
    public Commentaire(int id, String comment,String created) {
        this.id = id;
        this.comment = comment;
        this.created=created; 
        
    }
    
    public Commentaire(int id, String comment,int etablissement_id,String created) {
        this.id = id;
        this.comment = comment;
        this.etablissement_id=etablissement_id;
        this.created=created;
        
    }
    
    public Commentaire(int id, String comment,int id_etab,String created,String photo) {
        this.id = id;
        this.comment = comment;
        this.etablissement_id=id_etab;
        this.created=created;
        this.photo=photo;
        
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getEtablissement_id() {
        return etablissement_id;
    }

    public void setEtablissement_id(int etablissement_id) {
        this.etablissement_id = etablissement_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "comment=" + comment + '}';
    }
    
    
    
    
    
    
}
