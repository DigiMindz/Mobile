/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Etablissement;
import Entity.Session;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Ons Ben Othmen
 */
public class ParametresFrom extends BaseForm{
             private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
  
    Etablissement E;
    
    Session s;
    public ParametresFrom(Session s,Resources resourceObjectInstance)
    {
        super(s);
        this.E = E;
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(s,resourceObjectInstance);
        setTitle("para");
        setName("para");
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
         Form last =  Display.getInstance().getCurrent();
//        getToolbar().addMaterialCommandToRightBar("",FontImage.MATERIAL_ARROW_BACK, e -> last.show());
//        getToolbar().setTitleComponent(
//                FlowLayout.encloseCenterMiddle(
//                        new Label("Paramètres", "Title")
//                        
//                )
//      
//        );
        getContentPane().setUIID("SignInForm");
          
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {new GoogleMapsForm(s,resourceObjectInstance).show();});
    

    }
    
        private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("ParametresForm");
        setName("ParametresForm");
        addComponent(gui_Container_1);
        
        gui_Container_1.setName("Container_1");
        

        
        
        }
}
