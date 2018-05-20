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

import Entity.Etablissement;
import Entity.Session;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 * Utility methods common to forms e.g. for binding the side menu
 *
 * @author Shai Almog
 */
public class BaseForm extends Form {
    Session s;

    public BaseForm(Session s) 
    {
        this.s = s;
    }

    
    
    public Session getS() {
        return s;
    }

    public void setS(Session s) 
    {
        this.s = s;
    }
    public void installSidemenu(Session ss,Resources res) 
    {
        ss = s;
        Image selection = res.getImage("selection-in-sidemenu.png");
        
        Image inboxImage = null;
        if(isCurrentInbox()) inboxImage = selection;

        Image trendingImage = null;
        if(isCurrentTrending()) trendingImage = selection;
        
        Image calendarImage = null;
        if(isCurrentCalendar()) calendarImage = selection;
        
        Image statsImage = null;
        if(isCurrentStats()) statsImage = selection;
        
        //Button inboxButton = new Button("Les Bons Plans", inboxImage);
        //inboxButton.setUIID("SideCommand");
        //inboxButton.getAllStyles().setPaddingBottom(0);
        //Container inbox = FlowLayout.encloseMiddle(inboxButton, 
        //        new Label("18", "SideCommandNumber"));
        //inbox.setLeadComponent(inboxButton);
        //inbox.setUIID("SideCommand");
        //inboxButton.addActionListener(e -> new InboxForm().show());
        //getToolbar().addComponentToSideMenu(inbox);
        //Etablissement E=new Etablissement(3,"Wolf&Rabbit", "Resto_Café",0,1);
        getToolbar().addCommandToSideMenu("Les Bons Plans", calendarImage, e -> new BonsPlansForm(s,res).show());
        getToolbar().addCommandToSideMenu("Evènements", calendarImage, e -> new EventsForm(s,res).show());
        getToolbar().addCommandToSideMenu("Offres", calendarImage, e -> new OffresForm(s,res).show());
        //getToolbar().addCommandToSideMenu("Google Maps", null, e -> new TrendingForm(res).show());
        getToolbar().addCommandToSideMenu("Profile", trendingImage, e -> new ProfileForm(s,res).show());
        getToolbar().addCommandToSideMenu("Contact", null, e -> new SMS(s,res).show());
        getToolbar().addCommandToSideMenu("Je suis propriétaire", null, e -> new UneDemande(s,res).show());
        //getToolbar().addCommandToSideMenu("Wolf&Rabbit", null, e -> new UnEtablissement(E,res).show());
        getToolbar().addCommandToSideMenu("Paramètres", trendingImage, e -> new ParametresFrom(s,res).show());
        getToolbar().addCommandToSideMenu("Réclamation", null, e -> new ReclamationForm(s,res).show());
        getToolbar().addCommandToSideMenu("Se déconnecter", null, e -> new SplashForm(res).show());
        
        // spacer
        getToolbar().addComponentToSideMenu(new Label(" ", "SideCommand"));
       
    }

        
    protected boolean isCurrentInbox() {
        return false;
    }
    
    protected boolean isCurrentTrending() {
        return false;
    }

    protected boolean isCurrentCalendar() {
        return false;
    }

    protected boolean isCurrentStats() {
        return false;
    }
}
