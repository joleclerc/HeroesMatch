package app.hm.service;

import java.util.List;

import app.hm.dao.EntityManagerProvider;
import app.hm.dao.SuperHeroDAO;
import app.hm.dao.SuperHeroDAOImpl;
import app.hm.entities.SuperHero;

public class SuperHeroServiceImpl implements SuperHeroService {

	private SuperHeroDAO superHeroDAO;	
	private static SuperHeroService INSTANCE;
	private static EntityManagerProvider emp;
 
	public static SuperHeroService getInstance(){
		if(INSTANCE == null)
			INSTANCE = new SuperHeroServiceImpl();
		return INSTANCE;
	}
	
	private SuperHeroServiceImpl() {
		superHeroDAO = new SuperHeroDAOImpl();		
	}
	
	@Override
	public void saveOrUpdate(SuperHero sh) {
		emp.beginTransaction();
		this.superHeroDAO.saveOrUpdate(sh);
		emp.commitTransaction();
	}

	@Override
	public void delete(SuperHero sh) {
		emp.beginTransaction();
		this.superHeroDAO.delete(sh);
		emp.commitTransaction();
	}

	@Override
	public SuperHero getById(Integer idSuperHero) {
		return this.superHeroDAO.getById(idSuperHero);
	}

	@Override
	public List<SuperHero> getAll() {
		return this.superHeroDAO.getAll();
	}

}
