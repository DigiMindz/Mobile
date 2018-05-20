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
import Service.GoingService;
import Service.InterestService;
import Service.OffreService;
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
public class OffresForm extends BaseForm{
    ArrayList<Offre> ALE = new ArrayList<>();
    Session s;
    ArrayList<Offre> ALE2 = new ArrayList<>();
    
    public OffresForm (Session s,com.codename1.ui.util.Resources resourceObjectInstance) {
        super(s);
        this.s=s;
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(s,resourceObjectInstance);
        setTitle("Offres");
        setName("Offres");
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {new GoogleMapsForm(s,resourceObjectInstance).show();});
//         Form last =  Display.getInstance().getCurrent();
//        getToolbar().addMaterialCommandToRightBar("",FontImage.MATERIAL_ARROW_BACK, e -> last.show());
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Offres", "Title")
                        
                )
        );
        getContentPane().setUIID("SignInForm");
        gui_separator1.setShowEvenIfBlank(true);
        gui_Label_1_1_1.setShowEvenIfBlank(true);
      
             gui_Text_Field_1.addDataChangedListener(new DataChangedListener() {
        
            @Override
            public void dataChanged(int type, int index) {
                    OffreService ser = new OffreService();
                    gui_Container_2.removeAll();
         
                    String motcle=gui_Text_Field_1.getText();
                    if (motcle.equals("")){
                    ALE = ser.getList2();
                    FillContainersOffre(ALE,gui_Container_2,resourceObjectInstance);
                    refreshTheme();
                    }
                    else {
                     ALE2 = ser.getListCle(motcle);
                    FillContainersOffre(ALE2,gui_Container_2,resourceObjectInstance);
                    refreshTheme();
                    }
                    
                    
                
            }
        });
       gui_Text_Field_1.setRows(2);
       gui_Text_Field_1.setColumns(100);
       gui_Text_Field_1.setGrowByContent(false);      
       //gui_Container_2.setScrollableY(true);
        
    }
      
    
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_separator1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_1_1_1 = new com.codename1.ui.Label();
    private com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
    private com.codename1.components.MultiButton gui_LA = new com.codename1.components.MultiButton();
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("OffresForm");
        setName("OffresForm");
        
        addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");
        
        gui_Container_1.addComponent( gui_Text_Field_1);
        Container content3 = BoxLayout.encloseY(
                 
                new Label(resourceObjectInstance.getImage("welcome-separator.png"), "WelcomeTitle")
               
        );
        addComponent(content3);;
        addComponent(gui_Container_2);
       
        //gui_Container_1.setScrollableY(true);
        
        
        
         OffreService ser = new OffreService();
                    
         
                    ALE = ser.getList2();
                 
                    FillContainersOffre(ALE,gui_Container_2,resourceObjectInstance);
       setScrollableY(true);
        
    }
        public void FillContainersOffre(ArrayList<Offre> ALE,Container C,com.codename1.ui.util.Resources resourceObjectInstance){
        
            for (Offre E:ALE)
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
        gui_Multi_Button_1_.setPropertyValue("line1", E.getOffre());
        gui_Multi_Button_1_.setPropertyValue("line2", "@"+E.getId_etablissement().getNom());
        gui_Multi_Button_1_.addActionListener(new ActionListener() 
                {
                    @Override
                 public void actionPerformed(ActionEvent evt) 
                   {
                      UnEtablissementOffre UE = new UnEtablissementOffre(s,E.getId_etablissement(),resourceObjectInstance);
                      UE.show();
                  }
              });
        gui_Multi_Button_1_.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                 public void actionPerformed(ActionEvent evt) 
                   {
                      UnEtablissementOffre UE = new UnEtablissementOffre(s,E.getId_etablissement(),resourceObjectInstance);
                      UE.show();
                  }
              });
        gui_Multi_Button_2_.setPropertyValue("line1", "Date début: "+E.getDate_debut());
        gui_Multi_Button_2_.setPropertyValue("uiid1", "Label");
        gui_Multi_Button_2_.setPropertyValue("uiid1", "SlightlySmallerFontLabelLeft");
        
        gui_Multi_Button_2_.setPropertyValue("line2", "Date fin: "+E.getDate_debut());
        gui_Multi_Button_2_.setPropertyValue("uiid2", "Label");
        gui_Multi_Button_2_.setPropertyValue("uiid2", "SlightlySmallerFontLabelLeft");
        
        if (E.getId_etablissement().getPartenaire()==0){}
        else {
        gui_Multi_Button_2_.setPropertyValue("line3", "Code promo: "+E.getCode());
        gui_Multi_Button_2_.setPropertyValue("uiid3", "Label");
        gui_Multi_Button_2_.setPropertyValue("uiid3", "SlightlySmallerFontLabelLeft");
        
        gui_Multi_Button_2_.setPropertyValue("line4", "Pourcentage off: "+E.getPourcentage());
        gui_Multi_Button_2_.setPropertyValue("uiid4", "Label");
        gui_Multi_Button_2_.setPropertyValue("uiid4", "SlightlySmallerFontLabelLeft");
        
        }
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
        gui_Text_Area_1_.setText("Description: "+ E.getDescription());
        gui_Text_Area_1_.setUIID("SlightlySmallerFontLabelLeft");
        gui_Text_Area_1_.setName("Text_Area_1");
        
            InterestService interSer=new InterestService();
            GoingService goSer=new GoingService();
    

    
                update.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        UpdateOffre UE = new UpdateOffre(s,E,resourceObjectInstance);
                        UE.show();
                    }
                });
                delete.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        OffreService ser=new OffreService();
                        ser.deleteOffre(E);
                        OffresForm UE = new OffresForm(s,resourceObjectInstance);
                        UE.show();
                    }
                });
       
        delete.setText("");
        delete.setUIID("Label");
        delete.setIcon(resourceObjectInstance.getImage("delete.png"));
        
        update.setText("");
        update.setUIID("Label");
        gui_imageContainer1_.add(update);
        gui_imageContainer1_.add(delete);
        update.setIcon(resourceObjectInstance.getImage("update.png"));
        if (E.getId_etablissement().getResponsable()==s.user.getId()){
        main.addComponent(gui_imageContainer1_);
        }

        gui_Container_2_.setName("Container_2");
        main.addComponent(gui_Container_2_);
        
        main.addComponent(gui_separator1_);
        //main.setScrollableY(true);
        C.addComponent(main);  
        //C.setScrollableY(true);

              
                }
    }
        

}
