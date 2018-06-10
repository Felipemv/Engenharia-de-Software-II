package br.carmaker.model;

import br.carmaker.model.abstracts.ABaseEntity;
import java.util.ArrayList;
import java.util.List;

public class JFeedstock extends ABaseEntity {

    private String name;
    private List<JSupplier> suppliers;
    private int quantity;
    private double cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JSupplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<JSupplier> suppliers) {
        this.suppliers = suppliers;
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
