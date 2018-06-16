/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.JLogin;
import br.carmaker.model.connection.ConnectionFactory;
import br.carmaker.model.dao.abstracts.ABaseEntityDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuário
 */
public class JLoginDAO extends ABaseEntityDAO {

    private static JLoginDAO instance;

    public static final String TABLE_NAME = "login";
    public static final String USER = "username";
    public static final String PASS = "password";
    public static final String EMPLOYEE = "employee_id";

    public static JLoginDAO getInstance() {
        if (instance == null) {
            return new JLoginDAO();
        }
        return instance;
    }

    public int login(JLogin login) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT " + EMPLOYEE + " FROM " + TABLE_NAME
                + " WHERE " + USER + "='" + login.getUser() + "' AND "
                + PASS + "='" + login.getPassword() + "'";

        int i = -1;

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            if (rs.first()) {
                i = rs.getInt(EMPLOYEE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        ConnectionFactory.closeConnection(connection, stmt, rs);
        return i;
    }

    public static boolean userExists(String user, int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean exists;

        String sql = "SELECT * FROM " + TABLE_NAME
                + " WHERE " + USER + "='" + user + "' AND "
                + DELETED + "=0 AND " + ID + " != " + id;

        int i = -1;

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            exists = rs.first();
        } catch (SQLException ex) {
            exists = true;
        }

        ConnectionFactory.closeConnection(connection, stmt, rs);
        return exists;
    }

    public static JLogin getLoginByEmployeeId(int employeeId) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        JLogin login = new JLogin();

        String sql = "SELECT * FROM " + TABLE_NAME
                + " WHERE " + EMPLOYEE + "='" + employeeId + "' AND "
                + DELETED + "=0";

        int i = -1;

        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();
            if (rs.first()) {
                login.setId(rs.getInt(ID));
                login.setUser(rs.getString(USER));
                login.setPassword(rs.getString(PASS));
                login.setEmployee_id(rs.getInt(EMPLOYEE));
            }
        } catch (SQLException ex) {
        }

        ConnectionFactory.closeConnection(connection, stmt, rs);
        return login;
    }
}
