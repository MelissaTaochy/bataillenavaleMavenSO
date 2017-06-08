package fr.ibformation.springboot.bataillenavale.gestionnairejeu;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Emplacement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long idEmplacement;
	int position_x;
	int posiyion_y;
	TypeStatutCase statut;
	TypeType type;

	public Emplacement() {
		this.type = TypeType.MER;
		this.statut = TypeStatutCase.PASDECOUVERT;
	}

	public Emplacement(int position_x, int posiyion_y) {
		this.position_x = position_x;
		this.posiyion_y = posiyion_y;
		this.type = TypeType.MER;
		this.statut = TypeStatutCase.PASDECOUVERT;
	}

	public int getPosition_x() {
		return position_x;
	}

	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}

	public int getPosiyion_y() {
		return posiyion_y;
	}

	public void setPosiyion_y(int posiyion_y) {
		this.posiyion_y = posiyion_y;
	}

	public TypeStatutCase getStatut() {
		return statut;
	}

	public void setStatut(TypeStatutCase statut) {
		this.statut = statut;
	}

	public TypeType getType() {
		return type;
	}

	public void setType(TypeType type) {
		this.type = type;
	}

}
