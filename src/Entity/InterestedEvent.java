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
public class InterestedEvent {
   
    private int id;
    private int user;
    private Evenement event;

    public InterestedEvent(int id, int user, Evenement event) {
        this.id = id;
        this.user = user;
        this.event = event;
    }

    public InterestedEvent(int user, Evenement event) {
        this.user = user;
        this.event = event;
    }

    public InterestedEvent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public Evenement getEvent() {
        return event;
    }

    public void setEvent(Evenement event) {
        this.event = event;
    }

  
    @Override
    public String toString() {
        return "InterestedEvent{" + "id=" + id + ", user=" + user + ", event=" + event + '}';
    }

   
    

   
    
}
