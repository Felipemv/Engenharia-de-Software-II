/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model;

/**
 *
 * @author Usuário
 */
public enum EEmployeeType {
    Employee(0){        
        @Override
        public String toString(){
            return "Funcionário";
        }
    },
    Manager(1){
        @Override
        public String toString(){
            return "Gerente";
        }
    };

    private final int userType;

    EEmployeeType(int status) {
        this.userType = status;
    }
    
    public static EEmployeeType valueAt(int value){
       return values()[value];
    }
}
