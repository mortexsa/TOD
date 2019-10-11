package slimani_tarabay.rogue_like;

import java.util.ArrayList;
import java.util.EnumSet;

public class Map {
	private int hauteur = 10;
	private int largeur = 20;
	private int nbrMur = (hauteur*largeur)/9;
	public static final int nbrMonstre = 3;
	private int nb=0;
	public static int level = 1;
	private Object[][] carte;
	private Joueur joueur;
	private ArrayList<Dragon> dragon;
	private Arme arme;
	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}
	public Map() {
		carte = new Object[hauteur][largeur];
		this.joueur=new Joueur((int)((Math.random()*(largeur-2))+1),(int)((Math.random()*(hauteur-2))+1),"@",20, 20);
		this.dragon = new ArrayList<Dragon>(); 
	} 
	public Map(int h,int l,int le,Joueur j,ArrayList<Dragon> d,Arme a) {
		this.hauteur=h;
		this.largeur=l;
		this.level=le;
		this.setArme(a);
	
		this.nbrMur=(hauteur*largeur)/9;
		carte = new Object[hauteur][largeur];
		this.joueur=j;
		this.dragon = d; 
	} 
	public void initCarte() {
		int x,y;
		int randomX,randomY;
		for(y=0;y<hauteur;y++) {
			for(x=0;x<largeur;x++) {
				if(y== 0 || y == hauteur-1 || x == 0 || x == largeur-1)
					this.carte[y][x] = DecorMap.BORDURE;
				else
					this.carte[y][x] = DecorMap.SOL;
			}	
		}	
		
		for(y=0;y<nbrMur;y++) {
			this.carte[(int)((Math.random()*(hauteur-2))+1)][(int)((Math.random()*(largeur-2))+1)] = DecorMap.MUR;
		}
		for(y=0;y<hauteur;y++) {
			for(x=0;x<largeur;x++) {
				if(this.carte[y][x]==DecorMap.MUR)
					this.nb++;
			}	
		}	
		do {
			randomY = (int)((Math.random()*(hauteur-2))+1);
			randomX = (int)((Math.random()*(largeur-2))+1);
		}while(this.carte[randomY][randomX] != DecorMap.SOL);
		carte[this.joueur.getCoordonneesY()][this.joueur.getCoordonneesX()]=this.joueur;
		
		do {
			randomY = (int)((Math.random()*(hauteur-2))+1);
			randomX = (int)((Math.random()*(largeur-2))+1);
		}while(this.carte[randomY][randomX] != DecorMap.SOL);
		this.carte[randomY][randomX] = DecorMap.SORTIE;



		
		for(y=0;y<level+nbrMonstre;y++) {
			do {
				randomY = (int)((Math.random()*(hauteur-2))+1);
				randomX = (int)((Math.random()*(largeur-2))+1);
			}while(this.carte[randomY][randomX] != DecorMap.SOL);
			Dragon d = new Dragon(randomX, randomY, "D", 2);
			dragon.add(d);
			this.carte[randomY][randomX] = d;
		}

		int a=(int) (Math.random()*3+1);
		
		do {
			randomY = (int)((Math.random()*(hauteur-2))+1);
			randomX = (int)((Math.random()*(largeur-2))+1);
				
		}while(this.carte[randomY][randomX] != DecorMap.SOL);
		if(a==1)
		{
			this.carte[randomY][randomX] = Arme.BATON;
			this.arme = Arme.BATON;
		}
		if(a==2) {
			this.carte[randomY][randomX] = Arme.EPAIS;
			this.arme = Arme.EPAIS;
		}
		if(a==3) {
			this.carte[randomY][randomX] = Arme.HACHE;
			this.arme = Arme.HACHE;
		}

	}
	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}
	
	public void remettreCarte(int xa,int ya,int xs,int ys,int n,String[][] murs) {
		int x,y;
		int randomX,randomY;
		this.nb=n;
		for(y=0;y<hauteur;y++) {
			for(x=0;x<largeur;x++) {
				if(y== 0 || y == hauteur-1 || x == 0 || x == largeur-1)
					this.carte[y][x] = DecorMap.BORDURE;
				else
					this.carte[y][x] = DecorMap.SOL;
			}	
		}	
		
		for(y=0;y<hauteur;y++) {
			for(x=0;x<largeur;x++) {
				if(murs[y][x]=="#")
					this.carte[y][x] = DecorMap.MUR;
				
			}	
		}	
		
		carte[this.joueur.getCoordonneesY()][this.joueur.getCoordonneesX()]=this.joueur;
		
		
		for(y=0;y<level+nbrMonstre;y++) {
			int yd,xd;
			do {
				yd=dragon.get(y).getCoordonneesY();
				xd=dragon.get(y).getCoordonneesX();
			}while(this.carte[yd][xd] != DecorMap.SOL);
			if(dragon.get(y).getPointDeVie() > 0)
				this.carte[yd][xd] = dragon.get(y);
		}
		if(ya != -1 && xa != -1)
			this.carte[ya][xa] = this.arme;
		this.carte[ys][xs] = DecorMap.SORTIE;
	}
	@Override
	public String toString() {
		int y,x;
		String map="";
		for(y=(hauteur-1);y>=0;y--) {
			map += "\n";
			for(x=0;x<largeur;x++) {
				map += this.carte[y][x];
			}
		}
		map += "\n";
		return map;
	}
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		Map.level = level;
	}

	public int getHauteur() {
		return hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	public int getNbrmur() {
		return nbrMur;
	}
	public void movePlayer(int x,int y) throws NoMoveException
	{
		int i,randomDirection;
		if(carte[this.joueur.getCoordonneesY()+y][this.joueur.getCoordonneesX()+x] == DecorMap.SORTIE) {
			randomDirection = 0;
			for(i=0;i<dragon.size();i++) {
				if(dragon.get(i).getPointDeVie() > 0)
					randomDirection++;
			}
			if(randomDirection==0) {
				this.dragon.clear();
				level = level+1;
				if(Saisie.levelFinal != level)
					this.initCarte();
			}
		}else if(carte[this.joueur.getCoordonneesY()+y][this.joueur.getCoordonneesX()+x] == DecorMap.SOL){
			carte[this.joueur.getCoordonneesY()][this.joueur.getCoordonneesX()] = DecorMap.SOL;
			this.joueur.move(x, y);	
			carte[this.joueur.getCoordonneesY()][this.joueur.getCoordonneesX()]=this.joueur;
			for(i=0; i<dragon.size();i++) {
				if(this.dragon.get(i).getPointDeVie() > 0) {
					if(carte[this.dragon.get(i).getCoordonneesY()][this.dragon.get(i).getCoordonneesX()+1] == this.joueur ||
					   carte[this.dragon.get(i).getCoordonneesY()][this.dragon.get(i).getCoordonneesX()-1] == this.joueur ||
					   carte[this.dragon.get(i).getCoordonneesY()+1][this.dragon.get(i).getCoordonneesX()] == this.joueur ||
					   carte[this.dragon.get(i).getCoordonneesY()-1][this.dragon.get(i).getCoordonneesX()] == this.joueur) {
						this.dragon.get(i).taper(this.joueur);
						if(this.joueur.getPointDeVie() == 0) {
							Saisie.echecPartie = 1;
						}
					}else {
						randomDirection = (int)((Math.random()*4)%4)+1;
						carte[this.dragon.get(i).getCoordonneesY()][this.dragon.get(i).getCoordonneesX()] = DecorMap.SOL;
						if(randomDirection == 1) {
							if(carte[this.dragon.get(i).getCoordonneesY()][this.dragon.get(i).getCoordonneesX()+1] == DecorMap.SOL)
								this.dragon.get(i).move(1,0);
						}else if(randomDirection == 2) {
							if(carte[this.dragon.get(i).getCoordonneesY()+1][this.dragon.get(i).getCoordonneesX()] == DecorMap.SOL)
								this.dragon.get(i).move(0,1);
						}else if(randomDirection == 3) {
							if(carte[this.dragon.get(i).getCoordonneesY()-1][this.dragon.get(i).getCoordonneesX()] == DecorMap.SOL)
								this.dragon.get(i).move(0,-1);
						}else if(randomDirection == 4) {
							if(carte[this.dragon.get(i).getCoordonneesY()][this.dragon.get(i).getCoordonneesX()-1] == DecorMap.SOL)
								this.dragon.get(i).move(-1,0);
						}	
					}
					carte[this.dragon.get(i).getCoordonneesY()][this.dragon.get(i).getCoordonneesX()]=dragon.get(i);
				}
			}
		}else {
			throw new NoMoveException();
		}
		
	}
	
	public int coordxJ()
	{
		return this.joueur.getCoordonneesX();
	}
	
	public int coordyJ()
	{
		return this.joueur.getCoordonneesY();
	}
	
	public Joueur getJoueur()
	{
		return this.joueur;
	}

	public Dragon getDragon(int i)
	{
		return this.dragon.get(i);
	}

	public Object[][] getCarte() {
		return carte;
	}

	public ArrayList<Dragon> getDragon() {
		return dragon;
	}

	public void setDragon(ArrayList<Dragon> dragon) {
		this.dragon = dragon;
	}

	public void setCarte(Object[][] carte) {
		this.carte = carte;
	}
}
