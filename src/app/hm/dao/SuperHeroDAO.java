package app.hm.dao;

import java.util.List;

import app.hm.entities.SuperHero;

public interface SuperHeroDAO {

	public void saveOrUpdate(SuperHero sh);
	
	public void delete(SuperHero sh);
	
	public SuperHero getById(Integer idSuperHero);
	
	public List<SuperHero> getAll();
}
