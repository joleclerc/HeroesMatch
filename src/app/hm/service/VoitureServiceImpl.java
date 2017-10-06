package app.hm.service;

import java.util.List;

import app.hm.dao.EntityManagerProvider;
import app.hm.dao.VoitureDAO;
import app.hm.dao.VoitureDAOImpl;
import app.hm.entities.SuperHero;

public class VoitureServiceImpl implements VoitureService{

	private VoitureDAO voitureDAO;	
	private static VoitureService INSTANCE;
	private static EntityManagerProvider emp;
 
	public static VoitureService getInstance(){
		if(INSTANCE == null)
			INSTANCE = new VoitureServiceImpl();
		return INSTANCE;
	}
	
	private VoitureServiceImpl() {
		voitureDAO = new VoitureDAOImpl();		
	}
	
	@Override
	public void saveOrUpdate(SuperHero v) {
		emp.beginTransaction();
		this.voitureDAO.saveOrUpdate(v);
		emp.commitTransaction();
	}

	@Override
	public void delete(SuperHero v) {
		emp.beginTransaction();
		this.voitureDAO.delete(v);
		emp.commitTransaction();
	}

	@Override
	public SuperHero getById(Integer idVoiture) {
		return this.voitureDAO.getById(idVoiture);
	}

	@Override
	public List<SuperHero> getAll() {
		return this.voitureDAO.getAll();
	}

	@Override
	public List<SuperHero> getAllWithoutParking() {
		return this.voitureDAO.getAllWithoutParking();
	}

}
