
public enum Operation {
	
	PLUS ('+')
	{
		@Override
		public double eval(double a, double b)
		{
			return a+b;
		}
	},
	
	MOINS ('-')
	{
		
		@Override
		public double eval(double a, double b)
		{
			return a-b;
		}
	},
	
	MULT ('*')
	{
		@Override
		public double eval(double a, double b)
		{
			return a*b;
		}
	},
	
	DIV ('/')
	{
		@Override
		public double eval(double a, double b)
		{
			return a/b;
		}
	};

	
	//private char symbol;

	Operation(char symbol)
	{
		//this.symbol = symbol;
		
	}
	public abstract double eval(double a, double b);
	
	
}
