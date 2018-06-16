/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model;

import br.carmaker.model.abstracts.ABaseEntity;
import br.carmaker.model.enums.EEmployeeType;

/**
 *
 * @author Usuário
 */
public class JEmployee extends ABaseEntity {

    private String name;
    private String address;
    private String phone;
    private String registerNumber;
    private EEmployeeType role;
    private String email;
    private byte[] photo;
    private boolean online;
    private JLogin login;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public EEmployeeType getRole() {
        return role;
    }

    public void setRole(EEmployeeType role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public JLogin getLogin() {
        return login;
    }

    public void setLogin(JLogin login) {
        this.login = login;
    }
}
