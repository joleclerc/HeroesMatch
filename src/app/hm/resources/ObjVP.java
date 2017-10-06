package app.hm.resources;

import java.util.List;

import app.hm.entities.Parking;
import app.hm.entities.SuperHero;
import lombok.Data;

@Data
public class ObjVP {

	private List<SuperHero> voitures;
	private List<Parking> parkings;
	
}
