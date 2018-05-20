/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Evenement;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;

/**
 *
 * @author Ons Ben Othmen
 */
public class smsService {
        public void sendSMS(String text) {
        ConnectionRequest cntRqst = new ConnectionRequest() ;
                cntRqst.setPost(false);
                

               
                //key=3386767e
                //secret=q5cRVthECzU7ERTM
                cntRqst.setUrl("https://rest.nexmo.com/sms/json?api_key=3386767e&api_secret=q5cRVthECzU7ERTM"
                    +"&to=21628870445"
                    +"&from=NEXMO"
                    +"&text="+text
                   );
        
                 cntRqst.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                       System.out.println("ok");
//                      if (s.equals("success")) {
//                           Dialog.show("SMS", "sms successfully sent", "OK", null);
//                      }
                    }
                });
                 
                NetworkManager.getInstance().addToQueue(cntRqst);

        
    }
    
}
