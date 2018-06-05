/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.JShippingCompany;
import br.carmaker.model.connection.ConnectionFactory;
import br.carmaker.model.dao.abstracts.AAffiliateDAO;
import static br.carmaker.model.dao.abstracts.AAffiliateDAO.NAME;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe
 */
public class JShippingCompanyDAO extends AAffiliateDAO {

    public static final String TABLE_NAME = "shipping_company";
    private static final String AMOUNT = "amount";
    private static final String FLEET = "fleet";

    public static boolean insertShippingCompany(JShippingCompany shippingCompany) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "INSERT INTO " + TABLE_NAME + "(" + NAME + "," + ADDRESS + ", "
                + CNPJ + ", " + AMOUNT + ", " + FLEET + ") VALUES (?, ?, ?, ?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, shippingCompany.getName());
            stmt.setString(2, shippingCompany.getAddress());
            stmt.setString(3, shippingCompany.getCnpj());
            stmt.setInt(4, shippingCompany.getAmount());
            stmt.setInt(5, shippingCompany.getFleet());

            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JShippingCompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static JShippingCompany getShippingCompanyById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        JShippingCompany sc = new JShippingCompany();

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + "=" + id + " AND " + DELETED + "=0";

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                sc.setId(id);
                sc.setAddress(rs.getString(ADDRESS));
                sc.setName(rs.getString(NAME));
                sc.setCnpj(rs.getString(CNPJ));
                sc.setAmount(rs.getInt(AMOUNT));
                sc.setFleet(rs.getInt(FLEET));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JEmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.closeConnection(connection, stmt, rs);
        return sc;
    }
    
    public static List<JShippingCompany> getAllShippingCompanies() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;

        List<JShippingCompany> listShippingCompany = new ArrayList<>();
        JShippingCompany shippingCompany;

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + DELETED + "=0";

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                shippingCompany = new JShippingCompany();

                shippingCompany.setId(rs.getInt(ID));
                shippingCompany.setName(rs.getString(NAME));
                shippingCompany.setAddress(rs.getString(ADDRESS));
                shippingCompany.setCnpj(rs.getString(CNPJ));
                shippingCompany.setAmount(rs.getInt(AMOUNT));
                shippingCompany.setFleet(rs.getInt(FLEET));

                listShippingCompany.add(shippingCompany);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JShippingCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listShippingCompany;
    }

    public static boolean editShippingCompany(JShippingCompany shippingCompany) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "UPDATE " + TABLE_NAME + " SET " + NAME + "=?," + ADDRESS
                + "=?," + CNPJ + "=?," + AMOUNT + "=?, " + FLEET + "=? WHERE " 
                + ID + "=?";

        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, shippingCompany.getName());
            stmt.setString(2, shippingCompany.getAddress());
            stmt.setString(3, shippingCompany.getCnpj());
            stmt.setInt(4, shippingCompany.getAmount());
            stmt.setInt(5, shippingCompany.getFleet());
            stmt.setInt(6, shippingCompany.getId());

            return stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(JShippingCompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean deleteShippingCompany(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "UPDATE " + TABLE_NAME + " SET " + DELETED + "=1 WHERE " + ID + "=" + id;

        try {
            stmt = connection.prepareStatement(sql);
            return stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JShippingCompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
