package br.carmaker.model;

public class JShippingCompany extends AAffiliate{
    private int amountPerTransport;
    private JCar car;

    public int getAmountPerTransport() {
        return amountPerTransport;
    }

    public void setAmountPerTransport(int amountPerTransport) {
        this.amountPerTransport = amountPerTransport;
    }

    public JCar getCar() {
        return car;
    }

    public void setCar(JCar car) {
        this.car = car;
    }
    
}
