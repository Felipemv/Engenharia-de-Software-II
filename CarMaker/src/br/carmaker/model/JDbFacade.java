/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model;

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

    public JEmployee readEmployeeByID(int id) {
        return JEmployeeDAO.getEmployeeByID(id);
    }

    public boolean createEmployee(JEmployee employee, JPanel panel) {
        return JEmployeeDAO.insertEmployee(employee, panel);
    }

    public List<JEmployee> readAllEmployees() {
        return JEmployeeDAO.getAllEmployees();
    }

    public void createFeedstock(JFeedstock feedstock) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void createCar(JCar car) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
