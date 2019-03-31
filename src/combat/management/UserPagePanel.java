/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combat.management;

import combat.management.Config.CombatConfig;
import combat.management.Models.Payment;
import combat.management.Models.Student;
import combat.management.Services.PaymentsService;
import combat.management.Services.UserService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ahmed
 */
public class UserPagePanel extends javax.swing.JPanel {
    private boolean changes = false;
    private UserService userService;
    private PaymentsService paymentsService;
    private Student _s;
    private JTextField beltLevel;
    private JTextField beltLevelDate;
    private JTextField name;
    private JTextField dateOfBirth;
    private JTextField age;
    //private JTextField address;
    private JTextField contanctPhone;
    private JTextField contanctEmail;
    private JTextField emergencyContanctPhone;
    private JTextField emergencyContanctPerson;
    private JTextField emergencyContanctRelation;
    private JTextField emergencyContanctEmail;
    private JTextField memberSince;
    private JTextField leftOn;
    private String[] randomFileJPGs = { "karartekid.jpg", "lee1.jpg", "lee2.jpg", "lee3.jpg" };
    
    /**
     * Creates new form UserPagePanel
     */
    public UserPagePanel() {
        initComponents();
        
        userService = new UserService();
        paymentsService = new PaymentsService();
        
        /* Belt Panel - 1st Level */
        JPanel left = new JPanel();
        JPanel right = new JPanel();
   
        beltPanel.add(left);
        beltPanel.add(right);
        
        GridBagLayout beltPanelLayout = (GridBagLayout)beltPanel.getLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        beltLevel = new JTextField();
        left.setLayout(new BorderLayout());
        left.setBackground(Color.white);
        JLabel beltLevelLabel = new JLabel("Belt Level");
        beltLevelLabel.setBorder(new EmptyBorder(0, 0, 0, 5));
        left.add(beltLevelLabel, BorderLayout.WEST);
        left.add(beltLevel, BorderLayout.CENTER);
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        
        beltPanelLayout.setConstraints(left, gridBagConstraints);
        
        beltLevelDate = new JTextField();
        right.setLayout(new BorderLayout());
        right.setBackground(Color.white);
        JLabel beltLevelDateLabel = new JLabel("Belt Level Date");
        beltLevelDateLabel.setBorder(new EmptyBorder(0, 5, 0, 5));
        right.add(beltLevelDateLabel, BorderLayout.WEST);
        right.add(beltLevelDate, BorderLayout.CENTER);
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        
        beltPanelLayout.setConstraints(right, gridBagConstraints);

        /* Bio Panel - 2nd Level */       
        JPanel bioPanelLeft = new JPanel();
        JPanel bioPanelCenter = new JPanel();
        JPanel bioPanelRight = new JPanel();
        
        GridBagLayout bioPanelLayout = (GridBagLayout)bioPanel.getLayout();
        
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.45;
        
        name = new JTextField();
        bioPanelLeft.setLayout(new BorderLayout());
        bioPanelLeft.setBackground(Color.white);
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBorder(new EmptyBorder(0, 0, 0, 5));
        bioPanelLeft.add(nameLabel, BorderLayout.WEST);
        bioPanelLeft.add(name, BorderLayout.CENTER);
        
        bioPanelLayout.setConstraints(bioPanelLeft, gridBagConstraints);
        bioPanel.add(bioPanelLeft);
        
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.45;
        //gridBagConstraints.weighty = 1;
        
        dateOfBirth = new JTextField();
        bioPanelCenter.setLayout(new BorderLayout());
        bioPanelCenter.setBackground(Color.white);
        JLabel dobLabel = new JLabel("Date of birth");
        dobLabel.setBorder(new EmptyBorder(0, 5, 0, 5));
        bioPanelCenter.add(dobLabel, BorderLayout.WEST);
        bioPanelCenter.add(dateOfBirth, BorderLayout.CENTER);
        
        bioPanelLayout.setConstraints(bioPanelCenter, gridBagConstraints);
        bioPanel.add(bioPanelCenter);
           
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        
        age = new JTextField();
        bioPanelRight.setLayout(new BorderLayout());
        bioPanelRight.setBackground(Color.white);
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setBorder(new EmptyBorder(0, 5, 0, 5));
        bioPanelRight.add(ageLabel, BorderLayout.WEST);
        bioPanelRight.add(age, BorderLayout.CENTER);
        
        bioPanelLayout.setConstraints(bioPanelRight, gridBagConstraints);
        bioPanel.add(bioPanelRight);
        
        /* Address Panel - 3rd Level */
        GridBagLayout addressPanelLayout = (GridBagLayout)addressPanel.getLayout();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.4;
        addressPanelLayout.setConstraints(addressLeftPanel, gridBagConstraints);
        
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.4;
        addressPanelLayout.setConstraints(addressCenterPanel, gridBagConstraints);
        
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        addressPanelLayout.setConstraints(addressRightPanel, gridBagConstraints);
        
        
        /* Contact Panel - 4th Level */
        JPanel contactPanelLeft = new JPanel();
        JPanel contactPanelRight = new JPanel();

        GridBagLayout contactPanelLayout = (GridBagLayout)contactPanel.getLayout();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        
        contanctPhone = new JTextField();
        contactPanelLeft.setLayout(new BorderLayout());
        contactPanelLeft.setBackground(Color.white);
        JLabel contactPhoneLabel = new JLabel("Contact Phone");
        contactPhoneLabel.setBorder(new EmptyBorder(0, 0, 0, 5));
        contactPanelLeft.add(contactPhoneLabel, BorderLayout.WEST);
        contactPanelLeft.add(contanctPhone, BorderLayout.CENTER);
        
        contactPanelLayout.setConstraints(contactPanelLeft, gridBagConstraints);
        contactPanel.add(contactPanelLeft);
        
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        
        contanctEmail = new JTextField();
        contactPanelRight.setLayout(new BorderLayout());
        contactPanelRight.setBackground(Color.white);
        JLabel contanctEmailLabel = new JLabel("Contact Email");
        contanctEmailLabel.setBorder(new EmptyBorder(0, 5, 0, 5));
        contactPanelRight.add(contanctEmailLabel, BorderLayout.WEST);
        contactPanelRight.add(contanctEmail, BorderLayout.CENTER);
        
        contactPanelLayout.setConstraints(contactPanelRight, gridBagConstraints);
        contactPanel.add(contactPanelRight);

        /*Emergency Contact - 5th Level*/
        JPanel emergencyContactPanelLeft = new JPanel();
        JPanel emergencyContactPanelRight = new JPanel();
       
        GridBagLayout emergencyContactPanelLayout = (GridBagLayout)emergencyContactPanel.getLayout();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        
        emergencyContanctPhone = new JTextField();
        emergencyContactPanelLeft.setLayout(new BorderLayout());
        emergencyContactPanelLeft.add(new JLabel("Emergency Contact Phone"), BorderLayout.WEST);
        emergencyContactPanelLeft.add(emergencyContanctPhone, BorderLayout.CENTER);
        
        emergencyContactPanelLayout.setConstraints(emergencyContactPanelLeft, gridBagConstraints);
        emergencyContactPanel.add(emergencyContactPanelLeft);
        
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
      
        emergencyContanctPerson = new JTextField();
        emergencyContactPanelRight.setLayout(new BorderLayout());
        emergencyContactPanelRight.add(new JLabel("Emergency Contact Person"), BorderLayout.WEST);
        emergencyContactPanelRight.add(emergencyContanctPerson, BorderLayout.CENTER);
        
        emergencyContactPanelLayout.setConstraints(emergencyContactPanelRight, gridBagConstraints);
        emergencyContactPanel.add(emergencyContactPanelRight);

        /*Emergency Contact 2nd - 6th Level*/
        JPanel emergencyContact2PanelLeft = new JPanel();
        JPanel emergencyContact2PanelRight = new JPanel();
        
        GridBagLayout emergencyContact2PanelLayout = (GridBagLayout)emergencyContact2Panel.getLayout();
        
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        
        emergencyContanctRelation = new JTextField();
        emergencyContact2PanelLeft.setLayout(new BorderLayout());
        emergencyContact2PanelLeft.add(new JLabel("Emergency Contact Relation"), BorderLayout.WEST);
        emergencyContact2PanelLeft.add(emergencyContanctRelation, BorderLayout.CENTER);
        
        emergencyContact2PanelLayout.setConstraints(emergencyContact2PanelLeft, gridBagConstraints);
        emergencyContact2Panel.add(emergencyContact2PanelLeft);
        
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        
        emergencyContanctEmail = new JTextField();
        emergencyContact2PanelRight.setLayout(new BorderLayout());
        emergencyContact2PanelRight.add(new JLabel("Emergency Contact Email"), BorderLayout.WEST);
        emergencyContact2PanelRight.add(emergencyContanctEmail, BorderLayout.CENTER);
        
        emergencyContact2PanelLayout.setConstraints(emergencyContact2PanelRight, gridBagConstraints);
        emergencyContact2Panel.add(emergencyContact2PanelRight);
        
        /*Membership - 7th Level*/
        JPanel membershipPanelLeft = new JPanel();
        JPanel membershipPanelRight = new JPanel();
        
        GridBagLayout membershipPanelLayout = (GridBagLayout)membershipPanel.getLayout();
        
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        
        memberSince = new JTextField();
        membershipPanelLeft.setLayout(new BorderLayout());
        membershipPanelLeft.add(new JLabel("Member Since"), BorderLayout.WEST);
        membershipPanelLeft.add(memberSince, BorderLayout.CENTER);
        
        membershipPanelLayout.setConstraints(membershipPanelLeft, gridBagConstraints);
        membershipPanel.add(membershipPanelLeft);
        
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        
        leftOn = new JTextField();
        membershipPanelRight.setLayout(new BorderLayout());
        membershipPanelRight.add(new JLabel("Left On"), BorderLayout.WEST);
        membershipPanelRight.add(leftOn, BorderLayout.CENTER);
        
        membershipPanelLayout.setConstraints(membershipPanelRight, gridBagConstraints);
        membershipPanel.add(membershipPanelRight);
        
        setupColumnsForPaymentHistoryTable();
    }
    
