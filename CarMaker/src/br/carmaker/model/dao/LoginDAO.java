/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuário
 */
public class LoginDAO {

    private static LoginDAO instance;

    private final String TABLE_NAME = "employee";
    private final String ID = "id";
    private final String EMAIL = "email";
    private final String PASS = "pass";

    public static LoginDAO getInstance() {
        if (instance == null) {
            return new LoginDAO();
        }
        return instance;
    }

    public int login(String email, String password) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int i = -1;

        try {
            stmt = connection.prepareStatement("SELECT * FROM " + TABLE_NAME
                    + " WHERE " + EMAIL + "='" + email + "' AND " + PASS + "='"
                    + password + "'");

            rs = stmt.executeQuery();
            if (rs.first()) {
                i = rs.getInt(ID);
            }
        } catch (SQLException ex) {
        }
        
        ConnectionFactory.closeConnection(connection, stmt);
        return i;
    }
}
