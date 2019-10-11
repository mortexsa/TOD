package slimani_tarabay.rogue_like;

public class Joueur extends Personnage{

	private int pointDeMagie;
	private Arme arme=Arme.BATON;
	public Joueur(int coordonneesX, int coordonneesY, String apparence, int pointDeVie, int pointDeMagie) {
		super(coordonneesX, coordonneesY, apparence, pointDeVie);
		this.pointDeMagie = pointDeMagie;
	}

	public void setPointDeMagie(int pointDeMagie) {
		this.pointDeMagie = pointDeMagie;
	}
	public void move(int a,int b)
	{
		setCoordonneesX(getCoordonneesX()+a);
		setCoordonneesY(getCoordonneesY()+b);
		
	}
	@Override
	public void taper(Personnage p,Arme a) throws TaperInterdit
	{
		p.setPointDeVie(p.getPointDeVie()-a.perdPoints());
		this.pointDeMagie=this.pointDeMagie-1;
		
	}

	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}

	public int getPointDeMagie() {
		return pointDeMagie;
	}
	

}
