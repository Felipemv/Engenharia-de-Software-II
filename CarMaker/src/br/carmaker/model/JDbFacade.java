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
import br.carmaker.model.dao.JFeedstockHasSupplierDAO;
import br.carmaker.model.dao.JShippingCompanyDAO;
import br.carmaker.model.dao.JSupplierDAO;
import java.util.List;

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
    
    public boolean createEmployee(JEmployee employee) {
        return JEmployeeDAO.insertEmployee(employee);
    }

    public List<JEmployee> readAllEmployees() {
        return JEmployeeDAO.getAllEmployees();
    }
    
    public JEmployee readEmployeeByID(int id) {
        return JEmployeeDAO.getEmployeeByID(id);
    }
    
    public boolean editEmployee(JEmployee employee){
        return JEmployeeDAO.editEmployee(employee);
    }
    
    public boolean deleteEmployee(int id){
        return JEmployeeDAO.deleteEmployee(id);
    }
    
    public boolean registerExists(String register, int id){
        return JEmployeeDAO.registerExists(register, id);
    }

    //CRUD de Carros
    
    public boolean createCar(JCar car) {
        return JCarDAO.insertCar(car);
    }

    public JCar readCarById(int car) {
        return JCarDAO.getCarById(car);
    }

    public List<JCar> readAllCars() {
        return JCarDAO.getAllCars();
    }
    
    public boolean editCar(JCar car){
        return JCarDAO.editCar(car);
    }
    
    public boolean deleteCar(int id){
        return JCarDAO.deleteCar(id);
    }
    
    //CRUD de Matérias-primas
    
    public boolean createFeedstock(JFeedstock feedstock){
        return JFeedstockDAO.insertFeedstock(feedstock);
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

    public boolean createSupplier(JSupplier supplier) {
        return JSupplierDAO.insertSupplier(supplier);
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
    
    //CRUD de Matérias-primas e Fornecedoras (Relação M-N)
    
    public boolean createSupplierToFeedstock(int feedstock_id, int supplier_id){
        return JFeedstockHasSupplierDAO.insertSupplierToFeedstock(feedstock_id, supplier_id);
    }
    
    public List<Integer> readSupplierByFeedstock(int feedstock_id){
        return JFeedstockHasSupplierDAO.getSuppliersByFeedstockId(feedstock_id);
    }
    
    public boolean editSupplierOfAFeedstock(int feedstock_id, List<Integer> suppliers){
        return JFeedstockHasSupplierDAO.editSuppliersOfAFeedstock(feedstock_id, suppliers);
    }
    
    //CRUD de Transportadoras
    
    public boolean createShippingCompany(JShippingCompany shippingCompany) {
        return JShippingCompanyDAO.insertShippingCompany(shippingCompany);
    }
    
    public JShippingCompany readShippingCompanyById(int shippingCompany) {
        return JShippingCompanyDAO.getShippingCompanyById(shippingCompany);
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
    
    public boolean createDealership(JDealership dealership) {
        return JDealershipDAO.insertDealership(dealership);
    }
    
    public JDealership readDealershipById(int dealership){
        return JDealershipDAO.getDealershipById(dealership);
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
