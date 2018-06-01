/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.view.dialog;

import br.carmaker.model.JConstants;
import br.carmaker.model.JDbFacade;
import br.carmaker.model.JFeedstock;
import br.carmaker.model.JSupplier;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Usuário
 */
public class FeedstockDialog extends javax.swing.JPanel {

    /**
     * Creates new form FeedstockDialog
     */
    public FeedstockDialog(JDialog registerDialog, JFrame parent) {
        initComponents();
        this.registerDialog = registerDialog;
        this.parent = parent;
        creating = true;
        initSuppliersList();
    }

    public FeedstockDialog(JDialog registerDialog, JFrame parent, JFeedstock feedstock) {
        initComponents();
        this.registerDialog = registerDialog;
        this.parent = parent;
        creating = false;
        initSuppliersList();
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
        jLabel1 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        spnAmount = new javax.swing.JSpinner();
        tfPrice = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAvailable = new javax.swing.JList<>();
        btnSelectSupplier = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnRemoveSupplier = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listSelected = new javax.swing.JList<>();
        panelFooter = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        jLabel1.setText("Nome: ");

        jLabel2.setText("Quantidade por Lote: ");

        jLabel3.setText("Preço por lote: ");

        spnAmount.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        spnAmount.setRequestFocusEnabled(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fornecedores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 1, 12))); // NOI18N

        jLabel4.setText("Disponíveis:");

        listAvailable.setModel(dlmAvailable);
        listAvailable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listAvailable);

        btnSelectSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnSelectSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSelectSupplierMouseClicked(evt);
            }
        });

        jLabel5.setText("Selecionados:");

        btnRemoveSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/remove.png"))); // NOI18N
        btnRemoveSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveSupplierMouseClicked(evt);
            }
        });

        listSelected.setModel(dlmSelected);
        listSelected.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listSelected);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSelectSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemoveSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnRemoveSupplier, btnSelectSupplier});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnSelectSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemoveSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnRemoveSupplier, btnSelectSupplier});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPrice)
                            .addComponent(spnAmount)
                            .addComponent(tfName))
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spnAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelFooter.setBackground(new java.awt.Color(37, 37, 39));

        btnSave.setBackground(new java.awt.Color(76, 139, 244));
        btnSave.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnSave.setText("Salvar");
        btnSave.setBorder(null);
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelFooterLayout = new javax.swing.GroupLayout(panelFooter);
        panelFooter.setLayout(panelFooterLayout);
        panelFooterLayout.setHorizontalGroup(
            panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFooterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel)
                .addGap(21, 21, 21))
        );
        panelFooterLayout.setVerticalGroup(
            panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFooterLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelFooter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panelFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        String name = tfName.getText();
        String amount = spnAmount.getValue().toString();
        String price = tfPrice.getText();

        if (validation(new JFeedstock(), 0)) {
            JFeedstock feedstock = new JFeedstock();

            //JDbFacade.getInstance().createFeedstock(feedstock);
        } else {
            MessageDialog.showMessage(JConstants.LABEL_ALL_FIELDS_REQUIRED, this);
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        registerDialog.dispose();
        parent.setEnabled(true);
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnSelectSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectSupplierMouseClicked
        if(listSelected.getModel().getSize() == 2){
            MessageDialog.showMessage(JConstants.LABEL_TWO_SUPPLIERS_ONLY, this);
        }else{
            int index = listAvailable.getSelectedIndex();
            if(index != -1){
                addSupplier(index);
            }else{
                MessageDialog.showMessage(JConstants.LABEL_NO_ITEM_SELECTED, this);
            }
        }
    }//GEN-LAST:event_btnSelectSupplierMouseClicked

    private void btnRemoveSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveSupplierMouseClicked
        int index = listSelected.getSelectedIndex();
        if(index != -1){
            removeSupplier(index);
        }else{
            MessageDialog.showMessage(JConstants.LABEL_NO_ITEM_SELECTED, this);
        }
    }//GEN-LAST:event_btnRemoveSupplierMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRemoveSupplier;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSelectSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listAvailable;
    private javax.swing.JList<String> listSelected;
    private javax.swing.JPanel panelFooter;
    private javax.swing.JSpinner spnAmount;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPrice;
    // End of variables declaration//GEN-END:variables

    private final JDialog registerDialog;
    private final JFrame parent;
    private JFeedstock feedstock;
    private boolean creating = true;
    private List<JSupplier> availableSp;
    private List<JSupplier> selectedSp;
    private DefaultListModel dlmAvailable = new DefaultListModel();
    private DefaultListModel dlmSelected = new DefaultListModel();
    
    private boolean validation(JFeedstock feedstock, int id) {
        if(feedstock.getName().trim().length() == 0 || feedstock.getCost() == 0
                || feedstock.getQuantity() == 0){
            MessageDialog.showMessage(JConstants.LABEL_ALL_FIELDS_REQUIRED, this);
            return false;
        }
        
        if(feedstock.getSuppliers().isEmpty()){
            MessageDialog.showMessage(JConstants.LABEL_NEED_ONE_SUPPLIER, this);
            return false;
        }
        return true;
    }

    private void initSuppliersList() {
        dlmAvailable = (DefaultListModel) listAvailable.getModel();
        dlmAvailable.clear();
        
        availableSp = JDbFacade.getInstance().readAllSuppliers();
        selectedSp = new ArrayList<>();
        
        if(availableSp != null){
            for (int i = 0; i < availableSp.size(); i++) {
                dlmAvailable.addElement(availableSp.get(i).getName());
            }
        }
        listAvailable.setModel(dlmAvailable);
    }
    
    private void addSupplier(int index){
        selectedSp.add(availableSp.get(index));
        availableSp.remove(index);
        
        dlmSelected = (DefaultListModel) listSelected.getModel();
        dlmAvailable = (DefaultListModel) listAvailable.getModel();
        
        dlmSelected.clear();
        dlmAvailable.clear();
        
        for (int i = 0; i < availableSp.size(); i++) {
            dlmAvailable.addElement(availableSp.get(i).getName());
        }
        
        for (int i = 0; i < selectedSp.size(); i++) {
            dlmSelected.addElement(selectedSp.get(i).getName());
        }
        
        listSelected.setModel(dlmSelected);
        listAvailable.setModel(dlmAvailable);
    }
    
    private void removeSupplier(int index){
        availableSp.add(selectedSp.get(index));
        selectedSp.remove(index);
        
        dlmSelected = (DefaultListModel) listSelected.getModel();
        dlmAvailable = (DefaultListModel) listAvailable.getModel();
        
        dlmSelected.clear();
        dlmAvailable.clear();
        
        for (int i = 0; i < selectedSp.size(); i++) {
            dlmSelected.addElement(selectedSp.get(i).getName());
        }
        
        for (int i = 0; i < availableSp.size(); i++) {
            dlmAvailable.addElement(availableSp.get(i).getName());
        }
        
        listSelected.setModel(dlmSelected);
        listAvailable.setModel(dlmAvailable);
    }
}
