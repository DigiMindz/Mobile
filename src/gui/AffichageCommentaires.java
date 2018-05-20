/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Entity.Commentaire;
import Entity.Etablissement;
import Entity.Evenement;
import Entity.Session;
import Service.EvenementService;
import Service.ServiceCommentaire;
import Service.ServiceEvaluation;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.InteractionDialog;
import com.codename1.components.SpanLabel;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.DateFormatPatterns;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Calendar;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import static com.codename1.ui.events.ActionEvent.Type.Log;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ons Ben Othmen
 */
public class AffichageCommentaires extends BaseForm  {
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.Label label1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label label2 = new com.codename1.ui.Label();
    private com.codename1.ui.Label label3 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    Picker C = new Picker();
    Session session;
    Container f = new Container(BoxLayout.y()); 
    SpanLabel lb;
    Button btnajout,btnaff;
    Label tcomment;
    
    public AffichageCommentaires(Session session,Etablissement id_etablissement,com.codename1.ui.util.Resources resourceObjectInstance)
    {
        super(session);
        this.session=session;
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(session,resourceObjectInstance);
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Tous les conseils", "Title")
                        
                )
      
        );
        Form last =  Display.getInstance().getCurrent();
        getToolbar().addMaterialCommandToRightBar("",FontImage.MATERIAL_ARROW_BACK, e -> last.show());
       // getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, ev -> { new UnEtablissement(id_etablissement,resourceObjectInstance).show();});
        getContentPane().setUIID("SignInForm");
   
        ServiceCommentaire ser=new ServiceCommentaire();
        ArrayList<Commentaire> listCommentaires = new ArrayList<>();
        listCommentaires = ser.getList2(id_etablissement); 
        
        for( Commentaire c : listCommentaires)
        {  
        Container c1 = new Container(BoxLayout.x());
        ImageViewer img = new ImageViewer(resourceObjectInstance.getImage("commentaire.png"));
        Label label = new Label(c.getComment());
        Container ff = new Container(BoxLayout.x()); 
        label.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                
         tcomment = new Label();
         //ImageViewer img = new ImageViewer(resourceObjectInstance.getImage("commentaire.png"));
         tcomment.setText(c.getComment());
         Dialog D = new Dialog(new FlowLayout(CENTER, TOP));
         TextField TF = new TextField();
         TF.setText(tcomment.getText());
         D.add(TF);
         Button B0 = new Button("Modifier");
         Button B1 = new Button("Supprimer");
         Button B2 = new Button("Annuler");
         D.add(B0).add(B1).add(B2);
         
         
          B1.addActionListener(new ActionListener() {

                                 @Override
            public void actionPerformed(ActionEvent evt) {
             ServiceCommentaire ser1 = new ServiceCommentaire();
            ser1.SuppCommentaire(c);
            D.dispose();
            }
                                
                                
                            });
          B0.addActionListener(new ActionListener() {

                                 @Override
            public void actionPerformed(ActionEvent evt) {
             ServiceCommentaire ser1 = new ServiceCommentaire();
             c.setComment(TF.getText());
             ser1.ModifCommentaire(c);
             D.dispose();
            }
                            });
          
          B2.addActionListener(new ActionListener() 
          {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        D.dispose();
                    }
                });
          D.show();
          
     
        
          
          
          
                                
                                
        
        //ff.add(img);
        
      //c1.add(ff);
                
        }
        });
        
        c1.add(img);
        //c1.add(ff);
        
        c1.add(label);
        // f.add(f5);
        f.add(c1);
        //f.show();
        }
       
          
        FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        Button conseil = fab.createSubFAB(FontImage.MATERIAL_EDIT, "Laissez un conseil");
        conseil.addActionListener((e) -> {
        AjoutCommentaire h=new AjoutCommentaire(session, id_etablissement,resourceObjectInstance);;
        h.show();
        });
        f.add(conseil);
        Dialog.setDefaultBlurBackgroundRadius(8);
        Button evaluer = fab.createSubFAB(FontImage.MATERIAL_ASSIGNMENT, "Evaluez nous");
        //  evaluer.addActionListener((e) -> Dialog.show("Aidez nous a evaluer cet etablissement ", "As tu aimé notre service ? ", "Suivant",null));
        evaluer.addActionListener((e) ->
        
        
        {InteractionDialog dlg = new InteractionDialog("Evaluez nous");
        Dialog.setDefaultBlurBackgroundRadius(8);
        dlg.setLayout(new BorderLayout());
        dlg.add(BorderLayout.NORTH, new Label("    Avez vous aimé notre service ? "));
        
        
        Button btn1 = new Button("           oui           ");
        Button btn2 = new Button("           non           ");
        
        btn1.addActionListener((eee) -> {ServiceEvaluation se = new ServiceEvaluation(); 
        se.ajoutAime(dlg,id_etablissement);
        //dlg.dispose();
        //DialogDeux();
        });
         
         
        btn2.addActionListener((eee) ->{ServiceEvaluation se = new ServiceEvaluation(); 
        se.ajoutPasAime(dlg,id_etablissement);
        //dlg.dispose();
        //DialogDeux();
       
        });
        Container c = new Container(BoxLayout.x());
        c.add(btn1); c.add(btn2);
         
         
        dlg.addComponent(BorderLayout.CENTER,c);
        
        
        Button close = new Button("Close");
        close.addActionListener((ee) -> dlg.dispose());
        dlg.addComponent(BorderLayout.SOUTH, close);
        
        
        Dimension pre = dlg.getContentPane().getPreferredSize();
        dlg.show(200,0,0,0);
        }
        
    );
          f.add(evaluer);
          
        // Button noter = fab.createSubFAB(FontImage.MATERIAL_GRADE, "Notez nous");
        //noter.addActionListener((e) -> {
        // NoterCommentaires ac = new NoterCommentaires();
        //});
        
        //fab.bindFabToContainer(f.getComponentForm());
    //}
    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) 
    {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("Commentaires");
        setName("Commentaires");
        addComponent(f);
        f.setScrollableY(true);
        

        setScrollableY(true);

    }

   
}
