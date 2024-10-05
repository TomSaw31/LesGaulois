package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;
import personnages.Trophee;

/**
 * Cette classe est utilisee pour representer un musee dans un village. Le
 * musee sert a garder les differents trophees recoltes par les gaulois
 */
public class Musee {
	// ===== ATTRIBUTS =====
	/** Le max de trophees que le musee peut contenir */
	private final static int MAX_TROPHEES = 200;
	/** Les trophees presents dans le musee */
	private Trophee[] trophees = new Trophee[MAX_TROPHEES];
	/** Le nombre de trophees du musee */
	private int nbTrophees = 0;

	// ===== METHODES =====
	/**
	 * Recupere le trophee donne par le gaulois specifie et le range dans le musee
	 * 
	 * @param gaulois    Le gaulois donnateur (Gaulois)
	 * @param equipement L'equipement donne (Equipement)
	 */
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee trophee = new Trophee(gaulois, equipement);
		trophees[nbTrophees] = trophee;
		nbTrophees++;
	}

	/**
	 * Transforme le contenu du musee en chaine de caracteres utilisable en OCaml
	 * 
	 * @return la chaine de caracteres utilisable en OCaml
	 */
	public String extraireInstructionsOCaml() {
		String texte = "let musee = [";
		for (int i = 0; i < trophees.length; i++) {
			if (trophees[i] != null) {
				if (i != 0) {
					texte += ";";
				}
				texte += "\n\t\"";
				texte += trophees[i].getGaulois().getNom();
				texte += "\", \"";
				texte += trophees[i].getEquipement().getNom();
				texte += "\"";
			}
		}
		texte += "\n]";
		return texte;
	}
}
