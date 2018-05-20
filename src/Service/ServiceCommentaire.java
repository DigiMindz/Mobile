/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import Entity.Commentaire;
import Entity.Etablissement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Maissa
 */
public class ServiceCommentaire 
{
    
    public void ajoutCommentaire(Commentaire C, Etablissement E)
    {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobil/addCommentaire/" + C.getComment() + 
                "/" + Integer.toString(E.getId()) + "/2";
        con.setUrl(Url);

        System.out.println("tt");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
//            if (str.trim().equalsIgnoreCase("OK")) {
//                f2.setTitle(tlogin.getText());
//             f2.show();
//            }
//            else{
//            Dialog.show("error", "login ou pwd invalid", "ok", null);
//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);   
    }
    
    
    
    public ArrayList<Commentaire> getListCommentaires(String json) 
    {
        ArrayList<Commentaire> listComment = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(etudiants);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");

            for (Map<String, Object> obj : list) {
                Commentaire e = new Commentaire();

                // System.out.println(obj.get("id"));
                float id = Float.parseFloat(obj.get("id").toString());
                System.out.println(id);
                e.setId((int) id);
                //e.setId(Integer.parseInt(obj.get("id").toString().trim()));
                e.setComment(obj.get("comment").toString());
             //   e.setCreated(obj.get("created").toString());
               // e.setNom(obj.get("name").toString());
                System.out.println(e);
                listComment.add(e);

            }

        } catch (IOException ex) {
        }
        System.out.println(listComment);
        return listComment;
    }
    
    ArrayList<Commentaire> listCommentaires = new ArrayList<>();
    
    public ArrayList<Commentaire> getList2(Etablissement E)
    {       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/AfficheService/" + Integer.toString(E.getId()));  
        con.addResponseListener(new ActionListener<NetworkEvent>() 
        {
            @Override
            public void actionPerformed(NetworkEvent evt) 
            {
                ServiceCommentaire ser = new ServiceCommentaire();
                listCommentaires = ser.getListCommentaires(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listCommentaires;
    }
    
    public void SuppCommentaire(Commentaire C)
    {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobil/suppCommentaire/" + Integer.toString(C.getId());
        con.setUrl(Url);

        System.out.println("test suppression");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
//            if (str.trim().equalsIgnoreCase("OK")) {
//                f2.setTitle(tlogin.getText());
//             f2.show();
//            }
//            else{
//            Dialog.show("error", "login ou pwd invalid", "ok", null);
//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con); 
        
    }
    
    public void ModifCommentaire(Commentaire C)
    {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobil/modifCommentaire/" + C.getId()+ "/" + C.getComment();
        con.setUrl(Url);

        System.out.println("test modif");

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
//            if (str.trim().equalsIgnoreCase("OK")) {
//                f2.setTitle(tlogin.getText());
//             f2.show();
//            }
//            else{
//            Dialog.show("error", "login ou pwd invalid", "ok", null);
//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con); 
    }
    
    public void SignCommentaire()
    {
        
    }
    
    
    
    
    
}
