package personnages;

/**
 * Cette classe est utilisée pour représenter le comportement d'un gaulois.
 * Un gaulois est défini par son nom, sa force et l'effet de la potion qu'il a bu.
 * 
 * <p> Il peut :</p>
 * <ul>
 *   <li> -parler ({@link #parler(String)})</li>
 *   <li> -frapper un romain ({@link #frapper(Romain)})</li>
 *   <li> -boire une potion ({@link #boirePotion(int)})</li>
 * </ul>
 */
public class Gaulois {
	// ===== ATTRIBUTS =====
	/**
	 * Le nom du gaulois
	 */
	private String nom;
	/**
	 * La force du gaulois
	 */
	private int force;
	/**
	 * L'effet de potion du gaulois. Initialisé à 1 par défaut
	 */
	private int effetPotion = 1;

	// ===== CONSTRUCTEURS =====
	/**
	 * Crée un gaulois en fonction du nom et de la force spécifiée
	 * 
	 * @param nom   Le nom du gaulois (String)
	 * @param force La force du gaulois (int)
	 */
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	
	// ===== METHODES =====
	/**
	 * Renvoie le nom du gaulois
	 * 
	 * @return nom le nom du gaulois (String)
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Affiche une ligne de dialogue en fonction du texte spécifié
	 * 
	 * @param texte le texte prononcé par le gaulois (String)
	 */
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	/**
	 * Affiche un messahe puis frappe le romain spécifié. Inflige des dégâts proportionnels à la force du
	 * gaulois.
	 * 
	 * @param romain le romain visé par l'attaque (Romain)
	 */
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup((force / 3) * effetPotion);
	}

	/**
	 * Affiche les attributs du gaulois
	 * 
	 * @return chaîne de caractères contenant les attributs du gaulois (String)
	 */
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	/**
	 * Remplace l'effet actuel de la potion par celui passé en argument puis affiche un message
	 * 
	 * @param forcePotion La nouvelle force de la potion du gaulois (int)
	 */
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + String.valueOf(forcePotion) + " fois décuplée.");
	}

	/**
	 * Renvoie une chaîne de caractères destinée à précéder une parole
	 * 
	 * @return "Le gaulois NOM : " où NOM est le nom du gaulois (String)
	 */
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
}
