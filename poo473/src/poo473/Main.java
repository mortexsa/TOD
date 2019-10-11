package poo473;


public class Main {
    public static void main(String[] args) {
    	Repertoire r1=new Repertoire("racine");
    	Repertoire r2=new Repertoire("r2");
    	Repertoire r3=new Repertoire("r3");
        Repertoire r4=new Repertoire("r4");
        Repertoire r5=new Repertoire("r5");
        Repertoire r6=new Repertoire("r6");
        Repertoire r7=new Repertoire("r7");
    	Fichier f1=new Fichier("f1",2);
    	Fichier f2=new Fichier("f2",4);
    	Fichier f3=new Fichier("f3",3);
        r1.ajoutComposant(f1);//6
        r1.ajoutComposant(r4);
        r1.ajoutComposant(r1);
        r1.ajoutComposant(f1);
        r1.ajoutComposant(f2);
        r1.ajoutComposant(r2);
        System.out.println("Contenu de la racine r1");
        r1.afficher();
        r2.ajoutComposant(r3);
        System.out.println("Contenu de r2");
        r2.afficher();
        r4.ajoutComposant(r5);
        System.out.println("Contenu de r4");
        r4.afficher();
        r5.ajoutComposant(r6);
        r5.ajoutComposant(r4);
        System.out.println("Contenu de r5");
        r5.afficher();
        r6.ajoutComposant(f2);
        r6.ajoutComposant(r1);
        System.out.println("Contenu de r6");
        r6.afficher();
        r3.ajoutComposant(r1);
        System.out.println("Contenu de r3");
        r3.afficher();
        System.out.println("Taille repertoire : "+r1.getTaille());
    }
}
