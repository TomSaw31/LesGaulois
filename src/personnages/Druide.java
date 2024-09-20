package personnages;

import java.util.Random;

/**
 * Cette classe est utilisée pour représenter le comportement d'un druide. Un
 * druide est défini par son nom ainsi qu'un minimum et maximum pour ses effets
 * de potion
 * 
 * <p>
 * Il peut :
 * </p>
 * <ul>
 * <li>-parler ({@link #parler(String)})</li>
 * <li>-préparer une potion ({@link #preparerPotion()})</li>
 * <li>-booster un gaulois ({@link #booster(Gaulois)})</li>
 * </ul>
 */
public class Druide {
	// ===== ATTRIBUTS =====
	/**
	 * Le nom du druide
	 */
	private String nom;
	/**
	 * L'effet minimum des potions préparées par le druide (int)
	 */
	private int effetPotionMin;
	/**
	 * L'effet maximum des potions préparées par le druide (int)
	 */
	private int effetPotionMax;
	/**
	 * L'effet actuel de la potion préparé par le druide. Initialisé à 1 par défaut.
	 * (int)
	 */
	private int forcePotion = 1;

	// ===== CONSTRUCTEURS =====
	/**
	 * Crée un druide en fonction du nom, du minimum et maximum d'effet de potion
	 * spécifiés. Affiche ensuite un message.
	 * 
	 * @param nom            Le nom du druide (String)
	 * @param effetPotionMin L'effet minimum des potions préparées par le druide
	 *                       (int)
	 * @param effetPotionMax L'effet maximum des potions préparées par le druide
	 *                       (int)
	 */
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
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
	 * Affiche une ligne de dialogue en fonction du texte spécifié
	 * 
	 * @param texte le texte prononcé par le druide (String)
	 */
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	/**
	 * Prépare une nouvelle potion possédant une force comprise entre le minimum
	 * (inclus) et le maximum (inclus) d'effet de potion du druide. Change la valeur
	 * de l'ancien effet de potion par celui de la nouvelle potion. Affiche un
	 * message en fonction de la force de la nouvelle potion. Si la force de la
	 * potion dépasse 7, il s'agira d'une super potion, sinon ce sera un potion
	 * simple.
	 */
	public void preparerPotion() {
		Random rand = new Random();
		int random_force = rand.nextInt(effetPotionMax - effetPotionMin + 1) + effetPotionMin;
		if (random_force > 7) {
			parler("J'ai préparé une super potion de force " + String.valueOf(random_force) + ".");
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force "
					+ String.valueOf(random_force) + ".");
		}
		forcePotion = random_force;
	}

	/**
	 * Booste le gaulois spécifié si le gaulois n'est pas Obélix, auquel cas un
	 * message sera affiché, sinon le gaulois boira la potion.
	 * 
	 * @param gaulois Le gaulois recevant la potion (Gaulois)
	 */
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() == "Obélix") {
			parler("Non, Obélix !... Tu n’auras pas de potion magique !");
		} else {
			gaulois.boirePotion(forcePotion);
		}
	}

	/**
	 * Renvoie une chaîne de caractères destinée à précéder une parole
	 * 
	 * @return "Le druide NOM : " où NOM est le nom du druide (String)
	 */
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
}
