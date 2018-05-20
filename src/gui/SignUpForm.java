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

import Entity.User;
import Service.OffreService;
import Service.ServiceUser;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import static com.codename1.ui.TextArea.PASSWORD;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.spinner.Picker;

/**
 * GUI builder created Form
 *
 * @author Shai Almog
 */
public class SignUpForm extends com.codename1.ui.Form {

    public SignUpForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public SignUpForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("SigninTitle");
        //FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_PUBLIC, e -> {new SplashForm().show();});
        //getToolbar().addCommandToLeftBar("", mat, e -> new SplashForm().show());
        getContentPane().setUIID("SignInForm");
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();

    
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField("","Pseudo");
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField("","E-mail");
    private com.codename1.ui.TextField gui_Text_Field_3 = new com.codename1.ui.TextField("","Nom&Prénom");
    CheckBox tsexe;
    CheckBox chHomme;
    //        gui_Text_Field_1.setText("Pseudo");
//        gui_Text_Field_2.setText("E-mail");
//        gui_Text_Field_3.setText("Nom&Prénom");
//        gui_Text_Field_4.setText("Mot de passe");
//        gui_Text_Field_5.setText("Retapez le mot de passe");
//        gui_Text_Field_6.setText("Ville");
//        gui_Text_Field_7.setText("Numéro");
//        gui_Text_Field_8.setText("Site web");
//        gui_Text_Field_2.setName("Text_Field_2");

    private com.codename1.ui.TextField gui_Text_Field_4 = new com.codename1.ui.TextField("","Mot de passe");
    private com.codename1.ui.TextField gui_Text_Field_5 = new com.codename1.ui.TextField("","Ville");
    private com.codename1.ui.TextField gui_Text_Field_6 = new com.codename1.ui.TextField("","Numéro de téléphone");
    
    
    private com.codename1.ui.Label l=new com.codename1.ui.Label("Date de naissance");
    private com.codename1.ui.Label l2=new com.codename1.ui.Label("Sexe");
    //private com.codename1.ui.GenericSpinner gs=new com.codename1.uiGenericSpinner();
    Picker C = new Picker();
    String s;
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

//        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
//            com.codename1.ui.Component sourceComponent = ev.getComponent();
//            if(sourceComponent.getParent().getLeadParent() != null) {
//                sourceComponent = sourceComponent.getParent().getLeadParent();
//            }
//
//            if(sourceComponent == gui_Button_2) {
//                onButton_2ActionEvent(ev);
//            }
//        }
//
//        public void dataChanged(int type, int index) {
//        }
//    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        //guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("S'inscrire");
        setName("SignInForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        
        gui_Component_Group_1.addComponent(gui_Text_Field_1);
        gui_Component_Group_1.addComponent(gui_Text_Field_2);
        gui_Component_Group_1.addComponent(gui_Text_Field_3);
        
        tsexe = new CheckBox("Femme");
        chHomme = new CheckBox("Homme");
        if (tsexe.isSelected()){
        if (chHomme.isSelected()){
        chHomme.setSelected(false);
        
        }
        s="Femme";
        }
        if (chHomme.isSelected()){
        if (tsexe.isSelected()){
        tsexe.setSelected(false);
        }
        s="Homme";
        }
        
        gui_Component_Group_1.addComponent(gui_Text_Field_4);
        gui_Component_Group_1.addComponent(gui_Text_Field_5);
        gui_Component_Group_1.addComponent(l2);
        gui_Component_Group_1.addComponent(tsexe);
        gui_Component_Group_1.addComponent(chHomme);
        gui_Component_Group_1.addComponent(l);
        gui_Component_Group_1.addComponent(gui_Text_Field_6);

        //gui_Text_Field_1.setText("Mot de passe");
        gui_Text_Field_1.setName("Text_Field_1");
        gui_Container_1.addComponent(gui_Button_2);
        gui_Label_1.setUIID("CenterLabel");
        gui_Label_1.setName("Label_1");
        gui_Label_1.setIcon(resourceObjectInstance.getImage("logo1.png"));
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Button_2.setText("S'inscrire");
        gui_Button_2.setName("Button_2");
                gui_Button_2.addActionListener((e) -> {
            ServiceUser ser = new ServiceUser();
            User U = new User( 0 ,gui_Text_Field_3.getText(), gui_Text_Field_1.getText(), gui_Text_Field_2.getText(), gui_Text_Field_4.getText(),
                    s, gui_Text_Field_5.getText(), Integer.valueOf(gui_Text_Field_6.getText()));
            
            ser.ajoutUser(U);
           Dialog.show("Inscription réussie","Vous etes inscrit Bienvenue Mr/Mme","Login",null);
           new SignInForm().show();
        }); 
        addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Button_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Button_1.setText("Se connecter");
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
    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        //new BonsPlansForm(s,resourceObjectInstances).show();
    }
    public void onButton_1ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        new SignInForm().show();
    }
}