    private void setupColumnsForPaymentHistoryTable() {
        DefaultTableModel model  = (DefaultTableModel)paymentsHistory.getModel();
        
        model.addColumn("Reference");
        model.addColumn("Amount");
        model.addColumn("Date Due");
        model.addColumn("Is Paid");
        model.addColumn("Paid On Time");
        
//        Class[] types = new Class [] {
//                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
//            };
//            boolean[] canEdit = new boolean [] {
//                false, false, false, true, true
//            };
//
//            public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }
//
//            public boolean isCellEditable(int rowIndex, int columnIndex) {
//                return canEdit [columnIndex];
//            }
    }
    
    public void bindStudent(Student s) {
        changes = false;
        _s = s;
        beltLevel.setText(s.BeltLevel);
        beltLevelDate.setText(s.BeltLevelDate);
        name.setText(s.Firstname + " " + s.Lastname);
        dateOfBirth.setText(s.DateOfBirth);
        
        LocalDate nowDateObj = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate dobObj = LocalDate.parse(s.DateOfBirth, myFormatObj);
        age.setText(Integer.toString(nowDateObj.getYear() - dobObj.getYear()));
        
        String userImageDirectory = CombatConfig.UserImagesDirectory();
        
        int random = (int)(Math.random() * 50);
        int limit = 4;
        
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(userImageDirectory + randomFileJPGs[random % limit]));
            Image dimg = img.getScaledInstance(Picture.getPreferredSize().width, Picture.getPreferredSize().height, Image.SCALE_SMOOTH);
            this.Picture.setIcon(new ImageIcon(dimg));
        }
        catch (Exception e) {
        }
        
        address.setText(s.Address);
        suburb.setText(s.Suburb);
        postcode.setText(Integer.toString(s.Postcode));
        
        contanctPhone.setText(s.ContactPhoneNumber);
        contanctEmail.setText(s.ContactEmail);
        emergencyContanctPhone.setText(s.EmergencyContactPhoneNumber);
        emergencyContanctPerson.setText(s.EmergencyContactName);
        //emergencyContanctRelation.setText(s.);
        memberSince.setText(s.MemberSinceDate);
        leftOn.setText(s.LeftOnDate);
        
        ArrayList<Payment> payments = paymentsService.getPaymentsHistoryForStudent(s.ID, combat.management.Config.CombatConfig.PaymentsCSVPath());
        DefaultTableModel model = (DefaultTableModel) paymentsHistory.getModel();
        model.setRowCount(0);
        /*if (s.ID == 1) {
            System.out.println( payments.size());
        }*/
        
        payments.forEach((action) -> { 
            model.addRow(new Object[]{action.GetReferenceNumber(), action.GetAmount(), action.GetDueDate(), action.IsPaid(), action.PaidOnTime()});
        });
        
