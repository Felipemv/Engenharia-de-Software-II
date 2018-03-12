/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.view.dialog;

import br.carmaker.model.enums.EMenuItem;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Usuário
 */
public class RegisterDialog extends javax.swing.JDialog {

    /**
     * Creates new form RegisterDialog
     */
    public RegisterDialog(java.awt.Frame parent, boolean modal, int panel) {
        super(parent, modal);
        initComponents();
        
        this.parent = parent;
        
        employeeDialog = new EmployeeDialog();      //Dialog 0
        feedstockDialog = new FeedstockDialog();    //Dialog 1
        carDialog = new CarDialog();                //Dialog 2
        affiliateDialog = new AffiliateDialog();    //Dialog 3
        orderDialog = new OrderDialog();            //Dialog 4
        
        labelList = new ArrayList<>();
        labelList.add(lblEmployee);
        labelList.add(lblFeedstock);
        labelList.add(lblCar);
        labelList.add(lblAffiliate);
        labelList.add(lblOrder);
        
        barList = new ArrayList<>();
        barList.add(lblEmployeeSb);
        barList.add(lblFeedstockSb);
        barList.add(lblCarSb);
        barList.add(lblAffiliateSb);
        barList.add(lblOrderSb);
        
        selectMenuItem(panel);
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
        jPanel3 = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        menuEmployee = new javax.swing.JPanel();
        lblEmployeeSb = new javax.swing.JLabel();
        lblEmployee = new javax.swing.JLabel();
        menuFeedstock = new javax.swing.JPanel();
        lblFeedstockSb = new javax.swing.JLabel();
        lblFeedstock = new javax.swing.JLabel();
        menuCars = new javax.swing.JPanel();
        lblCarSb = new javax.swing.JLabel();
        lblCar = new javax.swing.JLabel();
        menuAffiliates = new javax.swing.JPanel();
        lblAffiliateSb = new javax.swing.JLabel();
        lblAffiliate = new javax.swing.JLabel();
        menuOrders = new javax.swing.JPanel();
        lblOrderSb = new javax.swing.JLabel();
        lblOrder = new javax.swing.JLabel();
        panelView = new javax.swing.JPanel();
        employeeDialog = new javax.swing.JPanel();
        feedstockDialog = new javax.swing.JPanel();
        carDialog = new javax.swing.JPanel();
        affiliateDialog = new javax.swing.JPanel();
        orderDialog = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(220, 220, 220));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(64, 64, 64));

        lblHeader.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(188, 189, 187));
        lblHeader.setText("Cadastrar:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(504, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 60));

        jPanel4.setBackground(new java.awt.Color(64, 64, 64));

        btnSave.setBackground(new java.awt.Color(76, 139, 244));
        btnSave.setText("Salvar");
        btnSave.setBorder(null);
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(611, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel)
                .addGap(21, 21, 21))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancel, btnSave});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel))
                .addGap(24, 24, 24))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 800, 80));

        jPanel5.setBackground(new java.awt.Color(37, 37, 39));

        menuEmployee.setOpaque(false);
        menuEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEmployeeMouseClicked(evt);
            }
        });

        lblEmployeeSb.setBackground(new java.awt.Color(185, 62, 31));
        lblEmployeeSb.setForeground(new java.awt.Color(185, 62, 31));
        lblEmployeeSb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmployeeSb.setOpaque(true);

        lblEmployee.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblEmployee.setForeground(new java.awt.Color(185, 62, 31));
        lblEmployee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEmployee.setText("Cadastro de Funcionários");

        javax.swing.GroupLayout menuEmployeeLayout = new javax.swing.GroupLayout(menuEmployee);
        menuEmployee.setLayout(menuEmployeeLayout);
        menuEmployeeLayout.setHorizontalGroup(
            menuEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEmployeeLayout.createSequentialGroup()
                .addComponent(lblEmployeeSb, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuEmployeeLayout.setVerticalGroup(
            menuEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEmployeeSb, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(lblEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menuFeedstock.setOpaque(false);
        menuFeedstock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuFeedstockMouseClicked(evt);
            }
        });

        lblFeedstockSb.setBackground(new java.awt.Color(185, 62, 31));
        lblFeedstockSb.setForeground(new java.awt.Color(185, 62, 31));
        lblFeedstockSb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFeedstockSb.setOpaque(true);

        lblFeedstock.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblFeedstock.setForeground(new java.awt.Color(188, 189, 187));
        lblFeedstock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFeedstock.setText("Cadastro de Matéria-Prima");

        javax.swing.GroupLayout menuFeedstockLayout = new javax.swing.GroupLayout(menuFeedstock);
        menuFeedstock.setLayout(menuFeedstockLayout);
        menuFeedstockLayout.setHorizontalGroup(
            menuFeedstockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuFeedstockLayout.createSequentialGroup()
                .addComponent(lblFeedstockSb, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFeedstock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuFeedstockLayout.setVerticalGroup(
            menuFeedstockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFeedstockSb, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(lblFeedstock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menuCars.setOpaque(false);
        menuCars.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCarsMouseClicked(evt);
            }
        });

        lblCarSb.setBackground(new java.awt.Color(185, 62, 31));
        lblCarSb.setForeground(new java.awt.Color(185, 62, 31));
        lblCarSb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCarSb.setOpaque(true);

        lblCar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblCar.setForeground(new java.awt.Color(188, 189, 187));
        lblCar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCar.setText("Cadastro de Carros");

        javax.swing.GroupLayout menuCarsLayout = new javax.swing.GroupLayout(menuCars);
        menuCars.setLayout(menuCarsLayout);
        menuCarsLayout.setHorizontalGroup(
            menuCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuCarsLayout.createSequentialGroup()
                .addComponent(lblCarSb, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuCarsLayout.setVerticalGroup(
            menuCarsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCarSb, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(lblCar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menuAffiliates.setOpaque(false);
        menuAffiliates.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAffiliatesMouseClicked(evt);
            }
        });

        lblAffiliateSb.setBackground(new java.awt.Color(185, 62, 31));
        lblAffiliateSb.setForeground(new java.awt.Color(185, 62, 31));
        lblAffiliateSb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAffiliateSb.setOpaque(true);

        lblAffiliate.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblAffiliate.setForeground(new java.awt.Color(188, 189, 187));
        lblAffiliate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAffiliate.setText("Cadastro de Afiliados");

        javax.swing.GroupLayout menuAffiliatesLayout = new javax.swing.GroupLayout(menuAffiliates);
        menuAffiliates.setLayout(menuAffiliatesLayout);
        menuAffiliatesLayout.setHorizontalGroup(
            menuAffiliatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuAffiliatesLayout.createSequentialGroup()
                .addComponent(lblAffiliateSb, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAffiliate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuAffiliatesLayout.setVerticalGroup(
            menuAffiliatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAffiliateSb, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(lblAffiliate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menuOrders.setOpaque(false);
        menuOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuOrdersMouseClicked(evt);
            }
        });

        lblOrderSb.setBackground(new java.awt.Color(185, 62, 31));
        lblOrderSb.setForeground(new java.awt.Color(185, 62, 31));
        lblOrderSb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOrderSb.setOpaque(true);

        lblOrder.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblOrder.setForeground(new java.awt.Color(188, 189, 187));
        lblOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOrder.setText("Cadastro de Pedidos");

        javax.swing.GroupLayout menuOrdersLayout = new javax.swing.GroupLayout(menuOrders);
        menuOrders.setLayout(menuOrdersLayout);
        menuOrdersLayout.setHorizontalGroup(
            menuOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuOrdersLayout.createSequentialGroup()
                .addComponent(lblOrderSb, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuOrdersLayout.setVerticalGroup(
            menuOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOrderSb, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addComponent(lblOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuFeedstock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuCars, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuAffiliates, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(menuEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuFeedstock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuCars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuAffiliates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 200, 470));

        panelView.setBackground(new java.awt.Color(220, 220, 220));
        panelView.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout employeeDialogLayout = new javax.swing.GroupLayout(employeeDialog);
        employeeDialog.setLayout(employeeDialogLayout);
        employeeDialogLayout.setHorizontalGroup(
            employeeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        employeeDialogLayout.setVerticalGroup(
            employeeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        panelView.add(employeeDialog, "card2");

        javax.swing.GroupLayout feedstockDialogLayout = new javax.swing.GroupLayout(feedstockDialog);
        feedstockDialog.setLayout(feedstockDialogLayout);
        feedstockDialogLayout.setHorizontalGroup(
            feedstockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        feedstockDialogLayout.setVerticalGroup(
            feedstockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        panelView.add(feedstockDialog, "card3");

        javax.swing.GroupLayout carDialogLayout = new javax.swing.GroupLayout(carDialog);
        carDialog.setLayout(carDialogLayout);
        carDialogLayout.setHorizontalGroup(
            carDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        carDialogLayout.setVerticalGroup(
            carDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        panelView.add(carDialog, "card4");

        javax.swing.GroupLayout affiliateDialogLayout = new javax.swing.GroupLayout(affiliateDialog);
        affiliateDialog.setLayout(affiliateDialogLayout);
        affiliateDialogLayout.setHorizontalGroup(
            affiliateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        affiliateDialogLayout.setVerticalGroup(
            affiliateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        panelView.add(affiliateDialog, "card5");

        javax.swing.GroupLayout orderDialogLayout = new javax.swing.GroupLayout(orderDialog);
        orderDialog.setLayout(orderDialogLayout);
        orderDialogLayout.setHorizontalGroup(
            orderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        orderDialogLayout.setVerticalGroup(
            orderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        panelView.add(orderDialog, "card6");

        jPanel1.add(panelView, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 600, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
//        String name = tfName.getText();
//        String email = tfEmail.getText();
//        String confirmEmail = tfConfirmEmail.getText();
//        String password = Arrays.toString(pfPassword.getPassword());
//        String confirmPassword = Arrays.toString(pfConfirmPassword.getPassword());
//        String address = tfAddress.getText();
//        String phone = tfPhone.getText();
//        String register = tfRegister.getText();
//        EEmployeeType role = rbManager.isSelected() ? EEmployeeType.valueAt(1) : 
//                EEmployeeType.valueAt(0);
//        
//        if(validation()){
//            JEmployee employee = new JEmployee();
//            employee.setName(name);
//            employee.setEmail(email);
//            employee.setPassword(password);
//            employee.setAddress(address);
//            employee.setPhone(phone);
//            employee.setRegisterNumber(register);
//            employee.setRole(role);
//            employee.setPhoto(getImage());
//            
//            JDbFacade.getInstance().insertEmployee(employee);
//        }else{
//            MessageDialog dialog = new MessageDialog(null, false);
//            dialog.configurarDialog("Todos os campos são obrigatórios!");
//            this.setEnabled(false);
//            dialog.setVisible(true);
//        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void menuEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuEmployeeMouseClicked
        selectMenuItem(0);  
    }//GEN-LAST:event_menuEmployeeMouseClicked

    private void menuFeedstockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuFeedstockMouseClicked
        selectMenuItem(1);
    }//GEN-LAST:event_menuFeedstockMouseClicked

    private void menuCarsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCarsMouseClicked
        selectMenuItem(2);
    }//GEN-LAST:event_menuCarsMouseClicked

    private void menuAffiliatesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAffiliatesMouseClicked
        selectMenuItem(3);
    }//GEN-LAST:event_menuAffiliatesMouseClicked

    private void menuOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuOrdersMouseClicked
        selectMenuItem(4);
    }//GEN-LAST:event_menuOrdersMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        this.dispose();
        parent.setEnabled(true);
    }//GEN-LAST:event_btnCancelMouseClicked

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
            java.util.logging.Logger.getLogger(RegisterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RegisterDialog dialog = new RegisterDialog(new javax.swing.JFrame(), true, 0);
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
    private javax.swing.JPanel affiliateDialog;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel carDialog;
    private javax.swing.JPanel employeeDialog;
    private javax.swing.JPanel feedstockDialog;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblAffiliate;
    private javax.swing.JLabel lblAffiliateSb;
    private javax.swing.JLabel lblCar;
    private javax.swing.JLabel lblCarSb;
    private javax.swing.JLabel lblEmployee;
    private javax.swing.JLabel lblEmployeeSb;
    private javax.swing.JLabel lblFeedstock;
    private javax.swing.JLabel lblFeedstockSb;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblOrderSb;
    private javax.swing.JPanel menuAffiliates;
    private javax.swing.JPanel menuCars;
    private javax.swing.JPanel menuEmployee;
    private javax.swing.JPanel menuFeedstock;
    private javax.swing.JPanel menuOrders;
    private javax.swing.JPanel orderDialog;
    private javax.swing.JPanel panelView;
    // End of variables declaration//GEN-END:variables

    private Frame parent;
    
    private List<JLabel> labelList;
    private List<JLabel> barList;
    
    private void selectMenuItem(int panel) {
        panelView.removeAll();
           
            switch(panel){
                case 0:
                    panelView.add(employeeDialog);
                    break;                    
                case 1:
                    panelView.add(feedstockDialog);                    
                    break;                    
                case 2:
                    panelView.add(carDialog);
                    break;                    
                case 3:
                    panelView.add(affiliateDialog);
                    break;                    
                case 4:
                    panelView.add(orderDialog);
                    break;                    
                default:
                    break;
            }
        panelView.repaint();
        panelView.revalidate();
        lightMenuItem(panel);
    }
    
    private void lightMenuItem(int panel){
        for (int i = 0; i < labelList.size(); i++) {
            if(i == panel){
                labelList.get(i).setForeground(new java.awt.Color(185, 62, 31));
                barList.get(i).setBackground(new java.awt.Color(185, 62, 31));
                barList.get(i).setOpaque(true);
            }else{
                labelList.get(i).setForeground(new java.awt.Color(188, 189, 187));
                barList.get(i).setForeground(new java.awt.Color(37,37,39));
                barList.get(i).setOpaque(false);
            }
        }
    }
}
