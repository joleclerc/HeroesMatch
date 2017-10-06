package app.hm.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@Column(name = "version")
	@Version
	private Integer version;
	
	@OneToOne()
	private Caracteristique caracteristique;
	
	@ManyToMany()
	private List<Team> teams;
	
	
}
