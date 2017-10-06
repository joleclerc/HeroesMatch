package app.hm.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="team")
public class Team {

	@Id
	@Column(name="idTeam")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idTeam;
	
	@ManyToMany(mappedBy="teams")
	private List<SuperHero> superHeroes;
	
	
}
