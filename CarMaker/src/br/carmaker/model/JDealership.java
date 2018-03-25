package br.carmaker.model;

import br.carmaker.model.abstracts.AAffiliate;

public class JDealership extends AAffiliate{
    private JCar car;

    public JCar getCar() {
        return car;
    }

    public void setCar(JCar car) {
        this.car = car;
    }
}
