/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.JEmployee;
import br.carmaker.model.JSupplier;
import br.carmaker.model.connection.ConnectionFactory;
import br.carmaker.model.dao.abstracts.AAffiliateDAO;
import static br.carmaker.model.dao.abstracts.ABaseEntityDAO.ID;
import br.carmaker.model.enums.EEmployeeType;
import br.carmaker.view.dialog.MessageDialog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author felipe
 */
public class JSupplierDAO extends AAffiliateDAO {

    private final static String TABLE_NAME = "supplier";
    private static final String LEAD_TIME = "lead_time";

    public static boolean insertSupplier(JSupplier supplier, JPanel panel) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "INSERT INTO " + TABLE_NAME + "(" + NAME + "," + ADDRESS + ", "
                + CNPJ + ", " + LEAD_TIME + ") VALUES (?, ?, ?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, supplier.getName());
            stmt.setString(2, supplier.getAddress());
            stmt.setString(3, supplier.getCnpj());
            stmt.setString(4, Integer.toString(supplier.getLeadTime()));

            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        MessageDialog.showMessage("Fornecedor adicionado com sucesso", panel);
        return true;
    }

    public static JSupplier getSupplierById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;

        JSupplier supplier = new JSupplier();

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + "=" + id;

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                supplier = new JSupplier();

                supplier.setId(rs.getInt(ID));
                supplier.setName(rs.getString(NAME));
                supplier.setAddress(rs.getString(ADDRESS));
                supplier.setCnpj(rs.getString(CNPJ));
                supplier.setLeadTime(rs.getInt(LEAD_TIME));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return supplier;
    }

    public static List<JSupplier> getAllSuppliers() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;

        List<JSupplier> listSuppliers = new ArrayList<>();
        JSupplier supplier;

        String sql = "SELECT * FROM " + TABLE_NAME;

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                supplier = new JSupplier();

                supplier.setId(rs.getInt(ID));
                supplier.setName(rs.getString(NAME));
                supplier.setAddress(rs.getString(ADDRESS));
                supplier.setCnpj(rs.getString(CNPJ));
                supplier.setLeadTime(rs.getInt(LEAD_TIME));

                listSuppliers.add(supplier);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSuppliers;
    }

    public static boolean editSupplier(JSupplier supplier) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "UPDATE " + TABLE_NAME + " SET " + NAME + "=?," + ADDRESS
                + "=?," + CNPJ + "=?," + LEAD_TIME + "=? WHERE " + ID + "=?";

        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, supplier.getName());
            stmt.setString(2, supplier.getAddress());
            stmt.setString(3, supplier.getCnpj());
            stmt.setInt(4, supplier.getLeadTime());
            stmt.setInt(5, supplier.getId());

            return stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(JSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean deleteSupplier(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + "=" + id;

        try {
            stmt = connection.prepareStatement(sql);
            return stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
