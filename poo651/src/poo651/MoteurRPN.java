package poo651;

import java.util.Stack;

public class MoteurRPN {

	private Stack<Double> pile;

	public MoteurRPN() {
		this.pile = new Stack<Double>();
	}

	public Stack<Double> getPile() {
		return pile;
	}

	public void enregistrer(double operande) {
		pile.push(operande);
	}

	public void appliquer(Operation op) throws PileException, NonDivisibleException, HorsBornesException {

		if (pile.isEmpty()) {
			throw new PileVideException();
		}
		if (pile.size() == 1)
			throw new PileInsuffisanteException();
		else {
			Double a = pile.pop();
			Double b = pile.pop();
			if (Math.abs(op.eval(b, a)) <= SaisieRPN.MIN_VALUE || Math.abs(op.eval(b, a)) >= SaisieRPN.MAX_VALUE) {
				pile.push(b);
				pile.push(a);
				throw new HorsBornesException("La valeur doit etre un nombre entre la valeur absolue de "+ SaisieRPN.MIN_VALUE + " et la valeur absolue de " + SaisieRPN.MAX_VALUE);
			} else {
				enregistrer(op.eval(b, a));
			}
		}
	}

	public String toString() {
		return pile.toString();
	}
}