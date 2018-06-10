/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.JFeedstock;
import br.carmaker.model.JPlacedOrders;
import br.carmaker.model.connection.ConnectionFactory;
import br.carmaker.model.dao.abstracts.AOrderDAO;
import br.carmaker.model.enums.EDeliveryStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author felipe
 */
public class JPlacedOrdersDAO extends AOrderDAO {

    private static final String TABLE_NAME = "placed_order";
    
    private static final String FEEDSTOCK_ID = "feedstock_id";
    private static final String SUPPLIER_ID = "supplier_id";
    
    private static final String F_ID = "f_id";
    private static final String F_NAME = "f_name";
    private static final String S_ID = "s_id";
    private static final String S_NAME = "s_name";
    

    public static boolean insertPlacedOrder(JPlacedOrders order) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "INSERT INTO " + TABLE_NAME + "(" + PROTOCOL + "," + STATUS
                + ", " + EXPECTED_DATE + ", " + FEEDSTOCK_ID + ", " + SUPPLIER_ID
                + ") VALUES (?, ?, ?, ?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, order.getProtocol());
            stmt.setInt(2, order.getStatus().getStatus());
            stmt.setDate(3, new java.sql.Date(order.getExpectedDate().getTime()));
            stmt.setInt(4, order.getFeedstock().getId());
            stmt.setInt(5, order.getSupplier().getId());

            stmt.execute();
        } catch (SQLException ex) {
            return false;
        }
        ConnectionFactory.closeConnection(connection, stmt);
        return true;
    }

    public static JPlacedOrders getPlacedOrderById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        JPlacedOrders order = new JPlacedOrders();

        //String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + "=" + id + " AND " + DELETED + "=0";
        String sql = "SELECT " + TABLE_NAME + "." + ID + ", "
                + TABLE_NAME + "." + PROTOCOL + ", "
                + TABLE_NAME + "." + EXPECTED_DATE + ", "
                + JFeedstockDAO.TABLE_NAME + "." + JFeedstockDAO.ID + " AS '" + F_ID + "', "
                + JFeedstockDAO.TABLE_NAME + "." + JFeedstockDAO.NAME + " AS '" + F_NAME + "', "
                + JSupplierDAO.TABLE_NAME + "." + JSupplierDAO.NAME + " AS '" + F_NAME + "', "
                + JFeedstockDAO.TABLE_NAME + "." + JFeedstockDAO.NAME + " AS '" + F_NAME + "', "
                + " FROM " + TABLE_NAME;

        sql += " INNER JOIN " + JCarDAO.TABLE_NAME + "." + JCarDAO.ID + "="
                + TABLE_NAME + "." + FEEDSTOCK_ID;

        sql += " WHERE " + TABLE_NAME + "." + ID + "=" + id + " AND " + TABLE_NAME + "." + DELETED + "=0";

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                order.setId(id);
                order.setProtocol(rs.getString(PROTOCOL));
//                order.setCar(new JFeedstock(rs.getInt(FEEDSTOCK_ID), rs.getString(F_NAME)));
                order.setStatus(EDeliveryStatus.valueOf(rs.getInt(STATUS)));
                order.setExpectedDate(rs.getDate(EXPECTED_DATE));
                
                switch(order.getStatus()){
                    case ARRIVED_LATE:
                        order.setDelivered(true);
                        break;
                    case ACCOMPLISHED:
                        order.setDelivered(true);
                        break;
                    case IN_ADVANCE:
                        order.setDelivered(true);
                        break;
                    default:
                        order.setDelivered(false);
                }
            }
        } catch (SQLException ex) {
            
        }
        ConnectionFactory.closeConnection(connection, stmt, rs);
        return order;
    }

    public static List<JPlacedOrders> getAllPlacedOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean editPlacedOrder(JPlacedOrders order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean deletePlacedOrder(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
