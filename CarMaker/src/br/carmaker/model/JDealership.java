package br.carmaker.model;

import br.carmaker.model.abstracts.AAffiliate;
import br.carmaker.model.enums.EDealershipType;

public class JDealership extends AAffiliate {

    private EDealershipType type;

    public EDealershipType getType() {
        return type;
    }

    public void setType(EDealershipType type) {
        this.type = type;
    }

}
