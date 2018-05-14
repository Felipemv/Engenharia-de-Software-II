package br.carmaker.model.enums;

public enum EDeliveryStatus {
    LATE(0) {
        public String toString() {
            return "Atrasado";
        }
    },
    ON_TIME(1) {
        public String toString() {
            return "Dentro do prazo";
        }
    },
    IN_ADVANCE(2) {
        public String toString() {
            return "Chegou Adiantado";
        }
    },
    SCHEDULED_ARRIVAL(3) {
        public String toString() {
            return "Chegada agendada";
        }
    },
    ACCOMPLISHED(4) {
        public String toString() {
            return "Chegou";
        }
    };

    private int status;

    EDeliveryStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }
}
