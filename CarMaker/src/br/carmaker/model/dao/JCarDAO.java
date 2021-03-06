/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.JCar;
import br.carmaker.model.connection.ConnectionFactory;
import br.carmaker.model.dao.abstracts.ABaseEntityDAO;
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
public class JCarDAO extends ABaseEntityDAO {

    public static final String TABLE_NAME = "car";
    public static final String MODEL = "model";
    public static final String PRODUCTION_TIME = "production_time";
    public static final String COST_PRICE = "cost_price";
    public static final String SALE_PRICE = "sale_price";
    public static final String COLOR = "color";

    public static boolean insertCar(JCar car) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "INSERT INTO " + TABLE_NAME + "(" + MODEL + ","
                + PRODUCTION_TIME + ", " + COST_PRICE + ", " + SALE_PRICE + ", "
                + COLOR + ") VALUES (?, ?, ?, ?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, car.getModel());
            stmt.setInt(2, car.getProductionTime());
            stmt.setDouble(3, car.getCostPrice());
            stmt.setDouble(4, car.getSalePrice());
            stmt.setString(5, car.getColor());
            stmt.execute();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection, stmt);
            return false;
        }
        ConnectionFactory.closeConnection(connection, stmt);
        return true;
    }

    public static JCar getCarById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        JCar car = new JCar();

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + "=" + id + " AND " + DELETED + "=0";

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                car.setId(id);
                car.setModel(rs.getString(MODEL));
                car.setCostPrice(rs.getDouble(COST_PRICE));
                car.setSalePrice(rs.getDouble(SALE_PRICE));
                car.setProductionTime(rs.getInt(PRODUCTION_TIME));
                car.setColor(rs.getString(COLOR));
            }
        } catch (SQLException ex) {

        }
        ConnectionFactory.closeConnection(connection, stmt, rs);
        return car;
    }

    public static List<JCar> getAllCars() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<JCar> listCars = new ArrayList<>();
        JCar car;

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + DELETED + "=0";

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                car = new JCar();

                car.setId(rs.getInt(ID));
                car.setModel(rs.getString(MODEL));
                car.setProductionTime(rs.getInt(PRODUCTION_TIME));
                car.setCostPrice(rs.getDouble(COST_PRICE));
                car.setSalePrice(rs.getDouble(SALE_PRICE));
                car.setColor(rs.getString(COLOR));

                listCars.add(car);
            }
        } catch (SQLException ex) {
        }
        ConnectionFactory.closeConnection(connection, stmt, rs);
        return listCars;
    }

    public static boolean editCar(JCar car) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "UPDATE " + TABLE_NAME + " SET " + MODEL + " = ?, "
                + PRODUCTION_TIME + " = ?, " + COST_PRICE + " = ?, "
                + SALE_PRICE + " = ?, " + COLOR + " = ?  WHERE " + ID + " = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, car.getModel());
            stmt.setInt(2, car.getProductionTime());
            stmt.setDouble(3, car.getCostPrice());
            stmt.setDouble(4, car.getSalePrice());
            stmt.setString(5, car.getColor());
            stmt.setInt(6, car.getId());

            stmt.execute();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection, stmt);
            return false;
        }
        ConnectionFactory.closeConnection(connection, stmt);
        return true;
    }

    public static boolean deleteCar(int id) {
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
