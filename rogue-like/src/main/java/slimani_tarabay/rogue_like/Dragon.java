package slimani_tarabay.rogue_like;
/**
 * La classe Dragon herite la classe Personnage
 * @author marianetarabay
 *
 */
public class Dragon extends Personnage{

	public Dragon(int coordonneesX, int coordonneesY, String apparence, int pointDeVie) {
		super(coordonneesX, coordonneesY, apparence, pointDeVie);
	}
	
	public void taper(Personnage p) {
			int pv = p.getPointDeVie()-1;
			p.setPointDeVie(pv);
	}
}
