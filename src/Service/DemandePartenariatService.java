/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Entity.DemandePartenariat;
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
public class DemandePartenariatService {
    int i;
      public void ajouteDemande(DemandePartenariat D) {
       
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/sendRequestPartnerShip/"+D.getEtab()+"/"+D.getDescription();
        con.setUrl(Url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
         
    }
      public int check(int etab){
    
    ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobile/checkD/"+etab);
        
        
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
}
