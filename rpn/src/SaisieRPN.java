import java.util.Scanner;
import java.util.EmptyStackException;
public class SaisieRPN {
	
	protected static final double MIN_VALUE = 0;
	protected static final double MAX_VALUE = 99999;
	
	public void affiche() 
	{
		MoteurRPN m = new MoteurRPN();
		char ope;
		System.out.println("entrer");
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Double entree;
	
		while(!input.equals("exit"))
		{
			try
			{
				ope = input.charAt(0);
				if(ope == '+')
				{
					m.appliquer(Operation.PLUS);
	
				}
				else if(ope == '-')
				{
					m.appliquer(Operation.MOINS);
	
				}
				else if(ope == '*')
				{
					m.appliquer(Operation.MULT);
				}
				else if (ope== '/')
				{
					m.appliquer(Operation.DIV);
				}
				
				else 
				{
					entree = Double.parseDouble(input);
					if(entree > MAX_VALUE || entree < MIN_VALUE)
					{
						throw new ExceptionValue();
					}
				
					m.empiler(entree);
				}
				m.toString();
	
			}
			
			catch(IllegalArgumentException e)
			{
				System.out.println("Rentrer une opérande : ");
			}
			catch(EmptyStackException e)
			{
				System.out.println("Vous n'avez aucune valeurs à calculer");
				
			}
			catch(StringIndexOutOfBoundsException e)
			{
				System.out.println("Vous êtes");
			}
			catch(ExceptionValue e)
			{
				System.out.println("Valeur non gérée");
			}
			
			input = sc.nextLine();
			}
		
			sc.close();
			System.exit(0);
		
		}
}
