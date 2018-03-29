/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.view.dialog;

import br.carmaker.model.enums.EMenuItem;
import java.awt.Frame;
import java.io.File;
import javax.swing.JFrame;

/**
 *
 * @author Usuário
 */
public class RegisterDialog extends javax.swing.JDialog {

    /**
     * Creates new form RegisterDialog
     * @param parent frame que chamou a dialog (MainFrame nesse caso).
     * @param modal indica se a tela que chamou a dialog continuará executando enquanto a dialog está aberta.
     * @param panel indica qual painel do card layout será executado.
     * @param header é o Enum que indica a entidade que será cadastrada ou editada.
     * @param operation é o tipo de operação da tela (0-cadastro, 1-edição).
     */
    public RegisterDialog(JFrame parent, boolean modal, int panel, EMenuItem header, int operation) {
        super(parent, modal);
        initComponents();
        if(operation == 0){
            lblHeader.setText("Cadastro de "+ header.getMenuItem() + ":");
        }else{
            lblHeader.setText("Edição de " + header.getMenuItem() + ":");
        }
        
        this.parent = parent;
        
        employeeDialog = new EmployeeDialog(this, parent);      //Dialog 0
        feedstockDialog = new FeedstockDialog(this, parent);    //Dialog 1
        carDialog = new CarDialog(this, parent);                //Dialog 2
//        affiliateDialog = new AffiliateDialog();    //Dialog 3
//        orderDialog = new OrderDialog();            //Dialog 4
        
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
        panelHeader = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        panelView = new javax.swing.JPanel();
        employeeDialog = new javax.swing.JPanel();
        feedstockDialog = new javax.swing.JPanel();
        carDialog = new javax.swing.JPanel();
        affiliateDialog = new javax.swing.JPanel();
        orderDialog = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelHeader.setBackground(new java.awt.Color(37, 37, 39));

        lblHeader.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(188, 189, 187));
        lblHeader.setText("Cadastrar:");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelView.setBackground(new java.awt.Color(220, 220, 220));
        panelView.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout employeeDialogLayout = new javax.swing.GroupLayout(employeeDialog);
        employeeDialog.setLayout(employeeDialogLayout);
        employeeDialogLayout.setHorizontalGroup(
            employeeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );
        employeeDialogLayout.setVerticalGroup(
            employeeDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );

        panelView.add(employeeDialog, "card2");

        javax.swing.GroupLayout feedstockDialogLayout = new javax.swing.GroupLayout(feedstockDialog);
        feedstockDialog.setLayout(feedstockDialogLayout);
        feedstockDialogLayout.setHorizontalGroup(
            feedstockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );
        feedstockDialogLayout.setVerticalGroup(
            feedstockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );

        panelView.add(feedstockDialog, "card3");

        javax.swing.GroupLayout carDialogLayout = new javax.swing.GroupLayout(carDialog);
        carDialog.setLayout(carDialogLayout);
        carDialogLayout.setHorizontalGroup(
            carDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );
        carDialogLayout.setVerticalGroup(
            carDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );

        panelView.add(carDialog, "card4");

        javax.swing.GroupLayout affiliateDialogLayout = new javax.swing.GroupLayout(affiliateDialog);
        affiliateDialog.setLayout(affiliateDialogLayout);
        affiliateDialogLayout.setHorizontalGroup(
            affiliateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );
        affiliateDialogLayout.setVerticalGroup(
            affiliateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );

        panelView.add(affiliateDialog, "card5");

        javax.swing.GroupLayout orderDialogLayout = new javax.swing.GroupLayout(orderDialog);
        orderDialog.setLayout(orderDialogLayout);
        orderDialogLayout.setHorizontalGroup(
            orderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 796, Short.MAX_VALUE)
        );
        orderDialogLayout.setVerticalGroup(
            orderDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );

        panelView.add(orderDialog, "card6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
                RegisterDialog dialog = new RegisterDialog(new javax.swing.JFrame(), true, 0, EMenuItem.HOME, 0);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel carDialog;
    private javax.swing.JPanel employeeDialog;
    private javax.swing.JPanel feedstockDialog;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JPanel orderDialog;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelView;
    // End of variables declaration//GEN-END:variables

    private Frame parent;
    private File imagem;
        
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
    }    
}
