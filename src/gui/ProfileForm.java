/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Etablissement;
import Entity.Evenement;
import Entity.GoingEvent;
import Entity.InterestedEvent;
import Entity.LikedEtablissement;
import Entity.Reservation;
import Entity.Session;
import Entity.VisitedEtablissement;
import Service.EtablissementService;
import Service.EvenementService;
import Service.GoingService;
import Service.InterestService;
import Service.LikedService;
import Service.ReservationService;
import Service.VisitedService;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;

/**
 *
 * @author Ons Ben Othmen
 */
public class ProfileForm extends BaseForm {
    Session session;
        ArrayList<Etablissement> ALE = new ArrayList<>();
        ArrayList<LikedEtablissement> ALL = new ArrayList<>();
        ArrayList<VisitedEtablissement> ALV = new ArrayList<>();
        ArrayList<Reservation> ALR = new ArrayList<>();
        ArrayList<GoingEvent> ALG = new ArrayList<>();
        ArrayList<InterestedEvent> ALI = new ArrayList<>();
        private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
        private com.codename1.ui.Container main = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
        private com.codename1.ui.Container main2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
        private com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        com.codename1.ui.Button page = new com.codename1.ui.Button();
        com.codename1.ui.Button mine = new com.codename1.ui.Button();
        com.codename1.ui.Button visited = new com.codename1.ui.Button();
        com.codename1.ui.Button wish = new com.codename1.ui.Button();
        com.codename1.ui.Button goings = new com.codename1.ui.Button();
        com.codename1.ui.Button interests = new com.codename1.ui.Button();
        com.codename1.ui.Button reservations = new com.codename1.ui.Button();
            private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_3 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_4 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_5 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_6 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_7 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_8 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextArea gui_Text_Field_9 = new com.codename1.ui.TextArea(10,10);
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.Label l=new com.codename1.ui.Label("Date de naissance");
        private com.codename1.ui.Label gui_separator1 = new com.codename1.ui.Label();
        Picker C=new Picker();
    
    
    public ProfileForm(Session s,Resources resourceObjectInstance)
    {
        super(s);
        
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(s,resourceObjectInstance);
//        Form last =  Display.getInstance().getCurrent();
//        getToolbar().addMaterialCommandToRightBar("",FontImage.MATERIAL_ARROW_BACK, e -> last.show());
//          getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Profile", "Title")
                        
                )
      
        );
        getContentPane().setUIID("SignInForm");
          
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {new GoogleMapsForm(s,resourceObjectInstance).show();});
        
        page.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                gui_Container_2.removeAll();
                gui_Container_2.refreshTheme(true);
               
                gui_Container_2.add(gui_Component_Group_1);
                page.setIcon(resourceObjectInstance.getImage("userC.png"));
                mine.setIcon(resourceObjectInstance.getImage("mine.png"));
                visited.setIcon(resourceObjectInstance.getImage("visits.png"));
                goings.setIcon(resourceObjectInstance.getImage("goings.png"));
                interests.setIcon(resourceObjectInstance.getImage("interests.png"));
                wish.setIcon(resourceObjectInstance.getImage("wishliste.png"));
                reservations.setIcon(resourceObjectInstance.getImage("reservations.png"));
                
            }
        });
                mine.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                gui_Container_2.removeAll();
                gui_Container_2.refreshTheme(true);
                page.setIcon(resourceObjectInstance.getImage("user.png"));
                mine.setIcon(resourceObjectInstance.getImage("mineC.png"));
                visited.setIcon(resourceObjectInstance.getImage("visits.png"));
                goings.setIcon(resourceObjectInstance.getImage("goings.png"));
                interests.setIcon(resourceObjectInstance.getImage("interests.png"));
                wish.setIcon(resourceObjectInstance.getImage("wishliste.png"));
                reservations.setIcon(resourceObjectInstance.getImage("reservations.png"));
                EtablissementService ser=new EtablissementService();
                ALE=ser.getMine(s.user.getId());
                
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
        
                gui_Multi_Button_2_.setPropertyValue("line2", "Horaires: "+E.getHoraire_fermeture()+":"+E.getHoraire_fermeture());
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
                gui_Container_2.add(gui_Container_1_);
                gui_Container_2.add(gui_Container_2_);
                gui_Container_2.add(gui_Container_3_);
                gui_Container_2.addComponent(gui_separator1_);
                

                }
                
            }
        });
                wish.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                
                gui_Container_2.removeAll();
                gui_Container_2.refreshTheme(true);
                page.setIcon(resourceObjectInstance.getImage("user.png"));
                mine.setIcon(resourceObjectInstance.getImage("mine.png"));
                visited.setIcon(resourceObjectInstance.getImage("visits.png"));
                goings.setIcon(resourceObjectInstance.getImage("goings.png"));
                interests.setIcon(resourceObjectInstance.getImage("interests.png"));
                wish.setIcon(resourceObjectInstance.getImage("wishlisteC.png"));
                LikedService ser=new LikedService();
                ALL=ser.getWishes(s.user.getId());
                        for (LikedEtablissement E:ALL)
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
                gui_Multi_Button_1_.setPropertyValue("line1", E.getEtab().getNom());
                
                gui_Multi_Button_2_.setPropertyValue("line1", "Adresse: "+E.getEtab().getAdresse());
                gui_Multi_Button_2_.setPropertyValue("uiid1", "Label");
                gui_Multi_Button_2_.setPropertyValue("uiid1", "SlightlySmallerFontLabelLeft");
        
                gui_Multi_Button_2_.setPropertyValue("line2", "Horaires: "+E.getEtab().getHoraire_ouverture()+"-"+E.getEtab().getHoraire_fermeture());
                gui_Multi_Button_2_.setPropertyValue("uiid2", "Label");
                gui_Multi_Button_2_.setPropertyValue("uiid2", "SlightlySmallerFontLabelLeft");
                
                gui_Multi_Button_2_.setPropertyValue("line3", "Télephone: "+E.getEtab().getNumtel());
                gui_Multi_Button_2_.setPropertyValue("uiid3", "Label");
                gui_Multi_Button_2_.setPropertyValue("uiid3", "SlightlySmallerFontLabelLeft");
                
                gui_Multi_Button_2_.setPropertyValue("line4", "$$$ "+E.getEtab().getBudgetmoyen());
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
                        UnEtablissement UE = new UnEtablissement(s,E.getEtab(),resourceObjectInstance);
                        UE.show();
                    }
                });
                gui_Container_1_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_1_);
                gui_Container_2_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, show);
                gui_Container_3_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_2_);
                gui_Container_2.add(gui_Container_1_);
                gui_Container_2.add(gui_Container_2_);
                gui_Container_2.add(gui_Container_3_);
                gui_Container_2.addComponent(gui_separator1_);

                }
                
                
                
            }
        });
                visited.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                gui_Container_2.removeAll();
                gui_Container_2.refreshTheme(true);
                page.setIcon(resourceObjectInstance.getImage("user.png"));
                mine.setIcon(resourceObjectInstance.getImage("mine.png"));
                visited.setIcon(resourceObjectInstance.getImage("visitsC.png"));
                goings.setIcon(resourceObjectInstance.getImage("goings.png"));
                interests.setIcon(resourceObjectInstance.getImage("interests.png"));
                wish.setIcon(resourceObjectInstance.getImage("wishliste.png"));
                reservations.setIcon(resourceObjectInstance.getImage("reservations.png"));
                VisitedService ser=new VisitedService();
                ALV=ser.getV(s.user.getId());
                        for (VisitedEtablissement E:ALV)
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
                gui_Multi_Button_1_.setPropertyValue("line1", E.getEtab().getNom());
                
                gui_Multi_Button_2_.setPropertyValue("line1", "Adresse: "+E.getEtab().getAdresse());
                gui_Multi_Button_2_.setPropertyValue("uiid1", "Label");
                gui_Multi_Button_2_.setPropertyValue("uiid1", "SlightlySmallerFontLabelLeft");
        
                gui_Multi_Button_2_.setPropertyValue("line2", "Horaires: "+E.getEtab().getHoraire_ouverture()+"-"+E.getEtab().getHoraire_fermeture());
                gui_Multi_Button_2_.setPropertyValue("uiid2", "Label");
                gui_Multi_Button_2_.setPropertyValue("uiid2", "SlightlySmallerFontLabelLeft");
                
                gui_Multi_Button_2_.setPropertyValue("line3", "Télephone: "+E.getEtab().getNumtel());
                gui_Multi_Button_2_.setPropertyValue("uiid3", "Label");
                gui_Multi_Button_2_.setPropertyValue("uiid3", "SlightlySmallerFontLabelLeft");
                
                gui_Multi_Button_2_.setPropertyValue("line4", "$$$ "+E.getEtab().getBudgetmoyen());
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
                        UnEtablissement UE = new UnEtablissement(s,E.getEtab(),resourceObjectInstance);
                        UE.show();
                    }
                });
                gui_Container_1_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_1_);
                gui_Container_2_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, show);
                gui_Container_3_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_2_);
                gui_Container_2.add(gui_Container_1_);
                gui_Container_2.add(gui_Container_2_);
                gui_Container_2.add(gui_Container_3_);
                gui_Container_2.addComponent(gui_separator1_);

                }
                
                
                
            }
        });
                                goings.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                gui_Container_2.removeAll();
                gui_Container_2.refreshTheme(true);
                page.setIcon(resourceObjectInstance.getImage("user.png"));
                mine.setIcon(resourceObjectInstance.getImage("mine.png"));
                visited.setIcon(resourceObjectInstance.getImage("visits.png"));
                goings.setIcon(resourceObjectInstance.getImage("goingsC.png"));
                interests.setIcon(resourceObjectInstance.getImage("interests.png"));
                wish.setIcon(resourceObjectInstance.getImage("wishliste.png"));
                reservations.setIcon(resourceObjectInstance.getImage("reservations.png"));
                GoingService ser=new GoingService();
                ALG=ser.getGoings(s.user.getId());
                            for (GoingEvent E:ALG)
                { 
        
        com.codename1.ui.Container main = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        com.codename1.ui.Container gui_Container_1_ = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        com.codename1.ui.Container gui_Container_1__2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        com.codename1.components.MultiButton gui_Multi_Button_1_ = new com.codename1.components.MultiButton();
        com.codename1.components.MultiButton gui_Multi_Button_2_ = new com.codename1.components.MultiButton();
        com.codename1.components.MultiButton gui_LA_ = new com.codename1.components.MultiButton();
        com.codename1.ui.Container gui_imageContainer1_ = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
        
        com.codename1.ui.Container gui_Container_2_ = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        com.codename1.ui.TextArea gui_Text_Area_1_ = new com.codename1.ui.TextArea();
        com.codename1.ui.Button inter = new com.codename1.ui.Button();
        com.codename1.ui.Button going = new com.codename1.ui.Button();
        com.codename1.ui.Button delete = new com.codename1.ui.Button();
        com.codename1.ui.Button update = new com.codename1.ui.Button();
        com.codename1.ui.Label gui_separator1_ = new com.codename1.ui.Label();
       
        main.add(gui_Container_1_);
        main.add(gui_Container_1__2);
        gui_Container_1_.setName("Container_1_");
        gui_Container_1__2.setName("Container_1__2");
        gui_Container_1_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_1_);
        gui_Container_1__2.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Multi_Button_2_);
        gui_Multi_Button_1_.setUIID("Label");
        gui_Multi_Button_2_.setUIID("Label");
        gui_Multi_Button_1_.setPropertyValue("line1", E.getEvent().getNom());
        gui_Multi_Button_1_.setPropertyValue("line2", "@"+E.getEvent().getId_etablissement().getNom());
        gui_Multi_Button_1_.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                 public void actionPerformed(ActionEvent evt) 
                   {
                      UnEtablissementEvent UE = new UnEtablissementEvent(s,E.getEvent().getId_etablissement(),resourceObjectInstance);
                      UE.show();
                  }
              });
        gui_Multi_Button_2_.setPropertyValue("line1", "Date: "+E.getEvent().getDate());
        gui_Multi_Button_2_.setPropertyValue("uiid1", "Label");
        gui_Multi_Button_2_.setPropertyValue("uiid1", "SlightlySmallerFontLabelLeft");
        
        gui_Multi_Button_2_.setPropertyValue("uiid2", "Label");
        gui_Multi_Button_2_.setPropertyValue("uiid2", "SlightlySmallerFontLabelLeft");
        
        gui_Multi_Button_2_.setPropertyValue("uiid3", "Label");
        gui_Multi_Button_2_.setPropertyValue("uiid3", "SlightlySmallerFontLabelLeft");
        update(gui_Multi_Button_2_,E.getEvent());
        
        gui_Multi_Button_1_.setPropertyValue("uiid1", "Label");
        gui_Multi_Button_1_.setPropertyValue("uiid2", "RedLabel");
        gui_LA_.setUIID("Label");
        gui_LA_.setName("LA");
        gui_LA_.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
            
        gui_Text_Area_1_.setRows(2);
        gui_Text_Area_1_.setColumns(100);
        gui_Text_Area_1_.setGrowByContent(false);
        gui_Text_Area_1_.setEditable(false);
        
        gui_separator1_.setUIID("Separator");
        gui_separator1_.setName("separator1");
        gui_separator1_.setShowEvenIfBlank(true);
        gui_LA_.setPropertyValue("uiid2", "RedLabelRight");
        //main.add(gui_imageContainer1);
        //gui_imageContainer1.setName("imageContainer1");
        //gui_imageContainer1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_2);
        gui_Container_2_.setName("Container_2");
        gui_Container_2_.setScrollableY(true);
        gui_Container_2_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Text_Area_1_);
        gui_Text_Area_1_.setText("Description: "+ E.getEvent().getDescription());
        gui_Text_Area_1_.setUIID("SlightlySmallerFontLabelLeft");
        gui_Text_Area_1_.setName("Text_Area_1");
        
            InterestService interSer=new InterestService();
            GoingService goSer=new GoingService();
        if (interSer.check(s.user.getId(),E.getId() )==0){
            
        inter.setName("Marquer intéressé(e)");
        inter.setIcon(resourceObjectInstance.getImage("interUn.png"));
        
        }
        else {
        inter.setName("Intéressé(e)");
        inter.setIcon(resourceObjectInstance.getImage("interF.png"));
        }
        if (goSer.check(s.user.getId(),E.getId())==0){
        going.setName("Marquer partant(e)");
        going.setIcon(resourceObjectInstance.getImage("goingUn.png"));
        }
        else {
        going.setName("Partant(e)");
        going.setIcon(resourceObjectInstance.getImage("goingF.png"));
        }
             inter.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                
                if (inter.getName().equals("Marquer intéressé(e)")){
                    interSer.ajoutV(E.getId(), s.user.getId());
                    E.getEvent().setInteresses(E.getEvent().getInteresses()+1);
                inter.setIcon(resourceObjectInstance.getImage("interF.png"));
                
                inter.setName("Intéressé(e)");
                
                if (going.getName().equals("Partant(e)")){
                    goSer.deleteV(E.getId(),s.user.getId());
                    E.getEvent().setNbr_personnes(E.getEvent().getNbr_personnes()-1);
                going.setIcon(resourceObjectInstance.getImage("goingUn.png"));
                going.setName("Marquer partant(e)");
                
                
                }
                
                }
                else if (inter.getName().equals("Intéressé(e)")){
                    interSer.deleteV(E.getId(),s.user.getId());
                    E.getEvent().setInteresses(E.getEvent().getInteresses()-1);
                inter.setIcon(resourceObjectInstance.getImage("interUn.png"));
                
                inter.setName("Marquer intéressé(e)");
                
                }
                
                update(gui_Multi_Button_2_,E.getEvent());
            }
        });
                going.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                if (going.getName().equals("Marquer partant(e)")){
                    goSer.ajoutV(E.getId(), s.user.getId());
                    E.getEvent().setNbr_personnes(E.getEvent().getNbr_personnes()+1);
                going.setIcon(resourceObjectInstance.getImage("goingF.png"));
                
                going.setName("Partant(e)");
                
                if (inter.getName().equals("Intéressé(e)")){
                    interSer.deleteV(E.getId(),s.user.getId());
                    E.getEvent().setInteresses(E.getEvent().getInteresses()-1);
                inter.setIcon(resourceObjectInstance.getImage("interUn.png"));   
                
                inter.setName("Marquer intéressé(e)");
                
                }
                }
                else if (going.getName().equals("Partant(e)")){
                    goSer.deleteV(E.getId(), s.user.getId());
                    E.getEvent().setNbr_personnes(E.getEvent().getNbr_personnes()-1);
                going.setIcon(resourceObjectInstance.getImage("goingUn.png"));    
                
                going.setName("Marquer partant(e)");
                
                }
                update(gui_Multi_Button_2_,E.getEvent());
                
            }
        });
                update.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        UpdateEvent UE = new UpdateEvent(s,E.getEvent(),resourceObjectInstance);
                        UE.show();
                    }
                });
                delete.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        EvenementService ser=new EvenementService();
                        ser.deleteEvenement(E.getEvent());
                        EventsForm UE = new EventsForm(s,resourceObjectInstance);
                        UE.show();
                    }
                });
        

        inter.setText("");
        inter.setUIID("Label");
        
        going.setText("");
        going.setUIID("Label");
        
        delete.setText("");
        delete.setUIID("Label");
        delete.setIcon(resourceObjectInstance.getImage("delete.png"));
        
        update.setText("");
        update.setUIID("Label");
        update.setIcon(resourceObjectInstance.getImage("update.png"));
        
        if (E.getEvent().getId_etablissement().getResponsable()==s.user.getId()){
        
        gui_imageContainer1_.add(update);
        gui_imageContainer1_.add(delete);
        
        }
        else {
        gui_imageContainer1_.add(inter);
        gui_imageContainer1_.add(going);        
        }
        
        
        gui_Container_2_.setName("Container_2");
        
        main.addComponent(gui_imageContainer1_);
        main.addComponent(gui_Container_2_);
        main.addComponent(gui_separator1_);
        //main.setScrollableY(true);
        gui_Container_2.addComponent(main); 
        //C.setScrollableY(true);

              
                }
                
                
            }
        });
                                
