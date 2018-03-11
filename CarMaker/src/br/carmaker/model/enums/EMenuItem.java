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
    HOME("Início"),
    EMPLOYEES("Funcionários"),
    CARS("Carros"),
    FEEDSTOCK("Matéria-prima"),
    AFFILIATES("Afiliados"),
    ORDERS("Pedidos"),
    REPORT("Relatório"),
    LOGOUT("Sair");

    private final String menuItem;

    EMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }
    
    public String getMenuItem(){
        return menuItem;
    }

}
