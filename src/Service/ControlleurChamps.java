/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import com.codename1.util.regex.RE;

/**
 *
 * @author HP
 */
public class ControlleurChamps {
    
     public boolean isNumber(String s) {
        RE r = new RE("[0-9]*");
        return r.match(s);
    }

    public boolean isName(String s) {
        RE r = new RE("([a-z]|[A-Z])*");
        return r.match(s);
    }

    public boolean isEmail(String s) {
        RE r = new RE("(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)*\\@(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)+");
        return r.match(s);
    }

    public boolean isNum(String s) {
        RE r = new RE("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
        return r.match(s);
    }

    public boolean isFloat(String s) {
        RE r = new RE("\\d*\\.?\\d*");
        return r.match(s);
        
    }
    public boolean isEmpty(String s){
         return (s.length()==0);
     }
}
