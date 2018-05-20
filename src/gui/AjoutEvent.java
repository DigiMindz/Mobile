/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Etablissement;
import Entity.Evenement;
import Entity.Session;
import Service.EvenementService;
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
public class AjoutEvent extends BaseForm  {
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.Label label1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label label2 = new com.codename1.ui.Label();
    private com.codename1.ui.Label label3 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    Picker C = new Picker();
    Session session;
    
    public AjoutEvent(Session session,Etablissement id_etablissement,com.codename1.ui.util.Resources resourceObjectInstance){
        super(session);
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(session,resourceObjectInstance);
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Ajouter un évenement", "Title")
                        
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
                if (gui_Text_Field_1.getText().equals("") ||gui_Text_Field_2.getText().equals("")){
                Dialog.show("Champs Invalides", "Veuillez remplir les informations de votre évenement", "OK", null);
                }
                else{
                Evenement E=new Evenement(id_etablissement,C.getDate(),gui_Text_Field_2.getText(),gui_Text_Field_1.getText());
                EvenementService service=new EvenementService();
                service.ajouteEvenement(E);
                EventsEtabForm UE = new EventsEtabForm(s,E.getId_etablissement(),resourceObjectInstance);
                UE.show();
                }
                
                
            }
        });
          System.out.println(id_etablissement.getId());
    //}
    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("AjoutEvent");
        setName("AjoutEvent");
        addComponent(gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        
        label1.setText("Nom de l'évenement");
        gui_Container_1.add(label1);
        gui_Text_Field_1.setLabelForComponent(label1);
        gui_Container_1.addComponent(gui_Text_Field_1);
        
        
        label2.setText("Date");
        gui_Container_1.add(label2);
        C.setLabelForComponent(label2);
        gui_Container_1.add(C);
        
        
        label3.setText("Description");
        gui_Container_1.add(label3);
        gui_Text_Field_2.setLabelForComponent(label3);
        gui_Container_1.add(gui_Text_Field_2);
        
        gui_Button_1.setText("Ajouter");
        gui_Container_1.add(gui_Button_1);
        setScrollableY(true);

    }

   
}
