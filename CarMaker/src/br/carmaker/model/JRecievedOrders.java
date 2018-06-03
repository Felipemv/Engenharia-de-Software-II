package br.carmaker.model;

import br.carmaker.model.abstracts.AOrder;

public class JRecievedOrders extends AOrder {

    private int car;
    private int dealership;
    private int shippingCompany;

    public int getCar() {
        return car;
    }

    public void setCar(int car) {
        this.car = car;
    }

    public int getDealership() {
        return dealership;
    }

    public void setDealership(int dealership) {
        this.dealership = dealership;
    }

    public int getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(int shippingCompany) {
        this.shippingCompany = shippingCompany;
    }
}
