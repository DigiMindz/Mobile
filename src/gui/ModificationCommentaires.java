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
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.DateFormatPatterns;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Calendar;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import static com.codename1.ui.events.ActionEvent.Type.Log;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import java.util.Date;

/**
 *
 * @author Ons Ben Othmen
 */
public class ModificationCommentaires extends BaseForm  {
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.Label label1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label label2 = new com.codename1.ui.Label();
    private com.codename1.ui.Label label3 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    Picker C = new Picker();
    Session session;
    Form f;
    Button btnajout,btnaff;
    TextField tcomment;

    public ModificationCommentaires(Session session,Etablissement id_etablissement,Commentaire c,com.codename1.ui.util.Resources resourceObjectInstance){
        super(session);
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(session,resourceObjectInstance);
        //getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Ajouter un évenement", "Title")
                        
                )
      
        );
        Form last =  Display.getInstance().getCurrent();
        getToolbar().addMaterialCommandToRightBar("",FontImage.MATERIAL_ARROW_BACK, e -> last.show());
       // getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, ev -> { new UnEtablissement(id_etablissement,resourceObjectInstance).show();});
        getContentPane().setUIID("SignInForm");
   
          System.out.println("test modification*******************");
          f = new Form("Modifiez votre conseil");
          tcomment = new TextField();
          tcomment.setText(c.getComment()); 
          btnajout = new Button("Publier");
          f.add(tcomment);
          f.add(btnajout);
          f.show();
          
          btnajout.addActionListener((e) -> {
        ServiceCommentaire ser = new ServiceCommentaire();
        Commentaire C = new Commentaire(c.getId(), tcomment.getText());
        ser.ModifCommentaire(C);
        AjoutCommentaire h=new AjoutCommentaire(session, id_etablissement,resourceObjectInstance);
        });
          
//      f.getToolbar().addCommandToRightBar("back", null, (ev)->{AffichageCommentaires h=new AffichageCommentaires(E);
//          h.getF().show();
//          }); 
    //}
    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setTitle("AjoutEvent");
        setName("AjoutEvent");
        addComponent(f);
        
        setScrollableY(true);

    }

   
}
