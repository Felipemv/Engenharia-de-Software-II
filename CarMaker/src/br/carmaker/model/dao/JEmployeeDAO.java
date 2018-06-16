/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.dao.abstracts.ABaseEntityDAO;
import br.carmaker.model.enums.EEmployeeType;
import br.carmaker.model.JEmployee;
import br.carmaker.model.JLogin;
import br.carmaker.model.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private static final String PHOTO = "photo";

    private static final String LOGIN_UN = "login_un";
    private static final String LOGIN_PW = "login_pw";

    public static boolean insertEmployee(JEmployee employee) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmtEmployee = null;
        PreparedStatement stmtLogin = null;
        ResultSet rs = null;

        String sqlEmployee = "INSERT INTO " + TABLE_NAME + "(" + NAME + "," + ADDRESS + ", "
                + PHONE + ", " + REGISTER + ", " + ROLE + ", " + EMAIL + ", "
                + PHOTO + ") VALUES (?, ?, ?, ?, ?, ?, ?)";

        String sqlLogin = "INSERT INTO " + JLoginDAO.TABLE_NAME + "(" + JLoginDAO.USER + ", "
                + JLoginDAO.PASS + ", " + JLoginDAO.EMPLOYEE + ") VALUES (?, ?, ?)";

        try {
            connection.setAutoCommit(false);

            stmtEmployee = connection.prepareStatement(sqlEmployee, Statement.RETURN_GENERATED_KEYS);
            stmtEmployee.setString(1, employee.getName());
            stmtEmployee.setString(2, employee.getAddress());
            stmtEmployee.setString(3, employee.getPhone());
            stmtEmployee.setString(4, employee.getRegisterNumber());
            stmtEmployee.setInt(5, employee.getRole().getUserType());
            stmtEmployee.setString(6, employee.getEmail());
            stmtEmployee.setBytes(7, employee.getPhoto());

            stmtEmployee.execute();
            int idEmployee = getLastInsertedId(stmtEmployee);

            if (idEmployee != -1) {
                stmtLogin = connection.prepareStatement(sqlLogin);
                stmtLogin.setString(1, employee.getLogin().getUser());
                stmtLogin.setString(2, employee.getLogin().getPassword());
                stmtLogin.setInt(3, idEmployee);
                stmtLogin.execute();
            } else {
                throw new SQLException();
            }
            connection.commit();
        } catch (SQLException ex) {
            System.out.println("EX " + ex.getMessage());
            try {
                connection.rollback();
            } catch (SQLException e) {

            }
            ConnectionFactory.closeConnection(connection, stmtEmployee, stmtLogin);
            return false;
        }
        ConnectionFactory.closeConnection(connection, stmtEmployee, stmtLogin);
        return true;
    }

    public static JEmployee getEmployeeByID(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        JEmployee employee = new JEmployee();

        String sql = "SELECT " + TABLE_NAME + "." + ID + ", "
                + TABLE_NAME + "." + ID + ", "
                + TABLE_NAME + "." + NAME + ", "
                + TABLE_NAME + "." + ADDRESS + ", "
                + TABLE_NAME + "." + PHONE + ", "
                + TABLE_NAME + "." + REGISTER + ", "
                + TABLE_NAME + "." + ROLE + ", "
                + TABLE_NAME + "." + EMAIL + ", "
                + TABLE_NAME + "." + PHOTO + ", "
                + JLoginDAO.TABLE_NAME + "." + JLoginDAO.USER + " AS '" + LOGIN_UN + "', "
                + JLoginDAO.TABLE_NAME + "." + JLoginDAO.USER + " AS '" + LOGIN_PW + "'"
                + " FROM " + TABLE_NAME
                + " INNER JOIN " + JLoginDAO.TABLE_NAME + " ON "
                + JLoginDAO.TABLE_NAME + "." + JLoginDAO.EMPLOYEE + "="
                + TABLE_NAME + "." + ID
                + " WHERE " + TABLE_NAME + "." + ID + "=" + id + " AND "
                + TABLE_NAME + "." + DELETED + "=0";

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            if (rs.first()) {
                employee.setId(id);
                employee.setName(rs.getString(NAME));
                employee.setAddress(rs.getString(ADDRESS));
                employee.setPhone(rs.getString(PHONE));
                employee.setRegisterNumber(rs.getString(REGISTER));
                employee.setRole(EEmployeeType.valueAt(rs.getInt(ROLE)));
                employee.setEmail(rs.getString(EMAIL));
                employee.setPhoto(rs.getBytes(PHOTO));
                employee.setLogin(new JLogin(rs.getString(LOGIN_UN), rs.getString(LOGIN_PW)));
            }
        } catch (SQLException ex) {
        }
        ConnectionFactory.closeConnection(connection, stmt, rs);
        return employee;
    }

    public static List<JEmployee> getAllEmployees() {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<JEmployee> listEmployees = new ArrayList<>();
        JEmployee employee;

        String sql = "SELECT " + TABLE_NAME + "." + ID + ", "
                + TABLE_NAME + "." + ID + ", "
                + TABLE_NAME + "." + NAME + ", "
                + TABLE_NAME + "." + ADDRESS + ", "
                + TABLE_NAME + "." + PHONE + ", "
                + TABLE_NAME + "." + REGISTER + ", "
                + TABLE_NAME + "." + ROLE + ", "
                + TABLE_NAME + "." + EMAIL + ", "
                + TABLE_NAME + "." + PHOTO + ", "
                + JLoginDAO.TABLE_NAME + "." + JLoginDAO.USER + " AS " + LOGIN_UN + ", "
                + JLoginDAO.TABLE_NAME + "." + JLoginDAO.USER + " AS " + LOGIN_PW
                + " FROM " + TABLE_NAME
                + " INNER JOIN " + JLoginDAO.TABLE_NAME + " ON "
                + JLoginDAO.TABLE_NAME + "." + JLoginDAO.EMPLOYEE + "="
                + TABLE_NAME + "." + ID
                + " WHERE " + TABLE_NAME + "." + DELETED + "=0 AND "
                + TABLE_NAME + "." + ID + "!=1";

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
                employee.setPhoto(rs.getBytes(PHOTO));
                employee.setLogin(new JLogin(rs.getString(LOGIN_UN), rs.getString(LOGIN_PW)));

                listEmployees.add(employee);
            }
        } catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
        }
        ConnectionFactory.closeConnection(connection, stmt, rs);
        return listEmployees;
    }

    public static boolean editEmployee(JEmployee employee) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmtEmployee = null;
        PreparedStatement stmtLogin = null;

        String sqlEmployee = "UPDATE " + TABLE_NAME + " SET " + NAME + " = ?, " + ADDRESS + " = ?, "
                + PHONE + " = ?, " + REGISTER + " = ?, " + ROLE + " = ?, " + EMAIL + " = ?, "
                + PHOTO + " = ? WHERE " + ID + " = ?";

        String sqlLogin = "UPDATE " + JLoginDAO.TABLE_NAME
                + " SET " + JLoginDAO.USER + "=?, "
                + JLoginDAO.PASS + "=? WHERE " + JLoginDAO.EMPLOYEE + "=?";
        try {
            connection.setAutoCommit(false);

            stmtEmployee = connection.prepareStatement(sqlEmployee);
            stmtEmployee.setString(1, employee.getName());
            stmtEmployee.setString(2, employee.getAddress());
            stmtEmployee.setString(3, employee.getPhone());
            stmtEmployee.setString(4, employee.getRegisterNumber());
            stmtEmployee.setInt(5, employee.getRole().getUserType());
            stmtEmployee.setString(6, employee.getEmail());
            stmtEmployee.setBytes(7, employee.getPhoto());
            stmtEmployee.setInt(8, employee.getId());

            stmtEmployee.execute();

            stmtLogin = connection.prepareStatement(sqlLogin);
            stmtLogin.setString(1, employee.getLogin().getUser());
            stmtLogin.setString(2, employee.getLogin().getPassword());
            stmtLogin.setInt(3, employee.getId());
            
            stmtLogin.execute();
            
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
            }
            ConnectionFactory.closeConnection(connection, stmtEmployee, stmtLogin);
            return false;
        }
        ConnectionFactory.closeConnection(connection, stmtEmployee, stmtLogin);
        return true;
    }

    public static boolean deleteEmployee(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmtEmployee = null;
        PreparedStatement stmtLogin = null;

        String sqlEmployee = "UPDATE " + TABLE_NAME + " SET " + DELETED + "=1 "
                + "WHERE " + ID + "=" + id;

        String sqlLogin = "UPDATE " + JLoginDAO.TABLE_NAME + " SET "
                + JLoginDAO.TABLE_NAME + "." + JLoginDAO.DELETED + "=1 WHERE "
                + JLoginDAO.TABLE_NAME + "." + JLoginDAO.EMPLOYEE + "=" + id;

        try {
            connection.setAutoCommit(false);

            stmtEmployee = connection.prepareStatement(sqlEmployee);
            stmtEmployee.execute();

            stmtLogin = connection.prepareStatement(sqlLogin);
            stmtLogin.execute();

            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(JEmployeeDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            ConnectionFactory.closeConnection(connection, stmtEmployee);
            return false;
        }
        ConnectionFactory.closeConnection(connection, stmtEmployee);
        return true;
    }

    public static boolean registerExists(String register, int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean exists;

        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + REGISTER + "='"
                + register + "' AND " + ID + " !=" + id;

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            exists = rs.first();
        } catch (SQLException ex) {
            ConnectionFactory.closeConnection(connection, stmt, rs);
            return true;
        }
        ConnectionFactory.closeConnection(connection, stmt, rs);
        return exists;
    }

    private static int getLastInsertedId(PreparedStatement stmt) {
        int lastId = -1;
        ResultSet rs;

        try {
            rs = stmt.getGeneratedKeys();
            if (rs != null) {
                while (rs.next()) {
                    lastId = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
        }
        return lastId;
    }
}
