package tod31;

public class CompteBancaire {
double solde=0.0;

public CompteBancaire(double s) {
	if(s>0)
		solde=s;
	
}
double getsolde()
{
	return solde;
}
void credit(double c) {
	if(c>0)
		solde=solde-c;
}

}
