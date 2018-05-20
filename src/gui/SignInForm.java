/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package gui;

import Entity.Session;
import Service.OffreService;
import Service.ServiceUser;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import static com.codename1.ui.TextArea.PASSWORD;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

/**
 * GUI builder created Form
 *
 * @author Shai Almog
 */
public class SignInForm extends com.codename1.ui.Form 
{
  Form f3;
  
    public SignInForm() 
    {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public SignInForm(com.codename1.ui.util.Resources resourceObjectInstance) 
    {
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("SigninTitle");
        //FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
        //getToolbar().addCommandToLeftBar("", mat, e -> new SplashForm().show());
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_PUBLIC, e -> {new SplashForm().show();});
        getContentPane().setUIID("SignInForm");
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
//    private void guiBuilderBindComponentListeners() {
//        EventCallbackClass callback = new EventCallbackClass();
//        gui_Button_2.addActionListener(callback);
//    }

//    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
//        private com.codename1.ui.Component cmp;
//        public EventCallbackClass(com.codename1.ui.Component cmp) {
//            this.cmp = cmp;
//        }
//
//        public EventCallbackClass() {
//        }
//
//        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
//            com.codename1.ui.Component sourceComponent = ev.getComponent();
//            if(sourceComponent.getParent().getLeadParent() != null) {
//                sourceComponent = sourceComponent.getParent().getLeadParent();
//            }
//
//            if(sourceComponent == gui_Button_2) {
//               // onButton_2ActionEvent(ev);
//            }
//        }
//
//        public void dataChanged(int type, int index) {
//        }
//    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) 
    {
        //guiBuilderBindComponentListeners();
        
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Se connecter");
        setName("SignInForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        
        
        gui_Component_Group_1.addComponent(gui_Text_Field_2);
        gui_Component_Group_1.addComponent(gui_Text_Field_1);
        
        gui_Text_Field_2.setName("Text_Field_2");

        
        gui_Text_Field_1.setName("Text_Field_1");
        gui_Container_1.addComponent(gui_Button_2);
        gui_Container_1.addComponent(gui_Button_3);
        gui_Label_1.setUIID("CenterLabel");
        gui_Label_1.setName("Label_1");
        gui_Label_1.setIcon(resourceObjectInstance.getImage("logo1.png"));
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Button_2.setText("Se connecter");
                gui_Button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //if(temail.getText().trim().isEmpty() && tpassword.getText().equals("123"))
                //{
                    Session S = new Session();
                    S.recupemail = gui_Text_Field_2.getText();
                    S.recupmdp= gui_Text_Field_1.getText();
                   
                    Label lb= new Label();
                    lb.setText(S.getList2(gui_Text_Field_2.getText(), gui_Text_Field_1.getText()).toString());
                    System.out.println(S.user.getEmail());
                    BaseForm BS = new BaseForm(S);
                    System.out.println(BS.getS().user.getId());
                    ProfileForm BPF = new ProfileForm(S,resourceObjectInstance);
                    System.out.println(BPF.s.user.getId());
                    BPF.show();
                    
//                    System.out.println(S.recupemail);
                    
                    //Form f2 =new Form("Welcome ", new FlowLayout(Component.CENTER,Component.CENTER));
                    //Label la = new Label("Application SideBar");
                    //new BonsPlansForm(S,resourceObjectInstance).show();
//                    f2.getToolbar().addComponentToSideMenu(la);
//                    f2.getToolbar().addMaterialCommandToSideMenu("HOME",FontImage.MATERIAL_HOME, null );
//                    f2.getToolbar().addMaterialCommandToSideMenu("About",FontImage.MATERIAL_BOOK, new ActionListener() 
//                    {
//                        @Override
//                        public void actionPerformed(ActionEvent evt) {
//                             f3 = new Form("Compte",BoxLayout.y());
//                             Label lb = new Label();
//                             Session ss=new Session();
//                             lb.setText(ss.getList2(gui_Text_Field_2.getText(),gui_Text_Field_1.getText()).toString());
//                             System.out.println("lala"+ss.user);
//                             SpanLabel s = new SpanLabel( ss.user.toString());
//                             //f3.add(lb);
//                             
//                             
//                            f3.add(s);
//                             //f3.getToolbar().addMaterialCommandToOverflowMenu("Home",FontImage.MATERIAL_ARROW_BACK, (e)->f.showBack());
//                              f3.getToolbar().addMaterialCommandToOverflowMenu("Ajouter Reclamation",FontImage.MATERIAL_CONTACTS, new ActionListener() {
//                                 @Override
//                                 public void actionPerformed(ActionEvent evt) {
//                                   Session ses = new Session();
//                                   Label lb = new Label();
//                                   lb.setText(ses.getList2(gui_Text_Field_2.getText(), gui_Text_Field_1.getText()).toString());
//                                  System.out.println(ses.user.getId());
//                                   HomeFormRec Rec = new HomeFormRec();
//                                  
//                                  Rec.id_user=ses.user.getId();
//                                  
//                                  Rec.getF().show();
//
//                                  //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                                 }
//                             });
//                              f3.getToolbar().addMaterialCommandToOverflowMenu("Mes Reclamations",FontImage.MATERIAL_MESSAGE, new ActionListener() {
//                                 @Override
//                                 public void actionPerformed(ActionEvent evt) {
//                                   Session ses = new Session();
//                                   Label lb = new Label();
//                                   lb.setText(ses.getList2(temail.getText(), tpassword.getText()).toString());
//                                  System.out.println("OK!"+ses.user.getId());
//                                   AffichageRec R = new AffichageRec();
//                                  
//                                  R.id_user=ses.user.getId();
//                                  
//                                  R.getF().show();
//
//                                  //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                                 }
//                             });
//                             f3.getToolbar().addMaterialCommandToOverflowMenu("Log Out",FontImage.MATERIAL_ARROW_BACK, e->f.showBack());
//                             f3.getToolbar().addMaterialCommandToOverflowMenu("Désactiver le compte", FontImage.MATERIAL_CLEAR, new ActionListener() {
//                                 @Override
//                                 public void actionPerformed(ActionEvent evt) { 
//                                    // (e)->{
//                                         ServiceUser ser= new ServiceUser();
//                                  Session ss = new Session();
//                                  ser.DeleteUser(ss.user);
//                                  Form ff = new Form();
//                                  Label ll = new Label("Votre compte a ete désactivé !"+"\n"+ "Creer un autre compte :) " );
//                                  Button btn = new Button("S'inscrire");
//                                 ff.add(ll);
//                                             ff.add(btn);
//                                  btn.addActionListener(new ActionListener() {
//                                             @Override
//                                             public void actionPerformed(ActionEvent evt) {
//                                                HomeFormUser hh=new HomeFormUser();
//                                                hh.getF().show();
//                                                
//                                                 // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                                             }
//                                             
//                                             
//                                         });
//                                 
//                                             ff.show();
//                                          
//                              
//                                 
//                                  
//                                //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                                 }
//                             });
//                                     
//                             f3.show();
//                        }
//                    } );
//                    f2.show(); 
                    
        }
            
   
                  //  else       
                //     Dialog.show("ERROR !", " lOGIN OU MOT DE PASSE INCORRECT !", "Okay",null);
           // }
        });
        gui_Button_2.setName("Button_2");
        gui_Button_3.setText("J'ai oublié mon mot de passe");
        gui_Button_3.setUIID("CenterLabelSmall");
        gui_Button_3.setName("Button_3");
        addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Button_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Button_1.setText("S'inscrire");
        gui_Button_1.setUIID("CenterLabel");
        gui_Button_1.setName("Button_1");
        gui_Button_1.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent evt) 
            {
                onButton_1ActionEvent(evt);
                
            }
        });
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
//    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
//        new BonsPlansForm().show();
//    }
    public void onButton_1ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        new SignUpForm().show();
    }
}
