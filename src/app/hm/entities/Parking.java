package app.hm.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Table(name="parking")
@Entity
@Data
public class Parking {
	
	@Id
	@Column(name = "idParking")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idParking;
	
	@Column(name = "nom", length=250)
	private String nom;
	
	@Column(name = "adresse", length=250)
	private String adresse;
	
	@OneToMany(mappedBy="parking", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<SuperHero> voitures;
	
	//Controllers
	public Parking(){
		super();
		this.setVoitures(new ArrayList<SuperHero>());
	}
	
	public Parking(String nom, String adresse){
		this();
		this.setNom(nom);
		this.setAdresse(adresse);
	}
	
	public Parking(String nom, String adresse, List<SuperHero> voitures){
		this(nom, adresse);
		this.setVoitures(voitures);
	}
	
	//Custom Setters
	public void setVoitures(List<SuperHero> voitures){
		if(voitures != null){
			for(SuperHero v : voitures){
				v.setParking(this);
			}
		}
		this.voitures = voitures;			
	}
	
}
