package personnages;

/**
 * Cette classe est utilisee pour representer le comportement d'un village
 */
public class Village {
	// ===== ATTRIBUTS =====
	/**
	 * Le nom du village (String)
	 */
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	// ===== CONSTRUCTEURS =====
	/**
	 * Cree un nouveau village portant le nom specifie
	 *
	 * @param nom le nom du village (String)
	 */
	public Village(String nom, int nbVillageoisMaximum) {
		this.villageois = new Gaulois[nbVillageoisMaximum];
		this.nom = nom;
	}

	// ===== METHODES =====
	/**
	 * Renvoie le nom du village
	 * 
	 * @return nom le nom du village (String)
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Modifie le chef du village
	 * 
	 * @param chef le nouveau chef du village (String)
	 */
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
	}

	public Gaulois trouverHabitant(int numero) {
		return villageois[numero];
	}

	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + chef + " vivent les legendaires gaulois :");
		for (int i = 0; i < villageois.length; i++) {
			if (villageois[i] != null) {
				System.out.println(" - " + villageois[i].getNom());
			}
		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irreductibles", 30);

		/*
		 * Gaulois gaulois = village.trouverHabitant(30); On obtient l'erreur : Index 30
		 * out of bounds for length 30 On obtient cette erreur car on cherche un gaulois
		 * à la 31eme case dans un tableau de 30 cases
		 */

		Chef abracourcix = new Chef("Abraracourcix", 8, village);
		village.setChef(abracourcix);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
		/*
		 * village.ajouterHabitant(asterix); Gaulois gaulois =
		 * village.trouverHabitant(1); System.out.println(gaulois);
		 * 
		 * null est affiche car villageois contient un unique gaulois qui est à l'indice
		 * 0 donc le villageois dans la case 1 n'est pas definie
		 */

		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
