package app.hm.dao;

import java.util.List;

import app.hm.entities.Match;

public class MatchDAOImpl implements MatchDAO{

	private EntityManagerProvider emp = EntityManagerProvider.getInstance();

	@Override
	public void saveOrUpdate(Match m) {
		emp.getEntityManager().persist(m);
	}

	@Override
	public void delete(Match m) {
		emp.getEntityManager().remove(m);
	}

	@Override
	public Match getById(Integer idMatch) {
		Match m = emp.getEntityManager().find(Match.class, idMatch);
		return m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Match> getAll() {
		List<Match> matches = emp.getEntityManager().createQuery("SELECT m FROM Match m").getResultList();
		return matches;
	}
	
}
