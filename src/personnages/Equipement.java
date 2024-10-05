package personnages;

/**
 * Cette enumeration est utilisee pour equiper un personne. Les equipements
 * possibles sont les casques et les boucliers
 */
public enum Equipement {
	/** casque */
	CASQUE("casque"),
	/** bouclier */
	BOUCLIER("bouclier");

	// ===== ATTRIBUTS =====
	/** Le nom de l'equipement */
	private String nom;

	// ===== CONSTRUCTEURS =====
	/**
	 * Cree un equipement portant le nom specifie
	 * 
	 * @param nom le nom de l'equipement (String)
	 */
	private Equipement(String nom) {
		this.nom = nom;
	}

	// ===== METHODES =====
	/**
	 * Renvoie le nom de l'equipement
	 * @return Le nom de l'equipement
	 */
	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return nom;
	}
}
