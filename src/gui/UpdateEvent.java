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
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Calendar;
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
public class UpdateEvent extends BaseForm  {
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        private com.codename1.ui.Label label1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label label2 = new com.codename1.ui.Label();
    private com.codename1.ui.Label label3 = new com.codename1.ui.Label();
    Picker C = new Picker();
    Evenement E;
    Session s;
    public UpdateEvent(Session s,Evenement E,com.codename1.ui.util.Resources resourceObjectInstance){
        super(s);
        this.E=E;
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(s,resourceObjectInstance);
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Modifier L'évenement", "Title")
                        
                )
      
        );
        
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, ev -> { new EventsForm(resourceObjectInstance).show();});
         Form last =  Display.getInstance().getCurrent();
        getToolbar().addMaterialCommandToRightBar("",FontImage.MATERIAL_ARROW_BACK, e -> last.show());
        getContentPane().setUIID("SignInForm");

          C.setType(Display.PICKER_TYPE_DATE);
          
          gui_Button_1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //if (nom.getText().equals(null) ||(description.getText().equals(null) ))
                Evenement E2=new Evenement(E.getId_etablissement(),C.getDate(),gui_Text_Field_2.getText(),gui_Text_Field_1.getText());
                EvenementService service=new EvenementService();
                service.updateEvenement(E,E2);
                last.refreshTheme();
                last.show();
                
            }
        });
                    gui_Button_2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //if (nom.getText().equals(null) ||(description.getText().equals(null) ))
                
                EvenementService service=new EvenementService();
                service.deleteEvenement(E);
                last.refreshTheme();
                last.show();
                
            }
        });
       
    //}
    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("UpdateEvent");
        setName("UpdateEvent");
        addComponent(gui_Container_1);
        getContentPane().setUIID("SignInForm");
        setScrollableY(true);
        label1.setText("Nom de l'évenement");
        gui_Container_1.add(label1);
        gui_Text_Field_1.setLabelForComponent(label1);
        gui_Text_Field_1.setText(E.getNom());
        gui_Container_1.addComponent(gui_Text_Field_1);
        
        
        label2.setText("Date");
        gui_Container_1.add(label2);
        C.setLabelForComponent(label2);
        C.setDate(E.getDate());
        gui_Container_1.add(C);
        
        
        label3.setText("Description");
        gui_Container_1.add(label3);
        gui_Text_Field_2.setLabelForComponent(label3);
        gui_Text_Field_2.setText(E.getDescription());
        gui_Container_1.add(gui_Text_Field_2);
        
        gui_Container_1.setName("Container_1");
        
        gui_Button_1.setText("Modifier");
        gui_Button_2.setText("Annuler");
        gui_Container_1.add(gui_Button_1);
        gui_Container_1.add(gui_Button_2);
        setScrollableY(true);

        
           
       
        
    }

   
}
