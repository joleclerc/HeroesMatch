package app.hm.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Table(name="caracteristique")
@Entity
@Data
public class Caracteristique {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idCarac")
	private Integer idCaracteristique;
	private Integer terre;
	private Integer eau;
	private Integer air;
	@OneToOne(mappedBy="caracteristique",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="idSuperHero")
	private SuperHero superHero;
	
//	private Integer feu;
//	private Integer vie;
//	
//	private Integer force;
//	private Integer agilite;
	
//	private Integer intelligence;
//	private Integer charisme;
	
}
