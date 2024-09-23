package personnages;

/**
 * Cette classe est utilisee pour representer le comportement d'un chef.
 * Un gaulois est defini par son nom et sa force.
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
	 * Cree un nouveau chef
	 *
	 * @param nom   le nom du chef (String)
	 * @param force la force du chef (int)
	 * @param nom   le nom du village dirige par le chef (String)
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
	 * Affiche une ligne de dialogue en fonction du texte specifie
	 * 
	 * @param texte le texte prononce par le chef (String)
	 */
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}

	/**
	 * Frappe le romain specifie. Les degats recus sont propotionnels a l'attribut
	 * force
	 * 
	 * @param romain le romain vise par l'attaque (Romain)
	 */
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoir de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}

	/**
	 * Renvoie une chaine de caracteres destinee a preceder une parole
	 * 
	 * @return "Le chef NOM : " ou NOM est le nom du chef (Romain)
	 */
	private String prendreParole() {
		return "Le chef " + nom + " : ";
	}

}
