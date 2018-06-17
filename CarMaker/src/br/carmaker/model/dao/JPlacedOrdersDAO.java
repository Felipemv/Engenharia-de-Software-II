/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.JFeedstock;
import br.carmaker.model.JPlacedOrders;
import br.carmaker.model.JSupplier;
import br.carmaker.model.connection.ConnectionFactory;
import br.carmaker.model.dao.abstracts.AOrderDAO;
import br.carmaker.model.enums.EDeliveryStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
        PreparedStatement stmt = null;

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
            ConnectionFactory.closeConnection(connection, stmt);
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
        JFeedstock feedstock;
        JSupplier supplier;

        String sql = "SELECT " + TABLE_NAME + "." + ID + ", "
                + TABLE_NAME + "." + PROTOCOL + ", "
                + TABLE_NAME + "." + EXPECTED_DATE + ", "
                + TABLE_NAME + "." + STATUS + ", "
                + JFeedstockDAO.TABLE_NAME + "." + JFeedstockDAO.ID + " AS '" + F_ID + "', "
                + JFeedstockDAO.TABLE_NAME + "." + JFeedstockDAO.NAME + " AS '" + F_NAME + "', "
                + JSupplierDAO.TABLE_NAME + "." + JSupplierDAO.ID + " AS '" + S_ID + "', "
                + JSupplierDAO.TABLE_NAME + "." + JSupplierDAO.NAME + " AS '" + S_NAME + "', "
                + " FROM " + TABLE_NAME;

        sql += " INNER JOIN " + JFeedstockDAO.TABLE_NAME + " ON "
                + JFeedstockDAO.TABLE_NAME + "." + JFeedstockDAO.ID + "="
                + TABLE_NAME + "." + FEEDSTOCK_ID;

        sql += " INNER JOIN " + JSupplierDAO.TABLE_NAME + " ON "
                + JSupplierDAO.TABLE_NAME + "." + JSupplierDAO.ID + "="
                + TABLE_NAME + "." + SUPPLIER_ID;

        sql += " WHERE " + TABLE_NAME + "." + ID + "=" + id + " AND " + TABLE_NAME + "." + DELETED + "=0";

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            if (rs.first()) {
                order.setId(id);
                order.setProtocol(rs.getString(PROTOCOL));
                order.setStatus(EDeliveryStatus.valueOf(rs.getInt(STATUS)));
                order.setExpectedDate(rs.getDate(EXPECTED_DATE));

                feedstock = new JFeedstock();
                feedstock.setId(rs.getInt(F_ID));
                feedstock.setName(rs.getString(F_NAME));
                order.setFeedstock(feedstock);

                supplier = new JSupplier();
                supplier.setId(rs.getInt(S_ID));
                supplier.setName(rs.getString(S_NAME));
                order.setSupplier(supplier);

                switch (order.getStatus()) {
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
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<JPlacedOrders> listOrders = new ArrayList<>();
        JPlacedOrders order;
        JSupplier supplier;
        JFeedstock feedstock;

        String sql = "SELECT " + TABLE_NAME + "." + ID + ", "
                + TABLE_NAME + "." + PROTOCOL + ", "
                + TABLE_NAME + "." + EXPECTED_DATE + ", "
                + TABLE_NAME + "." + STATUS + ", "
                + JFeedstockDAO.TABLE_NAME + "." + JFeedstockDAO.ID + " AS '" + F_ID + "', "
                + JFeedstockDAO.TABLE_NAME + "." + JFeedstockDAO.NAME + " AS '" + F_NAME + "', "
                + JSupplierDAO.TABLE_NAME + "." + JSupplierDAO.ID + " AS '" + S_ID + "', "
                + JSupplierDAO.TABLE_NAME + "." + JSupplierDAO.NAME + " AS '" + S_NAME + "'"
                + " FROM " + TABLE_NAME;

        sql += " INNER JOIN " + JFeedstockDAO.TABLE_NAME + " ON "
                + JFeedstockDAO.TABLE_NAME + "." + JFeedstockDAO.ID + "="
                + TABLE_NAME + "." + FEEDSTOCK_ID;

        sql += " INNER JOIN " + JSupplierDAO.TABLE_NAME + " ON "
                + JSupplierDAO.TABLE_NAME + "." + JSupplierDAO.ID + "="
                + TABLE_NAME + "." + SUPPLIER_ID;

        sql += " WHERE " + TABLE_NAME + "." + DELETED + "=0";

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                order = new JPlacedOrders();
                order.setId(rs.getInt(ID));
                order.setProtocol(rs.getString(PROTOCOL));
                order.setStatus(EDeliveryStatus.valueOf(rs.getInt(STATUS)));
                order.setExpectedDate(rs.getDate(EXPECTED_DATE));

                feedstock = new JFeedstock();
                feedstock.setId(rs.getInt(F_ID));
                feedstock.setName(rs.getString(F_NAME));
                order.setFeedstock(feedstock);

                supplier = new JSupplier();
                supplier.setId(rs.getInt(S_ID));
                supplier.setName(rs.getString(S_NAME));
                order.setSupplier(supplier);

                switch (order.getStatus()) {
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

        }
        ConnectionFactory.closeConnection(connection, stmt, rs);
        return listOrders;
    }

    public static boolean editPlacedOrder(JPlacedOrders order) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "UPDATE " + TABLE_NAME;

        sql += " SET " + PROTOCOL + "=?, " + EXPECTED_DATE + "=?, " + STATUS + "=?, "
                + FEEDSTOCK_ID + "=?, " + SUPPLIER_ID + "=?";

        sql += " WHERE " + ID + "=?";

        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, order.getProtocol());
            stmt.setDate(2, new java.sql.Date(order.getExpectedDate().getTime()));
            stmt.setInt(3, order.getStatus().getStatus());
            stmt.setInt(4, order.getFeedstock().getId());
            stmt.setInt(5, order.getSupplier().getId());
            stmt.setInt(6, order.getId());

            stmt.execute();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection, stmt);
            return false;
        }

        ConnectionFactory.closeConnection(connection, stmt);
        return true;
    }

    public static boolean deletePlacedOrder(int id) {
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

    public static List<JPlacedOrders> getReceivedOrdersNotDelivered() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<JPlacedOrders> listOrders = new ArrayList<>();
        JPlacedOrders order;

        String sql = "SELECT " + TABLE_NAME + "." + ID + ", "
                + TABLE_NAME + "." + EXPECTED_DATE + ", "
                + TABLE_NAME + "." + STATUS
                + " FROM " + TABLE_NAME
                + " WHERE " + DELETED + "=0"
                + " AND (" + STATUS + "=" + EDeliveryStatus.ON_TIME.getStatus()
                + " OR " + STATUS + "=" + EDeliveryStatus.SCHEDULED_ARRIVAL.getStatus() + ")";

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                order = new JPlacedOrders();

                order.setId(rs.getInt(ID));
                order.setStatus(EDeliveryStatus.valueOf(rs.getInt(STATUS)));
                order.setExpectedDate(new Date(rs.getDate(EXPECTED_DATE).getTime()));

                listOrders.add(order);
            }
        } catch (SQLException ex) {
        }
        ConnectionFactory.closeConnection(connection, stmt, rs);
        return listOrders;
    }

    public static void editPlacedOrderStatus(JPlacedOrders order) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "UPDATE " + TABLE_NAME + " SET " + STATUS + "=?  WHERE " + ID + "=?";

        try {
            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, order.getStatus().getStatus());
            stmt.setInt(2, order.getId());

            stmt.execute();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection, stmt);
        }
        ConnectionFactory.closeConnection(connection, stmt);
    }
}
