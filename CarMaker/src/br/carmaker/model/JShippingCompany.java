package br.carmaker.model;

public class JShippingCompany extends AAffiliate{
    private int amount;
    private JCar car;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public JCar getCar() {
        return car;
    }

    public void setCar(JCar car) {
        this.car = car;
    }
    
}
