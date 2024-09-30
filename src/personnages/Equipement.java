package personnages;

/**
 * Cette enumeration est utilisee pour equiper un personne
 */
public enum Equipement {
	CASQUE("casque"), BOUCLIER("bouclier");

	// ===== ATTRIBUTS =====
	/**
	 * Le nom de l'equipement
	 */
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
	 */
	public String toString() {
		return nom;
	}
}
