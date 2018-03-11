package br.carmaker.model.enums;

public enum EAffiliate {
    DEALERSHIP("Concessionaria"),
    SHIPPING_COMPANY("Transportadpra"),
    SUPPLIER("Fornecedor");

    private String affiliate;

    EAffiliate(String status) {
            this.affiliate = affiliate;
    }

    public String getAffiliate() {
            return this.affiliate;
    }
}
