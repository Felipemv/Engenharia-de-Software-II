/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.view.dialog;

import br.carmaker.model.util.JConstants;
import br.carmaker.model.JDbFacade;
import br.carmaker.model.JDealership;
import br.carmaker.model.JShippingCompany;
import br.carmaker.model.JSupplier;
import br.carmaker.model.abstracts.AAffiliate;
import br.carmaker.model.enums.EAffiliate;
import br.carmaker.model.enums.EDealershipType;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Usuário
 */
public class AffiliateDialog extends javax.swing.JPanel {

    /**
     * Creates new form AffiliateDialog
     */
    public AffiliateDialog(JDialog registerDialog, JFrame parent) {
        initComponents();
        this.registerDialog = registerDialog;
        this.parent = parent;
        this.creating = true;
    }

    public AffiliateDialog(JDialog registerDialog, JFrame parent, AAffiliate affiliate, EAffiliate entityType) {
        initComponents();
        this.registerDialog = registerDialog;
        this.parent = parent;
        this.affiliate = affiliate;
        this.entityType = entityType;
        this.creating = false;
        setEntity();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgDealershipType = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        panelFooter = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbType = new javax.swing.JComboBox<>();
        tfCnpj = new javax.swing.JTextField();
        tfAddress = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        panelView = new javax.swing.JPanel();
        panelSupplier = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        spnLeadTime = new javax.swing.JSpinner();
        panelShippingCompany = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        spnAmount = new javax.swing.JSpinner();
        spnFleet = new javax.swing.JSpinner();
        panelDealership = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        rbGeneral = new javax.swing.JRadioButton();
        rbExclusive = new javax.swing.JRadioButton();
        cbSCompany = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setText("Nome: ");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setText("Endereço: ");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setText("CNPJ: ");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setText("TIpo de Afiliada : ");

        cbType.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        cbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fornecedor", "Transportadora", "Concessionária" }));
        cbType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTypeActionPerformed(evt);
            }
        });

        tfCnpj.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        tfAddress.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        tfName.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfAddress, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfCnpj, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbType, javax.swing.GroupLayout.Alignment.TRAILING, 0, 549, Short.MAX_VALUE)
                    .addComponent(tfName))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        panelView.setLayout(new java.awt.CardLayout());

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setText("Lead time: ");

        spnLeadTime.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout panelSupplierLayout = new javax.swing.GroupLayout(panelSupplier);
        panelSupplier.setLayout(panelSupplierLayout);
        panelSupplierLayout.setHorizontalGroup(
            panelSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                .addComponent(spnLeadTime, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelSupplierLayout.setVerticalGroup(
            panelSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(spnLeadTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        panelView.add(panelSupplier, "card2");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("Quantidade por entrega: ");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel7.setText("Tamanho da frota: ");

        spnAmount.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spnFleet.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout panelShippingCompanyLayout = new javax.swing.GroupLayout(panelShippingCompany);
        panelShippingCompany.setLayout(panelShippingCompanyLayout);
        panelShippingCompanyLayout.setHorizontalGroup(
            panelShippingCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShippingCompanyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShippingCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(18, 38, Short.MAX_VALUE)
                .addGroup(panelShippingCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spnAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                    .addComponent(spnFleet))
                .addContainerGap())
        );
        panelShippingCompanyLayout.setVerticalGroup(
            panelShippingCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShippingCompanyLayout.createSequentialGroup()
                .addGroup(panelShippingCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spnAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelShippingCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(spnFleet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 170, Short.MAX_VALUE))
        );

        panelView.add(panelShippingCompany, "card3");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel8.setText("Tipo: ");

        bgDealershipType.add(rbGeneral);
        rbGeneral.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        rbGeneral.setSelected(true);
        rbGeneral.setText("Geral");

        bgDealershipType.add(rbExclusive);
        rbExclusive.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        rbExclusive.setText("Exclusiva");

        cbSCompany.setModel(cbmSCompany);
        cbSCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSCompanyActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel9.setText("Transportadora: ");

        javax.swing.GroupLayout panelDealershipLayout = new javax.swing.GroupLayout(panelDealership);
        panelDealership.setLayout(panelDealershipLayout);
        panelDealershipLayout.setHorizontalGroup(
            panelDealershipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDealershipLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDealershipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDealershipLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelDealershipLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)))
                .addGroup(panelDealershipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDealershipLayout.createSequentialGroup()
                        .addComponent(rbGeneral)
                        .addGap(18, 18, 18)
                        .addComponent(rbExclusive))
                    .addComponent(cbSCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelDealershipLayout.setVerticalGroup(
            panelDealershipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDealershipLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDealershipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rbGeneral)
                    .addComponent(rbExclusive))
                .addGap(18, 18, 18)
                .addGroup(panelDealershipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        panelView.add(panelDealership, "card4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(panelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panelFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        int selection = cbType.getSelectedIndex();

        switch (selection) {
            case 0:
                if (creating) {
                    saveSupplier();
                } else {
                    editSupplier();
                }
                break;
            case 1:
                if (creating) {
                    saveShippingCompany();
                } else {
                    editShippingCompany();
                }
                break;
            case 2:
                if (creating) {
                    saveDealership();
                } else {
                    editDealership();
                }
                break;
            default:
                MessageDialog.showMessage(JConstants.LABEL_NO_AFFILIATE_SELECTED, this);
                break;
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        registerDialog.dispose();
        parent.setEnabled(true);
    }//GEN-LAST:event_btnCancelMouseClicked

    private void cbTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTypeActionPerformed
        changeCard();
    }//GEN-LAST:event_cbTypeActionPerformed

    private void cbSCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSCompanyActionPerformed
        int index = cbSCompany.getSelectedIndex();
        
        if(index != -1){
            sc = listSC.get(index);
        }
    }//GEN-LAST:event_cbSCompanyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgDealershipType;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbSCompany;
    private javax.swing.JComboBox<String> cbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelDealership;
    private javax.swing.JPanel panelFooter;
    private javax.swing.JPanel panelShippingCompany;
    private javax.swing.JPanel panelSupplier;
    private javax.swing.JPanel panelView;
    private javax.swing.JRadioButton rbExclusive;
    private javax.swing.JRadioButton rbGeneral;
    private javax.swing.JSpinner spnAmount;
    private javax.swing.JSpinner spnFleet;
    private javax.swing.JSpinner spnLeadTime;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfCnpj;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables

    private final JDialog registerDialog;
    private final JFrame parent;
    private boolean creating = true;
    private EAffiliate entityType;
    private AAffiliate affiliate;
    private JSupplier supplier;
    private JShippingCompany shippingCompany;
    private JDealership dealership;
    private DefaultComboBoxModel<String> cbmSCompany = new DefaultComboBoxModel<>();
    private List<JShippingCompany> listSC = new ArrayList<>();
    private JShippingCompany sc;

    private void saveSupplier() {
        supplier = new JSupplier();

        supplier.setName(tfName.getText());
        supplier.setAddress(tfAddress.getText());
        supplier.setCnpj(tfCnpj.getText());
        supplier.setLeadTime((int) spnLeadTime.getValue());

        if (supplierValidation()) {
            if (JDbFacade.getInstance().createSupplier(supplier)) {
                MessageDialog.showMessage(JConstants.SUCCESS_CREATE_SUPPLIER, this);
                registerDialog.dispose();
                parent.setEnabled(true);
            } else {
                MessageDialog.showMessage(JConstants.FAILURE_CREATE_SUPPLIER, this);
            }
        }
    }

    private void saveShippingCompany() {
        shippingCompany = new JShippingCompany();

        shippingCompany.setName(tfName.getText());
        shippingCompany.setAddress(tfAddress.getText());
        shippingCompany.setCnpj(tfCnpj.getText());
        shippingCompany.setAmount((int) spnAmount.getValue());
        shippingCompany.setFleet((int) spnFleet.getValue());

        if (shippingCompanyValidation()) {
            if (JDbFacade.getInstance().createShippingCompany(shippingCompany)) {
                MessageDialog.showMessage(JConstants.SUCCESS_CREATE_SHIPPING_COMPANY, this);
                registerDialog.dispose();
                parent.setEnabled(true);
            } else {
                MessageDialog.showMessage(JConstants.FAILURE_CREATE_SHIPPING_COMPANY, this);
            }
        }
    }

    private void saveDealership() {
        dealership = new JDealership();

        dealership.setName(tfName.getText());
        dealership.setAddress(tfAddress.getText());
        dealership.setCnpj(tfCnpj.getText());
        dealership.setShippingCompany(sc);

        if (rbGeneral.isSelected()) {
            dealership.setType(EDealershipType.GENERAL);
        } else if (rbExclusive.isSelected()) {
            dealership.setType(EDealershipType.EXCLUSIVE);
        }
        if (dealershipValidation()) {
            if (JDbFacade.getInstance().createDealership(dealership)) {
                MessageDialog.showMessage(JConstants.SUCCESS_CREATE_DEALERSHIP, this);
                registerDialog.dispose();
                parent.setEnabled(true);
            } else {
                MessageDialog.showMessage(JConstants.FAILURE_CREATE_DEALERSHIP, this);
            }
        }
    }

    private void editSupplier() {
        supplier.setName(tfName.getText());
        supplier.setAddress(tfAddress.getText());
        supplier.setCnpj(tfCnpj.getText());
        supplier.setLeadTime((int) spnLeadTime.getValue());

        if (supplierValidation()) {
            if (JDbFacade.getInstance().editSupplier(supplier)) {
                MessageDialog.showMessage(JConstants.SUCCESS_EDIT_SUPPLIER, this);
                registerDialog.dispose();
                parent.setEnabled(true);
            } else {
                MessageDialog.showMessage(JConstants.FAILURE_EDIT_SUPPLIER, this);
            }
        }
    }

    private void editShippingCompany() {
        shippingCompany.setName(tfName.getText());
        shippingCompany.setAddress(tfAddress.getText());
        shippingCompany.setCnpj(tfCnpj.getText());

        if (shippingCompanyValidation()) {
            if (JDbFacade.getInstance().editShippingCompany(shippingCompany)) {
                MessageDialog.showMessage(JConstants.SUCCESS_EDIT_SHIPPING_COMPANY, this);
                registerDialog.dispose();
                parent.setEnabled(true);
            } else {
                MessageDialog.showMessage(JConstants.FAILURE_EDIT_SHIPPING_COMPANY, this);
            }
        }
    }

    private void editDealership() {
        dealership.setName(tfName.getText());
        dealership.setAddress(tfAddress.getText());
        dealership.setCnpj(tfCnpj.getText());
        dealership.setShippingCompany(sc);

        if (rbGeneral.isSelected()) {
            dealership.setType(EDealershipType.GENERAL);
        } else if (rbExclusive.isSelected()) {
            dealership.setType(EDealershipType.EXCLUSIVE);
        }
        if (dealershipValidation()) {
            if (JDbFacade.getInstance().editDealership(dealership)) {
                MessageDialog.showMessage(JConstants.SUCCESS_EDIT_DEALERSHIP, this);
                registerDialog.dispose();
                parent.setEnabled(true);
            } else {
                MessageDialog.showMessage(JConstants.FAILURE_EDIT_DEALERSHIP, this);
            }
        }
    }

    private boolean supplierValidation() {
        if (supplier.getName().trim().length() == 0
                || supplier.getAddress().trim().length() == 0
                || supplier.getCnpj().trim().length() == 0
                || supplier.getLeadTime() == 0) {
            MessageDialog.showMessage(JConstants.LABEL_ALL_FIELDS_REQUIRED, this);
            return false;
        }
        return true;
    }

    private boolean shippingCompanyValidation() {
        if (shippingCompany.getName().trim().length() == 0
                || shippingCompany.getAddress().trim().length() == 0
                || shippingCompany.getCnpj().trim().length() == 0
                || shippingCompany.getAmount() == 0
                || shippingCompany.getFleet() == 0) {
            MessageDialog.showMessage(JConstants.LABEL_ALL_FIELDS_REQUIRED, this);
            return false;
        }
        return true;
    }

    private boolean dealershipValidation() {
        if (dealership.getName().trim().length() == 0
                || dealership.getAddress().trim().length() == 0
                || dealership.getCnpj().trim().length() == 0
                || dealership.getType() == null
                || dealership.getShippingCompany() == null) {
            MessageDialog.showMessage(JConstants.LABEL_ALL_FIELDS_REQUIRED, this);
            return false;
        }
        return true;
    }

    private void setEntity() {
        switch (entityType) {
            case SUPPLIER:
                setSupplier();
                break;
            case SHIPPING_COMPANY:
                setShippingCompany();
                break;
            case DEALERSHIP:
                setDealership();
                break;
        }
        cbType.setEnabled(false);
        changeCard();
    }

    private void setSupplier() {
        cbType.setSelectedIndex(0);
        supplier = (JSupplier) affiliate;

        tfName.setText(supplier.getName());
        tfAddress.setText(supplier.getAddress());
        tfCnpj.setText(supplier.getCnpj());
        spnLeadTime.setValue(supplier.getLeadTime());
    }

    private void setShippingCompany() {
        cbType.setSelectedIndex(1);
        shippingCompany = (JShippingCompany) affiliate;

        tfName.setText(shippingCompany.getName());
        tfAddress.setText(shippingCompany.getAddress());
        tfCnpj.setText(shippingCompany.getCnpj());
        spnAmount.setValue(shippingCompany.getAmount());
        spnFleet.setValue(shippingCompany.getFleet());
    }

    private void setDealership() {
        cbType.setSelectedIndex(2);
        dealership = (JDealership) affiliate;

        tfName.setText(dealership.getName());
        tfAddress.setText(dealership.getAddress());
        tfCnpj.setText(dealership.getCnpj());

        if (dealership.getType() == EDealershipType.EXCLUSIVE) {
            rbExclusive.setSelected(true);
        } else {
            rbGeneral.setSelected(true);
        }
        
        loadShippingCompanies();
        
        for (int i = 0; i < listSC.size(); i++) {
            if(listSC.get(i).getId() == dealership.getShippingCompany().getId()){
                cbSCompany.setSelectedIndex(i);
                break;
            }
        }
    }

    private void changeCard() {
        int selection = cbType.getSelectedIndex();

        panelView.removeAll();
        switch (selection) {
            case 1:
                panelView.add(panelShippingCompany);
                break;
            case 2:
                panelView.add(panelDealership);
                loadShippingCompanies();
                break;
            default:
                panelView.add(panelSupplier);
                break;
        }
        panelView.repaint();
        panelView.revalidate();
    }

    private void loadShippingCompanies() {
        cbmSCompany = (DefaultComboBoxModel<String>) cbSCompany.getModel();
        cbmSCompany.removeAllElements();
        
        listSC.clear();
        listSC = JDbFacade.getInstance().readAllShippingCompanies();
        
        for (int i = 0; i < listSC.size(); i++) {
            cbmSCompany.addElement(listSC.get(i).getName());
        }
        
        if(!listSC.isEmpty()){
            cbSCompany.setSelectedIndex(0);
            sc = listSC.get(0);
        }
    }
}
