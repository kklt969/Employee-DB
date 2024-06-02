/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package employeedb;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author User
 */
public class EmployeeUpdate extends javax.swing.JDialog {

        Connection con = null;
        Statement ste  = null;
        ResultSet rs = null;
    public EmployeeUpdate(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        try
        {
            con = clsDBConnection.getConnection();
            
            getEmployeeID();
        }
        catch(Exception e)
        {
            System.out.println(e);

        } 
        
    }
    
    public void getEmployeeID()
            
    {
        
        try
        {
            ste = con.createStatement();
            cboEmployeeID.removeAllItems();
            cboEmployeeID.addItem("------Select------");
            
            String sql = "Select EmployeeID from Employee order by EmployeeID";
            rs = ste.executeQuery(sql);
            while(rs.next())
            {
                cboEmployeeID.addItem(rs.getString(1));
            }
            
      
            
        }
        
        catch(SQLException sqle)
        {
            System.out.println(sqle);
        }
          
        
    }
    
    public void fillrecord()
    {
        try{
        ste = con.createStatement();
        
        String sql = "Select * from employee where EmployeeID="+ cboEmployeeID.getSelectedItem().toString().trim();
        
        rs = ste.executeQuery(sql);
        
            if(rs.next())
            {
                lblEmployeeName.setText(rs.getString(2));
                lblEmployeeNRC.setText(rs.getString(3));
                lblEmployeeGender.setText(rs.getString(4));
                txtAddress.setText(rs.getString(5));
                cboEmployeeDepartment.setSelectedItem(rs.getObject(6));
                cboEmployeePost.setSelectedItem(rs.getObject(7));
                txtQualification.setText(rs.getString(8));
                txtAddress.requestFocus();
            }
        }
        
        catch(SQLException sqle)
        {
            
             System.out.println(sqle);
        }
        
        
        
    }   
    
    public void checkData()
    {
        if (cboEmployeeID.getSelectedIndex() <= 0)
        {
            JOptionPane.showMessageDialog(this, "Please select employee id.");
            cboEmployeeID.requestFocus();
        }
        
        else if (txtAddress.getText().trim().equals(""))
        {
             JOptionPane.showMessageDialog(this, "Please enter address");
            txtAddress.requestFocus();
        }
        
        else if (cboEmployeeDepartment.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(this, "Please choose department");
            cboEmployeeDepartment.requestFocus();
        }
        
        else if (cboEmployeePost.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(this, "Please choose Post");
            cboEmployeePost.requestFocus();
        }
        
        else if (txtQualification.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please choose Qualification");
            txtQualification.requestFocus();
        }
        
        else
        {
            updateRecord();
        }
        
        
    }
    
