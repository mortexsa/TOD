import java.util.Stack;

public class MoteurRPN {
	
	  private Stack<Double> pile; //= new Stack<Integer>();
	  
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
			  pile.push(op.eval(op1,op2));
		  }
		  else 
			  System.out.println("Rentrer une opérande : ");
		  
		  
	  }

	  public String toString()
	  {
		  String s = pile.toString();
		  System.out.println(s);
		  return s;
	  }
}

