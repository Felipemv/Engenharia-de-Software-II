package br.carmaker.model;

import br.carmaker.model.abstracts.AOrder;

public class JRecievedOrder extends AOrder{
    private JCar car;
    private JDealership dealership;
    private JShippingCompany shippingCompany;

    public JCar getCar() {
        return car;
    }

    public void setCar(JCar car) {
        this.car = car;
    }

    public JDealership getDealership() {
        return dealership;
    }

    public void setDealership(JDealership dealership) {
        this.dealership = dealership;
    }

    public JShippingCompany getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(JShippingCompany shippingCompany) {
        this.shippingCompany = shippingCompany;
    }
}