/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Reclamation;
import Entity.User;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.lang.String;

/**
 *
 * @author DADOU
 */
public class ServiceUser {
    
    
    public void ajoutUser(User user) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/AddUserWebSer/"+user.getNom()+"/"+user.getSexe()
                +"/"+user.getVille()+"/"+user.getPhone()+"/"+user.getEmail()+"/"+user.getUsername()+"/"+user.getPassword();
        con.setUrl(Url);

        

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
            System.out.println("User ajouté");
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    
    public void DeleteUser(User user) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/DeleteUsWebSer/"+user.getId();
        con.setUrl(Url);

        

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
            System.out.println("User supprimé");
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

}
