package br.carmaker.model;

import br.carmaker.model.abstracts.AAffiliate;

public class JShippingCompany extends AAffiliate{
    private int amount;
    private int fleet;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getFleet() {
        return fleet;
    }

    public void setFleet(int fleet) {
        this.fleet = fleet;
    }
    
}
