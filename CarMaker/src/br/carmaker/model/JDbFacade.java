/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model;

import br.carmaker.model.dao.JEmployeeDAO;
import br.carmaker.model.dao.LoginDAO;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class JDbFacade {
    private static LoginDAO login;
    
    private static final JDbFacade sInstance = null;
    
    public static JDbFacade getInstance(){
        if(sInstance == null){
            return new JDbFacade();
        }
        return sInstance;
    }
    
    public JEmployee getEmployeeByID(int id){
        return JEmployeeDAO.getEmployeeByID(id);
    }
    
    public void insertEmployee(JEmployee employee){
        JEmployeeDAO.insertEmployee(employee);
    }
    
    public List<JEmployee> getAllEmployees(){
        return JEmployeeDAO.getAllEmployees();
    }
}
