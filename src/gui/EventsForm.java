/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import Entity.Evenement;
import Entity.Session;
import Service.EvenementService;
import Service.GoingService;
import Service.InterestService;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
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
public class EventsForm extends BaseForm{
    ArrayList<Evenement> ALE = new ArrayList<>();
    ArrayList<Evenement> ALE2 = new ArrayList<>();
    Session session;
    
    public EventsForm (Session s,com.codename1.ui.util.Resources resourceObjectInstance) {
        super(s);
        session = s;
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(s,resourceObjectInstance);
        setTitle("EventsForm");
        setName("EventsForm");
//         Form last =  Display.getInstance().getCurrent();
//        getToolbar().addMaterialCommandToRightBar("",FontImage.MATERIAL_ARROW_BACK, e -> last.show());
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {new GoogleMapsForm(session,resourceObjectInstance).show();});
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Evènements", "Title")
                        
                )
        );
        getContentPane().setUIID("SignInForm");
         gui_separator1.setShowEvenIfBlank(true);
        gui_Label_1_1_1.setShowEvenIfBlank(true);
      
             gui_Text_Field_1.addDataChangedListener(new DataChangedListener() {
        
            @Override
            public void dataChanged(int type, int index) {
                    EvenementService ser = new EvenementService();
                    gui_Container_2.removeAll();
         
                    String motcle=gui_Text_Field_1.getText();
                    if (motcle.equals("")){
                    ALE = ser.getList2();
                    FillContainersEvent(ALE,gui_Container_2,resourceObjectInstance);
                    refreshTheme();
                    }
                    else {
                     ALE2 = ser.getListCle(motcle);
                    FillContainersEvent(ALE2,gui_Container_2,resourceObjectInstance);
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
        setTitle("Trending");
        setName("TrendingForm");
        
        addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");
        
        gui_Container_1.addComponent( gui_Text_Field_1);
        Container content3 = BoxLayout.encloseY(
                 
                new Label(resourceObjectInstance.getImage("welcome-separator.png"), "WelcomeTitle")
               
        );
        addComponent(content3);;
        addComponent(gui_Container_2);
       
        //gui_Container_1.setScrollableY(true);
        
        
        
         EvenementService ser = new EvenementService();
                    
         
                    ALE = ser.getList2();
                 
                    FillContainersEvent(ALE,gui_Container_2,resourceObjectInstance);
       setScrollableY(true);
        
    }
        public void FillContainersEvent(ArrayList<Evenement> ALE,Container C,com.codename1.ui.util.Resources resourceObjectInstance){
        
            for (Evenement E:ALE)
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
        gui_Multi_Button_1_.setPropertyValue("line1", E.getNom());
        gui_Multi_Button_1_.setPropertyValue("line2", "@"+E.getId_etablissement().getNom());
        gui_Multi_Button_1_.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                 public void actionPerformed(ActionEvent evt) 
                   {
                      UnEtablissement UE = new UnEtablissement(session,E.getId_etablissement(),resourceObjectInstance);
                      UE.show();
                  }
              });
        gui_Multi_Button_2_.setPropertyValue("line1", "Date: "+E.getDate());
        gui_Multi_Button_2_.setPropertyValue("uiid1", "Label");
        gui_Multi_Button_2_.setPropertyValue("uiid1", "SlightlySmallerFontLabelLeft");
        
        gui_Multi_Button_2_.setPropertyValue("uiid2", "Label");
        gui_Multi_Button_2_.setPropertyValue("uiid2", "SlightlySmallerFontLabelLeft");
        
        gui_Multi_Button_2_.setPropertyValue("uiid3", "Label");
        gui_Multi_Button_2_.setPropertyValue("uiid3", "SlightlySmallerFontLabelLeft");
        update(gui_Multi_Button_2_,E);
        
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
        if (interSer.check( session.user.getId(),E.getId())==0){
            
        inter.setName("Marquer intéressé(e)");
        inter.setIcon(resourceObjectInstance.getImage("interUn.png"));
        
        }
        else {
        inter.setName("Intéressé(e)");
        inter.setIcon(resourceObjectInstance.getImage("interF.png"));
        }
        if (goSer.check( session.user.getId(),E.getId())==0){
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
                    interSer.ajoutV(E.getId(), session.user.getId());
                    E.setInteresses(E.getInteresses()+1);
                inter.setIcon(resourceObjectInstance.getImage("interF.png"));
                
                inter.setName("Intéressé(e)");
                
                if (going.getName().equals("Partant(e)")){
                    goSer.deleteV(E.getId(), session.user.getId());
                    E.setNbr_personnes(E.getNbr_personnes()-1);
                going.setIcon(resourceObjectInstance.getImage("goingUn.png"));
                going.setName("Marquer partant(e)");
                
                
                }
                
                }
                else if (inter.getName().equals("Intéressé(e)")){
                    interSer.deleteV(E.getId(),session.user.getId());
                    E.setInteresses(E.getInteresses()-1);
                inter.setIcon(resourceObjectInstance.getImage("interUn.png"));
                
                inter.setName("Marquer intéressé(e)");
                
                }
                
                update(gui_Multi_Button_2_,E);
            }
        });
                going.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                if (going.getName().equals("Marquer partant(e)")){
                    goSer.ajoutV(E.getId(), session.user.getId());
                    E.setNbr_personnes(E.getNbr_personnes()+1);
                going.setIcon(resourceObjectInstance.getImage("goingF.png"));
                
                going.setName("Partant(e)");
                
                if (inter.getName().equals("Intéressé(e)")){
                    interSer.deleteV(E.getId(),session.user.getId());
                    E.setInteresses(E.getInteresses()-1);
                inter.setIcon(resourceObjectInstance.getImage("interUn.png"));   
                
                inter.setName("Marquer intéressé(e)");
                
                }
                }
                else if (going.getName().equals("Partant(e)")){
                    goSer.deleteV(E.getId(), session.user.getId());
                    E.setNbr_personnes(E.getNbr_personnes()-1);
                going.setIcon(resourceObjectInstance.getImage("goingUn.png"));    
                
                going.setName("Marquer partant(e)");
                
                }
                update(gui_Multi_Button_2_,E);
                
            }
        });
                update.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        UpdateEvent UE = new UpdateEvent(session,E,resourceObjectInstance);
                        UE.show();
                    }
                });
                delete.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        EvenementService ser=new EvenementService();
                        ser.deleteEvenement(E);
                        EventsForm UE = new EventsForm(session,resourceObjectInstance);
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
        
        if (E.getId_etablissement().getResponsable()==session.user.getId()){
        
        gui_imageContainer1_.add(update);
        gui_imageContainer1_.add(delete);
        
        }
        else {
        gui_imageContainer1_.add(inter);
        gui_imageContainer1_.add(going);        
        }
        
        
        gui_Container_2_.setName("Container_2");
        
        main.addComponent(gui_imageContainer1_);
//        Container f=createPieChartForm(E);
//        main.add(f);
        main.addComponent(gui_Container_2_);
        main.addComponent(gui_separator1_);
        //main.setScrollableY(true);
        C.addComponent(main);  
        //C.setScrollableY(true);

              
                }
    }
        public void update(MultiButton b1,Evenement E){
        b1.setPropertyValue("line2", "Personnes intéressées: "+E.getInteresses());
        b1.setPropertyValue("line3", "Personnes partantes: "+E.getNbr_personnes());
        }

}
