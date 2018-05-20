/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Ons Ben Othmen
 */




package gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.StorageImage;
import com.codename1.io.File;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import Service.EtablissementService;
import Entity.Etablissement;
import Entity.Session;
import Service.EvenementService;
import com.codename1.ui.layouts.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

public class BonsPlansForm extends BaseForm 
{   private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_separator1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_1_1_1 = new com.codename1.ui.Label();
    private com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
    private com.codename1.components.MultiButton gui_LA = new com.codename1.components.MultiButton();
    private com.codename1.ui.Container gui_Container_1_ = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    Session session;
    ArrayList<Etablissement> ALE = new ArrayList<>();
      
    
    public BonsPlansForm (Session s,com.codename1.ui.util.Resources resourceObjectInstance) {
        
        super(s);
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(s,resourceObjectInstance);
        setTitle("BonsPlans");
        setName("BonsPlans");
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {new GoogleMapsForm(session,resourceObjectInstance).show();});
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Les Bons Plans", "Title")
                        
                )
        );
        getContentPane().setUIID("SignInForm");
        //Container C0 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container C0 = new Container(new GridLayout(2, 2));
        Container C3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        com.codename1.ui.Button B0 = new com.codename1.ui.Button();
        com.codename1.ui.Button B1 = new com.codename1.ui.Button();
        com.codename1.ui.Button B2 = new com.codename1.ui.Button();
        com.codename1.ui.Button B3 = new com.codename1.ui.Button();
        B0.setText("");
        B1.setText("");
        B2.setText("");
        B3.setText("");
       
        
        B0.setUIID("Label");
        B1.setUIID("Label");
        B2.setUIID("Label");
        B3.setUIID("Label");
        B0.setIcon(resourceObjectInstance.getImage("resto.png"));
        B1.setIcon(resourceObjectInstance.getImage("boutique.png"));
        B2.setIcon(resourceObjectInstance.getImage("hotel.png"));
        B3.setIcon(resourceObjectInstance.getImage("other.png"));
        B0.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                ALE = DéclencherServiceType("Restaurants");
                FillContainers(ALE, C3,resourceObjectInstance);
                refreshTheme();
            }
        });
        B1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                ALE = DéclencherServiceType("Shops");
                FillContainers(ALE, C3,resourceObjectInstance);
                refreshTheme();
            }
        });
        B2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                ALE = DéclencherServiceType("Hotels");
                FillContainers(ALE, C3,resourceObjectInstance);
               
               refreshTheme();
            }
        });
        B3.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                ALE = DéclencherServiceType("Autres");
                FillContainers(ALE, C3,resourceObjectInstance);
                refreshTheme();
            }
        });
       ((com.codename1.ui.layouts.FlowLayout)gui_Container_1_.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        
        C0.add(B0); C0.add(B1); 
        C0.add(B2); C0.add(B3);
        gui_Container_1_.add(C0); 
         
                
        Container content3 = BoxLayout.encloseY(
                 
                new Label(resourceObjectInstance.getImage("welcome-separator.png"), "WelcomeTitle")
               
        );
        gui_Container_1.add(gui_Container_1_);
        gui_Container_1.add(content3);
        gui_Container_1.add(C3);
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("BonsPlansForm");
        setName("BonsPlansForm");

        addComponent(gui_Container_1);
       
        setScrollableY(true);
        
        
        
    }
    
    public ArrayList<Etablissement> DéclencherServiceType(String type)
    {
        EtablissementService ES = new EtablissementService();
        return ES.getEtablissementsParType(type);
    }
    
    public void FillContainers(ArrayList<Etablissement> ALE, Container C,com.codename1.ui.util.Resources resourceObjectInstance)
    {
        C.refreshTheme(true);
        C.removeAll();
        
//        int i = 0;
//        int j;
//        if (ALE.size() > 4)
//        {
//            j = 5;
//        }
//        else
//        {
//            j = ALE.size();
//        }
        for (Etablissement E:ALE)
                {
                
                com.codename1.ui.Container gui_Container_1_ = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());   
                com.codename1.ui.Container gui_Container_2_ = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());    
                com.codename1.ui.Container gui_Container_3_ = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());    
                com.codename1.components.MultiButton gui_Multi_Button_1_ = new com.codename1.components.MultiButton();
                com.codename1.components.MultiButton gui_Multi_Button_2_ = new com.codename1.components.MultiButton();
                Button show=new Button();
                com.codename1.ui.Label gui_separator1_ = new com.codename1.ui.Label();
                
                gui_Multi_Button_1_.setUIID("Label");
                gui_Multi_Button_1_.setPropertyValue("uiid1", "Label");
                gui_Multi_Button_1_.setPropertyValue("line1", E.getNom());
                
                gui_Multi_Button_2_.setPropertyValue("line1", "Adresse: "+E.getAdresse());
                gui_Multi_Button_2_.setPropertyValue("uiid1", "Label");
                gui_Multi_Button_2_.setPropertyValue("uiid1", "SlightlySmallerFontLabelLeft");
        
                gui_Multi_Button_2_.setPropertyValue("line2", "Horaires: "+E.getHoraire_fermeture()+" - "+E.getHoraire_fermeture());
                gui_Multi_Button_2_.setPropertyValue("uiid2", "Label");
                gui_Multi_Button_2_.setPropertyValue("uiid2", "SlightlySmallerFontLabelLeft");
                
                gui_Multi_Button_2_.setPropertyValue("line3", "Télephone: "+E.getNumtel());
                gui_Multi_Button_2_.setPropertyValue("uiid3", "Label");
                gui_Multi_Button_2_.setPropertyValue("uiid3", "SlightlySmallerFontLabelLeft");
                
                gui_Multi_Button_2_.setPropertyValue("line4", "$$$ "+E.getBudgetmoyen());
                gui_Multi_Button_2_.setPropertyValue("uiid4", "Label");
                gui_Multi_Button_2_.setPropertyValue("uiid4", "SlightlySmallerFontLabelLeft");
                
                gui_separator1_.setUIID("Separator");
                gui_separator1_.setName("separator1");
                gui_separator1_.setShowEvenIfBlank(true);
                show.setText("");
                show.setUIID("Label");
                show.setIcon(resourceObjectInstance.getImage("link.png"));
                show.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        UnEtablissement UE = new UnEtablissement(s,E,resourceObjectInstance);
                        UE.show();
                    }
                });
                gui_Container_1_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_1_);
                gui_Container_2_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, show);
                gui_Container_3_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_2_);
                C.add(gui_Container_1_);
                C.add(gui_Container_2_);
                C.add(gui_Container_3_);
                C.addComponent(gui_separator1_);
                
//                i++;
//                        if (i == j)
//                {
//                    Button B4 = new Button("Afficher Tout");
//                    C.add(B4);
//                    break;
//                }
                }

    }

     

}

