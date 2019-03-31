/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat.management;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Ahmed
 */
public class CombatManagement  {
    public CombatManagement() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException  {
        // TODO code application logic here
        Thread th=new Thread(){
            public void run(){
                for(int a=0;a<=10;a++){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        //Logger.getLogger(Splash_Screen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(a==10){
                        Login loginFrame = new Login();
                        loginFrame.setVisible(true);
                    }
                }
            }
        };th.start();
        
    }
    
}
