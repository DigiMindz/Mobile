/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Etablissement;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import Entity.Reservation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public class ReservationService {
    
    
     public void ajoutReservation(Reservation R,int user) {
     ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/addReservA/"+R.getId_etablissement().getId()+"/"+user+"/"+ R.getNom() + "/" + R.getPrenom()
                + "/" +R.getNum_tel() + "/" +R.getNbr_personnes() + "/" + R.getDate()
                ;
        con.setUrl(Url);

        System.out.println(con.getUrl());

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
     
     public ArrayList<Reservation> getListReservation(String json) {

        ArrayList<Reservation> listReservations = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> reservations = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(reservations);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) reservations.get("root");

            for (Map<String, Object> obj : list) {
                Reservation r = new Reservation();

                System.out.println(obj.get("id"));
                LinkedHashMap<String,Object> etabs = (LinkedHashMap<String,Object>) obj.get("etablissement");
                LinkedHashMap<String,Object> user = (LinkedHashMap<String,Object>) obj.get("user");
                float ide = Float.parseFloat(etabs.get("id").toString());
                float iduser = Float.parseFloat(user.get("id").toString());
                
                ////
                
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
                LinkedHashMap<String,Object> user_resp = (LinkedHashMap<String,Object>) etabs.get("representant");
                float id_user = Float.parseFloat(user_resp.get("id").toString());
                E.setResponsable((int)id_user);
                ////
                
                r.setId_etablissement(E);
                r.setId_user((int)iduser);
                Map<String, Object> date = (Map<String, Object>) obj.get("datedereservation");
                System.out.println(date);
                    double t = (double) date.get("timestamp");
                    long x = (long) (t * 1000L);
                    r.setDate(new Date(x));
                float id = Float.parseFloat(obj.get("id").toString());
                float nbr_personnes = Float.parseFloat(obj.get("nbrePersonnes").toString());
                
                System.out.println();
                r.setId((int) id);
                r.setNbr_personnes((int) nbr_personnes);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                r.setNom(obj.get("nom").toString());
                r.setPrenom(obj.get("prenom").toString());
                r.setNum_tel(obj.get("numtel").toString());
                //r.setId_etablissement("id_etablissement");
                System.out.println(r);
                listReservations.add(r);

            }

        } catch (IOException ex) {
        }
        System.out.println(listReservations);
        return listReservations;

    }
    ArrayList<Reservation> listReserv = new ArrayList<>();
    
    public ArrayList<Reservation> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/all");
        
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ReservationService ser = new ReservationService();
                listReserv = ser.getListReservation(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listReserv;
    }
    
    public ArrayList<Reservation> getListNom(Reservation R){       
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/findNom/"+ R.getNom();
        con.setUrl(Url);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ReservationService ser = new ReservationService();
                listReserv = ser.getListReservation(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listReserv;
    
    }
        public ArrayList<Reservation> getListUser(int id_user){       
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/findUser/"+ id_user;
        con.setUrl(Url);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ReservationService ser = new ReservationService();
                listReserv = ser.getListReservation(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listReserv;
    
    }
                public ArrayList<Reservation> getListEtab(Etablissement etab){       
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/findEtab/"+ etab.getId();
        con.setUrl(Url);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ReservationService ser = new ReservationService();
                listReserv = ser.getListReservation(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listReserv;
    
    }
                public ArrayList<Reservation> getMot(String mot,int id_etab){       
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/findMot/"+ mot+"/"+id_etab;
        con.setUrl(Url);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ReservationService ser = new ReservationService();
                listReserv = ser.getListReservation(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listReserv;
    
    }
    
    
    
     public void updateReservation(Reservation R,Reservation R2) {
        
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/update/"+ R.getId()+"/"+R.getId_etablissement().getId()+"/"+
                R.getId_user()+"/"+ R2.getNom() + "/" + R2.getPrenom()
                + "/" +R2.getNum_tel() + "/" +R2.getNbr_personnes() + "/" + R2.getDate();
        con.setUrl(Url);
        System.out.println(con.getUrl());

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         
    }
     public void deleteReservation(Reservation R) {
        //listReserv.remove(R);
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/delete/"+R.getId();
        con.setUrl(Url);


        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         
    }

    
}
