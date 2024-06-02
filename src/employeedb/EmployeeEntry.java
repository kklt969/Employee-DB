
package employeedb;
import java.sql.*;
import javax.swing.*;


public final class EmployeeEntry extends javax.swing.JDialog {

   Connection con = null;
   Statement ste = null;
   ResultSet rs = null;
   String gender = null;
    public EmployeeEntry(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        try{
        con = clsDBConnection.getConnection();
        }
        catch(Exception e)
        {   
            System.out.println(e);
        }
        
       AutoID();
    }
    
    public void AutoID()
    {   
        
        try {
            ste = con.createStatement();
            int id = 0; 

            rs = ste.executeQuery("SELECT * FROM employee ORDER BY EmployeeID Desc");

            if(rs.next())
                {
                    id = rs.getInt(1);
                }

             if (id == 0)
                {
                   lblEmployeeID.setText("1");
                }

             else 
                {
                   lblEmployeeID.setText("    "+(id+1));

                }

        }
        
        catch(SQLException e)
        {
            System.out.println(e);

        }
    }
    
    public void clearData()
    {   txtName.setText("");
        txtNRC.setText("");
        txtAddress.setText("");
        txtQualification.setText("");
        cboDepartment.setSelectedIndex(0);  // ---select---
        cboPost.setSelectedIndex(0);        // ---select---
    }
    
    public void checkData()
    {
        if(txtName.getText().trim().equals(""))
        {   
            JOptionPane.showMessageDialog(this,"You must enter Employee Name");
            txtName.requestFocus();
        }
        else if(txtNRC.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this,"You must enter NRC Number!");
            txtNRC.requestFocus();
        }
        
