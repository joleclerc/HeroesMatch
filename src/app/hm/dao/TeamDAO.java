package app.hm.dao;

import java.util.List;

import app.hm.entities.Team;

public interface TeamDAO {

	public void saveOrUpdate(Team t);
	
	public void delete(Team t);
	
	public Team getById(Integer idTeam);
	
	public List<Team> getAll();
}
