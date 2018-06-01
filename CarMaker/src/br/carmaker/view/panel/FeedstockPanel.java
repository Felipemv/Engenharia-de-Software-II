/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.view.panel;

import br.carmaker.model.JFeedstock;
import br.carmaker.model.JSupplier;
import br.carmaker.model.enums.EMenuItem;
import br.carmaker.view.dialog.RegisterDialog;
import br.carmaker.view.list.FeedstockList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;

/**
 *
 * @author felipe
 */
public class FeedstockPanel extends javax.swing.JPanel {

    /**
     * Creates new form FeedstockPanel
     */
    public FeedstockPanel(JFrame frame) {
        initComponents();
        //initList();
        this.mainFrame = frame;
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
        jLabel8 = new javax.swing.JLabel();
        btnAddFeedstock = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listFeedstock = new javax.swing.JList<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel8.setText("Lista de Matérias-primas:");

        btnAddFeedstock.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnAddFeedstock.setText("Adicionar nova");
        btnAddFeedstock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddFeedstockMouseClicked(evt);
            }
        });

        listFeedstock.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listFeedstock.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listFeedstockValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listFeedstock);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddFeedstock))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddFeedstock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddFeedstockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddFeedstockMouseClicked
        this.setEnabled(false);
        RegisterDialog dialog = new RegisterDialog(mainFrame, false, 1, EMenuItem.FEEDSTOCK);
        dialog.setVisible(true);

        mainFrame.setEnabled(false);
    }//GEN-LAST:event_btnAddFeedstockMouseClicked

    private void listFeedstockValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listFeedstockValueChanged

    }//GEN-LAST:event_listFeedstockValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFeedstock;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<JFeedstock> listFeedstock;
    // End of variables declaration//GEN-END:variables

    private JFrame mainFrame;

    private void initList() {
        DefaultListModel<JFeedstock> dlm = new DefaultListModel();
        for (int i = 0; i < 10; i++) {
            
        }
        listFeedstock.setModel(dlm);
        listFeedstock.setCellRenderer(new FeedstockList());
    }
}
