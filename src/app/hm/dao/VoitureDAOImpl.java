package app.hm.dao;

import java.util.List;

import app.hm.entities.SuperHero;

public class VoitureDAOImpl implements VoitureDAO{

	private EntityManagerProvider emp = EntityManagerProvider.getInstance();
	
	@Override
	public void saveOrUpdate(SuperHero v) {
		emp.getEntityManager().persist(v);
	}

	@Override
	public void delete(SuperHero v) {
		emp.getEntityManager().remove(v);
	}

	@Override
	public SuperHero getById(Integer idVoiture) {
		SuperHero v = emp.getEntityManager().find(SuperHero.class, idVoiture);
		return v;
	}

	@Override
	public List<SuperHero> getAll() {
		List<SuperHero> voitures = emp.getEntityManager().createQuery("SELECT v FROM Voiture v").getResultList();
		return voitures;
	}

	@Override
	public List<SuperHero> getAllWithoutParking() {
		List<SuperHero> voitures = emp.getEntityManager().createQuery("SELECT v FROM Voiture v WHERE v.parking IS NULL").getResultList();
		return voitures;
	}

}
