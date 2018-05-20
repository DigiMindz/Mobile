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
import com.codename1.components.SpanLabel;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
/**
 *
 * @author Ons Ben Othmen
 */
public class UnEvenement  extends BaseForm{
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container gui_Container_1_responsable = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Container buttons = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    Evenement E;
    Session s;
    private com.codename1.ui.Button inter = new com.codename1.ui.Button();
    private com.codename1.ui.Button going = new com.codename1.ui.Button();
    
    public UnEvenement(Session s,Evenement E, Resources resourceObjectInstance)
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
        
//         Form last =  Display.getInstance().getCurrent();
//        getToolbar().addMaterialCommandToRightBar("",FontImage.MATERIAL_ARROW_BACK, e -> last.show());
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, e -> {UnEtablissement h=new UnEtablissement(s,E.getId_etablissement(),resourceObjectInstance);
                     h.show();});
            InterestService interSer=new InterestService();
            GoingService goSer=new GoingService();
             inter.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                if (inter.getText().equals("Marquer intéressé(e)")){
                interSer.ajoutV(E.getId(), s.user.getId());
                inter.setText("Intéressé(e)");
                if (going.getText().equals("Partant(e)")){
                going.setText("Marquer partant(e)");
                goSer.deleteV(E.getId(), s.user.getId());
                
                }
                
                }
                else if (inter.getText().equals("Intéressé(e)")){
                interSer.deleteV(E.getId(),1);
                inter.setText("Marquer intéressé(e)");
                
                }
                
                
            }
        });
                going.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                if (going.getText().equals("Marquer partant(e)")){
                goSer.ajoutV(E.getId(),s.user.getId());
                going.setText("Partant(e)");
                if (inter.getText().equals("Intéressé(e)")){
                interSer.deleteV(E.getId(),s.user.getId());
                inter.setText("Marquer intéressé(e)");
                }
                }
                else if (going.getText().equals("Partant(e)")){
                goSer.deleteV(E.getId(), s.user.getId());
                going.setText("Marquer partant(e)");
                }
                
                
            }
        });
         
          
    }
    
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("UnEvenement");
        setName("UnEvenement");
        Image bla = resourceObjectInstance.getImage("party2.jpg").scaledLargerRatio(300, 150);
    
                Container content3 = BoxLayout.encloseY(
                new Label(bla, "WelcomeTitle"),        
                new Label(resourceObjectInstance.getImage("welcome-separator.png"), "WelcomeTitle")
               
        );
        getContentPane().setUIID("SignInForm");
        addComponent(content3); 
        addComponent(buttons);
        addComponent(gui_Container_1);
        gui_Container_1.setName("Container_1");
        
        setScrollableY(true);
               
        
        Label L1 = new Label("Date : "+E.getDate().toString());
        
        Label L2 = new Label("Chez: "+E.getId_etablissement().getNom());
        
        L2.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        UnEtablissementEvent UE = new UnEtablissementEvent(s,E.getId_etablissement(),resourceObjectInstance);
                        UE.show();
                    }
                });
        Label L3 = new Label("Personnes participants: "+E.getNbr_personnes());
        Label L4= new Label("Personnes intéréssées: "+E.getInteresses());
        Button b1=new Button("Modifier");
        Button b2=new Button("Annuler");
        Label SL1=new Label("Description: "+E.getDescription());
                b1.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        UpdateEvent UE = new UpdateEvent(s,E,resourceObjectInstance);
                        UE.show();
                    }
                });
                b2.addPointerPressedListener(new ActionListener() 
                {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        EvenementService ser=new EvenementService();
                        ser.deleteEvenement(E);
                        UnEtablissement UE = new UnEtablissement(s,E.getId_etablissement(),resourceObjectInstance);
                        UE.show();
                    }
                });
        
        gui_Container_1.add(L1);
        gui_Container_1.add(L2);
        gui_Container_1.add(L3);
        gui_Container_1.add(L4);
        gui_Container_1.add(SL1);
        addComponent(gui_Container_1_responsable);
        gui_Container_1_responsable.add(b1);
        gui_Container_1_responsable.add(b2);


        
        
    }
}
