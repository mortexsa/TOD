package slimani_tarabay.rogue_like;
/**
 * Cette enum est pour decrire les differents types d'obstacles et decors sur la map
 * @author marianetarabay
 *
 */
public enum DecorMap {
	
	BORDURE("G"),SOL(" "),SORTIE("0"),MUR("#");
	
	private String type;
	
	private DecorMap(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type;
	}
}
