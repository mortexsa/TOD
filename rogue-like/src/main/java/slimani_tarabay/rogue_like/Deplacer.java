package slimani_tarabay.rogue_like;


/**
 * Cette enum est pour decrire les sens dans lequelles le joueur peut se deplacer
 * @author marianetarabay
 *
 */
public enum Deplacer {
	HAUT("deplacer haut")  {
		@Override
		public void moveOnMap(Map m) {
			try {
				m.movePlayer(0,1);
			} catch (NoMoveException e) {
				
				System.out.println(e);
			}
		}
	},
	BAS("deplacer bas")  {
		@Override
		public void moveOnMap(Map m) {
			try {
				m.movePlayer(0,-1);
			} catch (NoMoveException e) {
				System.out.println(e);
			}
		}
	},
	DROITE("deplacer droite") {
		@Override
		public void moveOnMap(Map m) {
			try {
				m.movePlayer(1,0);
			} catch (NoMoveException e) {
				System.out.println(e);
			}
		}
	},
	
	GAUCHE("deplacer gauche")  {
		@Override
		public void moveOnMap(Map m) {
			try {
				m.movePlayer(-1,0);
			} catch (NoMoveException e) {
				System.out.println(e);
			}
		}
	};

	private String sens;

	Deplacer (String s) {
		sens = s;
	}

	public String getSens() {
		return sens;
	}
	/**
	 * Fonction abstraite pour pouvoir donner a la classe Map le sens dans lequel le joueur doit se deplacer
	 * @param m
	 */
	public abstract void moveOnMap(Map m);
}

