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
	// ===== ATTRIBUTS =====
	/**
	 * Le nom du romain
	 */
	private String nom;
	/**
	 * La force actuelle du romain
	 */
	private int force;
	/**
	 * Tableau contenant les equipements du romain
	 */
	private Equipement[] equipements = new Equipement[2];
	/**
	 * Le nombre q'equipements
	 */
	private int nbEquipement = 0;

	// ===== CONSTRUCTEURS =====
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
			throw new IllegalArgumentException("forceCoup negative : " + force);
		}
		int ancienne_force = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		if (ancienne_force < force) {
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

	/**
	 * Si le romain a déjà deux équipements la méthode affiche un message disant que
	 * le romain possède déjà l'equipement. Si le soldat possède déjà un équipement
	 * alors la première case du tableau est verifiee pour voir s'il s'agit du même
	 * équipement que celui donné en paramètre d’entrée, puis affichera un message. Dans
	 * les autres cas, l’équipement est ajouté au tableau et le nombre d’équipements
	 * est incrémenté puis un message est affiché.
	 * 
	 * @param equipement L'equipement a equiper (Equipement)
	 */
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			equiperObjet(equipement, 0);
			break;
		case 1:
			if (equipements[0] != null && equipement.equals(equipements[0])) {
				System.out.println("Le soldat " + getNom() + " possede deja un " + equipement + " !");
			} else {
				equiperObjet(equipement, 1);
			}
			break;
		case 2:
			System.out.println("Le soldat " + getNom() + " est deja bien protege !");
			break;
		default:
			break;
		}
	}

	/**
	 * Equipe un objet dans le tableau des equipements. Realise un affichage au
	 * prealable disant quel romain s'equipe de quel equipement
	 * 
	 * @param equipement L'equipement a equiper (Equipement)
	 * @param indice     L'indice du tableau d'equipements (int)
	 */
	private void equiperObjet(Equipement equipement, int indice) {
		System.out.println("Le soldat " + getNom() + " s'equipe avec un " + equipement + ".");
		equipements[indice] = equipement;
		nbEquipement++;
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
