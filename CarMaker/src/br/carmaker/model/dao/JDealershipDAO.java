/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.JDealership;
import br.carmaker.model.JSupplier;
import br.carmaker.model.connection.ConnectionFactory;
import br.carmaker.model.dao.abstracts.AAffiliateDAO;
import static br.carmaker.model.dao.abstracts.AAffiliateDAO.ADDRESS;
import static br.carmaker.model.dao.abstracts.AAffiliateDAO.CNPJ;
import static br.carmaker.model.dao.abstracts.AAffiliateDAO.NAME;
import static br.carmaker.model.dao.abstracts.ABaseEntityDAO.ID;
import br.carmaker.model.enums.EDealershipType;
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
public class JDealershipDAO extends AAffiliateDAO {

    private static final String TABLE_NAME = "dealership";
    private static final String TYPE = "type";
    
    public static boolean insertDealership(JDealership dealership, JPanel panel) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "INSERT INTO " + TABLE_NAME + "(" + NAME + "," + ADDRESS + ", "
                + CNPJ + ", " + TYPE + ") VALUES (?, ?, ?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, dealership.getName());
            stmt.setString(2, dealership.getAddress());
            stmt.setString(3, dealership.getCnpj());
            stmt.setInt(4, dealership.getType().getDealershipIntType());

            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JDealershipDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        MessageDialog.showMessage("Concessionária adicionada com sucesso", panel);
        return true;
    }

    public static List<JDealership> getAllDealerships() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;

        List<JDealership> listDealership = new ArrayList<>();
        JDealership dealership;

        String sql = "SELECT * FROM " + TABLE_NAME;

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                dealership = new JDealership();

                dealership.setId(rs.getInt(ID));
                dealership.setName(rs.getString(NAME));
                dealership.setAddress(rs.getString(ADDRESS));
                dealership.setCnpj(rs.getString(CNPJ));
                dealership.setType(EDealershipType.valueOf(rs.getInt(TYPE)));

                listDealership.add(dealership);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDealership;
    }

    public static boolean editDealership(JDealership dealership) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "UPDATE " + TABLE_NAME + " SET " + NAME + "=?," + ADDRESS
                + "=?," + CNPJ + "=?," + TYPE + "=? WHERE " + ID + "=?";

        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, dealership.getName());
            stmt.setString(2, dealership.getAddress());
            stmt.setString(3, dealership.getCnpj());
            stmt.setInt(4, dealership.getType().getDealershipIntType());
            stmt.setInt(5, dealership.getId());

            return stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(JDealershipDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean deleteDealership(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + "=" + id;

        try {
            stmt = connection.prepareStatement(sql);
            return stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JDealershipDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
