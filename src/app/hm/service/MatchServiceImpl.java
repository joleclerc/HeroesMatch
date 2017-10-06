package app.hm.service;

import java.util.List;

import app.hm.dao.EntityManagerProvider;
import app.hm.dao.MatchDAO;
import app.hm.dao.MatchDAOImpl;
import app.hm.entities.Match;

public class MatchServiceImpl implements MatchService{

	private MatchDAO matchDAO;	
	private static MatchService INSTANCE;
	private static EntityManagerProvider emp;
 
	public static MatchService getInstance(){
		if(INSTANCE == null)
			INSTANCE = new MatchServiceImpl();
		return INSTANCE;
	}
	
	private MatchServiceImpl() {
		matchDAO = new MatchDAOImpl();		
	}
	
	@Override
	public void saveOrUpdate(Match m) {
		emp.beginTransaction();
		this.matchDAO.saveOrUpdate(m);
		emp.commitTransaction();
		
	}

	@Override
	public void delete(Match m) {
		emp.beginTransaction();
		this.matchDAO.delete(m);
		emp.commitTransaction();
	}

	@Override
	public Match getById(Integer idMatch) {
		return this.matchDAO.getById(idMatch);
	}

	@Override
	public List<Match> getAll() {
		return this.matchDAO.getAll();
	}

}
