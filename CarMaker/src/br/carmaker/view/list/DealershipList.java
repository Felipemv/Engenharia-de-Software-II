/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.view.list;

import br.carmaker.model.JDealership;
import br.carmaker.model.JShippingCompany;
import br.carmaker.model.enums.EDealershipType;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author felipe
 */
public class DealershipList extends javax.swing.JPanel implements ListCellRenderer<JDealership>{

    /**
     * Creates new form DealershipList
     */
    public DealershipList() {
        initComponents();
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
        lblType = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblCnpj = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();

        lblType.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblType.setText("Tipo");

        lblName.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("Nome");

        lblCnpj.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblCnpj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCnpj.setText("CNPJ");

        lblAddress.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblAddress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddress.setText("Endereço");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(lblCnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(lblAddress)
                    .addComponent(lblCnpj)
                    .addComponent(lblType))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblType;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getListCellRendererComponent(JList<? extends JDealership> list, 
            JDealership value, int index, boolean isSelected, boolean hasFocus) {
       
        lblName.setText(value.getName());
        lblAddress.setText(value.getAddress());
        lblCnpj.setText(value.getCnpj());
        lblType.setText(value.getType().toString());
        
        if(isSelected){
            jPanel1.setBackground(Color.yellow);
        }else{
            jPanel1.setBackground(Color.white);
        }
        
        return this;
    }
}