package personnages;

/**
 * Cette classe est utilisée pour représenter le comportement d'un chef.
 * Un gaulois est défini par son nom et sa force.
 * 
 * <p> Il peut :</p>
 * <ul>
 *   <li> -parler ({@link #parler(String)})</li>
 *   <li> -frapper un romain ({@link #frapper(Romain)})</li>
 * </ul>
 */
public class Chef {
	// ===== ATTRIBUTS =====
	/**
	 * Le nom du chef
	 */
	private String nom;
	/**
	 * La force du chef
	 */
	private int force;
	/**
	 * Le nom du village du chef
	 */
	private Village village;

	// ===== CONSTRUCTEURS =====
	/**
	 * Crée un nouveau chef
	 *
	 * @param nom   le nom du chef (String)
	 * @param force la force du chef (int)
	 * @param nom   le nom du village dirigé par le chef (String)
	 */
	public Chef(String nom, int force, Village village) {
		this.nom = nom;
		this.force = force;
		this.village = village;
	}

	// ===== METHODES =====
	/**
	 * Renvoie le nom du chef
	 * 
	 * @return nom le nom du chef (String)
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Affiche une ligne de dialogue en fonction du texte spécifié
	 * 
	 * @param texte le texte prononcé par le chef (String)
	 */
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	/**
	 * Frappe le romain spécifié. Les dégâts reçus sont propotionnels à l'attribut
	 * force
	 * 
	 * @param romain le romain visé par l'attaque (Romain)
	 */
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoir de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}

	/**
	 * Renvoie une chaîne de caractères destinée à précéder une parole
	 * 
	 * @return "Le chef NOM : " où NOM est le nom du chef (Romain)
	 */
	private String prendreParole() {
		return "Le chef " + nom + " : ";
	}

}
