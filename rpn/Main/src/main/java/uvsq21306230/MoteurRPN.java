package uvsq21306230;
import java.util.Stack;

public class MoteurRPN {
	
	  private Stack<Double> pile; 
	  
	  public MoteurRPN()
	  {
		  this.pile = new Stack<Double>();
	  }
	  
	  
	  public void empiler(double op)
	  {
		  
			  pile.push(op);
		  
	  }
	  
	  public void appliquer(Operation op)
	  {
		  if(pile.size() >= 2)
		  {
			  double op1 = pile.pop();
			  double op2 = pile.pop();
			  if(op.eval(op1,op2)>=SaisieRPN.MIN_VALUE && op.eval(op1,op2)<=SaisieRPN.MAX_VALUE)
			  {
				  empiler(op.eval(op1,op2));
			  }
			  else
			  {
				  System.out.println("La valeur calculée est hors limite");
				  empiler(op2);
				  empiler(op1);
			  }
			  
			
		  }
		  else 
			  System.out.println("Rentrer une op�rande : ");
		  
		  
	  }

	  public String toString()
	  {
		  String s = pile.toString();
		  System.out.println(s);
		  return s;
	  }
}

