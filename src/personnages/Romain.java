package personnages;

/**
 * Cette classe est utilisee pour representer le comportement dun romain. Un
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
	// ===== CONSTANTES =====
	/** Chaine de caracteres utilisee pour eviter les repetitions : "Le soldat " */
	private static final String SOLDAT_STR = "Le soldat ";

	// ===== ATTRIBUTS =====
	/** Le nom du romain */
	private String nom;
	/** La force actuelle du romain */
	private int force;
	/** Tableau contenant les equipements du romain */
	private Equipement[] equipements = new Equipement[2];
	/** Le nombre d'equipements */
	private int nbEquipement = 0;
	/** Indique si le romain a gagne contre le gaulois */
	private boolean vainqueur = false;

	// ===== CONSTRUCTEURS =====
	/**
	 * Cree un nouveau romain en fonction du nom et de la force specifiee
	 * 
	 * @param nom   Le nom du romain (String)
	 * @param force La force du romain (int)
	 */
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert verifierForceValide();
	}

	// ===== METHODES =====
	/**
	 * Renvoie le nom du romain
	 * 
	 * @return nom le nom du romain (String)
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Renvoie la force actuelle du romain
	 * 
	 * @return la force du romain (int)
	 */
	public int getForce() {
		return force;
	}

	/**
	 * Renvoie si le romain a gagne son duel
	 * 
	 * @return l'etat du romain (true si il gagne, false sinon) (boolean)
	 */
	public boolean isVainqueur() {
		return vainqueur;
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
	 * Renvoie une chaine de caracteres destinee a preceder une parole
	 * 
	 * @return "Le romain NOM : " ou NOM est le nom du romain (String)
	 */
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	/**
	 * Si le romain a deja deux equipements la methode affiche un message disant que
	 * le romain possede deja lequipement. Si le soldat possede deja un equipement
	 * alors la premiere case du tableau est verifiee pour voir sil sagit du même
	 * equipement que celui donne en parametre d'entree, puis affichera un message.
	 * Dans les autres cas, l'equipement est ajoute au tableau et le nombre
	 * d'equipements est incremente puis un message est affiche.
	 * 
	 * @param equipement Lequipement a equiper (Equipement)
	 */
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			equiperObjet(equipement);
			break;
		case 1:
			if (equipements[0] != null && equipement.equals(equipements[0])) {
				System.out.println(SOLDAT_STR + getNom() + " possede deja un " + equipement + " !");
			} else {
				equiperObjet(equipement);
			}
			break;
		case 2:
			System.out.println(SOLDAT_STR + getNom() + " est deja bien protege !");
			break;
		default:
			break;
		}
	}

	/**
	 * Inflige un coup et diminue la force du romain en fonction de l'intensite
	 * specifiee. Affiche un message en fonction de la force restante.
	 * 
	 * @param forceCoup la force du coup inflige au romain (int)
	 * @return lliste des equipements perdus par le romain lors d'un combat (Equipement[])
	 */
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// precondition
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		if (forceCoup <= 0) {
			vainqueur = true;
			parler("J'ai gagne.");
		} else {
			force -= forceCoup;
			assert verifierForceValide();
			if (force > 0) {
				parler("Aie");
			} else {
				equipementEjecte = ejecterEquipement();
				parler("J'abandonne...");
			}
		}
		// post condition la force a diminuee
		assert force <= oldForce;
		return equipementEjecte;
	}

	/**
	 * Calcule et diminue la force du coup passee en parametre en fonction de
	 * l'equipement porte par le romain (BOUCLIER : resistance = 8, CASQUE: resistance = 5)
	 * 
	 * @param forceCoup la force du coup initiale avant diminution (int)
	 * @return la force du coup apres diminution grace aux equipements (int)
	 */
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace a mon equipement sa force est diminue de ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					if (equipements[i] != null && equipements[i].equals(Equipement.CASQUE)) {
						System.out.println("Equipement casque");
						resistanceEquipement += 5;
					}
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	/**
	 * Enleve les equipements portes par le romain et affiche un message. Renvoie
	 * les equipements perdus
	 * 
	 * @return Les equipements perdus par le romain (Equipement[])
	 */
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'equipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	/**
	 * Equipe un objet dans le tableau des equipements. Realise un affichage au
	 * prealable disant quel romain sequipe de quel equipement
	 * 
	 * @param equipement Lequipement a equiper (Equipement)
	 */
	private void equiperObjet(Equipement equipement) {
		System.out.println(SOLDAT_STR + getNom() + " sequipe avec un " + equipement + ".");
		equipements[nbEquipement] = equipement;
		nbEquipement++;
	}

	/**
	 * Verifie l'invariant de force positive
	 * 
	 * @return si la force est positive (boolean)
	 */
	private boolean verifierForceValide() {
		return force >= 0;
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;
		minus.sEquiper(casque);
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);
		minus.sEquiper(bouclier);
	}
}
