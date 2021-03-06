/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import Entity.Etablissement;
import Entity.Evenement;
import Entity.Reclamation;
import Entity.Session;
import Service.DemandePartenariatService;
import Service.EtablissementService;
import Service.EvenementService;
import Service.ServiceReclamation;
import Service.smsService;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.FlowLayout;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class ReclamationForm extends BaseForm {
    Session s;
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.TextArea gui_Text_Area_2 = new com.codename1.ui.TextArea(10,10);
    private com.codename1.ui.Label label = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));

    
    public ReclamationForm(Session s,com.codename1.ui.util.Resources resourceObjectInstance){
        super(s);
     initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(s,resourceObjectInstance);
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Réclamation", "Title")
                        
                )
      
        );
        getContentPane().setUIID("SignInForm");
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, ev -> { new UnEtablissement(id_etablissement,resourceObjectInstance).show();});
        Form last =  Display.getInstance().getCurrent();
        getToolbar().addMaterialCommandToRightBar("",FontImage.MATERIAL_ARROW_BACK, e -> last.show());
        
        TextField tsujet = new TextField("");
        
        TextArea tcontenuRec = new TextArea(10, 15);
        tcontenuRec.setMaxSize(100);

        Button btnajout = new Button("Envoyer");
        
      //btnaff=new Button("Les reclamations");
        ArrayList<Etablissement> ListeEtablissements = new ArrayList<>();
        EtablissementService EtabS = new EtablissementService();
        ListeEtablissements=EtabS.getListEtab();
        ComboBox Etab = new ComboBox();

            for (Etablissement obj : ListeEtablissements) 
            {
                
             Etab.addItem(obj.getNom());
            
            }
        
        
         
        gui_Container_1.add(tsujet);
        
        gui_Container_1.add(tcontenuRec);
        gui_Container_1.add(Etab);
        
        gui_Container_1.add(btnajout);
        //f.add(btnaff);
        
        
        btnajout.addActionListener((e) -> {
            String n = Etab.getSelectedItem().toString();
            ServiceReclamation ser = new ServiceReclamation();
            int id_etab ;
            
            Etablissement E= new Etablissement();
            EtablissementService etabS = new EtablissementService();
            
            E=etabS.getEtablissementsParNom(n);
            id_etab=E.getId();
            Reclamation R = new Reclamation(0,s.user.getId(), id_etab, tsujet.getText(), tcontenuRec.getText());
            System.out.println(id_etab);
            System.out.println(R);  
            //System.out.println("haw hnééé"+ser.getRecParIdEtab(id_etab));
             ser.ajoutReclamation(R);
            MesReclamations l = new MesReclamations(s,resourceObjectInstance);
            l.show();
            
        });
        
        
       
    
      
   
      
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setInlineStylesTheme(resourceObjectInstance);
        setTitle("SMS");
        setName("SMS");
        addComponent(gui_Container_1);
        gui_Text_Area_2.setMaxSize(200);
        gui_Text_Area_2.setText("");
        gui_Button_1.setText("Envoyer");
        label.setText("Contenu du SMS: ");
        
    }
    
    public void stop() {
        Form last = Display.getInstance().getCurrent();
        if(last instanceof Dialog) {
            ((Dialog)last).dispose();
            last = Display.getInstance().getCurrent();
        }
        
    }
}