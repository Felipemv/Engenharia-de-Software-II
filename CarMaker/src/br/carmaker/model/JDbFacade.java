/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model;

import br.carmaker.model.dao.JCarDAO;
import br.carmaker.model.dao.JDealershipDAO;
import br.carmaker.model.dao.JEmployeeDAO;
import br.carmaker.model.dao.JFeedstockDAO;
import br.carmaker.model.dao.JShippingCompanyDAO;
import br.carmaker.model.dao.JSupplierDAO;
import br.carmaker.model.dao.LoginDAO;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Usuário
 */
public class JDbFacade {

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
    
    //CRUD de Matérias-primas
    
    public void createFeedstock(JFeedstock feedstock, JPanel panel){
        JFeedstockDAO.insertFeedstock(feedstock, panel);
    }
    
    public List<JFeedstock> readAllFeedstocks(){
        return JFeedstockDAO.getAllFeedstocks();
    }
    
    public boolean editFeedstock(JFeedstock feedstock){
        return JFeedstockDAO.editFeedstock(feedstock);
    }
    
    public boolean deleteFeedstock(int id){
        return JFeedstockDAO.deleteFeedstock(id);
    }
    
    //CRUD de Fornecedores

    public void createSupplier(JSupplier supplier, JPanel panel) {
        JSupplierDAO.insertSupplier(supplier, panel);
    }
    
    public JSupplier readSupplierById(int id){
        return JSupplierDAO.getSupplierById(id);
    }
    
    public List<JSupplier> readAllSuppliers(){
        return JSupplierDAO.getAllSuppliers();
    }
    
    public boolean editSupplier(JSupplier supplier){
        return JSupplierDAO.editSupplier(supplier);
    }
    
    public boolean deleteSupplier(int id){
        return JSupplierDAO.deleteSupplier(id);
    }
    
    //CRUD de Transportadoras
    
    public void createShippingCompany(JShippingCompany shippingCompany, JPanel panel) {
        JShippingCompanyDAO.insertShippingCompany(shippingCompany, panel);
    }
    
    public List<JShippingCompany> readAllShippingCompanies(){
        return JShippingCompanyDAO.getAllShippingCompanies();
    }
    
    public boolean editShippingCompany(JShippingCompany shippingCompany){
        return JShippingCompanyDAO.editShippingCompany(shippingCompany);
    }
    
    public boolean deleteShippingCompany(int id){
        return JShippingCompanyDAO.deleteShippingCompany(id);
    }
    
    //CRUD de Concessionárias
    
    public void createDealership(JDealership dealership, JPanel panel) {
        JDealershipDAO.insertDealership(dealership, panel);
    }
    
    public List<JDealership> readAllDealerships(){
        return JDealershipDAO.getAllDealerships();
    }
    
    public boolean editDealership(JDealership dealership){
        return JDealershipDAO.editDealership(dealership);
    }
    
    public boolean deleteDealership(int id){
        return JDealershipDAO.deleteDealership(id);
    }
}
