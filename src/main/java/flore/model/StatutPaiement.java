package flore.model;

public enum StatutPaiement {
	Attente("Paiement en attente"), Accepte("Paiement accepté"), Refuse("Paiement refusé");

	private final String label;

	private StatutPaiement(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
