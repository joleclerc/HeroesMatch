package app.hm.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;


@Table(name="proprietaire")
@Entity
@Data
public class Proprietaire {

	@Id
	@Column(name = "idProprio")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idProprio;
	
	@Column(name = "nom", length=250)
	private String nom;
	
	@Column(name = "prenom", length=250)
	private String prenom;
	
	@Column(name = "dob")
	@Type(type="timestamp")
	private Date dob;
	
}
