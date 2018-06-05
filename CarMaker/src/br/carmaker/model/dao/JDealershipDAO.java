/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.JDealership;
import br.carmaker.model.JShippingCompany;
import br.carmaker.model.connection.ConnectionFactory;
import br.carmaker.model.dao.abstracts.AAffiliateDAO;
import br.carmaker.model.enums.EDealershipType;
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
public class JDealershipDAO extends AAffiliateDAO {

    protected static final String TABLE_NAME = "dealership";
    protected static final String SC_ID = "shipping_company_id";
    private static final String TYPE = "type";

    private static final String D_ID = "d_id";
    private static final String D_NAME = "d_name";
    private static final String SCOMP_ID = "sc_id";
    private static final String SCOMP_NAME = "sc_name";

    public static boolean insertDealership(JDealership dealership) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "INSERT INTO " + TABLE_NAME + "(" + NAME + "," + ADDRESS + ", "
                + CNPJ + ", " + TYPE + ") VALUES (?, ?, ?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, dealership.getName());
            stmt.setString(2, dealership.getAddress());
            stmt.setString(3, dealership.getCnpj());
            stmt.setInt(3, dealership.getShippingCompany().getId());
            stmt.setInt(4, dealership.getType().getDealershipIntType());

            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JDealershipDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    public static JDealership getDealershipById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        JDealership dealership = new JDealership();

        String sql = "SELECT " + TABLE_NAME + "." + ID + " AS '" + D_ID + "',"
                + TABLE_NAME + "." + NAME + " AS '" + D_NAME + "',"
                + TABLE_NAME + "." + ADDRESS + ", "
                + TABLE_NAME + "." + CNPJ + ", "
                + TABLE_NAME + "." + TYPE + ", "
                + JShippingCompanyDAO.TABLE_NAME + "." + ID + " AS '" + SCOMP_ID + "', "
                + JShippingCompanyDAO.TABLE_NAME + "." + NAME + " AS '" + SCOMP_NAME + "', "
                + " FROM " + TABLE_NAME;

        sql += " INNER JOIN " + JShippingCompanyDAO.TABLE_NAME + " ON "
                + JShippingCompanyDAO.TABLE_NAME + "." + ID + "=" + TABLE_NAME + "." + ID;

        sql += " WHERE " + TABLE_NAME
                + "." + ID + "= 0 AND " + TABLE_NAME
                + "." + DELETED + " AND " + JShippingCompanyDAO.TABLE_NAME + "." + DELETED + "= 0";

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                dealership.setId(id);
                dealership.setAddress(rs.getString(ADDRESS));
                dealership.setName(rs.getString(NAME));
                dealership.setCnpj(rs.getString(CNPJ));
                dealership.setType(EDealershipType.valueOf(rs.getInt(TYPE)));
                dealership.setShippingCompany(new JShippingCompany(rs.getInt(SCOMP_ID), rs.getString(SCOMP_NAME)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JEmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.closeConnection(connection, stmt, rs);
        return dealership;
    }

    public static List<JDealership> getAllDealerships() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;

        List<JDealership> listDealership = new ArrayList<>();
        JDealership dealership;

        String sql = "SELECT " + TABLE_NAME + "." + ID + ", "
                + TABLE_NAME + "." + NAME + ", "
                + TABLE_NAME + "." + ADDRESS + ", "
                + TABLE_NAME + "." + CNPJ + ", "
                + TABLE_NAME + "." + TYPE + ", "
                + JShippingCompanyDAO.TABLE_NAME + "." + ID + " AS " + SCOMP_ID + ", "
                + JShippingCompanyDAO.TABLE_NAME + "." + NAME + " AS " + SCOMP_NAME;

        sql += " FROM " + TABLE_NAME;

        sql += " INNER JOIN " + JShippingCompanyDAO.TABLE_NAME + " ON "
                + JShippingCompanyDAO.TABLE_NAME + "." + ID + "="
                + TABLE_NAME + "." + SC_ID;

        sql += " WHERE " + TABLE_NAME + "." + DELETED + "=0";

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
                dealership.setShippingCompany(new JShippingCompany(rs.getInt(SCOMP_ID), rs.getString(SCOMP_NAME)));

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
                + "=?," + CNPJ + "=?," + TYPE + "=?, " + SC_ID + "=? WHERE " + ID + "=?";

        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, dealership.getName());
            stmt.setString(2, dealership.getAddress());
            stmt.setString(3, dealership.getCnpj());
            stmt.setInt(4, dealership.getType().getDealershipIntType());
            stmt.setInt(5, dealership.getShippingCompany().getId());
            stmt.setInt(6, dealership.getId());

            return stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(JDealershipDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean deleteDealership(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "UPDATE " + TABLE_NAME + " SET " + DELETED + "=1 WHERE " + ID + "=" + id;

        try {
            stmt = connection.prepareStatement(sql);
            return stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JDealershipDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
