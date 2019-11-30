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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ahmed
 */
public class UserPagePanel extends javax.swing.JPanel {
    private boolean changes = false;
    private boolean isEdit = false;
    private UserService userService;
    private PaymentsService paymentsService;
    private Student _s;
    private JTextField beltLevel;
    private JComboBox<String> beltLevelCB;
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
    
    private Payment paymentFormObject;
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
        
        beltLevelCB = new JComboBox<String>();
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
        paymentsHistory.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                int selectedIndex = paymentsHistory.getSelectedRow();
                if (selectedIndex > -1) {
                    deletePaymentButton.setEnabled(true);
                    editPaymentButton.setEnabled(true);
                    paymentFormObject.SetReferenceNumber(paymentsHistory.getValueAt(selectedIndex, 0).toString());
                    paymentFormObject.SetAmount(Float.valueOf(paymentsHistory.getValueAt(selectedIndex, 1).toString()));
                    paymentFormObject.SetDueDate(paymentsHistory.getValueAt(selectedIndex, 2).toString());
                    paymentFormObject.SetPaid(Boolean.valueOf(paymentsHistory.getValueAt(selectedIndex, 3).toString()));
                    paymentFormObject.SetPaidOnTime(Boolean.valueOf(paymentsHistory.getValueAt(selectedIndex, 4).toString()));
                }
                else {
                    deletePaymentButton.setEnabled(false);
                    editPaymentButton.setEnabled(false);
                }
            }
        });
        paymentFormContainer.setVisible(false);
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
        if (payments.size() > 0) {
            payments.forEach((action) -> { 
                model.addRow(new Object[]{action.GetReferenceNumber(), action.GetAmount(), action.GetDueDate(), action.IsPaid(), action.PaidOnTime()});
            });
        }
        else {
            
        }
        
