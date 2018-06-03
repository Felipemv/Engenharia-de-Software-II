/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.carmaker.model;

import br.carmaker.model.abstracts.AOrder;

/**
 *
 * @author felipe
 */
public class JPlacedOrders extends AOrder {

    private JFeedstock feedstock;
    private int supplier;

    public JFeedstock getFeedstock() {
        return feedstock;
    }

    public void setFeedstock(JFeedstock feedstock) {
        this.feedstock = feedstock;
    }
    
    public int getSupplier() {
        return supplier;
    }

    public void setSupplier(int supplier) {
        this.supplier = supplier;
    }
}
