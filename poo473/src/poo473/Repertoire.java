package poo473;

import java.util.ArrayList;
import java.util.Iterator;

public class Repertoire extends Composant {
	protected ArrayList<Composant> composant;

	public Repertoire(String nom) {
		super(nom);
		this.composant = new ArrayList<Composant>();
	}

	public ArrayList<Composant> getComposant() {
		return composant;
	}

	public void ajoutComposant(Composant c) {
		if (c instanceof Fichier)
			for (int i = 0; i < this.getComposant().size(); i++)
				if (c == this.getComposant().get(i))
					return;

		if (!equals(c) && this.nonDescendant(c)) {
			this.composant.add(c);
		}
	}

	@Override
	public void afficher() {
		System.out.println("Nom : " + this.getNom());
		Iterator<Composant> iter = this.composant.iterator();
		System.out.println("Fichiers et Repertoires: ");
		if (!iter.hasNext())
			System.out.println("Vide");
		else
			while (iter.hasNext()) {
				System.out.println(iter.next().getNom() + "");
			}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((composant == null) ? 0 : composant.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		return false;
	}

	public boolean nonDescendant(Composant c) {
		if (c instanceof Repertoire) {
			Repertoire r = (Repertoire) c;
			for (int i = 0; i < r.getComposant().size(); i++) {
				if (this.equals(r.getComposant().get(i)) || !this.nonDescendant(r.getComposant().get(i)))
					return false;
			}
		}
		return true;
	}

	@Override
	public int getTaille() {
		int t = 0;
		for (int i = 0; i < this.getComposant().size(); i++)
			t = t + this.getComposant().get(i).getTaille();
		return t;
	}
}
