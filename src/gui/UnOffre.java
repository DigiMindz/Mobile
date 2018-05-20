/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Evenement;
import Entity.Offre;
import Entity.Session;
import Service.EvenementService;
import Service.OffreService;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Ons Ben Othmen
 */
public class UnOffre extends BaseForm{
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    Offre E;
    Session s;  
        
//    public UnOffre(Offre E) {
//        this.E = E;
//        this(com.codename1.ui.util.Resources.getGlobalResources());
//        
//    }
    UnOffre(Session s,Offre E, Resources resourceObjectInstance) {
        super(s);  
        this.E=E;
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(s,resourceObjectInstance);
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label(E.getOffre(), "Title")
                        
                )
      
        );
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, e -> {UnEtablissement h=new UnEtablissement(s,E.getId_etablissement(),resourceObjectInstance);
          h.show();});

          
    }
            private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("UnOffre");
        setName("UnOffre");
                Image bla = resourceObjectInstance.getImage("offre.jpg").scaledLargerRatio(300, 150);
    
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
               
        
        Label L1 = new Label("Date début: "+E.getDate_debut().toString());
        Label L2 = new Label("Date fin: "+E.getDate_fin().toString());
        Label L3 = new Label("Code promotion: "+E.getCode().toString());
        Label L4 = new Label("Pourcentage: "+E.getPourcentage());
        Label L5 = new Label("Chez: "+E.getId_etablissement().getNom());
         L5.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        UnEtablissement UE = new UnEtablissement(s,E.getId_etablissement(),resourceObjectInstance);
                        UE.show();
                    }
                });
        SpanLabel SL1=new SpanLabel("Description: "+E.getDescription());
        Button b1=new Button("Modifier");
        Button b2=new Button("Annuler");
        L5.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        UnEtablissement UE = new UnEtablissement(s,E.getId_etablissement(),resourceObjectInstance);
                        UE.show();
                    }
                });
        b1.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        UpdateOffre UE = new UpdateOffre(s,E,resourceObjectInstance);
                        UE.show();
                    }
                });
        b2.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        OffreService ser=new OffreService();
                        ser.deleteOffre(E);
                        UnEtablissement UE = new UnEtablissement(s,E.getId_etablissement(),resourceObjectInstance);
                        UE.show();
                    }
                });
        
        gui_Container_1.add(L1);
        gui_Container_1.add(L2);
        gui_Container_1.add(L5);
        if (E.getCode().toString().equals("")){} else {
            gui_Container_1.add(L3);
        }
        if (E.getPourcentage()==0.0){} else {
            gui_Container_1.add(L4);
        }
        
        gui_Container_1.add(SL1);
        gui_Container_1.add(b1);
        gui_Container_1.add(b2);
           
       
        
    }


    
    
    
}
