package br.carmaker.model.enums;

public enum EAffiliate {
    DEALERSHIP(0){
        @Override
        public String toString() {
            return "Concessionaria";
        }
    },
    
    SHIPPING_COMPANY(1){
        @Override
        public String toString() {
            return "Transportadora";
        }
    },
    
    SUPPLIER(2){
        @Override
        public String toString() {
            return "Fornecedor";
        }
    };

    private final int status;

    EAffiliate(int status) {
        this.status = status;
    }

    public int getAffiliate() {
        return this.status;
    }
}
