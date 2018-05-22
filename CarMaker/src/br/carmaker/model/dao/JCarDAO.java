/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.JCar;
import br.carmaker.model.connection.ConnectionFactory;
import br.carmaker.model.dao.abstracts.ABaseEntityDAO;
import br.carmaker.view.dialog.MessageDialog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author felipe
 */
public class JCarDAO extends ABaseEntityDAO {

    private static final String TABLE_NAME = "car";
    private static final String MODEL = "model";
    private static final String PRODUCTION_TIME = "production_time";
    private static final String COST_PRICE = "cost_price";
    private static final String SALE_PRICE = "sale_price";
    private static final String COLOR = "color";

    public static boolean insertCar(JCar car, JPanel panel) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

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
            Logger.getLogger(JCarDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        MessageDialog.showMessage("Carro adicionado com sucesso", panel);
        return true;
    }

    public static List<JCar> getAllCars() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;

        List<JCar> listCars = new ArrayList<>();
        JCar car;

        String sql = "SELECT * FROM " + TABLE_NAME;

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
            Logger.getLogger(JCarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCars;
    }

    public static void editCar(JCar car) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

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
            Logger.getLogger(JCarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteCar(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + "=" + id;

        try {
            stmt = connection.prepareStatement(sql);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JCarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
