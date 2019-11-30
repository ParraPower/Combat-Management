/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat.management;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Ahmed
 */
public class ManagementFrame extends javax.swing.JFrame {

    /**
     * Creates new form ManagementFrame
     */
    public ManagementFrame() {
        initComponents();
         
        this.usersPanel2.addComponentListener(new ResizeListener());
        this.setMinimumSize(new Dimension(100, 100));
        this.setVisible(true);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.userPagePanel1.setVisible(false);
        this.locations.setVisible(false);
    }

    private void cursorSet(Component c, int selectedCursor) {
        Cursor cursor = new Cursor(selectedCursor);
        JFrame frame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, c);
        frame.setCursor(cursor);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        parent = new javax.swing.JPanel();
        sidepane = new javax.swing.JPanel();
        users = new javax.swing.JLabel();
        locations = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        configpane = new javax.swing.JPanel();
        usersPanel2 = new combat.management.UsersPanel();
        userPagePanel1 = new combat.management.UserPagePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        parent.setBackground(new java.awt.Color(33, 231, 231));
        parent.setLayout(new java.awt.BorderLayout());

        sidepane.setBackground(new java.awt.Color(52, 78, 180));
        sidepane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sidepane.setPreferredSize(new java.awt.Dimension(300, 106));

        users.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        users.setForeground(new java.awt.Color(255, 255, 255));
        users.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        users.setText("Users");
        users.setToolTipText("");
        users.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        users.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                usersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                usersMouseExited(evt);
            }
        });

        locations.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        locations.setForeground(new java.awt.Color(255, 255, 255));
        locations.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        locations.setText("Locations");
        locations.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        locations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                locationsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                locationsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                locationsMouseExited(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create User");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout sidepaneLayout = new javax.swing.GroupLayout(sidepane);
        sidepane.setLayout(sidepaneLayout);
        sidepaneLayout.setHorizontalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(users, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(locations, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidepaneLayout.setVerticalGroup(
            sidepaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepaneLayout.createSequentialGroup()
                .addComponent(users, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locations, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1383, Short.MAX_VALUE))
        );

        parent.add(sidepane, java.awt.BorderLayout.WEST);

        configpane.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        configpane.add(usersPanel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        configpane.add(userPagePanel1, gridBagConstraints);

        parent.add(configpane, java.awt.BorderLayout.CENTER);

        getContentPane().add(parent);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void locationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_locationsMouseClicked
        // TODO add your handling code here:
//        this.userPagePanel1.setVisible(false);
//        this.usersPanel2.setVisible(true);
    }//GEN-LAST:event_locationsMouseClicked

    private void usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersMouseClicked
        // TODO add your handling code here:
        for (int i = 0; i < configpane.getComponentCount(); ++i) {
            Component c = configpane.getComponent(i);
            
            System.out.println(c);
            if (c instanceof UserPagePanel) {
                c.setVisible(false);
            }
            else if(!(c instanceof UserPagePanel)) {
                c.setVisible(true);
            }
        }
//        this.userPagePanel1.setVisible(false);
//        this.usersPanel2.setVisible(true);
    }//GEN-LAST:event_usersMouseClicked

    private void usersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersMouseEntered
        // TODO add your handling code here:
        cursorSet((Component)evt.getSource(), Cursor.HAND_CURSOR);
    }//GEN-LAST:event_usersMouseEntered

    private void usersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersMouseExited
        // TODO add your handling code here:
        cursorSet((Component)evt.getSource(), Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_usersMouseExited

    private void locationsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_locationsMouseEntered
        // TODO add your handling code here:
        cursorSet((Component)evt.getSource(), Cursor.HAND_CURSOR);
    }//GEN-LAST:event_locationsMouseEntered

    private void locationsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_locationsMouseExited
        // TODO add your handling code here:
        cursorSet((Component)evt.getSource(), Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_locationsMouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        JLabel thisComponent = (JLabel)evt.getSource();
        
        for (int i = 0; i < thisComponent.getParent().getParent().getComponentCount(); ++i) {
            Component c = thisComponent.getParent().getParent().getComponent(i);
            if ((c instanceof  JPanel) && (((JPanel)c) == configpane)) {
                JPanel configpaneLocal = (JPanel)c;
                
                for (int j = 0; j < configpaneLocal.getComponentCount(); ++j) {
                    Component d = configpaneLocal.getComponent(j);
                    
                    if (d instanceof  UserPagePanel) {
                        ((UserPagePanel)d).prepareForAddStudent();
                        d.setVisible(true);
                    }
                    else if(!(d instanceof UserPagePanel)) {
                        d.setVisible(false);
                    }
                }   
            }   
        }
    }//GEN-LAST:event_jLabel1MouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagementFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagementFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagementFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagementFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagementFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel configpane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel locations;
    private javax.swing.JPanel parent;
    private javax.swing.JPanel sidepane;
    private combat.management.UserPagePanel userPagePanel1;
    private javax.swing.JLabel users;
    private combat.management.UsersPanel usersPanel2;
    // End of variables declaration//GEN-END:variables
}
