/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat.management;

import combat.management.Models.Student;
import combat.management.Services.UserService;
import combat.management.Config.CombatConfig;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Ahmed
 */
public class UsersPanel extends javax.swing.JPanel  {
    public ArrayList<Student> students;
    public UserService userService;
    public ArrayList<String> nameSearchRandomsArray; 
    private int gridItemWidth = 143;
    private int gridItemHeight = 212;
    private boolean activeSearch = false;
    
    /**
     * Creates new form UsersPanel
     */
    public UsersPanel() {
        initComponents();
        userService = new UserService();
        students = userService.getStudentsFromFile(CombatConfig.StudentCSVPath());
        
        nameSearchRandomsArray = new ArrayList<String>();
        
        nameSearchRandomsArray.add("Le");
        nameSearchRandomsArray.add("Ao");
        nameSearchRandomsArray.add("Ah");
        nameSearchRandomsArray.add("med");
        nameSearchRandomsArray.add("eo");
        nameSearchRandomsArray.add("Y");
        nameSearchRandomsArray.add("Ye");
    }
    
    public void rebuildGrid() {
        grid.removeAll();
 
        ArrayList<UserPanel> userPanels = studentsListToUserPanels();
        String selectedFilter = namefield.getText();
        
        //System.out.println("userPanels: " +  userPanels.size());
        
//        ArrayList<String> filters = new ArrayList<String>();
//        int random = (int)(Math.random() * 50);
//        int limit  = nameSearchRandomsArray.size() - 1;
//        int selectedFilterIndx = random % limit;
//        
//        String selectedFilter = nameSearchRandomsArray.get(selectedFilterIndx);

        for (int i = 0; i < userPanels.size(); ++i) {    
            String studentName = userPanels.get(i).GetStudentName();
            if ((activeSearch && studentName.toLowerCase().contains(selectedFilter.toLowerCase())) || activeSearch == false) {
                grid.add(userPanels.get(i));
            }
        }
        
        //System.out.println("userPanels after filter: " +  grid.getComponentCount());
        
        int gridItemsRemainingForRow = getColumnCountForGrid();
        int column = 0;
        int row = 0;
        int gridItemCount = grid.getComponentCount();
        
        
        //System.out.println("gridItemCount: " +  gridItemCount);
        
        for (int i = 0; i < gridItemCount; ++i) {
            UserPanel userPanel = (UserPanel)grid.getComponent(i);

            userPanel.setBounds((column * gridItemWidth), (row * gridItemHeight), gridItemWidth, gridItemHeight);
            
            --gridItemsRemainingForRow;
            ++column;
            
            if (gridItemsRemainingForRow == 0) {
                ++row;
                gridItemsRemainingForRow = getColumnCountForGrid();
                column = 0;
            }
        }
        
        int gridHeight = getNumberOfRowsForGrid(gridItemCount) * gridItemHeight;
        System.out.println(gridHeight);
        grid.setSize(grid.getWidth(), gridHeight);

        grid.revalidate();
    }
    
    public void hideScrollPane() {
        this.jScrollPane1.setVisible(false);
    }
    
    private ArrayList<UserPanel> studentsListToUserPanels() {
        ArrayList<UserPanel> userPanels = new ArrayList<UserPanel>();
        if (students != null) {
            students.forEach((n) -> {
                /*byte panelSize = 0;
                        
                if (userPanelSize == 0) {
                    // 100 x 150
                }
                else if (userPanelSize == 1) {
                    // 110 x 160
                }
                else if (userPanelSize == 2) {
                    // 130 x 170
                }*/
                UserPanel userPanel = new UserPanel(n);
                userPanel.addMouseListener(new MouseAdapter() { 
                    @Override
                    public void mouseClicked(MouseEvent e) {                        
                        UserPanel thisComponent = (UserPanel)e.getSource();

                        JPanel configpane = (JPanel)(thisComponent).getParent().getParent().getParent().getParent().getParent();

                        for (int i = 0; i < configpane.getComponentCount(); ++i) {
                            Component c = configpane.getComponent(i);
                            if (c instanceof UserPagePanel) {
                                ((UserPagePanel)c).bindStudent(thisComponent.getStudent());
                                c.setVisible(true);
                            }
                            else if(!(c instanceof UserPagePanel)) {
                                c.setVisible(false);
                            }
                        }
                        
                        super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
                        JFrame frame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, (Component)e.getSource());
                        frame.setCursor(cursor);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent e) {
                        Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
                        JFrame frame = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, (Component)e.getSource());
                        frame.setCursor(cursor);
                    }
                 
                });
                
                userPanels.add(userPanel);
            });
        }
        //System.out.println("students size: " + " " + students.size());
        return userPanels;
    }
    
    private Integer getColumnCountForGrid() {
        //System.out.println("grid" + " " + grid.getWidth() + " " + this.getParent().getWidth());
        
        return (Integer)((this.getParent().getWidth() - 20) / gridItemWidth);
    }
    
    private Integer getNumberOfRowsForGrid(int gridItemCount) {
        //System.out.println("getNumberOfRowsForGrid" + " " + gridItemCount);
        
        return (Integer)(gridItemCount % getColumnCountForGrid());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        namefieldPanel = new javax.swing.JPanel();
        namefield = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grid = new javax.swing.JPanel();

        setBackground(new java.awt.Color(33, 231, 231));
        setMinimumSize(new java.awt.Dimension(100, 300));
        setRequestFocusEnabled(false);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        namefieldPanel.setLayout(new java.awt.BorderLayout());

        namefield.setText("Enter the text...");
        namefield.setToolTipText("");
        namefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namefieldActionPerformed(evt);
            }
        });
        namefieldPanel.add(namefield, java.awt.BorderLayout.CENTER);

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        namefieldPanel.add(search, java.awt.BorderLayout.EAST);

        add(namefieldPanel);

        grid.setBackground(new java.awt.Color(255, 255, 255));
        grid.setToolTipText("");
        grid.setPreferredSize(new java.awt.Dimension(130, 1500));

        javax.swing.GroupLayout gridLayout = new javax.swing.GroupLayout(grid);
        grid.setLayout(gridLayout);
        gridLayout.setHorizontalGroup(
            gridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );
        gridLayout.setVerticalGroup(
            gridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1500, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(grid);

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents

    private void namefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namefieldActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        activeSearch = true;
        rebuildGrid();
    }//GEN-LAST:event_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel grid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namefield;
    private javax.swing.JPanel namefieldPanel;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
