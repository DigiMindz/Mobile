package gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import Entity.Etablissement;
import Entity.Evenement;
import Entity.Session;
import Service.EvenementService;
import Service.LikedService;
import Service.VisitedService;
import com.codename1.components.MultiButton;
import com.codename1.components.WebBrowser;
import com.codename1.io.URL;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;
import java.net.URISyntaxException;
public class UnEtablissementEvent extends BaseForm
{
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_Container_1_responsable = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_Container_1_responsable_ = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container stat = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    
    URL u;
    Etablissement E;
    Session s;
    private com.codename1.ui.Button add_event = new com.codename1.ui.Button();
    private com.codename1.ui.Button add_offre = new com.codename1.ui.Button();
    private com.codename1.ui.Button modifier = new com.codename1.ui.Button();
    private com.codename1.ui.Button delete = new com.codename1.ui.Button();
    private com.codename1.ui.Button reservations = new com.codename1.ui.Button();
    private com.codename1.ui.Button events = new com.codename1.ui.Button();
    private com.codename1.ui.Button offers = new com.codename1.ui.Button();
    private com.codename1.ui.Button tags = new com.codename1.ui.Button();
    private com.codename1.ui.Button like = new com.codename1.ui.Button();
    private com.codename1.ui.Button visit = new com.codename1.ui.Button();
    private com.codename1.ui.TextArea commentaire = new com.codename1.ui.TextArea();
    private com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
    public UnEtablissementEvent(Session s,Etablissement E,Resources resourceObjectInstance)
    {
        super(s);
        this.E = E;
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(s,resourceObjectInstance);
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label(E.getNom(), "Title")
                        
                )
      
        );
        
          
//          getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, ev -> { new EventsForm(resourceObjectInstance).show();});
         Form last =  Display.getInstance().getCurrent();
        getToolbar().addMaterialCommandToRightBar("",FontImage.MATERIAL_ARROW_BACK, e -> last.show());
