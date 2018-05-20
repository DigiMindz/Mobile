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
import Service.DemandePartenariatService;
import Service.EtablissementService;
import Service.EvenementService;
import Service.LikedService;
import Service.VisitedService;
import com.codename1.components.MultiButton;
import com.codename1.components.WebBrowser;
import com.codename1.io.URL;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.TextArea;
import com.codename1.charts.*;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;
import java.net.URISyntaxException;
public class UnEtablissement extends BaseForm
{
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_Container_1_responsable = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_Container_1_responsable_ = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container stat = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    private com.codename1.ui.Container stat2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    URL u;
    Session session;
    Etablissement E;
    private com.codename1.ui.Button add_event = new com.codename1.ui.Button();
    private com.codename1.ui.Button add_offre = new com.codename1.ui.Button();
    private com.codename1.ui.Button add_reser = new com.codename1.ui.Button();
    private com.codename1.ui.Button modifier = new com.codename1.ui.Button();
    private com.codename1.ui.Button delete = new com.codename1.ui.Button();
    private com.codename1.ui.Button reservations = new com.codename1.ui.Button();
    private com.codename1.ui.Button events = new com.codename1.ui.Button();
    private com.codename1.ui.Button offers = new com.codename1.ui.Button();
    private com.codename1.ui.Button partener = new com.codename1.ui.Button();
    com.codename1.components.MultiButton part = new com.codename1.components.MultiButton();
    private com.codename1.ui.Button tags = new com.codename1.ui.Button();
    private com.codename1.ui.Button like = new com.codename1.ui.Button();
    private com.codename1.ui.Button visit = new com.codename1.ui.Button();
    private com.codename1.ui.TextArea commentaire = new com.codename1.ui.TextArea();
    private com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
    public UnEtablissement(Session session,Etablissement E,Resources resourceObjectInstance)
    {
        super(session);
        this.session = session;
        System.out.println(session.user.getId());
        //this.s=session;
        this.E = E;
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(s,resourceObjectInstance);
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label(E.getNom(), "Title")
                        
                )
      
        );
        getContentPane().setUIID("SignInForm");
        
          
