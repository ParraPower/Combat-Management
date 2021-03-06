/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat.management;

import combat.management.Models.Student;
import combat.management.Services.UserService;
import java.awt.Component;
import java.util.ArrayList;
import java.awt.Dimension;

/**
 *
 * @author Ahmed
 */
public class Users extends javax.swing.JPanel {
    private Dimension userPanelSize;
    public ArrayList<Student> students;
    public ArrayList<User> userPanels;
    public UserService userService;
    /**
     * Creates new form Users
     */
    public Users() {
        initComponents();
        userService = new UserService();
        setVisible(true);
    }
    
    public void LoadStudentPanels() {
        jPanel1.setLayout(null);
        jPanel1.removeAll();
        students = userService.getStudentsFromFile("students.csv");
        userPanels = new ArrayList<User>();
        
        final Dimension userWindowSize = new Dimension(200, 300);
        final int setPaddingX = 20;
        final int setPaddingGapY = 10;
        final int jPanel1Width = jPanel1.getWidth();
        
        final int userWindowsPerRow = ((jPanel1Width - setPaddingX) / userWindowSize.width);
        
        for (int i = 0; i < students.size(); ++i) {
            int modulusOfI = (i % userWindowsPerRow); 
            userPanels.add(new User(students.get(i), i));
            Component s = jPanel1.add(userPanels.get(i));
            int y = setPaddingGapY + (((i == 0) ? 0 : i / userWindowsPerRow) * (setPaddingGapY + userWindowSize.height));   
            int x = (setPaddingX / 2) + (modulusOfI * userWindowSize.width);
            s.setSize(userWindowSize);
            s.setLocation(x, y);
        }
        //calculateAndResizeJPanel5();
        jPanel1.validate();     
        jPanel1.repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setMaximumSize(new java.awt.Dimension(1050, 40));
        jPanel3.setMinimumSize(new java.awt.Dimension(1050, 40));
        jPanel3.setPreferredSize(new java.awt.Dimension(1050, 40));

        jLabel1.setText("Users");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(481, 481, 481))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setMaximumSize(new java.awt.Dimension(1000, 22));
        jPanel4.setMinimumSize(new java.awt.Dimension(1000, 22));
        jPanel4.setPreferredSize(new java.awt.Dimension(1000, 22));

        jTextField1.setText("Search for students...");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setText("Load");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setMaximumSize(new java.awt.Dimension(1030, 700));
        jPanel5.setMinimumSize(new java.awt.Dimension(800, 700));
        jPanel5.setName(""); // NOI18N
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(32647, 32647));
        jPanel1.setLayout(null);
        jPanel5.add(jPanel1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    
//    private void calculateAndResizeJPanel5() {
//        if (jPanel1.getComponentCount() > 8) {
//            int rows = (jPanel1.getComponentCount() / 4);
//            User firstUser = userPanels.get(1);
//            int newHeight = (216 * rows) + 150;
//            
//            jPanel1.setSize(jPanel1.getWidth(), newHeight);
//            jPanel1.invalidate();
//            jPanel1.repaint();
//        }
//    }
    
    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
        this.jPanel1.removeAll();
        
        for(int i = 0; i < this.students.size(); ++i) {
            Student thisSTUDENT = this.students.get(i);
            java.awt.Component[] components = this.jPanel5.getComponents();
            
            if ((thisSTUDENT.Firstname.equalsIgnoreCase(this.jTextField1.getText())) 
                    || (thisSTUDENT.Lastname.equalsIgnoreCase(this.jTextField1.getText()))) {
                boolean foundInJPanel = false;
                for (int j = 0; j < components.length && !foundInJPanel; ++j) {
                    if (((User)components[j]).getStudent().ID == thisSTUDENT.ID) {
                        foundInJPanel = true;
                        
                        //for (int k = 0; k < )
                        /*if (this.userPanelSize != null && this.userPanelSize.height != 0  &&
                            (!components[j].getSize().equals(this.userPanelSize))) {
                            components[j].setSize(this.userPanelSize);
                            components[j].setVisible(true);
                        }*/
                        //this
                    }
                }
                
                if (!foundInJPanel) {
                    for (int k = 0; k < this.userPanels.size(); ++k) {
                        User studentsPanel = ((User)this.userPanels.get(k));
                        if (studentsPanel.getStudent().ID == thisSTUDENT.ID) {
                            this.jPanel1.add(studentsPanel);
                        }
                    }
                }
            }
            else {
                System.out.print(thisSTUDENT.Lastname);
                boolean studentsPanelFound = false;
                for (int j = 0; j < components.length && !studentsPanelFound; ++j) {
                    if (((User)components[j]).getStudent().ID == thisSTUDENT.ID) {
                       studentsPanelFound = true;
                       this.jPanel1.remove(j);
//                        if (this.userPanelSize == null || this.userPanelSize.height == 0) {
//                            this.userPanelSize = components[j].getSize();
//                        }
//                        components[j].setSize(0, 0);
//                        components[j].setVisible(true);
                    }
                }
            }
            
            jPanel1.validate();
            jPanel1.repaint();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        LoadStudentPanels();
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
