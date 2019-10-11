package poo472;

import java.util.*;

public final class Fraction implements Comparable<Fraction> {
	int numerateur;
	int denominateur;
	public static final Fraction ZERO = new Fraction(0, 1);
	public static final Fraction UN = new Fraction(1, 1);

	public Fraction(int num, int dem) {
		numerateur = num;
		denominateur = dem;
	}

	public Fraction(int num) {
		numerateur = num;
		denominateur = 1;
	}

	public Fraction() {
		numerateur = 0;
		denominateur = 1;
	}

	int getNum() {
		return numerateur;
	}

	int getDen() {
		return denominateur;
	}

	double getNombre() {
		return numerateur / denominateur;
	}
	/**
	*/
	Fraction addition(Fraction a, Fraction b) {

		int a1 = a.getNum();
		int a2 = a.getDen();
		int b1 = b.getNum();
		int b2 = b.getDen();
		Fraction f;

		if (a2 > b2 && a2 % b2 == 0) {
			int n = a2 / b2;
			b1 = n * b1;
			f = new Fraction(a1 + b1, a2);
		} else if (a2 < b2 && b2 % a2 == 0) {
			int n = b2 / a2;
			a1 = n * a1;
			f = new Fraction(a1 + b1, b2);
		} else {
			f = new Fraction(a1 * b2 + a2 * b1, b1 * b2);
		}
		return f;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + denominateur;
		result = prime * result + numerateur;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		if (this.getNombre() == other.getNombre())
			return true;
		if (denominateur != other.denominateur)
			return false;
		if (numerateur != other.numerateur)
			return false;
		return true;
	}

	String chaineCaractere() {
		return String.valueOf(this.getNum()) + "/" + String.valueOf(this.getDen());
	}

	@Override
	public int compareTo(Fraction f) {
		if (this.equals(f))
			return 0;
		else if (this.getNombre() < f.getNombre())
			return -1;
		else
			return 1;
	}

}
