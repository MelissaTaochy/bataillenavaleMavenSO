package fr.ibformation.springboot.bataillenavale.launcher;

import fr.ibformation.springboot.bataillenavale.gestionnairepartie.Joueur;
import fr.ibformation.springboot.bataillenavale.gestionnairepartie.Partie;

public class Launcher {

	public static void main(String[] args) {
	

		Joueur joueur1=new Joueur("joueur1");
		Joueur joueur2=new Joueur("joueur2");

		Partie p = joueur1.creerPartie();
		joueur2.rejoindrePartie(p);
		
		p.demarrerPartie();
		System.out.println("MAP1 INIT");
		System.out.println(p.getMap1().myToString());
		
		System.out.println("MAP2 INIT");
		System.out.println(p.getMap2().myToString());
		
		
		System.out.println("JOUEUR1"+ p.getJoueur1());
		System.out.println("JOUEUR2"+ p.getJoueur2());
		System.out.println("joueur1 tire");
		joueur1.tirer(0, 3);
		System.out.println("joueur2 tire");
		joueur2.tirer(2, 1);
		System.out.println("joueur1 tire");
		joueur1.tirer(3, 1);
		System.out.println("joueur2 tire");
		joueur2.tirer(3, 3);
		System.out.println("joueur1 tire");
		joueur1.tirer(4, 4);
		System.out.println("joueur2 tire");
		joueur2.tirer(3, 1);
		System.out.println("MAP1");
		System.out.println(p.getMap1().myToString());
		
		System.out.println("MAP2");
		System.out.println(p.getMap2().myToString());
		
		
		System.out.println("FIN");

	}

}
