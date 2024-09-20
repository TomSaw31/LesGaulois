package personnages;

/**
 * Cette classe est utilisée pour représenter le comportement d'un romain.
 * Un romain est défini par son nom et sa force.
 * 
 * <p> Il peut :</p>
 * <ul>
 *   <li> -parler ({@link #parler(String)})</li>
 *   <li> -prendre un coup ({@link #recevoirCoup(int)})</li>
 * </ul>
 */
public class Romain {
	// --- ATTRIBUTS ---
	/**
	 * Le nom du romain
	 */
	private String nom;
	/**
	 * La force actuelle du romain
	 */
	private int force;

	// --- CONSTRUCTEURS ---
	/**
	 * Crée un nouveau romain en fonction du nom et de la force spécifiée
	 * 
	 * @param nom   Le nom du romain (String)
	 * @param force La force du romain (int)
	 */
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	// --- METHODES ---
	/**
	 * Renvoie le nom du romain
	 * 
	 * @return nom le nom du romain (String)
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Affiche une ligne de dialogue en fonction du texte spécifié
	 * 
	 * @param texte le texte prononcé par le romain (String)
	 */
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	/**
	 * Inflige un coup et diminue la force du romain en fonction de l'intensité
	 * spécifiée. Affiche un message en fonction de la force restante.
	 * 
	 * @param forceCoup la force du coup infligé au romain (int)
	 */
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}

	/**
	 * Renvoie une chaîne de caractères destinée à précéder une parole
	 * 
	 * @return "Le romain NOM : " où NOM est le nom du romain (String)
	 */
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
}
