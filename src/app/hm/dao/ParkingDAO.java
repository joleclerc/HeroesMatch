package app.hm.dao;

import java.util.List;

import app.hm.entities.Parking;

public interface ParkingDAO {

	public void saveOrUpdate(Parking p);
	
	public void delete(Parking p);
	
	public Parking getById(Integer idParking);
	
	public List<Parking> getAll();
	
	public List<Parking> getAllWithoutVoiture();
	
}
