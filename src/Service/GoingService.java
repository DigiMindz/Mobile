/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Etablissement;
import Entity.Evenement;
import Entity.GoingEvent;
import Entity.Test;
//import Entity.User;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ons Ben Othmen
 */
public class GoingService {

    

int i;
int visits;
ArrayList<GoingEvent> listEvents = new ArrayList<>();
          public ArrayList<GoingEvent> getListEvents(String json)  {

        

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> events = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(events);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");

            for (Map<String, Object> obj : list) {
                GoingEvent e = new GoingEvent();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
                LinkedHashMap<String,Object> user = (LinkedHashMap<String,Object>) obj.get("user");
                float id_us = Float.parseFloat(user.get("id").toString());
                e.setUser((int)id_us);
                e.setId((int) id);
                
                LinkedHashMap<String,Object> EV = (LinkedHashMap<String,Object>) obj.get("event");
                Evenement E1=new Evenement();
                Map<String, Object> debut = (Map<String, Object>) EV.get("date");
                    double t = (double) debut.get("timestamp");
                    long x = (long) (t * 1000L);
                E1.setDate(new Date(x));
                E1.setDescription(EV.get("description").toString());
                System.out.println(EV.get("interesses").toString());
                float inter = Float.parseFloat(EV.get("interesses").toString());
                float going= Float.parseFloat(EV.get("nbr_personnes").toString());
                //Etablissement etab= (Etablissement) obj.get("etablissement");
                E1.setInteresses((int) inter);
                E1.setNbr_personnes((int) going);
                
                LinkedHashMap<String,Object> etabs = (LinkedHashMap<String,Object>) EV.get("etablissement");
                Etablissement E=new Etablissement();
                
                
                float idu = Float.parseFloat(etabs.get("id").toString());
                E.setId((int) idu);
                E.setNom(etabs.get("nom").toString());
                E.setAdresse(etabs.get("adresse").toString());
                E.setDescription(etabs.get("description").toString());
                if (etabs.get("typeResto") != null)
                {
                    E.setType_resto(etabs.get("typeResto").toString());
                }
                if (etabs.get("typeShops") != null)
                {
                    E.setType_shops(etabs.get("typeShops").toString());
                }
                if (etabs.get("typeLoisirs") != null)
                {
                    E.setType_loisirs(etabs.get("typeLoisirs").toString());
                }
                if (etabs.get("nbrStars") != null)
                {
                    E.setNbrStars(etabs.get("nbrStars").toString());
                }
                E.setType(etabs.get("type").toString());
                E.setHoraire_ouverture(etabs.get("horaireOuverture").toString());
                E.setHoraire_fermeture(etabs.get("horaireFermeture").toString());
                E.setNumtel(Integer.parseInt(etabs.get("numTel").toString()));
                E.setImage(etabs.get("imagePrincipale").toString());
                E.setUrl(etabs.get("URL").toString());
                E.setBudgetmoyen(Integer.parseInt(etabs.get("budgetmoyen").toString()));
                float part = Float.parseFloat(etabs.get("partenaire").toString());
                E.setPartenaire((int) part);
                LinkedHashMap<String,Object> user_rep = (LinkedHashMap<String,Object>) etabs.get("representant");
                float id_user = Float.parseFloat(user_rep.get("id").toString());
                E.setResponsable((int)id_user);
                E1.setId_etablissement(E);
                E1.setNom(EV.get("nom").toString());
                e.setEvent(E1);
                listEvents.add(e);

            }

        } catch (IOException ex) {
        }
        System.out.println(listEvents);
        return listEvents;

    }
              public ArrayList<GoingEvent> getGoings(int id_user){
       
        ConnectionRequest con = new ConnectionRequest();
       
        con.setUrl("http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/showGoings/"+id_user);  
        
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                GoingService ser = new GoingService();
                
                    listEvents= ser.getListEvents(new String(con.getResponseData()));
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

        return listEvents;
    }
    public int check(int user,int event){
    
    ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/checkGoing/"+event+"/"+user);
        
        
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                  
                    String s=tasks.get("valeur").toString();
                    float id = Float.parseFloat(s);
                    i=(int)id;
                    
                   
                } catch (IOException ex) {
                }
                  
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         return i; 
    }

        public void ajoutV(int E,int user) {
         
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/addGoing/"+E+"/"+user;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
        public void deleteV(int E,int user) {
        
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/deleteGoing/"+E+"/"+user;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
                
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
                
      

}