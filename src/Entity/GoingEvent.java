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
public class GoingEvent {
    private int id;
    private int user;
    private Evenement event;

    public GoingEvent(int id,int user, Evenement event) {
        this.user = user;
        this.event = event;
        this.id=id;
    }

    public GoingEvent(int user, Evenement event) {
        this.user = user;
        this.event = event;
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
        return "GoingEvent{" + "id=" + id + ", user=" + user + ", event=" + event + '}';
    }


    public GoingEvent() {
    }
    
}
