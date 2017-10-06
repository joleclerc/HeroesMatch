package app.hm.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="teamMatch")
@Entity
public class Match {

	@Id
	@Column(name = "idMatch")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idMatch;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "idTeamA")
	private Team teamA;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "idTeamB")
	private Team teamB;
	
	@Enumerated(EnumType.STRING)
	@Column(name="terrainType")
	private TerrainType terrainType;
}
