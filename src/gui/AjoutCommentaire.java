/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.ShareButton;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.io.Storage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import Entity.Commentaire;
import Service.ServiceCommentaire;
import com.codename1.impl.VirtualKeyboardInterface;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.util.ImageIO;
import Entity.Etablissement;
import Entity.Session;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 *
 * @author Maissa
 */
public class AjoutCommentaire extends BaseForm {
 EncodedImage encoded;
    Container f = new Container(BoxLayout.y()); 
    Button btnajout,btnaff,imgBtn,btnfcb;
    TextField tcomment;
    Session session;
    public AjoutCommentaire(Session session,Etablissement id_etablissement,Resources resourceObjectInstance) 
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
          
          tcomment = new TextField();
          btnajout = new Button("Publier");
          imgBtn = new Button("Publier");
          btnfcb = new Button("Partager Sur Facebook");
          
          
          f.add(tcomment);
          f.add(btnajout);
          f.add(btnfcb);
          
          
          ShareButton sb = new ShareButton();
          f.add(sb);
          //f.show();
          
          btnajout.addActionListener((e) -> {
        ServiceCommentaire ser = new ServiceCommentaire();
        Commentaire C = new Commentaire(70, tcomment.getText());
        ser.ajoutCommentaire(C,id_etablissement);
        AffichageCommentaires ac = new AffichageCommentaires(session,id_etablissement, resourceObjectInstance);
        ac.show();
        });
      
       btnfcb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                        if (evt == null){
                            return;
                        }
                        String filename =  evt.getSource()+"";
                        if (Dialog.show("Partage", "partager ce conseil ?", "OK", "cancel")) {
                            MultipartRequest req = new MultipartRequest();
                            String endpoint;
                            endpoint = "https://graph.facebook.com/me/photos?access_token=EAACEdEose0cBAGWE4NijDkDZAm24XGbEZC81ZCQCtfoeIdGjlZCfjKpDgWsN1W165c8CS3mdgx5e0X2yodIDt4lZChixOetOZAeuQUAVP3NG8KyMyzykfaQql636KFqMZBlcONWsoRh2txQiBa4FTZANXIfxQhtfrNOK4zEJwXEII2yHHCvd7ZCgQkF2NHXLRZBIRPFady5nberQZDZD";
                                System.out.println("lolooooo");
                            req.setUrl(endpoint);
                            req.addArgument("tes", "ok");
                            String is = generateSessionKey(10);
                           String i = generateSessionKey(10);
                            try {
                                Storage.getInstance().deleteStorageFile("screenshot.png");
                                Image screenshot = Image.createImage(f.getWidth(), f.getHeight());
                                
                                f.revalidate();
                                f.setVisible(true);
                                f.paintComponent(screenshot.getGraphics(), true);
                                
                                String imageFile = FileSystemStorage.getInstance().getAppHomePath() + "screenshot.png";
                                try (OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile)) {
                                    ImageIO.getImageIO().save(screenshot, os, ImageIO.FORMAT_PNG, 1);
                                } catch (IOException err) {
                                    Log.e(err);
                                }
                                req.addData("source", imageFile, "image/png");
                                System.out.println(imageFile);
                                
                             
                                // FileSystemStorage.getInstance().rename(FileSystemStorage.getInstance().getAppHomePath() + "screenshot.png", is);
                                NetworkManager.getInstance().addToQueue(req);

                            } catch (IOException ioe) {
                                ioe.printStackTrace();
                            }
                            
                           
                        }
                   
            }
        });
        
          
    }

   
    
    public static String generateSessionKey(int length){
String alphabet = 
        new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"); //9
int n = alphabet.length(); //10

String result = new String(); 
Random r = new Random(); //11

for (int i=0; i<length; i++) //12
    result = result + alphabet.charAt(r.nextInt(n)); //13

return result;
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
