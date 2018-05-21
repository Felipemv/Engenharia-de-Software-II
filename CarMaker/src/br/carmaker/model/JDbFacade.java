/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model;

import br.carmaker.model.dao.JCarDAO;
import br.carmaker.model.dao.JEmployeeDAO;
import br.carmaker.model.dao.LoginDAO;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Usuário
 */
public class JDbFacade {

    private static LoginDAO login;

    private static final JDbFacade sInstance = null;

    public static JDbFacade getInstance() {
        if (sInstance == null) {
            return new JDbFacade();
        }
        return sInstance;
    }

    //CRUD de Funcionários
    
    public boolean createEmployee(JEmployee employee, JPanel panel) {
        return JEmployeeDAO.insertEmployee(employee, panel);
    }

    public List<JEmployee> readAllEmployees() {
        return JEmployeeDAO.getAllEmployees();
    }
    
    public JEmployee readEmployeeByID(int id) {
        return JEmployeeDAO.getEmployeeByID(id);
    }
    
    public void editEmployee(JEmployee employee){
        JEmployeeDAO.editEmployee(employee);
    }
    
    public void deleteEmployee(int id){
        JEmployeeDAO.deleteEmployee(id);
    }

    //CRUD de Carros
    
    public boolean createCar(JCar car, JPanel panel) {
        return JCarDAO.insertCar(car, panel);
    }

    public List<JCar> readAllCars() {
        return JCarDAO.getAllCars();
    }
    
    public void editCar(JCar car){
        JCarDAO.editCar(car);
    }
    
    public void deleteCar(int id){
        JCarDAO.deleteCar(id);
    }
}
