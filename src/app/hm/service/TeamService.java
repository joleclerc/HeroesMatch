package app.hm.service;

import java.util.List;

import app.hm.entities.Team;

public interface TeamService {

	public void saveOrUpdate(Team t);
	
	public void delete(Team t);
	
	public Team getById(Integer idTeam);
	
	public List<Team> getAll();
	
}
