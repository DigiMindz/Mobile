/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Etablissement;
import Entity.Evenement;
import Entity.Reservation;
import Entity.Session;
import Service.ControlleurChamps;
import Service.EvenementService;
import Service.ReservationService;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.DateFormatPatterns;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Calendar;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import static com.codename1.ui.events.ActionEvent.Type.Log;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import java.util.Date;

/**
 *
 * @author Ons Ben Othmen
 */
public class AjoutReservation extends BaseForm  {
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_3 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_4 = new com.codename1.ui.TextField();
    private com.codename1.ui.Label label1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label label2 = new com.codename1.ui.Label();
    private com.codename1.ui.Label label3 = new com.codename1.ui.Label();
    private com.codename1.ui.Label label4 = new com.codename1.ui.Label();
    private com.codename1.ui.Label label5 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    Picker C = new Picker();
    Session session;
//    Label L01 = new Label("");
//    Label L02= new Label("");
//    Label L03= new Label("");
//    Label L04= new Label("");
//    Label L05= new Label("");
    ControlleurChamps cc = new ControlleurChamps();
    public AjoutReservation(Session session,Etablissement id_etablissement,com.codename1.ui.util.Resources resourceObjectInstance){
        super(session);
        this.session=session;
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(s,resourceObjectInstance);
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Réserver", "Title")
                        
                )
      
        );
        Form last =  Display.getInstance().getCurrent();
        getToolbar().addMaterialCommandToRightBar("",FontImage.MATERIAL_ARROW_BACK, e -> last.show());
       // getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, ev -> { new UnEtablissement(id_etablissement,resourceObjectInstance).show();});
        getContentPane().setUIID("SignInForm");
   
          C.setType(Display.PICKER_TYPE_DATE);
          
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
                Reservation R = new Reservation(id_etablissement,session.user.getId() , C.getDate(), gui_Text_Field_1.getText(), gui_Text_Field_2.getText(), gui_Text_Field_3.getText(), 
                Integer.parseInt(gui_Text_Field_4.getText()));
                ser.ajoutReservation(R,R.getId_user());
                    ReservationsForm UE = new ReservationsForm(s,resourceObjectInstance);
                    UE.show();
                }
                
                
            }
        });
          System.out.println(id_etablissement.getId());
    //}
    }
//     private boolean verif() {
//        
//        ControlleurChamps cc = new ControlleurChamps();
//        if (gui_Text_Field_1.getText().isEmpty()) {
//            L01.setText("Champs nom Vide");
//            f.refreshTheme();
//        } else if (tnbrPers.getText().isEmpty()) {
//            L01.setText("");
//            L02.setText("Champs nombre de personne Vide");
//            f.refreshTheme();
//        } else if (!cc.isNumber(tnbrPers.getText())) {
//            L01.setText("");
//            L02.setText("Nombre de personne non Valide");
//            f.refreshTheme();
//        } else if (tnum.getText().isEmpty()) {
//            L01.setText("");
//            L02.setText("");
//            L03.setText("champs n     private boolean verif() {
//        
//        ControlleurChamps cc = new ControlleurChamps();
//        if (gui_Text_Field_1.getText().isEmpty()) {
//            L01.setText("Champs nom Vide");
//            f.refreshTheme();
//        } else if (tnbrPers.getText().isEmpty()) {
//            L01.setText("");
//            L02.setText("Champs nombre de personne Vide");
//            f.refreshTheme();
//        } else if (!cc.isNumber(tnbrPers.getText())) {
//            L01.setText("");
//            L02.setText("Nombre de personne non Valide");
//            f.refreshTheme();
//        } else if (tnum.getText().isEmpty()) {
//            L01.setText("");
//            L02.setText("");
//            L03.setText("champs numéro de telephone Vide");
//            f.refreshTheme();
//        } else if (!cc.isNum(tnum.getText())) {
//            L01.setText("");
//            L02.setText("");
//            L03.setText("champs numéro de telephone non Valide");
//            f.refreshTheme();
//        } else if (tprenom.getText().isEmpty()) {
//            L01.setText("");
//            L02.setText("");
//            L03.setText("");
//            L04.setText("champs prenom Vide");
//            f.refreshTheme();
//        } else if (CDate.getValue().toString().isEmpty()) {
//            L01.setText("");
//            L02.setText("");
//            L03.setText("");
//            L04.setText("");
//            L05.setText("Date de reservation vide");
//            f.refreshTheme();
//        } else {
//            L01.setText("");
//            L02.setText("");
//            L03.setText("");
//            L04.setText("");
//            L05.setText("");
//            f.refreshTheme();
//            return true;
//        }
//        return false;
//
//    }uméro de telephone Vide");
//            f.refreshTheme();
//        } else if (!cc.isNum(tnum.getText())) {
//            L01.setText("");
//            L02.setText("");
//            L03.setText("champs numéro de telephone non Valide");
//            f.refreshTheme();
//        } else if (tprenom.getText().isEmpty()) {
//            L01.setText("");
//            L02.setText("");
//            L03.setText("");
//            L04.setText("champs prenom Vide");
//            f.refreshTheme();
//        } else if (CDate.getValue().toString().isEmpty()) {
//            L01.setText("");
//            L02.setText("");
//            L03.setText("");
//            L04.setText("");
//            L05.setText("Date de reservation vide");
//            f.refreshTheme();
//        } else {
//            L01.setText("");
//            L02.setText("");
//            L03.setText("");
//            L04.setText("");
//            L05.setText("");
//            f.refreshTheme();
//            return true;
//        }
//        return false;
//
//    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("AjoutReservation");
        setName("AjoutReservation");
        addComponent(gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        
        label1.setText("Nom");
        gui_Container_1.add(label1);
        gui_Text_Field_1.setLabelForComponent(label1);
        gui_Container_1.addComponent(gui_Text_Field_1);
        
        
        label2.setText("Prénom");
        gui_Container_1.add(label2);
        gui_Text_Field_2.setLabelForComponent(label2);
        gui_Container_1.add(gui_Text_Field_2);
        
        
        label3.setText("Numéro téléphone");
        gui_Container_1.add(label3);
        gui_Text_Field_3.setLabelForComponent(label3);
        gui_Container_1.add(gui_Text_Field_3);
        
        label4.setText("Nombre de personnes");
        gui_Container_1.add(label4);
        gui_Text_Field_4.setLabelForComponent(label4);
        gui_Container_1.add(gui_Text_Field_4);
                
        
        label5.setText("Date de réservation");
        gui_Container_1.add(label5);
        gui_Text_Field_3.setLabelForComponent(label5);
        gui_Container_1.add(C);
        
        gui_Button_1.setText("Réserver");
        gui_Container_1.add(gui_Button_1);
        setScrollableY(true);

    }

   
}
