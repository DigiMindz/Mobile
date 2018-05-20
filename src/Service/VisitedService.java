/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Etablissement;
import Entity.Evenement;
import Entity.LikedEtablissement;
import Entity.Test;
import Entity.VisitedEtablissement;
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
public class VisitedService {

    
 ArrayList<VisitedEtablissement> listw = new ArrayList<>();
int i;
int visits;
          public ArrayList<VisitedEtablissement> getLiked(String json)  {

        
        ArrayList<VisitedEtablissement> LsE = new ArrayList<>();        
        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> wishes = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(wishes);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) wishes.get("root");

            for (Map<String, Object> obj : list) {
                VisitedEtablissement e = new VisitedEtablissement();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
                
                e.setId((int) id);
                LinkedHashMap<String,Object> userr = (LinkedHashMap<String,Object>) obj.get("user");
                float id_user = Float.parseFloat(userr.get("id").toString());
                
                e.setUser((int) id_user);
                
                
                LinkedHashMap<String,Object> etabs = (LinkedHashMap<String,Object>) obj.get("favoris");
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
                float id_rep = Float.parseFloat(user.get("id").toString());
                E.setResponsable((int)id_rep);
                e.setEtab(E);
               
                LsE.add(e);

            }

        } catch (IOException ex) {
        }
        
        return LsE;

    }
    public int check(int user,int etab){
    
    ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/checkV/"+etab+"/"+user);
        
        
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
        public int count(int etab){
    
    ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/countVisits/"+etab);
        
        
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                  
                    String s=tasks.get("valeur").toString();
                    float id = Float.parseFloat(s);
                    visits=(int)id;
                    
                   
                } catch (IOException ex) {
                }
                  
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         return visits; 
    }
        public void ajoutV(int E,int user) {
         
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/addV/"+E+"/"+user;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
        public void deleteV(int E,int user) {
        
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/deleteV/"+E+"/"+user;
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
                
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

    }
                
                                  public ArrayList<VisitedEtablissement> getV(int id_user)
    {       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/showVisits/" + id_user);  
        con.addResponseListener(new ActionListener<NetworkEvent>() 
        {
            @Override
            public void actionPerformed(NetworkEvent evt) 
            {
                listw = getLiked(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listw;
    }

}