package flore.model;

public enum StatutJuridique {

	EI("Entreprise Individuelle"), EIRL("Entreprise Individuelle à Responsabilité Limitée"), 
	SARL("Société à Responsabilité Limitée"), EURL("Entreprise Unipersonnelle à Responsabilité Limitée"), 
	SAS("Société par Actions Simplifiées"),  SASU("Société par Actions Simplifiées Unipersonnelle"),
	SA("Société Anonyme"), SNC("Société en Nom Collectif"),
	SCEA("Société Civile d'Exploitation Agricole"),  GAEC("Groupement Agricole d'Exploitation en Commun"),  
	EARL("Exploitation Agricole à Responsabilité Limitée"),  SEP("Société en Participation"),;

	private final String label;

	private StatutJuridique (String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}
