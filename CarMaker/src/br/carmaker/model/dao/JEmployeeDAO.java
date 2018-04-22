/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.dao;

import br.carmaker.model.enums.EEmployeeType;
import br.carmaker.model.JEmployee;
import br.carmaker.model.connection.ConnectionFactory;
import br.carmaker.view.list.EmployeeList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuário
 */
public class JEmployeeDAO {
    private static final String TABLE_NAME = "employee";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String PHONE = "phone";
    private static final String REGISTER = "register";
    private static final String ROLE = "role";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "pass";
    private static final String PHOTO = "photo";    
    
    public static JEmployee getEmployeeByID(int id){        
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
    
    public static void insertEmployee(JEmployee employee){
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        
        String sql = "INSERT INTO " + TABLE_NAME + "(" +NAME+ "," +ADDRESS+ ", "
                +PHONE+ ", " +REGISTER+ ", " +ROLE+ ", " +EMAIL+ ", "
                +PASSWORD+ ", " +PHOTO+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
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
        } catch (SQLException ex) {
            Logger.getLogger(JEmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static void editEmployee(JEmployee employee, String name){
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt;
        
//        String sql = "UPDATE  " + TABLE_NAME + "(" +NAME+ "," +ADDRESS+ ", "
//                +PHONE+ ", " +REGISTER+ ", " +ROLE+ ", " +EMAIL+ ", "
//                +PASSWORD+ ", " +PHOTO+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?) WHERE " + NAME + "='" + name + "'";

        String sql = "UPDATE employee SET name = ?, address = ?, phone = ?, register = ?,"
                + " role = ?, email = ?, pass = ?, photo = ? WHERE name = ?";
        
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
            stmt.setString(9, name);
            
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(JEmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    
    public static void deleteEmployee(int id){
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
    
    public static List<JEmployee> getAllEmployees(){
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
    
    public static int getEmployeeID(String email, String password){
        
        List<JEmployee> listEmployees = new ArrayList<>();
        listEmployees = getAllEmployees();
        
        for(int i = 0; i < listEmployees.size(); i++){
            if(listEmployees.get(i).getEmail().equalsIgnoreCase(email)){
                if(listEmployees.get(i).getPassword().equalsIgnoreCase(password))
                {
                    return listEmployees.get(i).getId();
                }
            }
        }
        
        return -1;
    }
}
