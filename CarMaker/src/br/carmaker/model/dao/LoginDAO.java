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
import java.util.logging.Level;
import java.util.logging.Logger;

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

        try {//
            stmt = connection.prepareStatement("SELECT * FROM " + TABLE_NAME
                    + " WHERE " + EMAIL + "='" + email + "' AND " + PASS + "='"
                    + password + "'");

            rs = stmt.executeQuery();
            if (rs == null) {
                return -1;
            }
            int i = -1;
            while (rs.next()) {
                i = rs.getInt(ID);
            }
            return i;
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
