package poo473;

public class Fichier extends Composant {
	int taille;

	public Fichier(String n, int t) {
		super(n);
		taille = t;
	}

	@Override
	public int getTaille() {
		return taille;
	}

	@Override
	public void afficher() {
		System.out.println("Nom " + this.getNom() + " Taille:" + this.getTaille());
	}

}
