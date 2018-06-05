package br.carmaker.model;

import br.carmaker.model.abstracts.AOrder;

public class JReceivedOrders extends AOrder {

    private JCar car;
    private JDealership dealership;

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
}
