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
        public String toString() {
            return "Exclusiva";
        }
    };

    private int dealershipType;

    EDealershipType(int dealershipType) {
        this.dealershipType = dealershipType;
    }

    public int getDealershipType() {
        return this.dealershipType;
    }

}
