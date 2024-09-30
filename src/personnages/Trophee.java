package personnages;

/**
 * Cette classe est utilisee ppour representer un trophee qui peut etre obtenu
 * par un gaulois apres s'etre battu avec un romain
 */
public class Trophee {
	// ===== ATTRIBUTS =====
	/** Le gaulois qui possede le trophee */
	private Gaulois gaulois;
	/** L'equipement representant le trophee */
	private Equipement equipement;

	// ===== CONSTRUCTEURS =====
	/**
	 * Cree un trophee en fonction du gaulois proprietaire ainsi que de l'equipement
	 * associe
	 * 
	 * @param gaulois    le gaulois proprietaire du trophee
	 * @param equipement l'equipement qui represente le trophee
	 */
	public Trophee(Gaulois gaulois, Equipement equipement) {
		this.gaulois = gaulois;
		this.equipement = equipement;
	}

	// ===== METHODES =====
	/**
	 * Renvoie le gaulois qui possede le trophee
	 * 
	 * @return le gaulois proprietaire du trophee (Gaulois)
	 */
	public Gaulois getGaulois() {
		return gaulois;
	}

	/**
	 * Renvoie l'equipement qui represente le trophee
	 * 
	 * @return l'equipement representant le trophee
	 */
	public Equipement getEquipement() {
		return equipement;
	}

}
