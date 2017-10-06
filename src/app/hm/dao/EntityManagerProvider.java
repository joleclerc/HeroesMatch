package app.hm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityManagerProvider {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tran;
	private static EntityManagerProvider INSTANCE;
	private final String DB_PERSISTENCE = "ParkingVoiture";
		 
	public static EntityManagerProvider getInstance(){	
		if(INSTANCE == null)
			INSTANCE = new EntityManagerProvider();
		return INSTANCE;
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory(DB_PERSISTENCE);
        }
        return emf;
    }
	
	public EntityManager getEntityManager(){
		if(em == null){
			em = this.getEntityManagerFactory().createEntityManager();
		}
		return em;
	}
	
	public EntityTransaction getEntityTransaction(){
		if(tran == null){
			tran = this.getEntityManager().getTransaction();
		}
		return tran;
	}
	
	public void beginTransaction(){
		getInstance().getEntityTransaction().begin();
	}
	
	public void commitTransaction(){
		getInstance().getEntityTransaction().commit();
	}
	
	public void rollbackTransaction(){
		getInstance().getEntityTransaction().rollback();
	}
}