//        if (s.ID == 2) {
//            
//            paymentsHistory.setPreferredSize(new Dimension(200, 1000));
//            //System.out.println(model.getRowCount());
//        }
//        else {
//            paymentsHistory.setPreferredSize(new Dimension(200, 10000));
//        }


        isEdit = true;

        model.fireTableDataChanged();
        
        paymentFormObject = new Payment(_s.ID, s.ID + "-5000");
        //paymentsHistory.repaint();
    }
    
    public void prepareForAddStudent() {
        this.unbindStudent();
    }
    
    private void unbindStudent() {
        changes = false;
        _s = new Student();
        beltLevel.setText(_s.BeltLevel);
        beltLevelDate.setText(_s.BeltLevelDate);
        name.setText("");
        dateOfBirth.setText(_s.DateOfBirth);
        
        LocalDate nowDateObj = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("d/MM/yyyy");
        try {
            LocalDate dobObj = LocalDate.parse(_s.DateOfBirth, myFormatObj);
            age.setText(Integer.toString(nowDateObj.getYear() - dobObj.getYear()));
        }
        catch(Exception e) {
            age.setText("0");
        }
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
        
        address.setText(_s.Address);
        suburb.setText(_s.Suburb);
        postcode.setText(Integer.toString(_s.Postcode));
        
        contanctPhone.setText(_s.ContactPhoneNumber);
        contanctEmail.setText(_s.ContactEmail);
        emergencyContanctPhone.setText(_s.EmergencyContactPhoneNumber);
        emergencyContanctPerson.setText(_s.EmergencyContactName);
        //emergencyContanctRelation.setText(s.);
        memberSince.setText(_s.MemberSinceDate);
        leftOn.setText(_s.LeftOnDate);
        
        //ArrayList<Payment> payments = paymentsService.getPaymentsHistoryForStudent(_s.ID, combat.management.Config.CombatConfig.PaymentsCSVPath());
        DefaultTableModel model = (DefaultTableModel) paymentsHistory.getModel();
        model.setRowCount(0);

        isEdit = false;

        model.fireTableDataChanged();
    }
    
    private void saveStudent() {
        if (isEdit == false) {
           userService.AddStudent(_s, combat.management.Config.CombatConfig.StudentCSVPath());
        }
        else {
            userService.SaveStudent(_s, combat.management.Config.CombatConfig.StudentCSVPath());
        }
        
        JOptionPane.showMessageDialog(this, "Save successful");
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

    private void clearPaymentForm() {
        paymentFormPaymentDate.setText("");
        paymentFormReferenceNumber.setText("");
        paymentFormAmount.setText("");
        paymentFormPaidOnTimeYes.setSelected(false);
        paymentFormHasBeenPaidYes.setSelected(false);
    }
    
    private void addPayment() {
        paymentFormObject.SetPaid(paymentFormHasBeenPaidYes.isSelected());
        paymentFormObject.SetPaidOnTime(paymentFormPaidOnTimeYes.isSelected());
        paymentFormObject.SetDueDate(paymentFormPaymentDate.getText());
        paymentsService.addPaymentHistoryForStudent(paymentFormObject, combat.management.Config.CombatConfig.PaymentsCSVPath());
    }
    
    private void openPaymentForm() {
        paymentFormContainer.setVisible(true);
        paymentsTableScroll.setVisible(false);
    }
    
    private void closePaymentForm() {
        paymentFormContainer.setVisible(false);
        paymentsTableScroll.setVisible(true);
    }
    
    private void bindPaymentFormObjectToPaymentFormFields() {
        this.paymentFormReferenceNumber.setText(this.paymentFormObject.GetReferenceNumber());
        this.paymentFormPaymentDate.setText(this.paymentFormObject.GetDueDate());
        this.paymentFormAmount.setText(Float.toString(this.paymentFormObject.GetAmount()));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        editPaymentButton = new javax.swing.JButton();
        deletePaymentButton = new javax.swing.JButton();
        paymentsTableScroll = new javax.swing.JScrollPane();
        paymentsHistory = new javax.swing.JTable();
        paymentFormContainer = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        paymentFormPaymentDate = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        paymentFormReferenceNumber = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        paymentFormAmount = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        paymentFormHasBeenPaidYes = new javax.swing.JToggleButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        paymentFormPaidOnTimeYes = new javax.swing.JToggleButton();
        jPanel10 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

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
                .addContainerGap(385, Short.MAX_VALUE)
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
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 150));
        jPanel4.setPreferredSize(new java.awt.Dimension(379, 150));
        jPanel4.setRequestFocusEnabled(false);

        jButton1.setText("Add a payment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        editPaymentButton.setText("Edit selected payment");
        editPaymentButton.setEnabled(false);
        editPaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPaymentButtonActionPerformed(evt);
            }
        });

        deletePaymentButton.setText("Delete selected payment");
        deletePaymentButton.setEnabled(false);
        deletePaymentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePaymentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deletePaymentButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editPaymentButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(editPaymentButton)
                    .addComponent(deletePaymentButton))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4);

        paymentsHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        paymentsHistory.setRequestFocusEnabled(false);
        paymentsHistory.getTableHeader().setReorderingAllowed(false);
        paymentsTableScroll.setViewportView(paymentsHistory);

        jPanel2.add(paymentsTableScroll);

        paymentFormContainer.setPreferredSize(new java.awt.Dimension(452, 259));
        paymentFormContainer.setLayout(new javax.swing.BoxLayout(paymentFormContainer, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        jPanel5.setLayout(new java.awt.GridLayout(3, 2));

        jLabel4.setText("Date of payment");

        paymentFormPaymentDate.setText("jTextField1");
        paymentFormPaymentDate.setMinimumSize(new java.awt.Dimension(100, 20));
        paymentFormPaymentDate.setPreferredSize(new java.awt.Dimension(100, 20));
        paymentFormPaymentDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentFormPaymentDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 157, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(paymentFormPaymentDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paymentFormPaymentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel6);

        jLabel5.setText("Reference Number");

        paymentFormReferenceNumber.setText("jTextField1");
        paymentFormReferenceNumber.setMinimumSize(new java.awt.Dimension(100, 20));
        paymentFormReferenceNumber.setPreferredSize(new java.awt.Dimension(100, 20));
        paymentFormReferenceNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentFormReferenceNumberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 148, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(paymentFormReferenceNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paymentFormReferenceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel7);

        jLabel8.setText("Amount");

        paymentFormAmount.setText("jTextField1");
        paymentFormAmount.setMinimumSize(new java.awt.Dimension(100, 20));
        paymentFormAmount.setPreferredSize(new java.awt.Dimension(100, 20));
        paymentFormAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentFormAmountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(0, 201, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(paymentFormAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paymentFormAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel11);

        jLabel6.setText("Has Been Paid?");

        paymentFormHasBeenPaidYes.setText("Not Paid, (click here if it is)");
        paymentFormHasBeenPaidYes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                paymentFormHasBeenPaidYesStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(paymentFormHasBeenPaidYes))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paymentFormHasBeenPaidYes))
        );

        jPanel5.add(jPanel8);

        jLabel7.setText("Paid On Time?");

        paymentFormPaidOnTimeYes.setText("Not Paid, (click here if it is)");
        paymentFormPaidOnTimeYes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                paymentFormPaidOnTimeYesStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(paymentFormPaidOnTimeYes))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paymentFormPaidOnTimeYes))
        );

        jPanel5.add(jPanel9);

        paymentFormContainer.add(jPanel5);

        jPanel10.setMaximumSize(new java.awt.Dimension(32767, 150));
        jPanel10.setPreferredSize(new java.awt.Dimension(452, 150));

        jButton5.setText("Save Payment");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Cancel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(266, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        paymentFormContainer.add(jPanel10);

        jPanel2.add(paymentFormContainer);

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

    private void deletePaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePaymentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletePaymentButtonActionPerformed

    private void paymentFormPaymentDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentFormPaymentDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentFormPaymentDateActionPerformed

    private void paymentFormReferenceNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentFormReferenceNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentFormReferenceNumberActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        paymentFormContainer.setVisible(true);
        paymentsTableScroll.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.clearPaymentForm();
        this.closePaymentForm();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.addPayment();
        this.clearPaymentForm();
        this.closePaymentForm();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void paymentFormPaidOnTimeYesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_paymentFormPaidOnTimeYesStateChanged
        // TODO add your handling code here:
        boolean current = paymentFormPaidOnTimeYes.isSelected();
        paymentFormObject.SetPaidOnTime(current);
        if (current) {
        paymentFormPaidOnTimeYes.setText("Paid On Time (click here if it's not)");
        }
        else {
            paymentFormPaidOnTimeYes.setText("Not Paid On Time (click here if it is)");
        }
    }//GEN-LAST:event_paymentFormPaidOnTimeYesStateChanged

    private void paymentFormHasBeenPaidYesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_paymentFormHasBeenPaidYesStateChanged
        // TODO add your handling code here:
        boolean current = paymentFormHasBeenPaidYes.isSelected();
        paymentFormObject.SetPaidOnTime(current);
        if (current) {
        paymentFormHasBeenPaidYes.setText("Has been Paid (click here if it's not)");
        }
        else {
            paymentFormHasBeenPaidYes.setText("Not been Paid (click here if it is)");
        }
    }//GEN-LAST:event_paymentFormHasBeenPaidYesStateChanged

    private void editPaymentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPaymentButtonActionPerformed
        // TODO add your handling code here:
        this.bindPaymentFormObjectToPaymentFormFields();
        this.openPaymentForm();
    }//GEN-LAST:event_editPaymentButtonActionPerformed

    private void paymentFormAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentFormAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentFormAmountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Picture;
    private javax.swing.JTextField address;
    private javax.swing.JPanel addressCenterPanel;
    private javax.swing.JPanel addressLeftPanel;
    private javax.swing.JPanel addressPanel;
    private javax.swing.JPanel addressRightPanel;
    private javax.swing.JPanel beltPanel;
    private javax.swing.JPanel bioPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel contactPanel;
    private javax.swing.JButton deletePaymentButton;
    private javax.swing.JButton editPaymentButton;
    private javax.swing.JPanel emergencyContact2Panel;
    private javax.swing.JPanel emergencyContactPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel membershipPanel;
    private javax.swing.JTextField paymentFormAmount;
    private javax.swing.JPanel paymentFormContainer;
    private javax.swing.JToggleButton paymentFormHasBeenPaidYes;
    private javax.swing.JToggleButton paymentFormPaidOnTimeYes;
    private javax.swing.JTextField paymentFormPaymentDate;
    private javax.swing.JTextField paymentFormReferenceNumber;
    private javax.swing.JTable paymentsHistory;
    private javax.swing.JScrollPane paymentsTableScroll;
    private javax.swing.JTextField postcode;
    private javax.swing.JPanel studentdetails;
    private javax.swing.JPanel studentpicture;
    private javax.swing.JTextField suburb;
    // End of variables declaration//GEN-END:variables
}
