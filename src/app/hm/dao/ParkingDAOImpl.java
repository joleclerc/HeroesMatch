package app.hm.dao;

import java.util.List;

import app.hm.entities.Parking;

public class ParkingDAOImpl implements ParkingDAO{

	private EntityManagerProvider emp = EntityManagerProvider.getInstance();
	
	@Override
	public void saveOrUpdate(Parking p) {
		emp.getEntityManager().persist(p);
	}

	@Override
	public void delete(Parking p) {
		emp.getEntityManager().remove(p);
	}

	@Override
	public Parking getById(Integer idParking) {
		Parking p = emp.getEntityManager().find(Parking.class, idParking);
		return p;
	}

	@Override
	public List<Parking> getAll() {
		List<Parking> parkings = emp.getEntityManager().createQuery("SELECT p FROM Parking p").getResultList();
		return parkings;
	}

	@Override
	public List<Parking> getAllWithoutVoiture() {
		List<Parking> parkings = emp.getEntityManager().createQuery("SELECT p FROM Parking p WHERE voitures IS NULL").getResultList();
		return parkings;
	}

}
