package br.carmaker.model.enums;

public enum EDeliveryStatus {
    LATE(0) {
        @Override
        public String toString() {
            return "Atrasado";
        }
    },
    ON_TIME(1) {
        @Override
        public String toString() {
            return "Dentro do prazo";
        }
    },
    IN_ADVANCE(2) {
        @Override
        public String toString() {
            return "Chegou Adiantado";
        }
    },
    SCHEDULED_ARRIVAL(3) {
        @Override
        public String toString() {
            return "Chegada agendada";
        }
    },
    ACCOMPLISHED(4) {
        @Override
        public String toString() {
            return "Chegou no prazo";
        }
    },
    ARRIVED_LATE(5){
        @Override
        public String toString() {
            return "Chegou atrasado";
        }
        
    };
    
    private final int status;

    EDeliveryStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }
    
    public static EDeliveryStatus valueOf(int value) {
        return values()[value];
    }

}