add_event.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                new AjoutEvent(s,E,resourceObjectInstance).show();
            }
        });
                      events.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                new EventsEtabForm(s,E,resourceObjectInstance).show();
            }
        });
                      offers.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                new OffresEtabForm(s,E,resourceObjectInstance).show();
            }
        });
           
            add_offre.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                new AjoutOffre(s,E,resourceObjectInstance).show();
                
            }
        });
                    LikedService likeSer=new LikedService();
                    VisitedService vSer=new VisitedService();
        like.setText("");
        like.setUIID("Label");
        visit.setText("");
        visit.setUIID("Label");            
                    like.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                if (like.getName().equals("J'aime")){
                
                likeSer.ajoutLike(E.getId(), s.user.getId());
                like.setName("Aimé");
                like.setIcon(resourceObjectInstance.getImage("heartColored.png"));
                update(gui_Multi_Button_1,E);
                }
                else if (like.getName().equals("Aimé")){
                likeSer.deleteLike(E.getId(),s.user.getId());
                like.setName("J'aime");
                like.setIcon(resourceObjectInstance.getImage("heart.png"));
                update(gui_Multi_Button_1,E);
                }
                
                
            }
        });
                visit.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                if (visit.getName().equals("Marquer visité")){
                vSer.ajoutV(E.getId(), s.user.getId());
                visit.setIcon(resourceObjectInstance.getImage("mapColored.png"));
                update(gui_Multi_Button_1,E);
                visit.setName("Visité");
                
                }
                else if (visit.getName().equals("Visité")){
                vSer.deleteV(E.getId(), s.user.getId());
                visit.setIcon(resourceObjectInstance.getImage("map.png"));
                update(gui_Multi_Button_1,E);
                visit.setName("Marquer visité");
                }
                
                
            }
        });
                


    }
        public void update(MultiButton b1,Etablissement E){
            LikedService ser=new LikedService();
            VisitedService vser=new VisitedService();
            b1.setPropertyValue("line1", ser.count(E.getId())+" aime(s)");
            b1.setPropertyValue("line2", vser.count(E.getId())+" visite(s)");
            }
    
        private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("UnEtablissementEvent");
        setName("UnEtablissementEvent");
        
        Image bla = resourceObjectInstance.getImage("bla2.jpg").scaledLargerRatio(300, 300);
    
                Container content3 = BoxLayout.encloseY(
                new Label(bla, "WelcomeTitle"),        
                new Label(resourceObjectInstance.getImage("welcome-separator.png"), "WelcomeTitle")
               
        );
        
        addComponent(content3);
        
        
        if (E.getResponsable()!=s.user.getId()){}
        else {
        addComponent(gui_Container_2);}
        
        addComponent(stat);
        
        
        
        addComponent(gui_Container_1);
        
        
        
        
        if (E.getResponsable()!=s.user.getId()){
        addComponent(gui_Container_1_responsable_);
        addComponent(gui_Container_1_responsable);
        }
        addComponent(gui_Container_3);
        if (E.getResponsable()!=s.user.getId()){}
        else {
        addComponent(gui_Container_4);
        }
        
        
        gui_Container_1.setName("Container_1");
        VisitedService vser=new VisitedService();
        Label visits = new Label(String.valueOf(vser.count(E.getId())));
        
        LikedService lser=new LikedService();
        Label likes = new Label(String.valueOf(lser.count(E.getId())));
        gui_Multi_Button_1.setUIID("Label");
        gui_Multi_Button_1.setPropertyValue("uiid1", "Label");
        gui_Multi_Button_1.setPropertyValue("uiid1", "SlightlySmallerFontLabelLeft");
        
        gui_Multi_Button_1.setPropertyValue("uiid2", "Label");
        gui_Multi_Button_1.setPropertyValue("uiid2", "SlightlySmallerFontLabelLeft");
        update(gui_Multi_Button_1,E);
        //SpanLabel vvv = new SpanLabel(visits.getText()+ " visite(s) "+likes.getText()+" aime(s)");
        Label L1 = new Label(E.getAdresse());
        SpanLabel L2 = new SpanLabel("Adresse : " + L1.getText());
        stat.add(gui_Multi_Button_1);
        gui_Container_1.add(tags);
        gui_Container_1.add(L2);
        com.codename1.ui.TextArea gui_Text_Area_1_ = new com.codename1.ui.TextArea();
        com.codename1.ui.Container containerDes = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        containerDes.setScrollableY(true);
        containerDes.add(gui_Text_Area_1_);
        gui_Text_Area_1_.setRows(2);
        gui_Text_Area_1_.setColumns(100);
        gui_Text_Area_1_.setGrowByContent(false);
        gui_Text_Area_1_.setEditable(false);
        gui_Text_Area_1_.setText("Description: "+ E.getDescription());
        gui_Text_Area_1_.setUIID("SlightlySmallerFontLabelLeft");
        gui_Text_Area_1_.setName("Text_Area_1");
        
        Label LL = new Label(E.getHoraire_fermeture()+" - "+E.getHoraire_ouverture());
        SpanLabel LL1 = new SpanLabel("Horaire : " + LL.getText());
        Label Lb = new Label(String.valueOf( E.getBudgetmoyen()));
        SpanLabel Lb1 = new SpanLabel("Budget moyen : " + Lb.getText());
        Label ur = new Label(String.valueOf( E.getUrl()));
        
        SpanLabel url = new SpanLabel(ur.getText());
                 url.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        WebBrowser browser = new WebBrowser();
                        com.codename1.ui.Container subCenterContainer = new com.codename1.ui.Container();
                        subCenterContainer.setLayout(new BorderLayout());
                        subCenterContainer.addComponent(BorderLayout.CENTER, browser);
                        
                        browser.setURL(E.getUrl());
                    }
                });
        
        
        Label L5 = new Label(E.getType());
        Label L6 = new Label();
        if (E.getType_resto() != null)
        {
            L6.setText(E.getType_resto());
        }
        if (E.getType_shops() != null)
        {
            L6.setText(E.getType_shops());
        }
        if (E.getType_loisirs() != null)
        {
            L6.setText(E.getType_loisirs());
        }
        if (E.getNbrStars() != null)
        {
            L6.setText(E.getNbrStars());
        }
                        modifier.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        
                    }
                });
                        delete.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                       
                    }
                });
        SpanLabel L7 = new SpanLabel("Type : " + L6.getText());
        gui_Container_1.add(L7);
        gui_Container_1.add(LL1);
        gui_Container_1.add(Lb1);
        gui_Container_1.add(url);
        gui_Container_1.add(containerDes);
        add_event.setText("Ajouter un évenement");
        
        modifier.setText("");
        modifier.setUIID("Label");
        modifier.setIcon(resourceObjectInstance.getImage("update.png"));
        
        delete.setText("");
        delete.setUIID("Label");
        delete.setIcon(resourceObjectInstance.getImage("delete.png"));
        reservations.setText("Réservations");
        
        add_offre.setText("Proposer une offre");
        offers.setText("Offres");
        events.setText("Evenements");
        tags.setText("Tags");
        like.setText("");
        like.setUIID("Label");
        visit.setText("");
        visit.setUIID("Label");
        
        
        
        
       
       
        
        setScrollableY(true);
        
        LikedService likeSer=new LikedService();
                    if (likeSer.check(E.getId(), s.user.getId())==0){
                    like.setName("J'aime");
                    like.setIcon(resourceObjectInstance.getImage("heart.png"));
                    }
                    else {
                    like.setName("Aimé");
                    like.setIcon(resourceObjectInstance.getImage("heartColored.png"));
                    }
        VisitedService vSer=new VisitedService();
                    if (vSer.check(E.getId(), s.user.getId())==0){
                    visit.setName("Marquer visité");
                    visit.setIcon(resourceObjectInstance.getImage("map.png"));
                    }
                    else {
                    visit.setName("Visité");
                    visit.setIcon(resourceObjectInstance.getImage("mapColored.png"));
                    }
        Label comm=new Label("Partager votre avis");
        
        gui_Container_2.add(like);  
        gui_Container_2.add(visit);
        
        gui_Container_3.add(events);
        gui_Container_3.add(offers);
             
        gui_Container_4.add(comm);
        TextArea TA3 = new TextArea(15, 15);
        TA3.setMaxSize(2000);
        gui_Container_4.add(TA3);
        
        gui_Container_1_responsable_.add(modifier);
        gui_Container_1_responsable_.add(delete);
        gui_Container_1_responsable.add(add_offre);
        gui_Container_1_responsable.add(add_event);
        gui_Container_1_responsable.add(reservations);
        
               
    }
  

    
    
}
