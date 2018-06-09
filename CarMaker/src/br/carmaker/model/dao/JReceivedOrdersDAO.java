/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.JCar;
import br.carmaker.model.JDealership;
import br.carmaker.model.JReceivedOrders;
import br.carmaker.model.JShippingCompany;
import br.carmaker.model.connection.ConnectionFactory;
import br.carmaker.model.dao.abstracts.AOrderDAO;
import br.carmaker.model.enums.EDeliveryStatus;
import java.sql.Connection;
import java.sql.Date;
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
public class JReceivedOrdersDAO extends AOrderDAO {

    private static final String TABLE_NAME = "received_order";

    private static final String CAR_ID = "car_id";
    private static final String DEALERSHIP_ID = "dealership_id";

    private static final String MODEL = "model";
    private static final String NAME = "name";
    private static final String SCOMP_ID = "scomp_id";
    private static final String SCOMP_NAME = "scomp_name";

    public static boolean insertReceivedOrder(JReceivedOrders order) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "INSERT INTO " + TABLE_NAME + "(" + PROTOCOL + "," + STATUS
                + ", " + EXPECTED_DATE + ", " + CAR_ID + ", " + DEALERSHIP_ID
                + ") VALUES (?, ?, ?, ?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, order.getProtocol());
            stmt.setInt(2, order.getStatus().getStatus());
            stmt.setDate(3, new java.sql.Date(order.getExpectedDate().getTime()));
            stmt.setInt(4, order.getCar().getId());
            stmt.setInt(5, order.getDealership().getId());

            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JReceivedOrders.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        ConnectionFactory.closeConnection(connection, stmt);
        return true;
    }

    public static JReceivedOrders getReceivedOrderById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        JReceivedOrders order = new JReceivedOrders();

        //String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + "=" + id + " AND " + DELETED + "=0";
        String sql = "SELECT " + TABLE_NAME + "." + ID + ", "
                + TABLE_NAME + "." + PROTOCOL + ", "
                + TABLE_NAME + "." + EXPECTED_DATE + ", "
                + JCarDAO.TABLE_NAME + "." + JCarDAO.ID + " AS '" + CAR_ID + "', "
                + JCarDAO.TABLE_NAME + "." + JCarDAO.MODEL + " AS '" + MODEL + "', "
                + JDealershipDAO.TABLE_NAME + "." + JDealershipDAO.ID + " AS '" + DEALERSHIP_ID + "', "
                + JDealershipDAO.TABLE_NAME + "." + JDealershipDAO.NAME + " AS '" + NAME + "'"
                + " FROM " + TABLE_NAME;

        sql += " INNER JOIN " + JCarDAO.TABLE_NAME + "." + JCarDAO.ID + "="
                + TABLE_NAME + "." + CAR_ID;

        sql += " INNER JOIN " + JDealershipDAO.TABLE_NAME + "." + JDealershipDAO.ID + "="
                + TABLE_NAME + "." + DEALERSHIP_ID;

        sql += " WHERE " + TABLE_NAME + "." + ID + "=" + id + " AND " + TABLE_NAME + "." + DELETED + "=0";

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                order.setId(id);
                order.setProtocol(rs.getString(PROTOCOL));
                order.setCar(new JCar(rs.getInt(CAR_ID), rs.getString(MODEL)));
                order.setDealership(new JDealership(rs.getInt(DEALERSHIP_ID), rs.getString(NAME)));
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
            Logger.getLogger(JReceivedOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.closeConnection(connection, stmt, rs);
        return order;
    }

    public static List<JReceivedOrders> getAllReceivedOrders() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<JReceivedOrders> listOrders = new ArrayList<>();
        JReceivedOrders order;

        //String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + DELETED + "=0";
        String sql = "SELECT " + TABLE_NAME + "." + ID + ", "
                + TABLE_NAME + "." + PROTOCOL + ", "
                + TABLE_NAME + "." + EXPECTED_DATE + ", "
                + TABLE_NAME + "." + STATUS + ", "
                + JCarDAO.TABLE_NAME + "." + JCarDAO.ID + " AS '" + CAR_ID + "', "
                + JCarDAO.TABLE_NAME + "." + JCarDAO.MODEL + " AS '" + MODEL + "', "
                + JDealershipDAO.TABLE_NAME + "." + JDealershipDAO.ID + " AS '" + DEALERSHIP_ID + "', "
                + JDealershipDAO.TABLE_NAME + "." + JDealershipDAO.NAME + " AS '" + NAME + "', "
                + JShippingCompanyDAO.TABLE_NAME + "." + JShippingCompanyDAO.ID + " AS '" + SCOMP_ID + "', "
                + JShippingCompanyDAO.TABLE_NAME + "." + JShippingCompanyDAO.NAME + " AS '" + SCOMP_NAME + "'"
                + " FROM " + TABLE_NAME;

        sql += " INNER JOIN " + JCarDAO.TABLE_NAME + " ON "
                + JCarDAO.TABLE_NAME + "." +JCarDAO.ID + "="
                + TABLE_NAME + "." + CAR_ID;

        sql += " INNER JOIN " + JDealershipDAO.TABLE_NAME + " ON "
                + JDealershipDAO.TABLE_NAME + "." +JDealershipDAO.ID + "="
                + TABLE_NAME + "." + DEALERSHIP_ID;
        
        sql += " INNER JOIN " + JShippingCompanyDAO.TABLE_NAME + " ON "
                + JDealershipDAO.TABLE_NAME + "." +JDealershipDAO.SC_ID + "="
                + JShippingCompanyDAO.TABLE_NAME + "." + JShippingCompanyDAO.ID;

        sql += " WHERE " + TABLE_NAME + "." + DELETED + "=0";

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                order = new JReceivedOrders();

                order.setId(rs.getInt(ID));
                order.setProtocol(rs.getString(PROTOCOL));
                order.setCar(new JCar(rs.getInt(CAR_ID), rs.getString(MODEL)));
                order.setStatus(EDeliveryStatus.valueOf(rs.getInt(STATUS)));
                order.setExpectedDate(new Date(rs.getDate(EXPECTED_DATE).getTime()));
                
                JShippingCompany sc = new JShippingCompany(rs.getInt(SCOMP_ID), rs.getString(SCOMP_NAME));
                JDealership dealership = new JDealership(rs.getInt(DEALERSHIP_ID), rs.getString(NAME));
                
                dealership.setShippingCompany(sc);
                order.setDealership(dealership);
                
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
                
                listOrders.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JReceivedOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactory.closeConnection(connection, stmt, rs);
        return listOrders;
    }

    public static boolean editReceivedOrder(JReceivedOrders order) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        
        String sql = "UPDATE " + TABLE_NAME;
        
        sql += " SET " + PROTOCOL + "=?, " + EXPECTED_DATE + "=?, " + STATUS + "=?, "
                + CAR_ID + "=?, " + DEALERSHIP_ID + "=?";
        
        sql += " WHERE " + ID + "=?";
        
        try {
            stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, order.getProtocol());
            stmt.setDate(2, new java.sql.Date(order.getExpectedDate().getTime()));
            stmt.setInt(3, order.getStatus().getStatus());
            stmt.setInt(4, order.getCar().getId());
            stmt.setInt(5, order.getDealership().getId());
            stmt.setInt(6, order.getId());
            
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JReceivedOrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        ConnectionFactory.closeConnection(connection, stmt);
        return true;
    }

    public static boolean deleteReceivedOrder(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "UPDATE " + TABLE_NAME + " SET " + DELETED + "=1 WHERE " + ID + "=" + id;

        try {
            stmt = connection.prepareStatement(sql);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JReceivedOrders.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        ConnectionFactory.closeConnection(connection, stmt);
        return true;
    }
}
