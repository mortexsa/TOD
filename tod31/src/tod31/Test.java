package tod31;

import static org.junit.jupiter.api.Assertions.*;

class Test {

	@org.junit.jupiter.api.Test

	
	void testCompteBancaire()
	{
		CompteBancaire compte=new CompteBancaire(100);
		assertEquals(compte.getsolde(),100);
	}
	

}
