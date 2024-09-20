package personnages;

/**
 * Cette classe est utilisée pour représenter le comportement d'un village
 */
public class Village {
	// ===== ATTRIBUTS =====
	/**
	 * Le nom du village (String)
	 */
	private String nom;

	// ===== CONSTRUCTEURS =====
	/**
	 * Crée un nouveau village portant le nom spécifié
	 *
	 * @param nom le nom du village (String)
	 */
	public Village(String nom) {
		this.nom = nom;
	}

	// ===== ATTRIBUTS =====
	/**
	 * Renvoie le nom du village
	 * 
	 * @return nom le nom du village (String)
	 */
	public String getNom() {
		return nom;
	}
}
