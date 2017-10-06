package app.hm.service;

import java.util.List;

import app.hm.entities.Parking;

public interface ParkingService {

public void delete(Parking p);
	
	public void saveOrUpdate(Parking p);

	public Parking getById(Integer idParking);
	
	public List<Parking> getAll();
	
	public List<Parking> getAllWithoutVoiture();
	
}
