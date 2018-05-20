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
public class UpdateOffre extends BaseForm  {
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
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label label5 = new com.codename1.ui.Label();
    private com.codename1.ui.Label label6 = new com.codename1.ui.Label();
    Picker C = new Picker();
    Picker C2 = new Picker();
    Offre E;
    Session s;
    
    public UpdateOffre(Session s,Offre E,com.codename1.ui.util.Resources resourceObjectInstance){
        super(s);
        this.E=E;
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(s,resourceObjectInstance);
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Modifier L'offre", "Title")
                        
                )
      
        );
        getContentPane().setUIID("SignInForm");
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, ev -> { new OffresForm(resourceObjectInstance).show();});
         Form last =  Display.getInstance().getCurrent();
        getToolbar().addMaterialCommandToRightBar("",FontImage.MATERIAL_ARROW_BACK, e -> last.show());
        getContentPane().setUIID("SignInForm");

          C.setType(Display.PICKER_TYPE_DATE);
          C2.setType(Display.PICKER_TYPE_DATE);
          gui_Button_1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //if (nom.getText().equals(null) ||(description.getText().equals(null) ))
                Offre E2=new Offre(E.getId_etablissement(),C.getDate(),C2.getDate(),gui_Text_Field_2.getText(),gui_Text_Field_1.getText());
                OffreService service=new OffreService();
                if (E.getId_etablissement().getPartenaire()==0){
                E2.setCode("");
                E2.setPourcentage(0);
                service.updateOffreSans(E, E2);
                
                }
                else {
                E2.setCode(gui_Text_Field_3.getText());
                
                E2.setPourcentage(Float.parseFloat(gui_Text_Field_4.getText()));
                service.updateOffreAvec(E, E2);
                }
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
                
                OffreService service=new OffreService();
                
                
                service.deleteOffre(E);
                
                last.refreshTheme();
                last.show();
                
            }
        });
       
    //}
    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("UpdateOffre");
        setName("UpdateOffre");
        addComponent(gui_Container_1);
        
        gui_Container_1.setName("Container_1");
        
        
        setScrollableY(true);
        
        
        
        ////
        label3.setText("Nom de l'offre");
        gui_Container_1.add(label3);
        gui_Text_Field_1.setText(E.getOffre());
        gui_Text_Field_1.setLabelForComponent(label3);
        gui_Container_1.addComponent(gui_Text_Field_1);
        
        label4.setText("Description");
        gui_Container_1.add(label4);
        gui_Text_Field_2.setLabelForComponent(label4);
        gui_Text_Field_2.setText(E.getDescription());
        gui_Container_1.addComponent(gui_Text_Field_2);
        
        label1.setText("Date début");
        label2.setText("Date fin");
        gui_Container_1.add(label1);
        C.setDate(E.getDate_debut());
        C2.setDate(E.getDate_fin());
        C.setLabelForComponent(label1);
        gui_Container_1.add(C);
        C2.setLabelForComponent(label2);
        gui_Container_1.add(label2);
        gui_Container_1.add(C2);
        
        
        label5.setText("Code de promotion");
        label6.setText("Pourcentage off");
       
        if (E.getId_etablissement().getPartenaire()==0){}
        else {
         gui_Container_1.add(label5);
         gui_Text_Field_3.setText(E.getCode());
         gui_Text_Field_4.setText(String.valueOf(E.getPourcentage()) );
         gui_Text_Field_3.setLabelForComponent(label5);
         
         gui_Container_1.add(gui_Text_Field_3);
         
         gui_Container_1.add(label6);
         
         gui_Text_Field_4.setLabelForComponent(label6);
         
         gui_Container_1.add(gui_Text_Field_4);
        }
        

        gui_Button_1.setText("Modifier");
        gui_Button_1.setText("Annuler");
        gui_Container_1.add(gui_Button_1);
        gui_Container_1.add(gui_Button_2);
        setScrollableY(true);

        
           
       
        
    }

   
}
