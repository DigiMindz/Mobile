/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Etablissement;
import Entity.Evenement;
import Entity.Offre;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ons Ben Othmen
 */
public class OffreService {
      public ArrayList<Offre> getListOffers(String json)  {

        ArrayList<Offre> listOffres = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> offers = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(offers);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) offers.get("root");

            for (Map<String, Object> obj : list) {
                Offre e = new Offre();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
                System.out.println(id);
                e.setId((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                
                Map<String, Object> debut = (Map<String, Object>) obj.get("dateDebut");
                    double t1 = (double) debut.get("timestamp");
                    long x1 = (long) (t1 * 1000L);
                Map<String, Object> fin = (Map<String, Object>) obj.get("dateFin");
                    double t2 = (double) fin.get("timestamp");
                    long x2 = (long) (t2 * 1000L);
                e.setDate_debut(new Date(x1));
                e.setDate_fin(new Date(x2));
                e.setDescription(obj.get("description").toString());
                String aa = obj.get("pourcentage").toString();
                Double pour= Double.parseDouble(aa);
                //Etablissement etab= (Etablissement) obj.get("etablissement");
               
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
                LinkedHashMap<String,Object> user = (LinkedHashMap<String,Object>) etabs.get("representant");
                float id_user = Float.parseFloat(user.get("id").toString());
                E.setResponsable((int)id_user);
                float partenaire = Float.parseFloat(etabs.get("partenaire").toString());
                E.setPartenaire((int) partenaire);
                if ((int) partenaire==1){
                e.setCode(obj.get("codePromo").toString());
                e.setPourcentage( pour);
                }
                else {
                e.setCode("");
                e.setPourcentage( 0);
                }
                e.setId_etablissement(E);
                e.setOffre(obj.get("offre").toString());
                System.out.println(e);
                listOffres.add(e);

            }

        } catch (IOException ex) {
        }
        System.out.println(listOffres);
        return listOffres;

    }
          
    ArrayList<Offre> listOffres = new ArrayList<>();
    
    public ArrayList<Offre> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/offres");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                OffreService ser = new OffreService();
                
                    listOffres= ser.getListOffers(new String(con.getResponseData()));
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listOffres;
    }
            public ArrayList<Offre> getListCle(String mot){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/Chercheroffres/"+mot);  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                OffreService ser = new OffreService();
                
                    listOffres= ser.getListOffers(new String(con.getResponseData()));
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listOffres;
    }
                        public ArrayList<Offre> getListEtab(Etablissement E){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/offresEtab/"+E.getId());  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                OffreService ser = new OffreService();
                
                    listOffres= ser.getListOffers(new String(con.getResponseData()));
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listOffres;
    }
                public void ajouteOffreAvec(Offre E) {
     
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/addOffreAvec/"+E.getId_etablissement().getId()+"/"+E.getDate_debut()+"/"+E.getDate_fin()+"/"+E.getOffre()+"/"+E.getDescription()+"/"+E.getCode()+"/"+E.getPourcentage();
        con.setUrl(Url);

       

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            

//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         
    }
    public void ajouteOffreSans(Offre E) {
        
//String date_s = " 2011-01-18 00:00:00.0"; 
//SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss"); 
//Date date = dt.parse(date_s); 
//SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");
//System.out.println(dt1.format(date));
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/addOffreSans/"+E.getId_etablissement().getId()+"/"+E.getDate_debut()+"/"+E.getDate_fin()+"/"+E.getOffre()+"/"+E.getDescription();
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            

//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         
    }
        public void updateOffreSans(Offre E,Offre E2) {
        
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/updateOffreSansPromoJson/"+E.getId()+"/"+E2.getDate_debut()+"/"+E2.getDate_fin()+"/"+E2.getOffre()+"/"+E2.getDescription();
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         
    }
                public void updateOffreAvec(Offre E,Offre E2) {
        
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/updateOffreAvecPromoJson/"+E.getId()+"/"+E2.getDate_debut()+"/"+E2.getDate_fin()+"/"+E2.getOffre()+"/"+E2.getDescription()+"/"+E2.getCode()+"/"+E2.getPourcentage();
        con.setUrl(Url);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         
    }
                        public void deleteOffre(Offre E) {
        listOffres.remove(E);
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/deleteOffre/"+E.getId();
        con.setUrl(Url);


        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         
    }
}
