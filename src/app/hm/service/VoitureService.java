package app.hm.service;

import java.util.List;

import app.hm.entities.SuperHero;

public interface VoitureService {

	public void saveOrUpdate(SuperHero v);
	
	public void delete(SuperHero v);
	
	public SuperHero getById(Integer idVoiture);
	
	public List<SuperHero> getAll();
	
	public List<SuperHero> getAllWithoutParking();
	
	
}
