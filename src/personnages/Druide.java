package personnages;

import java.util.Random;

/**
 * Cette classe est utilisee pour representer le comportement d'un druide. Un
 * druide est defini par son nom ainsi qu'un minimum et maximum pour ses effets
 * de potion
 * 
 * <p>
 * Il peut :
 * </p>
 * <ul>
 * <li>-parler ({@link #parler(String)})</li>
 * <li>-preparer une potion ({@link #preparerPotion()})</li>
 * <li>-booster un gaulois ({@link #booster(Gaulois)})</li>
 * </ul>
 */
public class Druide {
	// ===== ATTRIBUTS =====
	/** Le nom du druide */
	private String nom;
	/** L'effet minimum des potions preparees par le druide */
	private int effetPotionMin;
	/** L'effet maximum des potions preparees par le druide */
	private int effetPotionMax;
	/**
	 * L'effet actuel de la potion prepare par le druide. Initialise a 1 par defaut.
	 */
	private int forcePotion = 1;
	private Random rand = new Random();

	// ===== CONSTRUCTEURS =====
	/**
	 * Cree un druide en fonction du nom, du minimum et maximum d'effet de potion
	 * specifies. Affiche ensuite un message.
	 * 
	 * @param nom            Le nom du druide (String)
	 * @param effetPotionMin L'effet minimum des potions preparees par le druide
	 *                       (int)
	 * @param effetPotionMax L'effet maximum des potions preparees par le druide
	 *                       (int)
	 */
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " a "
				+ effetPotionMax + ".");
	}

	// ===== METHODES =====
	/**
	 * Renvoie le nom du druide
	 * 
	 * @return nom le nom du druide (String)
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Renvoie la force de la potion actuelle
	 * 
	 * @return forcePotion La force de la potion (int)
	 */
	public int getForcePotion() {
		return forcePotion;
	}

	/**
	 * Affiche une ligne de dialogue en fonction du texte specifie
	 * 
	 * @param texte le texte prononce par le druide (String)
	 */
	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}

	/**
	 * Prepare une nouvelle potion possedant une force comprise entre le minimum
	 * (inclus) et le maximum (inclus) d'effet de potion du druide. Change la valeur
	 * de l'ancien effet de potion par celui de la nouvelle potion. Affiche un
	 * message en fonction de la force de la nouvelle potion. Si la force de la
	 * potion depasse 7, il s'agira d'une super potion, sinon ce sera un potion
	 * simple.
	 */
	public void preparerPotion() {
		int random_force = rand.nextInt(effetPotionMax - effetPotionMin + 1) + effetPotionMin;
		if (random_force > 7) {
			parler("J'ai prepare une super potion de force " + random_force + ".");
		} else {
			parler("Je n'ai pas trouve tous les ingredients, ma potion est seulement de force " + random_force + ".");
		}
		forcePotion = random_force;
	}

	/**
	 * Booste le gaulois specifie si le gaulois n'est pas Obelix, auquel cas un
	 * message sera affiche, sinon le gaulois boira la potion.
	 * 
	 * @param gaulois Le gaulois recevant la potion (Gaulois)
	 */
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() != null && gaulois.getNom().equals("Obelix")) {
			parler("Non, Obelix !... Tu n'auras pas de potion magique !");
		} else {
			gaulois.boirePotion(forcePotion);
		}
	}

	/**
	 * Renvoie une chaine de caracteres destinee a preceder une parole
	 * 
	 * @return "Le druide NOM : " ou NOM est le nom du druide (String)
	 */
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
}
