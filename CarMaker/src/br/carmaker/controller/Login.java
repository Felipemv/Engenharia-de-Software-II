/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.controller;

import br.carmaker.model.dao.LoginDAO;

/**
 *
 * @author Usuário
 */
public class Login {
    
    private static Login instance;
        
    public static Login getInstance(){
        if(instance == null){
            return new Login();
        }        
        return instance;
    }
    
    public int validate(String user, String password){
        if(user.equals("") || password.equals("")){
            return -1;
        }
        return LoginDAO.getInstance().login(user, password);
    }
}
