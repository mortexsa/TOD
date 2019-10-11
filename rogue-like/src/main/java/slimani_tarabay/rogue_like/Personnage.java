package slimani_tarabay.rogue_like;

import javax.swing.plaf.metal.OceanTheme;

public abstract class Personnage {
	
	private int coordonneesX;
	private int coordonneesY;
	private int pointDeVie;
	private String apparence;
	/**
	 * Constructeur de la classe abstraite Personnage
	 * @param coordonneesX : x position du joueur
	 * @param coordonneesY: y position du joueur
	 * @param apparence String pour decrire comment va apparaitre le personnage
	 * @param pointDeVie Point de Vie de chaque personnage, lorseque les points de vie sont a ) le personnage meurt
	 */
	public Personnage(int coordonneesX,int coordonneesY, String apparence,int pointDeVie) {
		this.coordonneesX = coordonneesX;
		this.coordonneesY = coordonneesY;
		this.pointDeVie = pointDeVie;
		this.apparence = apparence;
	}
	/**
	 * Fonction pour inserer la coordonnees X du personnage
	 * @param coordonneesX
	 */
	public void setCoordonneesX(int coordonneesX) {
		this.coordonneesX = coordonneesX;
	}
	/**
	 * Fonction pour inserer la coordonnee Y du personnage
	 * @param coordonneesY
	 */
	public void setCoordonneesY(int coordonneesY) {
		this.coordonneesY= coordonneesY;
	}
	/**
	 * Fonction pour inserer le nb de points de vie du personnage
	 * @param pointDeVie
	 */
	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
	}
	/**
	 * Retourn la coordonneeX
	 * @return un type int
	 */
	public int getCoordonneesX() {
		return coordonneesX;
	}
	/**
	 * Retourn la coordonnee Y
	 * @return
	 */
	public int getCoordonneesY() {
		return coordonneesY;
	}
	public int getPointDeVie() {
		return pointDeVie;
	}
	
	public String getApparence() {
		return apparence;
	}

	public void setApparence(String apparence) {
		this.apparence = apparence;
	}

	@Override
	public String toString() {
		return this.apparence;
	}
	/** 
	 * Fonction qui permet au personnage de taper un autre personnage , soit les dragons soit les joueurs
	 * @param p qui est le personnage, soit dragons soit joueur
	 * @param a
	 * @throws TaperInterdit
	 */
	public void taper(Personnage p,Arme a) throws TaperInterdit
	{	
		int pv = p.getPointDeVie()-a.perdPoints();

	}
	
	public void move(int a,int b)
	{
		setCoordonneesX(getCoordonneesX()+a);
		setCoordonneesY(getCoordonneesY()+b);
		
	}
}
