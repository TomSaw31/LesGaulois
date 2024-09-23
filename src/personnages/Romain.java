package personnages;

/**
 * Cette classe est utilisee pour representer le comportement d'un romain. Un
 * romain est defini par son nom et sa force.
 * 
 * <p>
 * Il peut :
 * </p>
 * <ul>
 * <li>-parler ({@link #parler(String)})</li>
 * <li>-prendre un coup ({@link #recevoirCoup(int)})</li>
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
	 * Cree un nouveau romain en fonction du nom et de la force specifiee
	 * 
	 * @param nom   Le nom du romain (String)
	 * @param force La force du romain (int)
	 */
	public Romain(String nom, int force) {
		if (force < 0) {
			throw new IllegalArgumentException("force negative");
		}
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
	 * Affiche une ligne de dialogue en fonction du texte specifie
	 * 
	 * @param texte le texte prononce par le romain (String)
	 */
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}

	/**
	 * Inflige un coup et diminue la force du romain en fonction de l'intensite
	 * specifiee. Affiche un message en fonction de la force restante.
	 * 
	 * @param forceCoup la force du coup inflige au romain (int)
	 */
	public void recevoirCoup(int forceCoup) {
		if (forceCoup < 0) {
			throw new IllegalArgumentException("forceCoup negative");
		}
		int ancienne_force = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		if (ancienne_force < force ) {
			throw new IllegalArgumentException("la force du romain n'a pas diminuee");
		}
	}

	/**
	 * Renvoie une chaine de caracteres destinee a preceder une parole
	 * 
	 * @return "Le romain NOM : " ou NOM est le nom du romain (String)
	 */
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
	}
}
