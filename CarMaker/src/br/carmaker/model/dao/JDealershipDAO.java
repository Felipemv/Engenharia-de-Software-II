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


/**
 *
 * @author felipe
 */
public class JDealershipDAO extends AAffiliateDAO{

    public static final String TABLE_NAME = "dealership";
    public static final String TYPE = "dealership_type";
    public static final String SCOMP_ID = "shipping_company_id";
    
    private static final String SC_ID = "sc_id";
    private static final String SC_NAME = "sc_name";
    
    public static boolean insertDealership(JDealership dealership){
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "INSERT INTO " + TABLE_NAME + "(" + NAME + ","
                + ADDRESS + ", " + CNPJ + ", " + TYPE + ", " + SCOMP_ID + ") VALUES (?, ?, ?, ?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, dealership.getName());
            stmt.setString(2, dealership.getAddress());
            stmt.setString(3, dealership.getCnpj());
            stmt.setInt(4, dealership.getType().getDealershipIntType());
            stmt.setInt(5, dealership.getShippingCompany().getId());

            stmt.execute();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection, stmt);
            return false;
        }
        ConnectionFactory.closeConnection(connection, stmt);
        return true;
    }
    
    public static JDealership getDealershipById(int id){
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        JDealership dealership = new JDealership();
        JShippingCompany sc = new JShippingCompany();

        String sql = "SELECT " + TABLE_NAME + "." + ID + ", "
                + TABLE_NAME + "." + NAME + ", "
                + TABLE_NAME + "." + ADDRESS + ", "
                + TABLE_NAME + "." + CNPJ + ", "
                + TABLE_NAME + "." + TYPE + ", "
                + JShippingCompanyDAO.TABLE_NAME + "." + JShippingCompanyDAO.ID + " AS '" + SC_ID + "', "
                + JShippingCompanyDAO.TABLE_NAME + "." + JShippingCompanyDAO.NAME + " AS '" + SC_NAME + "'"
                + " FROM " + TABLE_NAME
                + " INNER JOIN " + JShippingCompanyDAO.TABLE_NAME + " ON " + TABLE_NAME + "." + SCOMP_ID + "="
                + JShippingCompanyDAO.TABLE_NAME + "." + JShippingCompanyDAO.ID
                + " WHERE " + TABLE_NAME + "." + DELETED + "= 0 AND " + TABLE_NAME + "." + ID + "=" + id;
        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            if (rs.first()) {
                dealership.setId(rs.getInt(ID));
                dealership.setName(rs.getString(NAME));
                dealership.setAddress(rs.getString(ADDRESS));
                dealership.setCnpj(rs.getString(CNPJ));
                dealership.setType(EDealershipType.valueOf(rs.getInt(TYPE)));
                
                sc.setId(rs.getInt(SC_ID));
                sc.setName(rs.getString(SC_NAME));
                
                dealership.setShippingCompany(sc);
            }
        } catch (SQLException ex) {
            
        }
        ConnectionFactory.closeConnection(connection, stmt, rs);
        return dealership;
    }
    
    public static List<JDealership> getAllDealerships(){
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<JDealership> listDealership = new ArrayList<>();
        JDealership dealership;
        JShippingCompany sc;

        String sql = "SELECT " + TABLE_NAME + "." + ID + ", "
                + TABLE_NAME + "." + NAME + ", "
                + TABLE_NAME + "." + ADDRESS + ", "
                + TABLE_NAME + "." + CNPJ + ", "
                + TABLE_NAME + "." + TYPE + ", "
                + JShippingCompanyDAO.TABLE_NAME + "." + JShippingCompanyDAO.ID + " AS '" + SC_ID + "', "
                + JShippingCompanyDAO.TABLE_NAME + "." + JShippingCompanyDAO.NAME + " AS '" + SC_NAME + "'"
                + " FROM " + TABLE_NAME
                + " INNER JOIN " + JShippingCompanyDAO.TABLE_NAME + " ON " + TABLE_NAME + "." + SCOMP_ID + "="
                + JShippingCompanyDAO.TABLE_NAME + "." + JShippingCompanyDAO.ID
                + " WHERE " + TABLE_NAME + "." + DELETED + "= 0";
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
                
                sc = new JShippingCompany();
                sc.setId(rs.getInt(SC_ID));
                sc.setName(rs.getString(SC_NAME));
                
                dealership.setShippingCompany(sc);
                
                listDealership.add(dealership);
            }
        } catch (SQLException ex) {
            
        }
        ConnectionFactory.closeConnection(connection, stmt, rs);
        return listDealership;
    }
    
    public static boolean editDealership(JDealership dealership){
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "UPDATE " + TABLE_NAME + " SET " + NAME + "=?, " 
                + ADDRESS + "=?, " + CNPJ + "=?, " + TYPE + "=?, " 
                + SCOMP_ID + "=? WHERE " + ID + "=?";

        try {
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, dealership.getName());
            stmt.setString(2, dealership.getAddress());
            stmt.setString(3, dealership.getCnpj());
            stmt.setInt(4, dealership.getType().getDealershipIntType());
            stmt.setInt(5, dealership.getShippingCompany().getId());
            stmt.setInt(6, dealership.getId());
            
            stmt.execute();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection, stmt);
            return false;
        }
        ConnectionFactory.closeConnection(connection, stmt);
        return true;
    }
    
    public static boolean deleteDealership(int id){
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "UPDATE " + TABLE_NAME + " SET " + DELETED + "=1 WHERE " + ID + "=" + id;

        try {
            stmt = connection.prepareStatement(sql);
            stmt.execute();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection, stmt);
            return false;
        }
        ConnectionFactory.closeConnection(connection, stmt);
        return true;
    }
}