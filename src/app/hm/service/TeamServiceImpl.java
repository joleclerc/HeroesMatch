package app.hm.service;

import java.util.List;

import app.hm.dao.EntityManagerProvider;
import app.hm.dao.TeamDAO;
import app.hm.dao.TeamDAOImpl;
import app.hm.entities.Team;

public class TeamServiceImpl implements TeamService{

	private TeamDAO teamDAO;	
	private static TeamService INSTANCE;
	private static EntityManagerProvider emp;
 
	public static TeamService getInstance(){
		if(INSTANCE == null)
			INSTANCE = new TeamServiceImpl();
		return INSTANCE;
	}
	
	private TeamServiceImpl() {
		teamDAO = new TeamDAOImpl();		
	}
	
	@Override
	public void saveOrUpdate(Team t) {
		emp.beginTransaction();
		this.teamDAO.saveOrUpdate(t);
		emp.commitTransaction();
		
	}

	@Override
	public void delete(Team t) {
		emp.beginTransaction();
		this.teamDAO.delete(t);
		emp.commitTransaction();
	}

	@Override
	public Team getById(Integer idTeam) {
		return this.teamDAO.getById(idTeam);
	}

	@Override
	public List<Team> getAll() {
		return this.teamDAO.getAll();
	}
	
}
