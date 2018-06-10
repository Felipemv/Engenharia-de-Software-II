/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.JSupplier;
import br.carmaker.model.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author felipe
 */
public class JFeedstockHasSupplierDAO {

    public static final String TABLE_NAME = "feedstock_has_supplier";
    public static final String FEEDSTOCK_ID = "feedstock_id";
    public static final String SUPPLIER_ID = "supplier_id";
    
    private static final String S_ID = "s_id";
    private static final String S_NAME = "s_name";

    public static boolean insertSupplierToFeedstock(int feedstock_id, int supplier_id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "INSERT INTO " + TABLE_NAME + "(" + FEEDSTOCK_ID + ","
                + SUPPLIER_ID + ") VALUES (?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, feedstock_id);
            stmt.setInt(2, supplier_id);

            stmt.execute();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection, stmt);
            return false;
        }
        ConnectionFactory.closeConnection(connection, stmt);
        return true;
    }

    public static List<JSupplier> getSuppliersByFeedstockId(int feedstock_id) {
        /*Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;

        ///String sql = "SELECT "
                
        sql += " WHERE " + FEEDSTOCK_ID
                + "=" + feedstock_id;

        List<JSupplier> suppliers = new ArrayList<>();

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                suppliers.add(rs.getInt(S));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return suppliers;*/return null;
    }

    private static boolean deleteSupplierofAFeedstock(int feedstock_id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + FEEDSTOCK_ID + "=" + feedstock_id;
        try{
            stmt = connection.prepareStatement(sql);
            
            stmt.execute();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection, stmt);
            return false;
        }
        ConnectionFactory.closeConnection(connection, stmt);
        return true;
    }

    public static boolean editSuppliersOfAFeedstock(int feedstock_id, List<JSupplier> suppliers) {
        if(!deleteSupplierofAFeedstock(feedstock_id)){
            return false;
        }
        
        for (int i = 0; i < suppliers.size(); i++) {
            if(!insertSupplierToFeedstock(feedstock_id, suppliers.get(i).getId())){
                return false;
            }
        }
        return true;
    }
}
