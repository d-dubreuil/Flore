package flore.model;

public enum StatutCommande {
	Prepa("En préparation"), Prete("En attente de l'expédition"), Exp("Expédiée");

	private final String label;

	private StatutCommande(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
