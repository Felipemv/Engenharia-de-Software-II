/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.connection.ConnectionFactory;
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
public class JFeedstockHasSupplierDAO {

    private static final String TABLE_NAME = "feedstock_has_supplier";
    private static final String FEEDSTOCK_ID = "feedstock_id";
    private static final String SUPPLIER_ID = "supplier_id";

    public static boolean insertSupplierToFeedstock(int feedstock_id, int supplier_id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "INSERT INTO " + TABLE_NAME + "(" + FEEDSTOCK_ID + ","
                + SUPPLIER_ID + ") VALUES (?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, feedstock_id);
            stmt.setInt(2, supplier_id);

            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static List<Integer> getSuppliersByFeedstockId(int feedstock_id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + FEEDSTOCK_ID
                + "=" + feedstock_id;

        List<Integer> suppliers = new ArrayList<>();

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                suppliers.add(rs.getInt(SUPPLIER_ID));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return suppliers;
    }

    private static boolean deleteSupplierofAFeedstock(int feedstock_id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + FEEDSTOCK_ID + "=" + feedstock_id;
        try{
            stmt = connection.prepareStatement(sql);
            
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JFeedstockHasSupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static boolean editSuppliersOfAFeedstock(int feedstock_id, List<Integer> suppliers) {
        if(!deleteSupplierofAFeedstock(feedstock_id)){
            return false;
        }
        
        for (int i = 0; i < suppliers.size(); i++) {
            if(!insertSupplierToFeedstock(feedstock_id, suppliers.get(i))){
                return false;
            }
        }
        return true;
    }
}
