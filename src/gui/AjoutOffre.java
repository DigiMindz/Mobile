/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Etablissement;
import Entity.Evenement;
import Entity.Offre;
import Entity.Session;
import Service.EvenementService;
import Service.OffreService;
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
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
/**
 *
 * @author Ons Ben Othmen
 */
public class AjoutOffre extends BaseForm  {
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
    private com.codename1.ui.Label label6 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    Picker C1 = new Picker();
    Picker C2 = new Picker();
    Etablissement E;
    Session session;
    public AjoutOffre(Session session,Etablissement id_etablissement,com.codename1.ui.util.Resources resourceObjectInstance){
        super(session);
        this.E=id_etablissement;
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(s,resourceObjectInstance);
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Ajouter un Offre", "Title")
                        
                )
      
        );
        getContentPane().setUIID("SignInForm");
        Form last =  Display.getInstance().getCurrent();
        getToolbar().addMaterialCommandToRightBar("",FontImage.MATERIAL_ARROW_BACK, e -> last.show());
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, ev -> { new UnEtablissement(id_etablissement,resourceObjectInstance).show();});
    
        
        
          
          C1.setType(Display.PICKER_TYPE_DATE);
          C2.setType(Display.PICKER_TYPE_DATE);
         
          gui_Button_1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                if (gui_Text_Field_1.getText().equals("") ||gui_Text_Field_2.getText().equals("")){
                Dialog.show("Champs Invalides", "Veuillez remplir les informations de votre offre", "OK", null);
                }
//                if (C1.getDate().after(C2.getDate())==true){
//                Dialog.show("Champs Invalides", "Date fin doit etre supérieur à la date début de l'offre", "OK", null);
//                }
                Offre E=new Offre(id_etablissement,C1.getDate(),C2.getDate(),gui_Text_Field_2.getText(),gui_Text_Field_1.getText());
                OffreService service=new OffreService();
                if (id_etablissement.getPartenaire()==0){
                E.setCode("");
                E.setPourcentage(0);
                service.ajouteOffreSans(E);
                }
                else{
                E.setCode(gui_Text_Field_3.getText());
                E.setPourcentage(Float.parseFloat(gui_Text_Field_4.getText()));
                service.ajouteOffreAvec(E);
                }
               
                OffresEtabForm UE = new OffresEtabForm(s,E.getId_etablissement(),resourceObjectInstance);
                UE.show();
                
            }
        });
         
    //}
    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("AjoutOffre");
        setName("AjoutOffre");
        setTitle("Ajouter un évenement");
        addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");
        
        
        setScrollableY(true);
        
        label3.setText("Nom de l'offre");
        gui_Container_1.add(label3);
        gui_Text_Field_1.setLabelForComponent(label3);
        gui_Container_1.addComponent(gui_Text_Field_1);
        
        label4.setText("Description");
        gui_Container_1.add(label4);
        gui_Text_Field_2.setLabelForComponent(label4);
        gui_Container_1.addComponent(gui_Text_Field_2);
        
        label1.setText("Date début");
        label2.setText("Date fin");
        gui_Container_1.add(label1);
        C1.setLabelForComponent(label1);
        gui_Container_1.add(C1);
        C2.setLabelForComponent(label2);
        gui_Container_1.add(label2);
        gui_Container_1.add(C2);
        
        
        label5.setText("Code de promotion");
        label6.setText("Pourcentage off");
       
        if (E.getPartenaire()==0){}
        else {
         gui_Container_1.add(label5);
         
         gui_Text_Field_3.setLabelForComponent(label5);
         
         gui_Container_1.add(gui_Text_Field_3);
         
         gui_Container_1.add(label6);
         
         gui_Text_Field_4.setLabelForComponent(label6);
         
         gui_Container_1.add(gui_Text_Field_4);
        }
       
        gui_Button_1.setText("Ajouter");
        gui_Container_1.add(gui_Button_1);
        setScrollableY(true);

        
           
       
        
    }

   
}
