/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.view.dialog;

import br.carmaker.model.JDbFacade;
import br.carmaker.model.JEmployee;
import br.carmaker.model.dao.JEmployeeDAO;
import br.carmaker.model.enums.EEmployeeType;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Usuário
 */
public class EmployeeDialog extends javax.swing.JPanel {

    private boolean creating = true;

    /**
     * Creates new form employeeDialog
     *
     * @param registerDialog
     */
    public EmployeeDialog(JDialog registerDialog, JFrame parent) {
        initComponents();
        this.registerDialog = registerDialog;
        this.parent = parent;
        creating = true;
    }

    public EmployeeDialog(JDialog registerDialog, JFrame parent, JEmployee employee) {
        initComponents();
        this.registerDialog = registerDialog;
        this.parent = parent;
        this.employee = employee;

        setEmployee(employee);
        creating = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        photoPanel = new javax.swing.JPanel();
        lblEmployeePhoto = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        tfConfirmEmail = new javax.swing.JTextField();
        pfPassword = new javax.swing.JPasswordField();
        pfConfirmPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfAddress = new javax.swing.JTextField();
        tfPhone = new javax.swing.JTextField();
        tfRegister = new javax.swing.JTextField();
        rbManager = new javax.swing.JRadioButton();
        rbEmployee = new javax.swing.JRadioButton();
        addPhoto = new javax.swing.JButton();
        panelFooter = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(220, 220, 220));

        photoPanel.setBackground(new java.awt.Color(226, 229, 235));

        lblEmployeePhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user_default.png"))); // NOI18N

        javax.swing.GroupLayout photoPanelLayout = new javax.swing.GroupLayout(photoPanel);
        photoPanel.setLayout(photoPanelLayout);
        photoPanelLayout.setHorizontalGroup(
            photoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEmployeePhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        photoPanelLayout.setVerticalGroup(
            photoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEmployeePhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(220, 220, 220));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setText("Nome: ");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setText("Email:");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel4.setText("Confirmar email: ");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel5.setText("Senha:");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel6.setText("Confirmar Senha:");

        tfName.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        tfEmail.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        tfConfirmEmail.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        pfPassword.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        pfConfirmPassword.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfConfirmEmail)
                    .addComponent(tfEmail)
                    .addComponent(pfPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addComponent(pfConfirmPassword)
                    .addComponent(tfName))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfConfirmEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pfConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel7.setText("Endereço");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel8.setText("Telefone: ");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setText("Registro:");

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel10.setText("Cargo:");

        tfAddress.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        tfPhone.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        tfRegister.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        rbManager.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        rbManager.setText("Gerente");

        rbEmployee.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        rbEmployee.setText("Vendedor");

