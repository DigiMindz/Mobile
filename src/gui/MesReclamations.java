/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import Entity.Etablissement;
import Entity.Evenement;
import Entity.Reclamation;
import Entity.Reservation;
import Entity.Session;
import Service.EvenementService;
import Service.GoingService;
import Service.InterestService;
import Service.ReservationService;
import Service.ServiceReclamation;
import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.io.NetworkEvent;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Ons Ben Othmen
 */
public class MesReclamations extends BaseForm{
    ArrayList<Reclamation> ALE = new ArrayList<>();
    int user;
    Session s;
    
    public MesReclamations (Session s,com.codename1.ui.util.Resources resourceObjectInstance) {
        super(s);
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(s,resourceObjectInstance);
        setTitle("ReservationsForm");
        setName("ReservationsForm");
//         Form last =  Display.getInstance().getCurrent();
//        getToolbar().addMaterialCommandToRightBar("",FontImage.MATERIAL_ARROW_BACK, e -> last.show());
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {new GoogleMapsForm(s,resourceObjectInstance).show();});
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Mes réclamations", "Title")
                        
                )
        );
        getContentPane().setUIID("SignInForm");
         gui_separator1.setShowEvenIfBlank(true);
        gui_Label_1_1_1.setShowEvenIfBlank(true);

      
       //gui_Container_2.setScrollableY(true);
        
    }
      
    
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    
    private com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_separator1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_1_1_1 = new com.codename1.ui.Label();
    private com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
    private com.codename1.components.MultiButton gui_LA = new com.codename1.components.MultiButton();
    
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) 
    {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Trending");
        setName("TrendingForm");
        
        addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");
        
        
        Container content3 = BoxLayout.encloseY(
                 
                new Label(resourceObjectInstance.getImage("welcome-separator.png"), "WelcomeTitle")
               
        );
        addComponent(content3);;
        addComponent(gui_Container_2);
       
        //gui_Container_1.setScrollableY(true);
        
        
        
         ServiceReclamation ser = new ServiceReclamation();
                    
         
                    ALE = ser.getList2(s.user.getId());
                 
       FillContainersRes(ALE,gui_Container_2,resourceObjectInstance);
       setScrollableY(true);
        
    }
        public void FillContainersRes(ArrayList<Reclamation> ALE,Container C,com.codename1.ui.util.Resources resourceObjectInstance){
        
        for (Reclamation E:ALE)
                {
                
                com.codename1.ui.Container gui_Container_1_ = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());   
                com.codename1.ui.Container gui_Container_2_ = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());    
                com.codename1.ui.Container gui_Container_3_ = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());    
                com.codename1.components.MultiButton gui_Multi_Button_1_ = new com.codename1.components.MultiButton();
                com.codename1.components.MultiButton gui_Multi_Button_2_ = new com.codename1.components.MultiButton();
                
                com.codename1.ui.Label gui_separator1_ = new com.codename1.ui.Label();
                
                gui_Multi_Button_1_.setUIID("Label");
                gui_Multi_Button_1_.setPropertyValue("uiid1", "Label");
                gui_Multi_Button_1_.setPropertyValue("line1", "Sujet "+E.getSujet());
                
                gui_Multi_Button_2_.setPropertyValue("line1", "Au nom de : "+E.getContenu_rec());
                gui_Multi_Button_2_.setPropertyValue("uiid1", "Label");
                gui_Multi_Button_2_.setPropertyValue("uiid1", "SlightlySmallerFontLabelLeft");
        
                
                
                
                
                gui_separator1_.setUIID("Separator");
                gui_separator1_.setName("separator1");
                
                gui_Container_1_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_1_);
                
                gui_Container_3_.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_2_);
                C.add(gui_Container_1_);
                C.add(gui_Container_3_);
                C.addComponent(gui_separator1_);

                }
    }

}