interests.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                gui_Container_2.removeAll();
                gui_Container_2.refreshTheme(true);
                page.setIcon(resourceObjectInstance.getImage("user.png"));
                mine.setIcon(resourceObjectInstance.getImage("mine.png"));
                visited.setIcon(resourceObjectInstance.getImage("visits.png"));
                goings.setIcon(resourceObjectInstance.getImage("goings.png"));
                interests.setIcon(resourceObjectInstance.getImage("interestsC.png"));
                wish.setIcon(resourceObjectInstance.getImage("wishliste.png"));
                reservations.setIcon(resourceObjectInstance.getImage("reservations.png"));
                InterestService ser=new InterestService();
                ALI=ser.getInter(s.user.getId());
                
                            for (InterestedEvent E:ALI)
                { 
        
        com.codename1.ui.Container main = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        com.codename1.ui.Container gui_Container_1_ = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        com.codename1.ui.Container gui_Container_1__2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        com.codename1.components.MultiButton gui_Multi_Button_1_ = new com.codename1.components.MultiButton();
        com.codename1.components.MultiButton gui_Multi_Button_2_ = new com.codename1.components.MultiButton();
        com.codename1.components.MultiButton gui_LA_ = new com.codename1.components.MultiButton();
        com.codename1.ui.Container gui_imageContainer1_ = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
        
        com.codename1.ui.Container gui_Container_2_ = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
        com.codename1.ui.TextArea gui_Text_Area_1_ = new com.codename1.ui.TextArea();
        com.codename1.ui.Button inter = new com.codename1.ui.Button();
        com.codename1.ui.Button going = new com.codename1.ui.Button();
        com.codename1.ui.Button delete = new com.codename1.ui.Button();
        com.codename1.ui.Button update = new com.codename1.ui.Button();
        com.codename1.ui.Label gui_separator1_ = new com.codename1.ui.Label();
       
        main.add(gui_Container_1_);
        main.add(gui_Container_1__2);
        gui_Container_1_.setName("Container_1_");
        gui_Container_1__2.setName("Container_1__2");
        gui_Container_1_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_1_);
        gui_Container_1__2.addComponent(com.codename1.ui.layouts.BorderLayout.WEST, gui_Multi_Button_2_);
        gui_Multi_Button_1_.setUIID("Label");
        gui_Multi_Button_2_.setUIID("Label");
        gui_Multi_Button_1_.setPropertyValue("line1", E.getEvent().getNom());
        gui_Multi_Button_1_.setPropertyValue("line2", "@"+E.getEvent().getId_etablissement().getNom());
        gui_Multi_Button_1_.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                 public void actionPerformed(ActionEvent evt) 
                   {
                      UnEtablissementEvent UE = new UnEtablissementEvent(s,E.getEvent().getId_etablissement(),resourceObjectInstance);
                      UE.show();
                  }
              });
        gui_Multi_Button_2_.setPropertyValue("line1", "Date: "+E.getEvent().getDate());
        gui_Multi_Button_2_.setPropertyValue("uiid1", "Label");
        gui_Multi_Button_2_.setPropertyValue("uiid1", "SlightlySmallerFontLabelLeft");
        
        gui_Multi_Button_2_.setPropertyValue("uiid2", "Label");
        gui_Multi_Button_2_.setPropertyValue("uiid2", "SlightlySmallerFontLabelLeft");
        
        gui_Multi_Button_2_.setPropertyValue("uiid3", "Label");
        gui_Multi_Button_2_.setPropertyValue("uiid3", "SlightlySmallerFontLabelLeft");
        update(gui_Multi_Button_2_,E.getEvent());
        
        gui_Multi_Button_1_.setPropertyValue("uiid1", "Label");
        gui_Multi_Button_1_.setPropertyValue("uiid2", "RedLabel");
        gui_LA_.setUIID("Label");
        gui_LA_.setName("LA");
        gui_LA_.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
            
        gui_Text_Area_1_.setRows(2);
        gui_Text_Area_1_.setColumns(100);
        gui_Text_Area_1_.setGrowByContent(false);
        gui_Text_Area_1_.setEditable(false);
        
        gui_separator1_.setUIID("Separator");
        gui_separator1_.setName("separator1");
        gui_separator1_.setShowEvenIfBlank(true);
        gui_LA_.setPropertyValue("uiid2", "RedLabelRight");
        //main.add(gui_imageContainer1);
        //gui_imageContainer1.setName("imageContainer1");
        //gui_imageContainer1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_2);
        gui_Container_2_.setName("Container_2");
        gui_Container_2_.setScrollableY(true);
        gui_Container_2_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Text_Area_1_);
        gui_Text_Area_1_.setText("Description: "+ E.getEvent().getDescription());
        gui_Text_Area_1_.setUIID("SlightlySmallerFontLabelLeft");
        gui_Text_Area_1_.setName("Text_Area_1");
        
            InterestService interSer=new InterestService();
            GoingService goSer=new GoingService();
        if (interSer.check(s.user.getId(),E.getId())==0){
            
        inter.setName("Marquer intéressé(e)");
        inter.setIcon(resourceObjectInstance.getImage("interUn.png"));
        
        }
        else {
        inter.setName("Intéressé(e)");
        inter.setIcon(resourceObjectInstance.getImage("interF.png"));
        }
        if (goSer.check( s.user.getId(),E.getId())==0){
        going.setName("Marquer partant(e)");
        going.setIcon(resourceObjectInstance.getImage("goingUn.png"));
        }
        else {
        going.setName("Partant(e)");
        going.setIcon(resourceObjectInstance.getImage("goingF.png"));
        }
             inter.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                
                if (inter.getName().equals("Marquer intéressé(e)")){
                    interSer.ajoutV(E.getId(), s.user.getId());
                    E.getEvent().setInteresses(E.getEvent().getInteresses()+1);
                inter.setIcon(resourceObjectInstance.getImage("interF.png"));
                
                inter.setName("Intéressé(e)");
                
                if (going.getName().equals("Partant(e)")){
                    goSer.deleteV(E.getId(),s.user.getId());
                    E.getEvent().setNbr_personnes(E.getEvent().getNbr_personnes()-1);
                going.setIcon(resourceObjectInstance.getImage("goingUn.png"));
                going.setName("Marquer partant(e)");
                
                
                }
                
                }
                else if (inter.getName().equals("Intéressé(e)")){
                    interSer.deleteV(E.getId(),s.user.getId());
                    E.getEvent().setInteresses(E.getEvent().getInteresses()-1);
                inter.setIcon(resourceObjectInstance.getImage("interUn.png"));
                
                inter.setName("Marquer intéressé(e)");
                
                }
                
                update(gui_Multi_Button_2_,E.getEvent());
            }
        });
                going.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                if (going.getName().equals("Marquer partant(e)")){
                    goSer.ajoutV(E.getId(), s.user.getId());
                    E.getEvent().setNbr_personnes(E.getEvent().getNbr_personnes()+1);
                going.setIcon(resourceObjectInstance.getImage("goingF.png"));
                
                going.setName("Partant(e)");
                
                if (inter.getName().equals("Intéressé(e)")){
                    interSer.deleteV(E.getId(),s.user.getId());
                    E.getEvent().setInteresses(E.getEvent().getInteresses()-1);
                inter.setIcon(resourceObjectInstance.getImage("interUn.png"));   
                
                inter.setName("Marquer intéressé(e)");
                
                }
                }
                else if (going.getName().equals("Partant(e)")){
                    goSer.deleteV(E.getId(), s.user.getId());
                    E.getEvent().setNbr_personnes(E.getEvent().getNbr_personnes()-1);
                going.setIcon(resourceObjectInstance.getImage("goingUn.png"));    
                
                going.setName("Marquer partant(e)");
                
                }
                update(gui_Multi_Button_2_,E.getEvent());
                
            }
        });
                update.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        UpdateEvent UE = new UpdateEvent(s,E.getEvent(),resourceObjectInstance);
                        UE.show();
                    }
                });
                delete.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        EvenementService ser=new EvenementService();
                        ser.deleteEvenement(E.getEvent());
                        EventsForm UE = new EventsForm(s,resourceObjectInstance);
                        UE.show();
                    }
                });
        

        inter.setText("");
        inter.setUIID("Label");
        
        going.setText("");
        going.setUIID("Label");
        
        delete.setText("");
        delete.setUIID("Label");
        delete.setIcon(resourceObjectInstance.getImage("delete.png"));
        
        update.setText("");
        update.setUIID("Label");
        update.setIcon(resourceObjectInstance.getImage("update.png"));
        
        if (E.getEvent().getId_etablissement().getResponsable()==s.user.getId()){
        
        gui_imageContainer1_.add(update);
        gui_imageContainer1_.add(delete);
        
        }
        else {
        gui_imageContainer1_.add(inter);
        gui_imageContainer1_.add(going);        
        }
        
        
        gui_Container_2_.setName("Container_2");
        
        main.addComponent(gui_imageContainer1_);
        main.addComponent(gui_Container_2_);
        main.addComponent(gui_separator1_);
        //main.setScrollableY(true);
        gui_Container_2.addComponent(main); 
        //C.setScrollableY(true);

              
                }
                
                
            }
        });
                             reservations.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                gui_Container_2.removeAll();
                gui_Container_2.refreshTheme(true);
                page.setIcon(resourceObjectInstance.getImage("user.png"));
                mine.setIcon(resourceObjectInstance.getImage("mine.png"));
                visited.setIcon(resourceObjectInstance.getImage("visits.png"));
                goings.setIcon(resourceObjectInstance.getImage("goings.png"));
                interests.setIcon(resourceObjectInstance.getImage("interests.png"));
                wish.setIcon(resourceObjectInstance.getImage("wishliste.png"));
                reservations.setIcon(resourceObjectInstance.getImage("reservationsC.png"));
                ReservationService ser=new ReservationService();
                ALR=ser.getListUser(s.user.getId());
                
                for (Reservation E:ALR)
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
                gui_Multi_Button_1_.setPropertyValue("line1", "Réservation chez "+E.getId_etablissement().getNom());
                
                gui_Multi_Button_2_.setPropertyValue("line1", "Au nom de : "+E.getNom()+" "+E.getPrenom());
                gui_Multi_Button_2_.setPropertyValue("uiid1", "Label");
                gui_Multi_Button_2_.setPropertyValue("uiid1", "SlightlySmallerFontLabelLeft");
        
                
                
                gui_Multi_Button_2_.setPropertyValue("line2", "Pour le "+E.getDate());
                gui_Multi_Button_2_.setPropertyValue("uiid2", "Label");
                gui_Multi_Button_2_.setPropertyValue("uiid2", "SlightlySmallerFontLabelLeft");
                
                gui_Multi_Button_2_.setPropertyValue("line3", "Nombre de personnes "+E.getNbr_personnes());
                gui_Multi_Button_2_.setPropertyValue("uiid3", "Label");
                gui_Multi_Button_2_.setPropertyValue("uiid3", "SlightlySmallerFontLabelLeft");
                
                gui_Multi_Button_2_.setPropertyValue("line4", "Numéro de téléphone "+E.getNum_tel());
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
                        UneReservation UE = new UneReservation(s,E,resourceObjectInstance);
                        UE.show();
                    }
                });
                gui_Container_1_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_1_);
                gui_Container_2_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, show);
                gui_Container_3_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_2_);
                gui_Container_2.add(gui_Container_1_);
                gui_Container_2.add(gui_Container_2_);
                gui_Container_2.add(gui_Container_3_);
                gui_Container_2.addComponent(gui_separator1_);

                }
                
                
            }
        });         

    }
     public void update(MultiButton b1,Evenement E){
        b1.setPropertyValue("line2", "Personnes intéressées: "+E.getInteresses());
        b1.setPropertyValue("line3", "Personnes partantes: "+E.getNbr_personnes());
        }
    
        private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("ProfileForm");
        setName("ProfileForm");
                gui_Button_1.setText("Modifier");
                gui_Button_1.setName("Button_1");
                C.setType(Display.PICKER_TYPE_DATE);
                System.out.println(s.user.getId() + s.user.getEmail());
                gui_Text_Field_1.setText(s.user.getUsername());
                gui_Text_Field_2.setText(s.user.getEmail());
                gui_Text_Field_3.setText(s.user.getNom());
                gui_Text_Field_4.setText(s.user.getSexe());
                gui_Text_Field_6.setText(s.user.getVille());
                gui_Text_Field_7.setText(String.valueOf(s.user.getPhone()));
                gui_Text_Field_8.setText(s.user.getUrl());
                gui_Text_Field_9.setText(s.user.getIntro());
                gui_Component_Group_1.addComponent(gui_Text_Field_1);
                gui_Component_Group_1.addComponent(gui_Text_Field_2);
                gui_Component_Group_1.addComponent(gui_Text_Field_3);
                gui_Component_Group_1.addComponent(gui_Text_Field_4);
                gui_Component_Group_1.addComponent(C); 
                gui_Component_Group_1.addComponent(gui_Text_Field_6);
                gui_Component_Group_1.addComponent(gui_Text_Field_7);
                gui_Component_Group_1.addComponent(gui_Text_Field_8); 
                gui_Component_Group_1.addComponent(gui_Text_Field_9); 
                gui_Component_Group_1.addComponent(gui_Button_1);
                gui_Container_2.addComponent(gui_Component_Group_1);
        addComponent(gui_Container_1);
        wish.setText("");
        wish.setUIID("Label");
        page.setText("");
        page.setUIID("Label");
        visited.setText("");
        visited.setUIID("Label");
        goings.setText("");
        goings.setUIID("Label");  
        interests.setText("");
        interests.setUIID("Label");  
        mine.setText("");
        mine.setUIID("Label"); 
        reservations.setText("");
        reservations.setUIID("Label");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_1.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        wish.setIcon(resourceObjectInstance.getImage("wishliste.png"));
        
        page.setIcon(resourceObjectInstance.getImage("userC.png"));
        mine.setIcon(resourceObjectInstance.getImage("mine.png"));
        visited.setIcon(resourceObjectInstance.getImage("visits.png"));
        goings.setIcon(resourceObjectInstance.getImage("goings.png"));
        interests.setIcon(resourceObjectInstance.getImage("interests.png"));
        reservations.setIcon(resourceObjectInstance.getImage("reservations.png"));
                main.add(page);
                main.add(mine);
                main.add(wish);
                main.add(visited);
                main2.add(goings);
                main2.add(interests);
                main2.add(reservations);
        gui_Container_1.addComponent(main);
        gui_Container_1.addComponent(main2);
        Container content3 = BoxLayout.encloseY(
                   
                new Label(resourceObjectInstance.getImage("welcome-separator.png"), "WelcomeTitle")
               
        );
        gui_Container_1.setName("Container_1");
        addComponent(content3);
        addComponent(gui_Container_2);
        gui_Container_2.setScrollableY(true);
        
        }
}
