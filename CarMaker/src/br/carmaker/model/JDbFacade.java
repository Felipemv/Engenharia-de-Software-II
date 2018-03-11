/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model;

import br.carmaker.model.dao.JEmployeeDAO;
import br.carmaker.model.dao.LoginDAO;

/**
 *
 * @author Usuário
 */
public class JDbFacade {
    private static LoginDAO login;
    
    private final JDbFacade sInstance = null;
    
    public JDbFacade getInstance(){
        if(sInstance == null){
            return new JDbFacade();
        }
        return sInstance;
    }
    
    public static JEmployee getEmployeeByID(int id){
        return JEmployeeDAO.getEmployeeByID(id);
    }
}
