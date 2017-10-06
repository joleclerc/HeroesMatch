package app.hm.service;

import java.util.ArrayList;
import java.util.List;

import app.hm.dao.EntityManagerProvider;
import app.hm.dao.ParkingDAO;
import app.hm.dao.ParkingDAOImpl;
import app.hm.entities.Parking;

public class ParkingServiceImpl implements ParkingService{

	private ParkingDAO parkingDAO;	
	private static ParkingService INSTANCE;
	private static EntityManagerProvider emp;
 
	public static ParkingService getInstance(){
		if(INSTANCE == null)
			INSTANCE = new ParkingServiceImpl();
		return INSTANCE;
	}
	
	private ParkingServiceImpl() {
		parkingDAO = new ParkingDAOImpl();		
	}
	
	@Override
	public void saveOrUpdate(Parking p){
		emp.beginTransaction();
		this.parkingDAO.saveOrUpdate(p);
		emp.commitTransaction();
	}
	
	@Override
	public void delete(Parking p) {
		emp.beginTransaction();
		this.parkingDAO.delete(p);
		emp.commitTransaction();
	}

	@Override
	public Parking getById(Integer idParking) {
		return this.parkingDAO.getById(idParking);
	}

	@Override
	public List<Parking> getAll() {
		return this.parkingDAO.getAll();
	}

	@Override
	public List<Parking> getAllWithoutVoiture() {
		List<Parking> parkings = this.parkingDAO.getAll();
		List<Parking> emptyParkings = new ArrayList<Parking>();
		for(Parking p : parkings){
			if(p.getVoitures().size() == 0){
				emptyParkings.add(p);
			}
		}
		return emptyParkings;
	}

}
