/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.DemandePartenariat;
import Entity.Etablissement;
import Entity.Evenement;
import Entity.Session;
import Service.DemandePartenariatService;
import Service.EvenementService;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.FlowLayout;

/**
 * GUI builder created Form
 *
 * @author Ons Ben Othmen
 */
public class sendMsg extends BaseForm {
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.Label label = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_2 = new com.codename1.ui.TextArea(15,15);
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    Session s;
        
    
    public sendMsg(Session s,Etablissement id_etablissement,com.codename1.ui.util.Resources resourceObjectInstance) {
        super(s);
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(s,resourceObjectInstance);
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Demande partenariat", "Title")
                        
                )
      
        );
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, ev -> { new UnEtablissement(id_etablissement,resourceObjectInstance).show();});
         Form last =  Display.getInstance().getCurrent();
        getToolbar().addMaterialCommandToRightBar("",FontImage.MATERIAL_ARROW_BACK, e -> last.show());
        gui_Button_1.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    //if (nom.getText().equals(null) ||(description.getText().equals(null) ))
                    DemandePartenariat E=new DemandePartenariat(id_etablissement.getId(),id_etablissement.getResponsable(),gui_Text_Area_2.getText());
                    DemandePartenariatService ser= new DemandePartenariatService();
                    ser.ajouteDemande(E);
                    new UnEtablissement(s,id_etablissement,resourceObjectInstance).show();

                }
            });
        }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        getContentPane().setUIID("SignInForm");
        setInlineStylesTheme(resourceObjectInstance);
        setTitle("Demande partenariat");
        setName("Demande partenariat");
        addComponent(gui_Container_1);
        gui_Text_Area_2.setMaxSize(2000);
        label.setText("Description de la demande");
        gui_Text_Area_2.setLabelForComponent(label);
        gui_Button_1.setText("Envoyer");
        gui_Container_1.add(label);
        gui_Container_1.add(gui_Text_Area_2);
        gui_Container_1.add(gui_Button_1);
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
