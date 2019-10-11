package slimani_tarabay.rogue_like;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Saisie {
	static Map map;
	public static final int levelFinal = 5;
	public static int echecPartie = 0;
	boolean t=true;
	public void debuterJeu() throws TaperInterdit{
		
		FileInputStream fin = null;
		FileOutputStream os = null;
		try {
			fin = new FileInputStream("sauvegarde");
		} catch (FileNotFoundException e) {
			System.out.println("File not found exception");
		}
		File file=new File("sauvegarde");
		int i = 0;
		if (file.length() == 0) {
			map = new Map();
			map.initCarte();
			System.out.println(map);
			commencerJeu(map);
		} else {
			
			String c;
			do {
			System.out.println("There's already a game saved. Do you want to start a new game? type yes or no");
			Scanner input=new Scanner(System.in);
			c=input.nextLine();
			}while(!c.equals("yes") && !c.equals("no"));
			
			if(c.equals("yes")) {
				map = new Map();
				map.initCarte();
				System.out.print(map);
				System.out.println("level"+Map.level+" pv:"+map.getJoueur().getPointDeVie()+" pm:"+map.getJoueur().getPointDeMagie()+" arme:"+map.getJoueur().getArme());
				commencerJeu(map);
			}else if (c.equals("no")) {
				System.out.flush();
				try {
					Joueur j1 = new Joueur(1, 1, "@", 4, 4);
					int hauteur, largeur, level;
					int nbr;
					int xa, ya, xs, ys;
					ArrayList<Dragon> dragons = new ArrayList<Dragon>();
					String str,armeMap;
					BufferedReader br = new BufferedReader(new FileReader("sauvegarde"));
					str = br.readLine();
					j1.setCoordonneesX(Integer.parseInt(str));
					str = br.readLine();
					j1.setCoordonneesY(Integer.parseInt(str));
					str = br.readLine();
					j1.setApparence(str);
					str = br.readLine();
					j1.setPointDeVie(Integer.parseInt(str));
					str = br.readLine();
					j1.setPointDeMagie(Integer.parseInt(str));
					str = br.readLine();
					if(str.charAt(0) == Arme.BATON.toString().charAt(0)) {
						j1.setArme(Arme.BATON);
					}else if(str.charAt(0) == Arme.EPAIS.toString().charAt(0)) {
						j1.setArme(Arme.EPAIS);
					}else if(str.charAt(0) == Arme.HACHE.toString().charAt(0)){
						j1.setArme(Arme.HACHE);
					}
					str = br.readLine();
					armeMap = str;
					str = br.readLine();
					xa = Integer.parseInt(str);
					str = br.readLine();
					ya = Integer.parseInt(str);
					
					str = br.readLine();
					xs = Integer.parseInt(str);
					str = br.readLine();
					ys = Integer.parseInt(str);
					str = br.readLine();
					hauteur = Integer.parseInt(str);
					str = br.readLine();
					largeur = Integer.parseInt(str);
					String murs[][] = new String[hauteur][largeur];
					str = br.readLine();
					level = Integer.parseInt(str);
					for (int k = 0; k < level + map.nbrMonstre; k++) {
						Dragon d = new Dragon(1, 1, "D", 1);
						str = br.readLine();
						d.setCoordonneesX(Integer.parseInt(str));
						str = br.readLine();
						d.setCoordonneesY(Integer.parseInt(str));
						str = br.readLine();
						d.setApparence(str);
						str = br.readLine();
						d.setPointDeVie(Integer.parseInt(str));
						dragons.add(d);

					}
					str = br.readLine();
					nbr = Integer.parseInt(str);

					for (int k = 0; k < nbr; k++){
						int x, y;
						str = br.readLine();

						x = Integer.parseInt(str);

						str = br.readLine();

						y = Integer.parseInt(str);

						murs[y][x] = "#";
					}
					if(armeMap.charAt(0) == Arme.BATON.toString().charAt(0)) {
						map = new Map(hauteur, largeur, level, j1, dragons, Arme.BATON);
					}else if(armeMap.charAt(0) == Arme.EPAIS.toString().charAt(0)) {
						
						map = new Map(hauteur, largeur, level, j1, dragons, Arme.EPAIS);
					}else if(armeMap.charAt(0) == Arme.HACHE.toString().charAt(0)){
						map = new Map(hauteur, largeur, level, j1, dragons, Arme.HACHE);
					}
					map.remettreCarte(xa, ya, xs, ys, nbr, murs);
					System.out.print(map);
					System.out.println("level"+Map.level+" pv:"+map.getJoueur().getPointDeVie()+" pm:"+map.getJoueur().getPointDeMagie()+" arme:"+map.getJoueur().getArme());
					br.close();
					fin.close();
					commencerJeu(map);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	public void commencerJeu(Map map) throws TaperInterdit
	{
		do
		{
			if(map.level == levelFinal) {
				System.out.println("\n\n\n\n\n\n\n\n\nFelicitation vous avez terminer le jeu avec succes !");
				break;
			}else if(echecPartie == 1) {
				System.out.println("\n\n\n\n\n\n\n\n\nVous avez perdu la partie !");
				break;
			}
			Scanner sc = new Scanner(System.in);
			String s=sc.nextLine();
			if(s.equals("deplacer haut"))
			{
				Deplacer.HAUT.moveOnMap(map);

			}
			if(s.equals("deplacer bas"))
			{
				Deplacer.BAS.moveOnMap(map);

			}
			if(s.equals("deplacer droite"))
			{
				Deplacer.DROITE.moveOnMap(map);

			}
			if(s.equals("deplacer gauche"))
			{
				Deplacer.GAUCHE.moveOnMap(map);

			}

			if(s.equals("taper monstre"))	{
				t=false;
				int x,y;
				for(int j=0;j<map.getDragon().size();j++)
				{
					x=0;y=0;
					if(map.getCarte()[map.getJoueur().getCoordonneesY()-1][map.getJoueur().getCoordonneesX()]==map.getDragon(j) ) {
						x = 0; y = -1;
						t=true;
					}
					else if(map.getCarte()[map.getJoueur().getCoordonneesY()+1][map.getJoueur().getCoordonneesX()]==map.getDragon(j)) {
						x = 0; y = 1;
						t=true;
					}
					else if(map.getCarte()[map.getJoueur().getCoordonneesY()][map.getJoueur().getCoordonneesX()-1]==map.getDragon(j)) {
						x = -1; y = 0;
						t=true;
					}
					else if(map.getCarte()[map.getJoueur().getCoordonneesY()][map.getJoueur().getCoordonneesX()+1]==map.getDragon(j) ){
						x = 1; y = 0;
						t=true;
					}
					if(x != 0 || y != 0) {
						map.getJoueur().taper(map.getDragon(j), map.getJoueur().getArme());
						if(map.getDragon(j).getPointDeVie()>=0)
							System.out.print("pv monstre: "+map.getDragon(j).getPointDeVie());
						else
							System.out.print("pv monstre: 0");
						if(map.getDragon(j).getPointDeVie() <= 0) {
							map.getCarte()[map.getJoueur().getCoordonneesY()+y][map.getJoueur().getCoordonneesX()+x] = DecorMap.SOL;
						}
					}
				}
			}
			
			if(s.equals("ramasser arme")) {
				int x=0,y=0;
				
				if(map.getCarte()[map.getJoueur().getCoordonneesY()][map.getJoueur().getCoordonneesX()+1] instanceof Arme) {
					x = 1; y = 0;
				}else if(map.getCarte()[map.getJoueur().getCoordonneesY()+1][map.getJoueur().getCoordonneesX()] instanceof Arme) {
					x = 0; y = 1;
				}else if(map.getCarte()[map.getJoueur().getCoordonneesY()][map.getJoueur().getCoordonneesX()-1] instanceof Arme) {
					x = -1; y = 0;
				}else if(map.getCarte()[map.getJoueur().getCoordonneesY()-1][map.getJoueur().getCoordonneesX()] instanceof Arme) {
					x = 0; y = -1;
				}else {
					System.out.print("aucun baton a proximité");
				}
				if(x != 0 || y != 0) {
					if(map.getCarte()[map.getJoueur().getCoordonneesY()+y][map.getJoueur().getCoordonneesX()+x] == Arme.BATON) {
						map.getJoueur().setPointDeMagie((map.getJoueur().getPointDeMagie()+Arme.BATON.perdPoints()));
						map.getJoueur().setArme(Arme.BATON);
					}else if(map.getCarte()[map.getJoueur().getCoordonneesY()+y][map.getJoueur().getCoordonneesX()+x] == Arme.EPAIS) {
						map.getJoueur().setPointDeMagie((map.getJoueur().getPointDeMagie()+Arme.EPAIS.perdPoints()));
						map.getJoueur().setArme(Arme.EPAIS);
					}else if(map.getCarte()[map.getJoueur().getCoordonneesY()+y][map.getJoueur().getCoordonneesX()+x] == Arme.HACHE){
						map.getJoueur().setPointDeMagie((map.getJoueur().getPointDeMagie()+Arme.HACHE.perdPoints()));
						map.getJoueur().setArme(Arme.HACHE);
					}
					map.getCarte()[map.getJoueur().getCoordonneesY()+y][map.getJoueur().getCoordonneesX()+x] = DecorMap.SOL;
				}
			}
			if(t==false) 
			{System.out.println("Ne peut pas taper le monstre, trop loin");}
			
			if (s.equals("sauvegarder partie")) {

				try {
					File f = new File("sauvegarde");
					FileWriter fw = new FileWriter("sauvegarde");
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(String.valueOf(map.coordxJ()));
					bw.newLine();
					bw.write(String.valueOf(map.coordyJ()));
					bw.newLine();
					bw.write(map.getJoueur().getApparence());
					bw.newLine();
					bw.write(String.valueOf(map.getJoueur().getPointDeVie()));
					bw.newLine();
					bw.write(String.valueOf(map.getJoueur().getPointDeMagie()));
					bw.newLine();
					bw.write(String.valueOf(map.getJoueur().getArme()));
					bw.newLine();
					bw.write(String.valueOf(map.getArme()));
					bw.newLine();
					boolean t = false;
					for (int y = 0; y < map.getHauteur(); y++) {
						for (int x = 0; x < map.getLargeur(); x++) {
							if (map.getCarte()[y][x] == map.getArme()) {
								t= true;
								bw.write(String.valueOf(x));

								bw.newLine();
								bw.write(String.valueOf(y));

								bw.newLine();
							}

						}
					}
					if(t == false) {
						bw.write(String.valueOf(-1));

						bw.newLine();
						bw.write(String.valueOf(-1));

						bw.newLine();
					}
					for (int y = 0; y < map.getHauteur(); y++) {
						for (int x = 0; x < map.getLargeur(); x++) {
							if (map.getCarte()[y][x] == DecorMap.SORTIE) {
								bw.write(String.valueOf(x));

								bw.newLine();
								bw.write(String.valueOf(y));

								bw.newLine();
							}

						}
					}
					bw.write(String.valueOf(map.getHauteur()));
					bw.newLine();
					bw.write(String.valueOf(map.getLargeur()));
					bw.newLine();
					bw.write(String.valueOf(map.getLevel()));
					bw.newLine();
					for (int k = 0; k < map.getLevel() + map.nbrMonstre; k++) {
						bw.write(String.valueOf(map.getDragon(k).getCoordonneesX()));
						bw.newLine();
						bw.write(String.valueOf(map.getDragon(k).getCoordonneesY()));
						bw.newLine();
						bw.write(map.getDragon(k).getApparence());
						bw.newLine();
						bw.write(String.valueOf(map.getDragon(k).getPointDeVie()));
						bw.newLine();
					}
					int count = map.getNb();
					bw.write(String.valueOf(count));
					bw.newLine();
					for (int y = 0; y < map.getHauteur(); y++) {
						for (int x = 0; x < map.getLargeur(); x++) {
							if (map.getCarte()[y][x] == DecorMap.MUR) {
								bw.write(String.valueOf(x));
								bw.newLine();
								bw.write(String.valueOf(y));
								bw.newLine();
							}
						}
					}

					bw.close();
					fw.close();
					System.out.println("Le niveau a bien ete sauvegarder.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.print(map);
			System.out.println("level"+Map.level+" pv:"+map.getJoueur().getPointDeVie()+" pm:"+map.getJoueur().getPointDeMagie()+" arme:"+map.getJoueur().getArme());
		}while(true);
	}
}
