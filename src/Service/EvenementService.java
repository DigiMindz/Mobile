/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Entity.Etablissement;
import Entity.Evenement;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
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
public class EvenementService {
   ArrayList<Evenement> listEvents = new ArrayList<>();
          public ArrayList<Evenement> getListEvents(String json)  {

        

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> events = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(events);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");

            for (Map<String, Object> obj : list) {
                Evenement e = new Evenement();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
                System.out.println(id);
                e.setId((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                
                Map<String, Object> debut = (Map<String, Object>) obj.get("date");
                    double t = (double) debut.get("timestamp");
                    long x = (long) (t * 1000L);
                e.setDate(new Date(x));
                e.setDescription(obj.get("description").toString());
                System.out.println(obj.get("interesses").toString());
                float inter = Float.parseFloat(obj.get("interesses").toString());
                float going= Float.parseFloat(obj.get("nbr_personnes").toString());
                //Etablissement etab= (Etablissement) obj.get("etablissement");
                e.setInteresses((int) inter);
                e.setNbr_personnes((int) going);
                
                LinkedHashMap<String,Object> etabs = (LinkedHashMap<String,Object>) obj.get("etablissement");
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
                LinkedHashMap<String,Object> user = (LinkedHashMap<String,Object>) etabs.get("representant");
                float id_user = Float.parseFloat(user.get("id").toString());
                E.setResponsable((int)id_user);
                e.setId_etablissement(E);
                e.setNom(obj.get("nom").toString());
                System.out.println(e);
                listEvents.add(e);

            }

        } catch (IOException ex) {
        }
        System.out.println(listEvents);
        return listEvents;

    }
          
             
    
    public ArrayList<Evenement> getList2(){
       
        ConnectionRequest con = new ConnectionRequest();
       
        con.setUrl("http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/events");  
        
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                EvenementService ser = new EvenementService();
                
                    listEvents= ser.getListEvents(new String(con.getResponseData()));
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

        return listEvents;
    }
        public ArrayList<Evenement> getListCle(String mot){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/Chercherevents/"+mot);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                EvenementService ser = new EvenementService();
                
                    listEvents= ser.getListEvents(new String(con.getResponseData()));
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvents;
    }
                public ArrayList<Evenement> getListEtab(Etablissement E){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/eventsEtab/"+E.getId());  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                EvenementService ser = new EvenementService();
                
                    listEvents= ser.getListEvents(new String(con.getResponseData()));
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvents;
    }
    public void ajouteEvenement(Evenement E) {
        listEvents.add(E);
        ConnectionRequest con = new ConnectionRequest();
        
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/addEvent/"+E.getId_etablissement().getId()+"/"+E.getDate()+"/"+E.getNom()+"/"+E.getDescription();
        con.setUrl(Url);
        System.out.println(con.getUrl());
        System.out.println("tt");
        System.out.println("--------");
        System.out.println(Url);
        System.out.println("ok");
        System.out.println(E.getDate());

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         System.out.println("fin");
    }
    public void updateEvenement(Evenement E,Evenement E2) {
        
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/updateEvent/"+E.getId()+"/"+E2.getDate()+"/"+E2.getNom()+"/"+E2.getDescription();
        con.setUrl(Url);


        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         
    }
        public void deleteEvenement(Evenement E) {
        listEvents.remove(E);
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/deleteEvent/"+E.getId();
        con.setUrl(Url);


        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         
    }
}
