/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.dao.abstracts.ABaseEntityDAO;
import br.carmaker.model.enums.EEmployeeType;
import br.carmaker.model.JEmployee;
import br.carmaker.model.connection.ConnectionFactory;
import br.carmaker.view.dialog.MessageDialog;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
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
 * @author Usuário
 */
public class JEmployeeDAO extends ABaseEntityDAO {

    private static final String TABLE_NAME = "employee";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String PHONE = "phone";
    private static final String REGISTER = "register";
    private static final String ROLE = "role";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "pass";
    private static final String PHOTO = "photo";

    public static JEmployee getEmployeeByID(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;

        JEmployee employee = new JEmployee();

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + "=" + id;

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                employee.setId(id);
                employee.setName(rs.getString(NAME));
                employee.setAddress(rs.getString(ADDRESS));
                employee.setPhone(rs.getString(PHONE));
                employee.setRegisterNumber(rs.getString(REGISTER));
                employee.setRole(EEmployeeType.valueAt(rs.getInt(ROLE)));
                employee.setEmail(rs.getString(EMAIL));
                employee.setPassword(rs.getString(PASSWORD));
                employee.setPhoto(rs.getBytes(PHOTO));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }

    public static boolean insertEmployee(JEmployee employee, JPanel panel) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "INSERT INTO " + TABLE_NAME + "(" + NAME + "," + ADDRESS + ", "
                + PHONE + ", " + REGISTER + ", " + ROLE + ", " + EMAIL + ", "
                + PASSWORD + ", " + PHOTO + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getAddress());
            stmt.setString(3, employee.getPhone());
            stmt.setString(4, employee.getRegisterNumber());
            stmt.setInt(5, employee.getRole().getUserType());
            stmt.setString(6, employee.getEmail());
            stmt.setString(7, employee.getPassword());
            stmt.setBytes(8, employee.getPhoto());

            stmt.execute();
        } catch (MySQLIntegrityConstraintViolationException i) {
            MessageDialog.showMessage("Número de registro já foi utilizado", panel);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(JEmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        MessageDialog.showMessage("Carro adicionado com sucesso", panel);
        return true;
    }

    public static void editEmployee(JEmployee employee) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "UPDATE " + TABLE_NAME + " SET " + NAME + " = ?, " + ADDRESS + " = ?, "
                + PHONE + " = ?, " + REGISTER + " = ?, " + ROLE + " = ?, " + EMAIL + " = ?, "
                + PASSWORD + " = ?, " + PHOTO + " = ? WHERE " + ID + " = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getAddress());
            stmt.setString(3, employee.getPhone());
            stmt.setString(4, employee.getRegisterNumber());
            stmt.setInt(5, employee.getRole().getUserType());
            stmt.setString(6, employee.getEmail());
            stmt.setString(7, employee.getPassword());
            stmt.setBytes(8, employee.getPhoto());
            stmt.setInt(9, employee.getId());

            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JEmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteEmployee(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;

        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + "=" + id;

        try {
            stmt = connection.prepareStatement(sql);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JEmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<JEmployee> getAllEmployees() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;

        List<JEmployee> listEmployees = new ArrayList<>();
        JEmployee employee;

        String sql = "SELECT * FROM " + TABLE_NAME;

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                employee = new JEmployee();

                employee.setId(rs.getInt(ID));
                employee.setName(rs.getString(NAME));
                employee.setAddress(rs.getString(ADDRESS));
                employee.setPhone(rs.getString(PHONE));
                employee.setRegisterNumber(rs.getString(REGISTER));
                employee.setRole(EEmployeeType.valueAt(rs.getInt(ROLE)));
                employee.setEmail(rs.getString(EMAIL));
                employee.setPassword(rs.getString(PASSWORD));
                employee.setPhoto(rs.getBytes(PHOTO));

                listEmployees.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEmployees;
    }
}