    public void updateRecord()
    {
        
        try
        {
            ste = con.createStatement();
            String sql = "Update Employee SET Address='"+txtAddress.getText().trim()+"' , Department='"+cboEmployeeDepartment.getSelectedItem()+"' ,Post='"+cboEmployeePost.getSelectedItem()
                  + ", Qualification='"+ txtQualification.getText().trim()+ "Where EmployeeID="+cboEmployeeID.getSelectedItem().toString().trim();
            
            int result = ste.executeUpdate(sql);
            
            if(result==1)
            {
                JOptionPane.showMessageDialog(this , "This record is succesfully updated");
            }
            
            
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle);
        }
        
        
    }
    
    public void deleteRecord()
    {
        try
        {
            ste = con.createStatement();
            
            String sql = "Delete From employee WHERE EmployeeID="+ cboEmployeeID.getSelectedItem().toString().trim();
            
            int result = ste.executeUpdate(sql);
            if(result == 1 )
                {
                JOptionPane.showMessageDialog(this , "This record is succesfully deleted");
                clearData();
                getEmployeeID();
                }
        }
        
        catch(SQLException sqle)
        {
            System.out.println(sqle);
        }
    }
    
    public void clearData()
    {
        cboEmployeeID.setSelectedIndex(0);
        lblEmployeeName.setText("");
        lblEmployeeNRC.setText("");
        lblEmployeeGender.setText("");
        cboEmployeeDepartment.setSelectedIndex(0);  // ---select---
        cboEmployeePost.setSelectedIndex(0);    
        txtAddress.setText("");
        txtQualification.setText("");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblEmployeeName = new javax.swing.JLabel();
        lblEmployeeNRC = new javax.swing.JLabel();
        lblEmployeeGender = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtQualification = new javax.swing.JTextField();
        cboEmployeeDepartment = new javax.swing.JComboBox<>();
        cboEmployeePost = new javax.swing.JComboBox<>();
        cboEmployeeID = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        jButton3.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Employee Update");

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Update Employee Information"));
        jPanel1.setToolTipText("");

        jLabel1.setText("Employee ID:");

        jLabel2.setText("Employee Name:");

        jLabel3.setText("NRC No:");

        jLabel4.setText("Gender:");

        jLabel5.setText("Address:");

        jLabel6.setText("Department:");

        jLabel7.setText("Post:");

        jLabel8.setText("Qualification:");

        lblEmployeeName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblEmployeeName.setName("lblEmployeeName"); // NOI18N

        lblEmployeeNRC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblEmployeeNRC.setName("lblEmployeeNRC"); // NOI18N

        lblEmployeeGender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblEmployeeGender.setName("lblEmployeeGender"); // NOI18N

        txtAddress.setName("txtAddress"); // NOI18N

        txtQualification.setName("txtQualification"); // NOI18N

        cboEmployeeDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------Select------", "NCC", "SE", "NE", "Training" }));
        cboEmployeeDepartment.setName("cboEmployeeDepartment"); // NOI18N
        cboEmployeeDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEmployeeDepartmentActionPerformed(evt);
            }
        });

        cboEmployeePost.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------Select------" }));
        cboEmployeePost.setName("cboEmployeePost"); // NOI18N

        cboEmployeeID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------Select------", " " }));
        cboEmployeeID.setName("cboEmployeeID"); // NOI18N
        cboEmployeeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEmployeeIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboEmployeeID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEmployeeNRC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEmployeeGender, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAddress))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboEmployeeDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboEmployeePost, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtQualification)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmployeeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmployeeNRC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmployeeGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboEmployeeDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboEmployeePost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtQualification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 255, 102));

        btnDelete.setText("Delete");
        btnDelete.setName("btnDelete"); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setName("btnUpdate"); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.setName("btnCancel"); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.setName("btnClose"); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnCancel)
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnCancel)
                    .addComponent(btnClose)
                    .addComponent(btnUpdate))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
         if(cboEmployeeID.getSelectedIndex() > 0)
         {
             checkData();
         }
        else
         {
             JOptionPane.showMessageDialog(this , "Please Choose Employee ID to update");
             cboEmployeeID.requestFocus();
         }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       if(cboEmployeeID.getSelectedIndex() > 0)
       {
           if(JOptionPane.showConfirmDialog(this,"Do you really want to delete?", "Delete option",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION)
           {
               deleteRecord();
          
           }
           
       }
       else
       {
            JOptionPane.showMessageDialog(this , "Please Choose Employee ID to update");
             cboEmployeeID.requestFocus();
           
       }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearData();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void cboEmployeeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEmployeeIDActionPerformed
        if(cboEmployeeID.getSelectedIndex()>0)
            fillrecord();
    }//GEN-LAST:event_cboEmployeeIDActionPerformed

    private void cboEmployeeDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEmployeeDepartmentActionPerformed
         if(cboEmployeeDepartment.getSelectedIndex()==1 || cboEmployeeDepartment.getSelectedIndex()==2 || cboEmployeeDepartment.getSelectedIndex()==3)
        {
            cboEmployeePost.removeAllItems();
            cboEmployeePost.addItem("------Select------");
            cboEmployeePost.addItem("Instructor");
            cboEmployeePost.addItem("Demonstrator");
            cboEmployeePost.addItem("Senior Instructor");
            cboEmployeePost.addItem("Incharge");
            cboEmployeePost.addItem("Lecturer");
            cboEmployeePost.addItem("Senior Lecturer");
            cboEmployeePost.addItem("Asst : training manager");
            cboEmployeePost.addItem("Training Manager");
            return;
            
        }
        
        if(cboEmployeeDepartment.getSelectedIndex()==4)
        {
            cboEmployeePost.removeAllItems();
            cboEmployeePost.addItem("------Select------");
            cboEmployeePost.addItem("Instructor");
            
            cboEmployeePost.addItem("Senior Instructor");
            cboEmployeePost.addItem("Incharge");
            cboEmployeePost.addItem("Lecturer");
            cboEmployeePost.addItem("Senior Lecturer");
            cboEmployeePost.addItem("Asst : training manager");
            cboEmployeePost.addItem("Training Manager");
            return;
        }
        
        if(cboEmployeeDepartment.getSelectedIndex()== 0)
        {
         cboEmployeePost.removeAllItems();
         cboEmployeePost.addItem("Select");
        }
    }//GEN-LAST:event_cboEmployeeDepartmentActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EmployeeUpdate dialog = new EmployeeUpdate(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboEmployeeDepartment;
    private javax.swing.JComboBox<String> cboEmployeeID;
    private javax.swing.JComboBox<String> cboEmployeePost;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel lblEmployeeGender;
    private javax.swing.JLabel lblEmployeeNRC;
    private javax.swing.JLabel lblEmployeeName;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtQualification;
    // End of variables declaration//GEN-END:variables
}
