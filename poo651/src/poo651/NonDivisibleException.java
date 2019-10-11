package poo651;

public class NonDivisibleException extends Exception{

	public NonDivisibleException()
	{
		super("On ne peut diviser avec 0");
	}
}
