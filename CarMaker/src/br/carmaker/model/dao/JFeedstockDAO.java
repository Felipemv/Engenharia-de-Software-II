/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.JDbFacade;
import br.carmaker.model.JFeedstock;
import br.carmaker.model.JSupplier;
import br.carmaker.model.connection.ConnectionFactory;
import br.carmaker.model.dao.abstracts.ABaseEntityDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe
 */
public class JFeedstockDAO extends ABaseEntityDAO {

    public static final String TABLE_NAME = "feedstock";
    public static final String NAME = "name";
    private static final String QUANTITY = "quantity";
    private static final String COST = "cost";

    private static final String S_ID = "s_id";
    private static final String S_NAME = "s_name";
    private static final String F_ID = "f_id";
    private static final String F_NAME = "f_name";

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
            int supplier_id = feedstock.getSuppliers().get(i).getId();
            JDbFacade.getInstance().createSupplierToFeedstock(feedstock_id, supplier_id);
        }
        return true;
    }

    public static List<JFeedstock> getAllFeedstocks() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;

        List<JFeedstock> listFeedstock = new ArrayList<>();
        List<JSupplier> listSupplier = new ArrayList<>();
        Map<Integer, List<JSupplier>> mapFS = new HashMap<>();
        JFeedstock feedstock;

        //String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + DELETED + "=0";
        String sql = "SELECT " + JFeedstockDAO.TABLE_NAME + "." + JFeedstockDAO.ID + " AS '" + F_ID + "', "
                + JFeedstockDAO.TABLE_NAME + "." + JFeedstockDAO.NAME + " AS '" + F_NAME + "', "
                + JFeedstockDAO.TABLE_NAME + "." + JFeedstockDAO.QUANTITY + ", "
                + JFeedstockDAO.TABLE_NAME + "." + JFeedstockDAO.COST + ", "
                + JSupplierDAO.TABLE_NAME + "." + JSupplierDAO.ID + " AS '" + S_ID + "', "
                + JSupplierDAO.TABLE_NAME + "." + JSupplierDAO.NAME + " AS '" + S_NAME + "'"
                + " FROM " + JFeedstockHasSupplierDAO.TABLE_NAME
                + " INNER JOIN " + TABLE_NAME + " ON " + TABLE_NAME + "." + ID + "="
                + JFeedstockHasSupplierDAO.TABLE_NAME + "." + JFeedstockHasSupplierDAO.FEEDSTOCK_ID
                + " INNER JOIN " + JSupplierDAO.TABLE_NAME + " ON "
                + JSupplierDAO.TABLE_NAME + "." + JSupplierDAO.ID + "="
                + JFeedstockHasSupplierDAO.TABLE_NAME + "." + JFeedstockHasSupplierDAO.SUPPLIER_ID
                + " WHERE " + TABLE_NAME + "." + DELETED + "= 0";
        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                feedstock = new JFeedstock();

                feedstock.setId(rs.getInt(F_ID));
                feedstock.setName(rs.getString(F_NAME));
                feedstock.setQuantity(rs.getInt(QUANTITY));
                feedstock.setCost(rs.getDouble(COST));
                listFeedstock.add(feedstock);

                JSupplier supplier = new JSupplier();

                supplier.setId(rs.getInt(S_ID));
                supplier.setName(rs.getString(S_NAME));

                listSupplier = mapFS.get(feedstock.getId());
                if(listSupplier == null){
                    listSupplier = new ArrayList<>();
                }
                listSupplier.add(supplier);
                mapFS.put(feedstock.getId(), listSupplier);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JFeedstockDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<JFeedstock> newFList = new ArrayList<>();
        for (Map.Entry map : mapFS.entrySet()) {
            JFeedstock f = new JFeedstock();
            
            int key = (int) map.getKey();
            List<JSupplier> sup = (List<JSupplier>) map.getValue();
            
            f.setId(key);
            
            for (int i = 0; i < listFeedstock.size(); i++) {
                JFeedstock fs = listFeedstock.get(i);
                if(fs.getId() == key){
                    f.setName(fs.getName());
                    f.setCost(fs.getCost());
                    f.setQuantity(fs.getQuantity());
                    break;
                }
            }
            f.setSuppliers(sup);
            newFList.add(f);
        }
        return newFList;
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

    private static int lastId() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int id = -1;

        String sql = "SELECT MAX(" + ID + ") AS " + ID + " FROM " + TABLE_NAME + " WHERE " + DELETED + "=0";

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