        else if(gender==null || gender.equals(""))
        { 
            JOptionPane.showMessageDialog(this,"You must choose gender!");
        }
        else if(txtAddress.getText().trim().equals(""))
        { 
            JOptionPane.showMessageDialog(this,"You must enter Address!");
            txtAddress.requestFocus();
        }
        else if(cboDepartment.getSelectedIndex()==0)    // ---Select---
        { 
            JOptionPane.showMessageDialog(this,"You must choose Department!");
            cboDepartment.requestFocus();
        }
    else if(cboPost.getSelectedIndex()==0)  // ---Select---
        { 
            JOptionPane.showMessageDialog(this,"You must choose Post!");
            cboPost.requestFocus();
        }
        else if(txtQualification.getText().trim().equals(""))
        { 
            JOptionPane.showMessageDialog(this,"You must enter Qualification!");
            txtQualification.requestFocus();
        }
        else if(lblEmployeeID.getText().trim().equals(""))
        { 
            AutoID(); 
        }
        else
        { 
            saveRecord(); // method call
        }
    }
    
    public void saveRecord ()
    {
        try{
        ste = con.createStatement();
        String sql = "Select * from Employee where EmployeeName='"+txtName.getText().toString()+"' And NRC='"+txtNRC.getText().toString()+"'";
        
        rs = ste.executeQuery(sql);
        
        if(rs.next())
        {
            JOptionPane.showMessageDialog(this, "This record is already exist");
            txtName.selectAll();
            txtName.requestFocus();
            return;
        }
        
        sql = "insert into Employee values("+lblEmployeeID.getText().trim()+",'"+txtName.getText().trim()+"','"+txtNRC.getText().trim()+"','"+gender+"','"+txtAddress.getText().trim()+"','"+
                cboDepartment.getSelectedItem().toString().trim()+"','"+cboPost.getSelectedItem().toString().trim()+ "','"+txtQualification.getText().trim()+"')";
        
        int result = ste.executeUpdate(sql);
        
        if (result == 1)
        {
            AutoID();
            clearData();
            JOptionPane.showMessageDialog(this, "This employee record is succesfully saved");
            
            
        }
        
       
        }catch(SQLException exp)
        {
            System.out.println(exp);
            JOptionPane.showMessageDialog(this, "Save record is failure");
        }
        
        catch(Exception e)
                {
                    System.out.println(e);
                }
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        Close = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblEmployeeID = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtNRC = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtQualification = new javax.swing.JTextField();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        cboDepartment = new javax.swing.JComboBox<>();
        cboPost = new javax.swing.JComboBox<>();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee Entry");

        jPanel1.setBackground(new java.awt.Color(185, 234, 187));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter Employee Information\n"));

        jPanel2.setBackground(new java.awt.Color(0, 204, 51));

        btnSave.setMnemonic('S');
        btnSave.setText("Save");
        btnSave.setName("btnSave"); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setMnemonic('C');
        btnCancel.setText("Cancel");
        btnCancel.setName("btnCancel"); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        Close.setText("Close");
        Close.setName("Close"); // NOI18N
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel)
                .addGap(61, 61, 61)
                .addComponent(Close)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(Close))
                .addGap(21, 21, 21))
        );

        jLabel1.setText("Employee ID:");
        jLabel1.setName(""); // NOI18N

        jLabel2.setText("Employee Name");

        jLabel3.setText("NRC No:");

        jLabel4.setText("Gender:");

        jLabel5.setText("Address:");

        jLabel6.setText("Department:");

        jLabel7.setText("Post:");

        jLabel8.setText("Qualification");

        lblEmployeeID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmployeeID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblEmployeeID.setName("lblEmployeeID"); // NOI18N

        txtName.setName("txtName"); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtNRC.setName("txtNRC"); // NOI18N

        txtAddress.setName("txtAddress"); // NOI18N

        txtQualification.setName("txtQualification"); // NOI18N

        buttonGroup1.add(rdoMale);
        rdoMale.setText("Male");
        rdoMale.setName("rdoMale"); // NOI18N
        rdoMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMaleActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoFemale);
        rdoFemale.setText("Female");
        rdoFemale.setName("rdoFemale"); // NOI18N
        rdoFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFemaleActionPerformed(evt);
            }
        });

        cboDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------Select------", "NCC", "SE", "NE", "Training" }));
        cboDepartment.setName("cboDepartment"); // NOI18N
        cboDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDepartmentActionPerformed(evt);
            }
        });

        cboPost.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------Select-------" }));
        cboPost.setName("cboPost"); // NOI18N
        cboPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPostActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                            .addComponent(jLabel6)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblEmployeeID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtName)
                                .addComponent(txtNRC, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                .addComponent(txtQualification, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoMale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoFemale))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cboDepartment, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboPost, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(16, 16, 16)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmployeeID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNRC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdoMale)
                    .addComponent(rdoFemale))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtQualification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        checkData();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearData();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        dispose();
    }//GEN-LAST:event_CloseActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void rdoMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMaleActionPerformed
        gender = "Male";
    }//GEN-LAST:event_rdoMaleActionPerformed

    private void cboPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPostActionPerformed

    private void cboDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDepartmentActionPerformed
        if(cboDepartment.getSelectedIndex()==1 || cboDepartment.getSelectedIndex()==2 || cboDepartment.getSelectedIndex()==3)
        {
            cboPost.addItem("------Select------");
            cboPost.addItem("Instructor");
            cboPost.addItem("Demonstrator");
            cboPost.addItem("Senior Instructor");
            cboPost.addItem("Incharge");
            cboPost.addItem("Lecturer");
            cboPost.addItem("Senior Lecturer");
            cboPost.addItem("Asst : training manager");
            cboPost.addItem("Training Manager");
            return;
            
        }
        
        if(cboDepartment.getSelectedIndex()==4)
        {
            cboPost.addItem("------Select------");
            cboPost.addItem("Instructor");
            
            cboPost.addItem("Senior Instructor");
            cboPost.addItem("Incharge");
            cboPost.addItem("Lecturer");
            cboPost.addItem("Senior Lecturer");
            cboPost.addItem("Asst : training manager");
            cboPost.addItem("Training Manager");
            return;
        }
        
        if(cboDepartment.getSelectedIndex()== 0)
        {
         cboPost.removeAllItems();
         cboPost.addItem("Select");
        }
    }//GEN-LAST:event_cboDepartmentActionPerformed

    private void rdoFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFemaleActionPerformed
        gender = "Female";
    }//GEN-LAST:event_rdoFemaleActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EmployeeEntry dialog = new EmployeeEntry(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Close;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboDepartment;
    private javax.swing.JComboBox<String> cboPost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblEmployeeID;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtNRC;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtQualification;
    // End of variables declaration//GEN-END:variables
}
