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
import br.carmaker.model.dao.JLoginDAO;
import br.carmaker.model.dao.JPlacedOrdersDAO;
import br.carmaker.model.dao.JReceivedOrdersDAO;
import br.carmaker.model.dao.JShippingCompanyDAO;
import br.carmaker.model.dao.JSupplierDAO;
import java.util.Date;
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
    
    //Login
       
    public int login(JLogin login){
        return JLoginDAO.getInstance().login(login);
    }
    
    public boolean userExists(String user, int id) {
        return JLoginDAO.userExists(user, id);
    }

    public JLogin readLoginByEmployeeId(int employeeId) {
        return JLoginDAO.getLoginByEmployeeId(employeeId);
    }

    //CRUD de Carros
    
    public boolean createCar(JCar car) {
        return JCarDAO.insertCar(car);
    }

    public JCar readCarById(int id) {
        return JCarDAO.getCarById(id);
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
    
    public List<JSupplier> readSupplierByFeedstock(int feedstock_id){
        return JFeedstockHasSupplierDAO.getSuppliersByFeedstockId(feedstock_id);
    }
    
    public boolean editSupplierOfAFeedstock(int feedstock_id, List<JSupplier> suppliers){
        return JFeedstockHasSupplierDAO.editSuppliersOfAFeedstock(feedstock_id, suppliers);
    }
    
    //CRUD de Transportadoras
    
    public boolean createShippingCompany(JShippingCompany shippingCompany) {
        return JShippingCompanyDAO.insertShippingCompany(shippingCompany);
    }
    
    public JShippingCompany readShippingCompanyById(int id) {
        return JShippingCompanyDAO.getShippingCompanyById(id);
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
    
    public JDealership readDealershipById(int id){
        return JDealershipDAO.getDealershipById(id);
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
    
    //CRUD de pedidos recebidos
    
    public boolean createReceivedOrder(JReceivedOrders order) {
        return JReceivedOrdersDAO.insertReceivedOrder(order);
    }
    
    public JReceivedOrders readReceivedOrderById(int id){
        return JReceivedOrdersDAO.getReceivedOrderById(id);
    }
    
    public List<JReceivedOrders> readAllReceivedOrders(){
        return JReceivedOrdersDAO.getAllReceivedOrders();
    }
    
    public boolean editReceivedOrder(JReceivedOrders order){
        return JReceivedOrdersDAO.editReceivedOrder(order);
    }
    
    public boolean deleteReceivedOrder(int id){
        return JReceivedOrdersDAO.deleteReceivedOrder(id);
    }
    
    //CRUD de pedidos recebidos
    
    public boolean createPlacedOrder(JPlacedOrders order) {
        return JPlacedOrdersDAO.insertPlacedOrder(order);
    }
    
    public JPlacedOrders readPlacedOrderById(int id){
        return JPlacedOrdersDAO.getPlacedOrderById(id);
    }
    
    public List<JPlacedOrders> readAllPlacedOrders(){
        return JPlacedOrdersDAO.getAllPlacedOrders();
    }
    
    public boolean editPlacedOrder(JPlacedOrders order){
        return JPlacedOrdersDAO.editPlacedOrder(order);
    }
    
    public boolean deletePlacedOrder(int id){
        return JPlacedOrdersDAO.deletePlacedOrder(id);
    }
}
