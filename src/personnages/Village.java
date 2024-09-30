package personnages;

/**
 * Cette classe est utilisee pour representer le comportement d'un village
 */
public class Village {
	// ===== ATTRIBUTS =====
	/** Le nom du village */
	private String nom;
	/** Le chef du village */
	private Chef chef;
	/** Les villageois du village */
	private Gaulois[] villageois;
	/** Le nombre de villageois dans le village */
	private int nbVillageois = 0;

	// ===== CONSTRUCTEURS =====
	/**
	 * Cree un nouveau village portant le nom specifie
	 *
	 * @param nom                 le nom du village (String)
	 * @param nbVillageoisMaximum le nombre maximum de villageois que le village
	 *                            peut accueillir
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

	/**
	 * Ajoute un gaulois dans le village
	 * 
	 * @param gaulois Le gaulois a ajouter dans le village (Gaulois)
	 */
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
	}

	/**
	 * Renvoie le villageois du village en fonction du numero passe en argument
	 * 
	 * @param numero le numero de l'habitant a trouver (int)
	 * @return le villageois correspondant (Gaulois)
	 */
	public Gaulois trouverHabitant(int numero) {
		return villageois[numero];
	}

	/** Affiche le chef du village ainsi que ses habitants */
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
		 * a la 31eme case dans un tableau de 30 cases
		 */

		Chef abracourcix = new Chef("Abraracourcix", 8, village);
		village.setChef(abracourcix);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
		/*
		 * village.ajouterHabitant(asterix); Gaulois gaulois =
		 * village.trouverHabitant(1); System.out.println(gaulois);
		 * 
		 * null est affiche car villageois contient un unique gaulois qui est a l'indice
		 * 0 donc le villageois dans la case 1 n'est pas defini
		 */

		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
