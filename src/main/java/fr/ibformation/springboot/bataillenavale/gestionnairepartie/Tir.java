package fr.ibformation.springboot.bataillenavale.gestionnairepartie;

import javax.persistence.OneToOne;

public class Tir {
int position_x;
int position_y;
@OneToOne
Joueur proprietaire;

public Tir(int position_x, int position_y, Joueur proprietaire) {
	this.position_x = position_x;
	this.position_y = position_y;
	this.proprietaire = proprietaire;
}
public int getPosition_x() {
	return position_x;
}
public void setPosition_x(int position_x) {
	this.position_x = position_x;
}
public int getPosition_y() {
	return position_y;
}
public void setPosition_y(int position_y) {
	this.position_y = position_y;
}
public Joueur getProprietaire() {
	return proprietaire;
}
public void setProprietaire(Joueur proprietaire) {
	this.proprietaire = proprietaire;
}

	
}
