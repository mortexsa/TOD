package poo651;

import java.io.*;

public enum Operation {
	PLUS('+') {
		@Override
		public double eval(double a, double b) {
			return a + b;
		}
	},
	MULT('*') {
		@Override
		public double eval(double a, double b) {
			return a * b;
		}
	},
	MOINS('-') {
		@Override
		public double eval(double a, double b) {
			return a - b;
		}
	},
	DIV('/') {
		@Override
		public double eval(double a, double b) throws NonDivisibleException {
			double c;
			if (b == 0)
				throw new NonDivisibleException();
			return a / b;

		}
	};

	private char symbole;

	Operation (char s) {
		symbole = s;
	}

	public char getSymbole() {
		return symbole;
	}

	public abstract double eval(double a, double b) throws NonDivisibleException;

}
