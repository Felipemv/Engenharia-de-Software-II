package br.carmaker.model;

public enum EDeliveryStatus {
	LATE("Atrasado"),
	ON_TIME("Dentro do prazo"),
	IN_ADVANCE("Adiantado"),
	SCHEDULED_ARRIVAL("Chegada agendada"),
	ACCOMPLISHED("Realizado");
	
	private String status;
	
	EDeliveryStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
}
