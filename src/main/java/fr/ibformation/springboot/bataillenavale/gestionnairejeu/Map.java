package fr.ibformation.springboot.bataillenavale.gestionnairejeu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.ibformation.springboot.bataillenavale.gestionnairepartie.Tir;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Map {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idMap;
	private int taille;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Emplacement> grille = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
	private List<Bateau> bateaux = new ArrayList<>();
	private int vieTotale;

	private static Random random = new Random(System.currentTimeMillis());

	public Map() {

	}

	public int getVieTotale() {
		return vieTotale;
	}

	public void setVieTotale(int vieTotale) {
		this.vieTotale = vieTotale;
	}

	public Map(int taille) {
		this.taille = taille;
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				grille.add(new Emplacement(i, j));

			}
		}

		Bateau bateau = new Bateau(3);
		int tailleBateau = bateau.getTaille();
		bateau.setOrientation(random.nextBoolean());

		if (bateau.getOrientation() == true) {
			bateau.setPosition_x(random.nextInt(taille - tailleBateau + 1));
			bateau.setPosition_y(random.nextInt(taille));
		}

		else if (bateau.getOrientation() == false) {
			bateau.setPosition_x(random.nextInt(taille));
			bateau.setPosition_y(random.nextInt(taille - tailleBateau + 1));
		}

		bateaux.add(bateau);

		ajouterBateau(bateau);

		for (int i = 0; i < bateaux.size(); i++) {
			vieTotale = vieTotale + bateaux.get(i).getVie();

		}

		// utiliser random pour generer un nombre aleatoire puis randomiser x, y
		// et orientation

	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public void ajouterBateau(Bateau b) {

		int i = b.getPosition_x();
		int j = b.getPosition_y();
		boolean orientation = b.getOrientation();
		int tailleBateau = b.getTaille();

		Emplacement e = grille.get(convertCoordToIndex(i, j));

		if (orientation == true) { // bateau vertical
			for (int t = 0; t < tailleBateau; t++) {
				grille.get(convertCoordToIndex(i + t, j)).setType(TypeType.BATEAU);
			}
		} else {
			for (int t = 0; t < tailleBateau; t++) { // bateau horizontal
				grille.get(convertCoordToIndex(i, j + t)).setType(TypeType.BATEAU);
			}

		}

	}

	public void gererTir(Tir tir) {
		Emplacement e = grille.get(convertCoordToIndex(tir.getPosition_x(), tir.getPosition_y()));
		switch (e.type) {
		case MER:
			e.statut = TypeStatutCase.DECOUVERT;
			System.out.println("plouf");
			System.out.println("vie restantes :  " + vieTotale);
			break;

		case BATEAU:
			e.statut = TypeStatutCase.DECOUVERT;
			System.out.println("BOOM");
			vieTotale = vieTotale - 1;
			System.out.println("vie restantes :  " + vieTotale);
			break;
		}
	}

	private int convertCoordToIndex(int x, int y) {
		return (y * taille) + x;

	}

	public String myToString() {
		String str = "";
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				if (grille.get(convertCoordToIndex(i, j)).getStatut() == TypeStatutCase.DECOUVERT) {
					if (grille.get(convertCoordToIndex(i, j)).getType() == TypeType.MER)
						str += "0";
					else
						str += "X";
				} else if (grille.get(convertCoordToIndex(i, j)).getType() == TypeType.BATEAU)
					str += "B";
				else
					str += ".";
			}
			str += "\n";
		}
		return str;
	}

	// toString personnalisr 2 boucles for, explorer les cases et afficher en
	// fonction du statut

}
