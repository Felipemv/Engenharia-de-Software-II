package br.carmaker.model;

import br.carmaker.model.abstracts.ABaseEntity;

public class JFeedstock extends ABaseEntity {

    private String name;
    private JSupplier supplier;
    private int quantity;
    private double cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(JSupplier supplier) {
        this.supplier = supplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
