package app.hm.service;

import java.util.List;

import app.hm.entities.Match;

public interface MatchService {

	public void saveOrUpdate(Match m);
	
	public void delete(Match m);
	
	public Match getById(Integer idMatch);
	
	public List<Match> getAll();
}
