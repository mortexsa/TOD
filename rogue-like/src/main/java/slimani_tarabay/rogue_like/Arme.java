package slimani_tarabay.rogue_like;

public enum Arme {
BATON("|") {
	@Override
	public int perdPoints() {
		return 1;
	}


},EPAIS("!") {
	@Override
	public int perdPoints() {
		return 2;
	}


},HACHE("?") {
	@Override
	public int perdPoints() {
		return 3;
	}


};
	String arme;
	
private Arme(String s)
{
arme=s;

}
public String getArme() {
	return this.arme;
}

public abstract int perdPoints();
@Override
public String toString() {
	return this.arme;
}

}