//        if (s.ID == 2) {
//            
//            paymentsHistory.setPreferredSize(new Dimension(200, 1000));
//            //System.out.println(model.getRowCount());
//        }
//        else {
//            paymentsHistory.setPreferredSize(new Dimension(200, 10000));
//        }
        
        System.out.println(paymentsHistory.getHeight());
        model.fireTableDataChanged();
        //paymentsHistory.repaint();
    }
    
    private void saveStudent() {
        userService.SaveStudent(_s, combat.management.Config.CombatConfig.StudentCSVPath());
    }
    
    private void updateStudentObject() {
        _s.Address = address.getText();
        _s.BeltLevelDate = beltLevelDate.getText();
        _s.BeltLevel = beltLevel.getText();
        _s.ContactEmail = contanctEmail.getText();
        _s.ContactPhoneNumber = contanctPhone.getText();
        _s.DateOfBirth = dateOfBirth.getText();
        _s.EmergencyContactName = emergencyContanctPerson.getText();
        _s.EmergencyContactPhoneNumber = emergencyContanctPhone.getText();
        //_s.Firstname;
        //_s.Lastname;
        _s.LeftOnDate = leftOn.getText();
        _s.MemberSinceDate = memberSince.getText();
        _s.Postcode = Integer.parseInt(postcode.getText());
        //_s.ProfileImageFilename =
        _s.Suburb = suburb.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        studentpicture = new javax.swing.JPanel();
        Picture = new javax.swing.JLabel();
        studentdetails = new javax.swing.JPanel();
        beltPanel = new javax.swing.JPanel();
        bioPanel = new javax.swing.JPanel();
        addressPanel = new javax.swing.JPanel();
        addressLeftPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        addressCenterPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        suburb = new javax.swing.JTextField();
        addressRightPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        postcode = new javax.swing.JTextField();
        contactPanel = new javax.swing.JPanel();
        emergencyContactPanel = new javax.swing.JPanel();
        emergencyContact2Panel = new javax.swing.JPanel();
        membershipPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymentsHistory = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(426, 336));
        setLayout(new java.awt.GridLayout(1, 2));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(200, 336));

        studentpicture.setBackground(new java.awt.Color(153, 153, 255));
        studentpicture.setMaximumSize(new java.awt.Dimension(32000, 32000));
        studentpicture.setMinimumSize(new java.awt.Dimension(200, 336));
        studentpicture.setName(""); // NOI18N
        studentpicture.setPreferredSize(new java.awt.Dimension(379, 558));
        studentpicture.setLayout(new java.awt.BorderLayout());

        Picture.setBackground(new java.awt.Color(102, 102, 255));
        Picture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Picture.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Picture.setMaximumSize(new java.awt.Dimension(168, 214));
        Picture.setMinimumSize(new java.awt.Dimension(168, 214));
        Picture.setName(""); // NOI18N
        Picture.setPreferredSize(new java.awt.Dimension(168, 214));
        studentpicture.add(Picture, java.awt.BorderLayout.CENTER);

        studentdetails.setBackground(new java.awt.Color(255, 255, 255));
        studentdetails.setMinimumSize(new java.awt.Dimension(180, 186));
        studentdetails.setLayout(new java.awt.GridLayout(8, 1));

        beltPanel.setBackground(new java.awt.Color(255, 255, 255));
        beltPanel.setLayout(new java.awt.GridBagLayout());
        studentdetails.add(beltPanel);

        bioPanel.setBackground(new java.awt.Color(255, 255, 255));
        bioPanel.setLayout(new java.awt.GridBagLayout());
        studentdetails.add(bioPanel);

        addressPanel.setBackground(new java.awt.Color(255, 255, 255));
        addressPanel.setLayout(new java.awt.GridBagLayout());

        addressLeftPanel.setBackground(new java.awt.Color(255, 255, 255));
        addressLeftPanel.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Address");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 5));
        addressLeftPanel.add(jLabel2, java.awt.BorderLayout.WEST);

        address.setText("jTextField1");
        address.setPreferredSize(new java.awt.Dimension(650, 20));
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        addressLeftPanel.add(address, java.awt.BorderLayout.CENTER);

        addressPanel.add(addressLeftPanel, new java.awt.GridBagConstraints());

        addressCenterPanel.setBackground(new java.awt.Color(255, 255, 255));
        addressCenterPanel.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Suburb");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5));
        addressCenterPanel.add(jLabel1, java.awt.BorderLayout.WEST);

        suburb.setText("jTextField1");
        addressCenterPanel.add(suburb, java.awt.BorderLayout.CENTER);

        addressPanel.add(addressCenterPanel, new java.awt.GridBagConstraints());

        addressRightPanel.setBackground(new java.awt.Color(255, 255, 255));
        addressRightPanel.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Postcode");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5));
        addressRightPanel.add(jLabel3, java.awt.BorderLayout.WEST);

        postcode.setText("jTextField1");
        addressRightPanel.add(postcode, java.awt.BorderLayout.CENTER);

        addressPanel.add(addressRightPanel, new java.awt.GridBagConstraints());

        studentdetails.add(addressPanel);

        contactPanel.setBackground(new java.awt.Color(255, 255, 255));
        contactPanel.setLayout(new java.awt.GridBagLayout());
        studentdetails.add(contactPanel);

        emergencyContactPanel.setBackground(new java.awt.Color(255, 255, 255));
        emergencyContactPanel.setLayout(new java.awt.GridBagLayout());
        studentdetails.add(emergencyContactPanel);

        emergencyContact2Panel.setBackground(new java.awt.Color(255, 255, 255));
        emergencyContact2Panel.setLayout(new java.awt.GridBagLayout());
        studentdetails.add(emergencyContact2Panel);

        membershipPanel.setBackground(new java.awt.Color(255, 255, 255));
        membershipPanel.setLayout(new java.awt.GridBagLayout());
        studentdetails.add(membershipPanel);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setText("Save");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(312, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        studentdetails.add(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentdetails, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(studentpicture, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(studentpicture, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentdetails, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(220, 11));
        jPanel2.setLayout(new java.awt.GridLayout(1, 1));

        paymentsHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        paymentsHistory.setRequestFocusEnabled(false);
        paymentsHistory.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(paymentsHistory);

        jPanel2.add(jScrollPane1);

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        updateStudentObject();
        saveStudent();
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Picture;
    private javax.swing.JTextField address;
    private javax.swing.JPanel addressCenterPanel;
    private javax.swing.JPanel addressLeftPanel;
    private javax.swing.JPanel addressPanel;
    private javax.swing.JPanel addressRightPanel;
    private javax.swing.JPanel beltPanel;
    private javax.swing.JPanel bioPanel;
    private javax.swing.JPanel contactPanel;
    private javax.swing.JPanel emergencyContact2Panel;
    private javax.swing.JPanel emergencyContactPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel membershipPanel;
    private javax.swing.JTable paymentsHistory;
    private javax.swing.JTextField postcode;
    private javax.swing.JPanel studentdetails;
    private javax.swing.JPanel studentpicture;
    private javax.swing.JTextField suburb;
    // End of variables declaration//GEN-END:variables
}
