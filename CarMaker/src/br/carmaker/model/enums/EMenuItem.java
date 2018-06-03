/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.enums;

/**
 *
 * @author Usuário
 */
public enum EMenuItem {
    HOME(0){
        @Override
        public String toString() {
            return "Início";
        }
    },
    EMPLOYEES(1){
        @Override
        public String toString() {
            return "Funcionários";
        }
    },
    CARS(2){
        @Override
        public String toString() {
            return "Carros";
        }
    },
    FEEDSTOCK(3){
        @Override
        public String toString() {
            return "Matérias-primas";
        }
    },
    AFFILIATES(4){
        @Override
        public String toString() {
            return "Afiliadas";
        }
    },
    ORDERS(5){
        @Override
        public String toString() {
            return "Pedidos";
        }
    },
    REPORT(6){
        @Override
        public String toString() {
            return "Relatório";
        }
    },
    LOGOUT(7){
        @Override
        public String toString() {
            return "Sair";
        }
    };

    private final int menuItem;

    EMenuItem(int menuItem) {
        this.menuItem = menuItem;
    }
    
    public int getMenuItem(){
        return menuItem;
    }

}
