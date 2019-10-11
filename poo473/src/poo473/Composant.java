package poo473;

public abstract class Composant {
	protected String nom;

	public Composant(String n) {
		nom = n;
	}

	abstract void afficher();

	public String getNom() {
		return nom;
	};

	abstract int getTaille();

}
