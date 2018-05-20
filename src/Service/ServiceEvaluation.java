/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.codename1.components.ImageViewer;
import com.codename1.components.InteractionDialog;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import Entity.Commentaire;
import Entity.Etablissement;

/**
 *
 * @author Maissa
 */
public class ServiceEvaluation {
    private Resources theme = UIManager.initFirstTheme("/theme");
    
    public void ajoutAime(InteractionDialog dlg, Etablissement E){
        ConnectionRequest con = new ConnectionRequest();
        dlg.dispose();
        InteractionDialog dlg2 = new InteractionDialog("Evaluez nous");
        Dialog.setDefaultBlurBackgroundRadius(8);
        dlg2.setLayout(new BorderLayout());
        dlg2.add(BorderLayout.NORTH, new Label("             Et notre ambiance ? "));
        
        
        Button btn3 = new Button("          Cool         ");
        Button btn4 = new Button("          Nulle        ");
        
        
        
        btn3.addActionListener((eeee) -> {ServiceEvaluation se2 = new ServiceEvaluation(); 
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobil/addEvalluationAC"+ 
                "/" + Integer.toString(E.getId()) + "/2";
        con.setUrl(Url);
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
        dlg2.dispose();
        DialogTrois();
        });
         
         
        btn4.addActionListener((eeee) ->{ServiceEvaluation se2 = new ServiceEvaluation(); 
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobil/addEvalluationAN"+ 
                "/" + Integer.toString(E.getId()) + "/2";
        con.setUrl(Url);
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
        dlg2.dispose();
        DialogTrois();
        });
        Container c2 = new Container(BoxLayout.x());
        c2.add(btn3); c2.add(btn4);
         
         
        dlg2.addComponent(BorderLayout.CENTER,c2);
        
        
        Button close = new Button("Close");
        close.addActionListener((ee) -> dlg2.dispose());
        dlg2.addComponent(BorderLayout.SOUTH, close);
        
        
        Dimension pre = dlg2.getContentPane().getPreferredSize();
        dlg2.show(200,0,0,0);     
    }
    
    
    
    
     public void ajoutPasAime(InteractionDialog dlg, Etablissement E){
        ConnectionRequest con = new ConnectionRequest();
        dlg.dispose();
        InteractionDialog dlg2 = new InteractionDialog("Evaluez nous");
        Dialog.setDefaultBlurBackgroundRadius(8);
        dlg2.setLayout(new BorderLayout());
        dlg2.add(BorderLayout.NORTH, new Label("             Et notre ambiance ? "));
        
        
        Button btn3 = new Button("          Cool         ");
        Button btn4 = new Button("          Nulle        ");
        btn3.addActionListener((eeee) -> {ServiceEvaluation se2 = new ServiceEvaluation(); 
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobil/addEvalluationPC"+ 
                "/" + Integer.toString(E.getId()) + "/2";
        con.setUrl(Url);
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
        dlg2.dispose();
        DialogTrois();
        });
         
         
        btn4.addActionListener((eeee) ->{ServiceEvaluation se2 = new ServiceEvaluation(); 
        String Url = "http://localhost/Bons_Plans/web/app_dev.php/BonsPlans/mobil/addEvalluationPN"+ 
                "/" + Integer.toString(E.getId()) + "/2";
        con.setUrl(Url);
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
        dlg2.dispose();
        DialogTrois();
        });
        Container c2 = new Container(BoxLayout.x());
        c2.add(btn3); c2.add(btn4);
         
         
        dlg2.addComponent(BorderLayout.CENTER,c2);
        
        
        Button close = new Button("Close");
        close.addActionListener((ee) -> dlg2.dispose());
        dlg2.addComponent(BorderLayout.SOUTH, close);
        
        
        Dimension pre = dlg2.getContentPane().getPreferredSize();
        dlg2.show(200,0,0,0);
        //dlg.dispose();
          
    }
     
     public void cool(){
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Pi_Bon_Plan/web/app_dev.php/BonsPlans/mobil/addEvalluationC";
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
     
     public void nulle(){
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/Pi_Bon_Plan/web/app_dev.php/BonsPlans/mobil/addEvalluationN";
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
    
      
       public void DialogTrois(){
        InteractionDialog dlg3 = new InteractionDialog("Mercii");
        dlg3.setLayout(new BorderLayout());
        dlg3.add(BorderLayout.CENTER, new ImageViewer(theme.getImage("smile.png")));
        Button close = new Button("Close");
        close.addActionListener((ee) -> dlg3.dispose());
        dlg3.addComponent(BorderLayout.SOUTH, close);
        Dimension pre = dlg3.getContentPane().getPreferredSize();
        dlg3.show(200,0,0,0);
            
        }

}
