/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model.enums;

/**
 *
 * @author felipe
 */
public enum EDealershipType {

    GENERAL(0) {
        @Override
        public String toString() {
            return "Geral";
        }
    },
    EXCLUSIVE(1) {
        @Override
        public String toString() {
            return "Exclusiva";
        }
    };

    private int dealershipType;

    EDealershipType(int dealershipType) {
        this.dealershipType = dealershipType;
    }

    public int getDealershipIntType() {
        return this.dealershipType;
    }
    
    public static EDealershipType valueOf(int value){
        for (int i = 0; i < values().length; i++) {
            if(values()[i].getDealershipIntType() == value){
                return values()[i];
            }
        }
        
        return EDealershipType.GENERAL;
    }
}
