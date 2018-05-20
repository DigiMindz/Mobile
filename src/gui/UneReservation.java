/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Evenement;
import Entity.Offre;
import Entity.Reservation;
import Entity.Session;
import Service.ControlleurChamps;
import Service.EvenementService;
import Service.OffreService;
import Service.ReservationService;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Ons Ben Othmen
 */
public class UneReservation extends BaseForm{
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_3 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_4 = new com.codename1.ui.TextField();
    private com.codename1.ui.Label label1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label label2 = new com.codename1.ui.Label();
    private com.codename1.ui.Label label3 = new com.codename1.ui.Label();
    private com.codename1.ui.Label label4 = new com.codename1.ui.Label();
    private com.codename1.ui.Label label5 = new com.codename1.ui.Label();
    Session s;
    Picker C = new Picker();
    Reservation E;
    ControlleurChamps cc = new ControlleurChamps();

    UneReservation(Session s,Reservation E, Resources resourceObjectInstance) {
        super(s);  
        this.E=E;
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(s,resourceObjectInstance);
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Votre réservation", "Title")
                        
                )
      
        );
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, e -> {BonsPlansForm h=new BonsPlansForm(s,resourceObjectInstance);
          h.show();});
        gui_Button_1.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        if (gui_Text_Field_1.getText().equals("") ||gui_Text_Field_2.getText().equals("") ||
                        gui_Text_Field_3.getText().equals("")||gui_Text_Field_4.getText().equals("")
                        ){
                Dialog.show("Champs Invalides", "Veuillez remplir les informations de votre réservation", "OK", null);
                }
                else if(!cc.isNum(gui_Text_Field_3.getText())){
                Dialog.show("Champs Invalides", "Veuillez saisir un numéro de téléphone valide", "OK", null);
                }
                else if (!cc.isNumber(gui_Text_Field_4.getText())){
                Dialog.show("Champs Invalides", "Veuillez saisir nombre de personnes valide", "OK", null);
                }
                else{
                ReservationService ser = new ReservationService();
                Reservation R2 = new Reservation(E.getId(),E.getId_etablissement(), E.getId_user(), C.getDate(), gui_Text_Field_1.getText(), gui_Text_Field_2.getText(), gui_Text_Field_3.getText(), 
                Integer.parseInt(gui_Text_Field_4.getText()));
                ser.updateReservation(E, R2);
                    UneReservation UE = new UneReservation(s,R2,resourceObjectInstance);
                    UE.show();
                }
                    }
                });
        
        gui_Button_2.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        ReservationService ser = new ReservationService();
                        ser.deleteReservation(E);
                        ReservationsForm h=new ReservationsForm(s,resourceObjectInstance);
                        h.show();
                    }
                });

          
    }
            private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("UneReservation");
        setName("UneReservation");
                Image bla = resourceObjectInstance.getImage("reservation.png");
    
                Container content3 = BoxLayout.encloseY(
                new Label(bla, "WelcomeTitle"),        
                new Label(resourceObjectInstance.getImage("welcome-separator.png"), "WelcomeTitle")
               
        );
        getContentPane().setUIID("SignInForm");
        addComponent(content3); 
        addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");
        
        
        gui_Container_1.setScrollableY(true);
        
        
        setScrollableY(true);
               
        
        label1.setText("Nom");
        gui_Container_1.add(label1);
        gui_Text_Field_1.setText(E.getNom());
        gui_Text_Field_1.setLabelForComponent(label1);
        gui_Container_1.addComponent(gui_Text_Field_1);
        
        
        label2.setText("Prénom");
        gui_Container_1.add(label2);
        gui_Text_Field_2.setText(E.getPrenom());
        gui_Text_Field_2.setLabelForComponent(label2);
        gui_Container_1.add(gui_Text_Field_2);
        
        
        label3.setText("Numéro téléphone");
        gui_Container_1.add(label3);
        gui_Text_Field_3.setText(E.getNum_tel());
        gui_Text_Field_3.setLabelForComponent(label3);
        gui_Container_1.add(gui_Text_Field_3);
        
        label4.setText("Nombre de personnes");
        gui_Container_1.add(label4);
        gui_Text_Field_4.setText(String.valueOf(E.getNbr_personnes()));
        gui_Text_Field_4.setLabelForComponent(label4);
        gui_Container_1.add(gui_Text_Field_4);
                
        
        label5.setText("Date de réservation");
        gui_Container_1.add(label5);
        C.setDate(E.getDate());
        gui_Text_Field_3.setLabelForComponent(label5);
        gui_Container_1.add(C);
        
        gui_Container_1.add(gui_Button_1);
        gui_Container_1.add(gui_Button_2);
        gui_Button_1.setText("Modifier");
        gui_Button_2.setText("Annuler");
        
       
           
       
        
    }


    
    
    
}