        addPhoto.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        addPhoto.setText("Adicionar Foto");
        addPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPhotoMouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbManager)
                        .addGap(18, 18, 18)
                        .addComponent(rbEmployee))
                    .addComponent(tfAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                    .addComponent(tfPhone)
                    .addComponent(tfRegister))
                .addGap(44, 44, 44))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(photoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addComponent(jSeparator1)
            .addComponent(panelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(photoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addPhoto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rbManager)
                    .addComponent(rbEmployee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addPhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPhotoMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens", "png");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        fileChooser.setCurrentDirectory(new File("C:\\Users\\Usuário\\Desktop"));
        fileChooser.showOpenDialog(this);

        image = fileChooser.getSelectedFile();
        setUserImage(image);
    }//GEN-LAST:event_addPhotoMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        if(creating){
            employee = new JEmployee();
        }
        employee.setName(tfName.getText());
        employee.setEmail(tfEmail.getText());
        employee.setPassword(new String(pfPassword.getPassword()));
        employee.setAddress(tfAddress.getText());
        employee.setPhone(tfPhone.getText());
        employee.setRegisterNumber(tfRegister.getText());
        employee.setPhoto(getImage());

        if (rbManager.isSelected()) {
            employee.setRole(EEmployeeType.Manager);
        } else if (rbEmployee.isSelected()) {
            employee.setRole(EEmployeeType.Employee);
        }

        String confirmEmail = tfConfirmEmail.getText();
        String confirmPassword = new String(pfConfirmPassword.getPassword());

        if (validation(employee, confirmEmail, confirmPassword)) {
            if (creating) {
                if (JDbFacade.getInstance().createEmployee(employee, this)) {
                    registerDialog.dispose();
                    parent.setEnabled(true);
                }
            } else {
                JEmployeeDAO.editEmployee(employee);
                registerDialog.dispose();
                parent.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        registerDialog.dispose();
        parent.setEnabled(true);
    }//GEN-LAST:event_btnCancelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPhoto;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEmployeePhoto;
    private javax.swing.JPanel panelFooter;
    private javax.swing.JPasswordField pfConfirmPassword;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JPanel photoPanel;
    private javax.swing.JRadioButton rbEmployee;
    private javax.swing.JRadioButton rbManager;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfConfirmEmail;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPhone;
    private javax.swing.JTextField tfRegister;
    // End of variables declaration//GEN-END:variables

    private final JDialog registerDialog;
    private final JFrame parent;
    private File image;
    private JEmployee employee;

    public boolean validation(JEmployee employee, String email, String password) {
        if (!employee.getEmail().equals(email)) {
            MessageDialog.showErrorMessage("Os emails assinalados são diferentes!", this);
            return false;
        }

        if (!employee.getPassword().equals(password)) {
            MessageDialog.showErrorMessage("As senhas assinaladas são diferentes!", this);
            return false;
        }

        if (employee.getName().trim().length() == 0
                || employee.getEmail().trim().length() == 0
                || employee.getAddress().trim().length() == 0
                || employee.getPhone().trim().length() == 0
                || employee.getRegisterNumber().trim().length() == 0
                || employee.getRole() == null) {

            MessageDialog.showErrorMessage("Todos os campos são obrigatórios!", this);
            return false;
        }

        return true;
    }

    public byte[] getImage() {
        if (image != null) {
            try {
                BufferedImage img = ImageIO.read(image);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(img, "png", baos);
                InputStream is = new ByteArrayInputStream(baos.toByteArray());

                return baos.toByteArray();
            } catch (IOException ex) {
                Logger.getLogger(RegisterDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void setUserImage(File image) {

        if (image != null) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(image);
            } catch (IOException ex) {
                Logger.getLogger(EmployeeDialog.class.getName()).log(Level.SEVERE, null, ex);
            }

            int width = lblEmployeePhoto.getWidth();
            int height = lblEmployeePhoto.getHeight();

            if (img != null) {
                Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                lblEmployeePhoto.setIcon(new ImageIcon(resizedImage));
            }
        }
    }

    private ImageIcon getUserImage(byte[] image) {
        if (image != null) {
            ImageIcon img = new ImageIcon(image);
            Image im = img.getImage();
            return getResizedImage(im);

        } else {
            Image img = new ImageIcon(getClass().getResource("/image/user_default.png")).getImage();
            return getResizedImage(img);
        }
    }

    private ImageIcon getResizedImage(Image img) {
        int width = 150;
        int height = 200;

        return new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    private void setEmployee(JEmployee employee) {
        tfName.setText(employee.getName());
        tfEmail.setText(employee.getEmail());
        tfConfirmEmail.setText(employee.getEmail());
        pfPassword.setText(employee.getPassword());
        pfConfirmPassword.setText(employee.getPassword());
        tfAddress.setText(employee.getAddress());
        tfPhone.setText(employee.getPhone());
        tfRegister.setText(employee.getRegisterNumber());
        lblEmployeePhoto.setIcon(getUserImage(employee.getPhoto()));
        if (employee.getRole() == EEmployeeType.Employee) {
            rbEmployee.setSelected(true);
            rbManager.setSelected(false);
        } else {
            rbEmployee.setSelected(false);
            rbManager.setSelected(true);
        }
    }
}
