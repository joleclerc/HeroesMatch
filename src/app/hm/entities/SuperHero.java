package app.hm.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;

@Table(name="superhero")
@Entity
@Data
public class SuperHero {

	@Id
	@Column(name = "idSuperHero")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idSuperHero;
	
	@Column(name = "alias", length=250)
	private String alias;
	
	@Column(name = "nom", length=250)
	private String nom;
	
	@Column(name = "version")
	@Version
	private Integer version;
	
	@OneToOne
	private Caracteristique caracteristique;
	

	//Controller
	public SuperHero(){
		super();
	}
	
	//Custom Setters
	public void setParking(Parking parking){
		if(parking != null){
			parking.getVoitures().add(this);
		}
		this.parking = parking;			
	}
	
}
