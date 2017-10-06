package app.hm.dao;

import java.util.List;

import app.hm.entities.Team;

public class TeamDAOImpl implements TeamDAO{

	private EntityManagerProvider emp = EntityManagerProvider.getInstance();

	@Override
	public void saveOrUpdate(Team t) {
		emp.getEntityManager().persist(t);
	}

	@Override
	public void delete(Team t) {
		emp.getEntityManager().remove(t);
		
	}

	@Override
	public Team getById(Integer idTeam) {
		Team t = emp.getEntityManager().find(Team.class, idTeam);
		return t;
	}

	@Override
	public List<Team> getAll() {
		List<Team> teams = emp.getEntityManager().createQuery("SELECT t FROM Team t").getResultList();
		return teams;
	}
	
}
