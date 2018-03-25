package br.carmaker.model;

import br.carmaker.model.abstracts.AAffiliate;

public class JSupplier extends AAffiliate{
    private int leadTime;

    public int getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(int leadTime) {
        this.leadTime = leadTime;
    }
    
    
}
