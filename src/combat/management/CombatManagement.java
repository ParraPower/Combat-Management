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

/**
 *
 * @author Ahmed
 */
public class CombatManagement  {
    public JFrame combatManagementFrame;
            
    public CombatManagement() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException  {
        // TODO code application logic here
        JFrame combatManagementFrame;
        
        combatManagementFrame = new JFrame();

        combatManagementFrame.setTitle("Taekwando Management application for Mr. Almawieh");

        combatManagementFrame.setLayout(new BorderLayout());

        //add other containers and elements to the JFrame
        //frame.add(mainPanel, BorderLayout.CENTER); 

        combatManagementFrame.setSize(new Dimension(1800, 1000));
        combatManagementFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        //this terminate the app when the close button is clicked
        combatManagementFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //this will make the app to always display at the center
        combatManagementFrame.setLocationRelativeTo(null);

        //well, I don't want you to resize the window
        combatManagementFrame.setResizable(true);
       
        Login loginPanel = new Login(combatManagementFrame);
        combatManagementFrame.add(loginPanel);
        
        combatManagementFrame.setVisible(true);
        
    }
    
}