//          getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, ev -> { new BonsPlansForm().show();});
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
                       reservations.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                new ReservationsFormEtab(s,E,resourceObjectInstance).show();
                
            }
        });
                       add_reser.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                new AjoutReservation(s,E,resourceObjectInstance).show();
                
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
        add_reser.setText("");
        add_reser.setUIID("Label");
        add_reser.setIcon(resourceObjectInstance.getImage("reser.png"));
        visit.setText("");
        visit.setUIID("Label");            
                    like.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                if (like.getName().equals("J'aime")){
                
                likeSer.ajoutLike(E.getId(), session.user.getId());
                like.setName("Aimé");
                like.setIcon(resourceObjectInstance.getImage("heartColored.png"));
                update(gui_Multi_Button_1,E);
                }
                else if (like.getName().equals("Aimé")){
                likeSer.deleteLike(E.getId(), session.user.getId());
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
                vSer.ajoutV(E.getId(), session.user.getId());
                visit.setIcon(resourceObjectInstance.getImage("mapColored.png"));
                update(gui_Multi_Button_1,E);
                visit.setName("Visité");
                
                }
                else if (visit.getName().equals("Visité")){
                vSer.deleteV(E.getId(), session.user.getId());
                visit.setIcon(resourceObjectInstance.getImage("map.png"));
                update(gui_Multi_Button_1,E);
                visit.setName("Marquer visité");
                }
                
                
            }
        });
                partener.setText("Demande partenariat");


    }
        public void update(MultiButton b1,Etablissement E){
            LikedService ser=new LikedService();
            VisitedService vser=new VisitedService();
            b1.setPropertyValue("line1", ser.count(E.getId())+" aime(s)");
            b1.setPropertyValue("line2", vser.count(E.getId())+" visite(s)");
            }
    
        private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("UnEtablissement");
        setName("UnEtablissement");
        
        Image bla = resourceObjectInstance.getImage("bla2.jpg").scaledLargerRatio(300, 300);
    
                Container content3 = BoxLayout.encloseY(
                new Label(bla, "WelcomeTitle"),        
                new Label(resourceObjectInstance.getImage("welcome-separator.png"), "WelcomeTitle")
               
        );
        
        addComponent(content3);
            part.setPropertyValue("uiid1", "Label");
            part.setPropertyValue("uiid1", "SlightlySmallerFontLabelLeft");
            part.setUIID("Label");
            System.out.println("responsebale"+E.getResponsable());
            System.out.println(session.user.getId());
        if (E.getResponsable()==s.user.getId()){}
        else {
        addComponent(gui_Container_2);}
        if (E.getResponsable()==s.user.getId()){
        if (E.getPartenaire()==0){
        DemandePartenariatService ser= new DemandePartenariatService();    
            if (ser.check(E.getId())!=0){
            
            part.setPropertyValue("line1", "Partenariat sous traitement");

        addComponent(part);
            }
            else {
            addComponent(partener);
            }
        
        }
        else {
        part.setPropertyValue("line1", "Vous etes notre partenaire");
        addComponent(part);
        }
        }
        addComponent(stat);
        
        
        
        addComponent(gui_Container_1);
        
        
        
        
        if (E.getResponsable()==s.user.getId()){
        addComponent(gui_Container_1_responsable_);
        addComponent(gui_Container_1_responsable);
        }
        addComponent(gui_Container_3);
        if (E.getResponsable()==s.user.getId()){
              
        addComponent(stat2);
        }
        else {
        addComponent(gui_Container_4);
        }
        Label m=new Label("Visites&Likes");
        stat2.add(m);
        stat2.add(createPieChartForm(E));
        gui_Container_1.setName("Container_1");
       
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
                        new UpdateEtablissement(s,E,resourceObjectInstance).show(); 
                    }
                });
                        delete.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                       EtablissementService serE=new EtablissementService();
                       serE.SupprimerEtablissement(E);
                       new BonsPlansForm(s,resourceObjectInstance).show();
                    }
                });
                        partener.addActionListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                       new sendMsg(s,E,resourceObjectInstance).show();
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
        reservations.setText("");
        reservations.setUIID("Label");
        reservations.setIcon(resourceObjectInstance.getImage("reser.png"));
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
                    if (likeSer.check( session.user.getId(),E.getId())==0){
                    like.setName("J'aime");
                    like.setIcon(resourceObjectInstance.getImage("heart.png"));
                    }
                    else {
                    like.setName("Aimé");
                    like.setIcon(resourceObjectInstance.getImage("heartColored.png"));
                    }
                    
        VisitedService vSer=new VisitedService();
                    if (vSer.check(session.user.getId(),E.getId())==0){
                    visit.setName("Marquer visité");
                    visit.setIcon(resourceObjectInstance.getImage("map.png"));
                    }
                    
                    else {
                    visit.setName("Visité");
                    visit.setIcon(resourceObjectInstance.getImage("mapColored.png"));
                    }
                    
        Button comm=new Button("Partager votre avis");
        
        gui_Container_2.add(like);  
        gui_Container_2.add(visit);
        gui_Container_2.add(add_reser);  
        gui_Container_3.add(events);
        gui_Container_3.add(offers);
             
        gui_Container_4.add(comm);
                                comm.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                       
                       
                       new AffichageCommentaires(s,E,resourceObjectInstance).show();
                    }
                });
        
        gui_Container_1_responsable_.add(modifier);
        gui_Container_1_responsable_.add(delete);
        gui_Container_1_responsable_.add(reservations);
        gui_Container_1_responsable.add(add_offre);
        gui_Container_1_responsable.add(add_event);
        
        
               
    }
  

private DefaultRenderer buildCategoryRenderer(int[] colors) {
    DefaultRenderer renderer = new DefaultRenderer();
    renderer.setLabelsTextSize(15);
    renderer.setLegendTextSize(15);
    renderer.setMargins(new int[]{20, 30, 15, 0});
    for (int color : colors) {
        SimpleSeriesRenderer r = new SimpleSeriesRenderer();
        r.setColor(color);
        renderer.addSeriesRenderer(r);
    }
    return renderer;
}
protected CategorySeries buildCategoryDataset(String title, double[] values) {
    CategorySeries series = new CategorySeries(title);
    int k = 0;
    for (double value : values) {
        series.add("", value);
    }

    return series;
}
public int getVisits(Etablissement E){
    VisitedService vser=new VisitedService();
    
return vser.count(E.getId());
}
public int getLikes(Etablissement E){
    LikedService ser=new LikedService();
return ser.count(E.getId());
}
public Container createPieChartForm(Etablissement E) {
    // Generate the values
    double[] values = new double[]{getVisits(E),getLikes(E)};

    // Set up the renderer
    int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN};
    DefaultRenderer renderer = buildCategoryRenderer(colors);
    renderer.setZoomButtonsVisible(true);
    renderer.setZoomEnabled(true);
    renderer.setChartTitleTextSize(5);
    renderer.setDisplayValues(true);
    renderer.setShowLabels(true);
    
    SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
    r.setGradientEnabled(true);
    r.setGradientStart(0, ColorUtil.BLUE);
    r.setGradientStop(0, ColorUtil.GREEN);
    
    //r.setHighlighted(true);

    // Create the chart ... pass the values and renderer to the chart object.
    PieChart chart = new PieChart(buildCategoryDataset("Visites&Likes", values), renderer);
    
    // Wrap the chart in a Component so we can add it to a form
    ChartComponent c = new ChartComponent(chart);

    // Create a form and show it.
    Container f = new Container(new BorderLayout());
    f.setHeight(10);
    f.setWidth(10);
    f.add(BorderLayout.CENTER, c);
    return f;

}
    
}
