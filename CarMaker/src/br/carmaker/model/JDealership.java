package br.carmaker.model;

import br.carmaker.model.abstracts.AAffiliate;
import br.carmaker.model.enums.EDealershipType;

public class JDealership extends AAffiliate {

    private EDealershipType type;
    private JShippingCompany shippingCompany;

    public JDealership() {
        super();
    }

    public JDealership(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public EDealershipType getType() {
        return type;
    }

    public void setType(EDealershipType type) {
        this.type = type;
    }

    public JShippingCompany getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(JShippingCompany shippingCompany) {
        this.shippingCompany = shippingCompany;
    }
    
    

}
