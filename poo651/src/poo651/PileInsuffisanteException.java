package poo651;

public class PileInsuffisanteException extends PileException{
	
	public PileInsuffisanteException()
	{
		super("Il n'y a qu'un seul nombre");
	}
}
