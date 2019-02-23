/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat.management;

import combat.management.Models.Student;
import combat.management.Config.CombatConfig;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Ahmed
 */
public class User extends javax.swing.JPanel {
    private Student s;
    private int index;
    /**
     * Creates new form User
     */
    public User(Student s, int index ) {
        initComponents();
        
        studentNameLabel.setText(s.Firstname + " " + s.Lastname);
        s = s;
        index = index;
        //setPreferredSize(new java.awt.Dimension(4000, 216));
        
        String userImageDirectory = CombatConfig.UserImagesDirectory();
        
        BufferedImage img = null;
        try {
            System.out.println(userImageDirectory);
            img = ImageIO.read(new File(userImageDirectory + s.ProfileImageFilename));
            //imageLabel.setText(imageLabel.getSize().height + " " + imageLabel.getSize().width);
            this.imageLabel.setIcon(new ImageIcon(img));
            this.imageLabel.setSize(150,189);
        }
        catch (Exception e) {
           System.out.println(e);
        }
    }
    
    public Student getStudent() {
        return s;
    }

//    public void hide() {
//        this.hide();
//    }
//    
//    public void show() {
//        this.show();
//    }
    
    public int getIndex() {
        return this.index;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JPanel();
        studentNameLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(150, 216));
        setMinimumSize(new java.awt.Dimension(150, 216));

        studentNameLabel.setText("studentName");
        studentNameLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        imageLabel.setText("sss");
        imageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));
        imageLabel.setMaximumSize(new java.awt.Dimension(36, 189));

        javax.swing.GroupLayout jLabel1Layout = new javax.swing.GroupLayout(jLabel1);
        jLabel1.setLayout(jLabel1Layout);
        jLabel1Layout.setHorizontalGroup(
            jLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLabel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(studentNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jLabel1Layout.setVerticalGroup(
            jLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLabel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jLabel1;
    private javax.swing.JLabel studentNameLabel;
    // End of variables declaration//GEN-END:variables
}
