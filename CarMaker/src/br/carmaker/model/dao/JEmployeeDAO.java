/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.EEmployeeType;
import br.carmaker.model.JEmployee;
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
public class JEmployeeDAO {
    private static final String TABLE_NAME = "employees";
    private static final String ID = "id_user";
    private static final String NAME = "user_name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "user_password";
    private static final String PERMISSION = "permission";
    private static final String REGISTER = "user_number";
    
    private static JEmployee employee;
    
    public static JEmployee getEmployeeByID(int id){        
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        ResultSet rs;
        
        employee = new JEmployee();
        
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + "=" + id;
       
        try {
            stmt = connection.prepareStatement(sql);

            rs = stmt.executeQuery();            
            while (rs.next()) {
                employee.setId(id);
                employee.setEmail(rs.getString(EMAIL));
                employee.setPassword(rs.getString(PASSWORD));
                employee.setName(rs.getString(NAME));
                employee.setRole(EEmployeeType.valueAt(rs.getInt(PERMISSION)));
                employee.setRegisterNumber(rs.getString(REGISTER));                
            }            
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);           
        }      
        return employee;       
    }
}
