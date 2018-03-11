package br.carmaker.model;

public class JFeedstock {	
    private String name;
    private JSupplier supplier;
    private int quantityPerLot;
    private double costPerLot;

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

    public int getQuantityPerLot() {
        return quantityPerLot;
    }

    public void setQuantityPerLot(int quantityPerLot) {
        this.quantityPerLot = quantityPerLot;
    }

    public double getCostPerLot() {
        return costPerLot;
    }

    public void setCostPerLot(double costPerLot) {
        this.costPerLot = costPerLot;
    }        
}
