package app.hm.dao;

import java.util.List;

import app.hm.entities.SuperHero;

public class SuperHeroDAOImpl implements SuperHeroDAO{

	private EntityManagerProvider emp = EntityManagerProvider.getInstance();
	
	@Override
	public void saveOrUpdate(SuperHero sh) {
		emp.getEntityManager().persist(sh);
	}

	@Override
	public void delete(SuperHero sh) {
		emp.getEntityManager().remove(sh);		
	}

	@Override
	public SuperHero getById(Integer idSuperHero) {
		SuperHero m = emp.getEntityManager().find(SuperHero.class, idSuperHero);
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SuperHero> getAll() {
		List<SuperHero> superHeroes = emp.getEntityManager().createQuery("SELECT sh FROM SuperHero sh").getResultList();
		return superHeroes;
	}

}
