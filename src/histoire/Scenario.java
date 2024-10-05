package histoire;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;
import villagegaulois.Musee;

/**
 * Cette classe est utilisee pour representer differents scenarios utilisant les
 * autres classes du projet
 */
public class Scenario {
	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5, 10);
		druide.parler("Je vais aller preparer une petite potion...");
		druide.preparerPotion();
		Gaulois obelix = new Gaulois("Obelix", 25);
		Gaulois asterix = new Gaulois("Asterix", 8);
		druide.booster(obelix);
		obelix.parler("Par Belenos, ce n'est pas juste !");
		druide.booster(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(minus);
		} while (!minus.isVainqueur() && minus.getForce() > 0);
		milexcus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(milexcus);
		} while (!milexcus.isVainqueur() && milexcus.getForce() > 0);		
		Musee musee = new Musee();
		asterix.faireUneDonation(musee);
		
		System.out.println(musee.extraireInstructionsOCaml());
	}

}
