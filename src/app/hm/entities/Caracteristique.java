package app.hm.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Table(name="caracteristique")
@Entity
@Data
public class Caracteristique {

	private Integer terre;
	private Integer mer;
	private Integer air;
	private Integer force;
	private Integer agilite;
	private Integer intelligence;
	private Integer charisme;
	
}
