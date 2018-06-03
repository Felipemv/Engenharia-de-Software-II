/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.JDbFacade;
import br.carmaker.model.JFeedstock;
import br.carmaker.model.connection.ConnectionFactory;
import br.carmaker.model.dao.abstracts.ABaseEntityDAO;
import static br.carmaker.model.dao.abstracts.ABaseEntityDAO.ID;
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
public class JFeedstockDAO extends ABaseEntityDAO {

    private static final String TABLE_NAME = "feedstock";
    private static final String NAME = "name";
    private static final String QUANTITY = "quantity";
    private static final String COST = "cost";
    
    public static boolean insertFeedstock(JFeedstock feedstock) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "INSERT INTO " + TABLE_NAME + "(" + NAME + ","
                + QUANTITY + ", " + COST + ") VALUES (?, ?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, feedstock.getName());
            stmt.setInt(2, feedstock.getQuantity());
            stmt.setDouble(3, feedstock.getCost());
            
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JFeedstockDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        int feedstock_id = lastId();
        
        for (int i = 0; i < feedstock.getSuppliers().size(); i++) {
            int supplier_id = feedstock.getSuppliers().get(i);
            JDbFacade.getInstance().createSupplierToFeedstock(feedstock_id, supplier_id);
        }
        return true;
    }
    
    public static List<JFeedstock> getAllFeedstocks() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;

        List<JFeedstock> listFeedstock = new ArrayList<>();
        JFeedstock feedstock;

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + DELETED + "=0";

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                feedstock = new JFeedstock();

                feedstock.setId(rs.getInt(ID));
                feedstock.setName(rs.getString(NAME));
                feedstock.setQuantity(rs.getInt(QUANTITY));
                feedstock.setCost(rs.getDouble(COST));
                
                List<Integer> suppliers = JDbFacade.getInstance().readSupplierByFeedstock(feedstock.getId());
                feedstock.setSuppliers(suppliers);

                listFeedstock.add(feedstock);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JFeedstockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listFeedstock;
    }
    
    public static boolean editFeedstock(JFeedstock feedstock) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "UPDATE " + TABLE_NAME + " SET " + NAME + "=?, " + QUANTITY 
                + "=?, " + COST + "=? WHERE " + ID + "=?";

        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, feedstock.getName());
            stmt.setInt(2, feedstock.getQuantity());
            stmt.setDouble(3, feedstock.getCost());
            stmt.setInt(4, feedstock.getId());
            
            for (int i = 0; i < feedstock.getSuppliers().size(); i++) {
                int feedstock_id = feedstock.getId();
                
                JDbFacade.getInstance().editSupplierOfAFeedstock(feedstock_id, feedstock.getSuppliers());
            }
            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(JFeedstockDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public static boolean deleteFeedstock(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "UPDATE " + TABLE_NAME + " SET " + DELETED + "=1 WHERE " + ID + "=" + id;

        try {
            stmt = connection.prepareStatement(sql);
            return stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JFeedstockDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    private static int lastId(){
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int id = -1;

        String sql = "SELECT MAX("+ID+") AS "+ID+" FROM " + TABLE_NAME + " WHERE " + DELETED + "=0";

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            if (rs.first()) {
               id = rs.getInt(ID);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JFeedstockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConnectionFactory.closeConnection(connection, stmt, rs);
        return id;
    } 
}
