package app.hm.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import app.hm.entities.Parking;
import app.hm.entities.SuperHero;
import app.hm.resources.ObjVP;

public class MainScanner {

	private static enum ACTION{
		VADD, PADD, ASS, GET
	}
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ParkingVoiture");
		
		Scanner sc = new Scanner(System.in);
		boolean encore = true;
		while(encore){			
			System.out.println("Que voulez-vous faire ?");
			System.out.println("Ajouter un Parking (P)");
			System.out.println("Ajouter une Voiture (V)");
			System.out.println("Attribuer une Voiture à un Parking (A)");
			char answer = sc.next().charAt(0);
			
			switch (answer) {
			case 'P':
				addParking(sc, emf);
				break;
			case 'V':
				addVoiture(sc, emf);
				break;
			case 'A':
				assocVP(sc, emf);
				break;
			default:
				encore = false;
				sc.close();
				break;
			}
		}
		
		
		
	}

	private static void assocVP(Scanner sc, EntityManagerFactory emf) {
		Integer cpt = 1;
		System.out.println("Sélectionnez votre voiture parmis les voitures suivantes :");
		ObjVP objVP = doAction(ACTION.GET, null, null, emf);
		for(SuperHero v : objVP.getVoitures()){
			System.out.println(cpt++ + " - " + v.getMarque() + " " + v.getNom());
		}
		
		//On récupère la voiture sélectionnée
		SuperHero vSelect = objVP.getVoitures().get(sc.nextInt() - 1);
		
		System.out.println("Sélectionnez votre parking parmis les parkings suivants :");
		cpt = 1;
		for(Parking p : objVP.getParkings()){
			System.out.println(cpt++ + " - " + p.getNom() + " " + p.getAdresse());
		}
		
		//On récupère la voiture sélectionnée
		Parking pSelect = objVP.getParkings().get(sc.nextInt() - 1);
		
		//Action
		doAction(ACTION.ASS, vSelect, pSelect, emf);
	}

	private static void addVoiture(Scanner sc, EntityManagerFactory emf) {
		System.out.println("Entrez la marque de la voiture");
		String marque = sc.next();
		System.out.println("Entrez le modèle de la voiture");
		String nom = sc.next();
		SuperHero v = new SuperHero(nom,marque);
		System.out.println("Ma voiture : " + marque + " " + nom);
		doAction(ACTION.VADD, v, null, emf);
	}


	private static void addParking(Scanner sc, EntityManagerFactory emf) {
		System.out.println("Entrez le nom du parking");
	    String nom = sc.next();
	    System.out.println("Entrez l'adresse du parking");
	    String adr = sc.next();
	    Parking p = new Parking(nom, adr);
	    System.out.println("Mon parking : " + nom + " " + adr);
	    doAction(ACTION.PADD, p, null, emf);
	}
	
	private static ObjVP doAction(ACTION action, Object obj1, Object obj2, EntityManagerFactory emf) {
		
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        ObjVP objVP = new ObjVP();
        
        switch (action) {
		case VADD:
			tx.begin();
			em.persist((SuperHero)obj1);
			tx.commit();
			break;

		case PADD:
			tx.begin();
			em.persist((Parking)obj1);
			tx.commit();
			break;
		case GET:
			List<SuperHero> vList = em.createQuery("SELECT v FROM Voiture v WHERE parking IS NULL").getResultList();
			objVP.setVoitures(vList);
			List<Parking> pList = em.createQuery("SELECT p FROM Parking p").getResultList();
			objVP.setParkings(pList);
			break;

		case ASS:
			SuperHero vToModif = em.find(SuperHero.class, ((SuperHero)obj1).getIdVoiture());
			Parking pToAdd = em.find(Parking.class, ((Parking)obj2).getIdParking());
			vToModif.setParking(pToAdd);
//			List<Voiture> voitures = ((Parking)obj2).getVoitures();
//			if(voitures == null){
//				voitures = new ArrayList<Voiture>();
//				voitures.add((Voiture)obj1);
//				((Parking)obj2).setVoitures(voitures);
//			}else{
//				((Parking)obj2).getVoitures().add((Voiture)obj1);
//			}
			tx.begin();
			em.persist(vToModif);
			tx.commit();
			break;

		default:
			break;
		}
		
        return objVP;
	}
}
