package app.hm.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import app.hm.entities.Parking;
import app.hm.entities.SuperHero;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ParkingVoiture");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        SuperHero v1 = new SuperHero("Mégane", "Renault");
        SuperHero v2 = new SuperHero("C4", "Citroën");
        SuperHero v3 = new SuperHero("208", "Peugeot");
        List<SuperHero> l1 = new ArrayList<SuperHero>(); l1.add(v1);
        List<SuperHero> l2 = new ArrayList<SuperHero>(); l2.add(v2); l2.add(v3);
        Parking p1 = new Parking("Parking du Cardo", "Le Cardo", l1);
        Parking p2 = new Parking("Parking d'Atlantis", "Saint-Herblain");
        Parking p3 = new Parking("Parking ENI", "Saint-Herblain");
        
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(v1);
        em.persist(v2);
        em.persist(v3);
        tx.commit();

        System.out.println("Ajout des voitures dans le p2");
        tx.begin();
        p2.setVoitures(l2);
        tx.commit();
        
        Parking p4 = em.find(Parking.class, 2);
        
        List<SuperHero> l4 = p4.getVoitures();
        System.out.println("---------------------------------------");
        System.out.println("Voitures du Parking p4 : " + p4.getNom());
        System.out.println("---------------------------------------");
        for(SuperHero v : l4){
        	System.out.println(v.getMarque() + " " + v.getNom());
        }
        
        //Suppression de v3
        System.out.println("---------------------------------------");
        System.out.println("Suppression de la v3");
        //On récupère la liste de tous les parkings
        List<Parking> pList = em.createQuery("SELECT p FROM Parking p").getResultList();
        
        //On supprime la voiture de la liste de voiture du parking
        for(Parking p : pList){
        	if(p.getVoitures().contains(v3)){
        		p.getVoitures().remove(v3);
        		em.persist(p);
        		//Break parce que une voiture ne peut-être que sur 1 suel parking
        		break;
        	}
        }
        tx.begin();
        em.remove(v3);
        tx.commit();
        
        System.out.println("---------------------------------------");
        System.out.println("Suppression du p1");
        tx.begin();
        //On retire le Parking des voitures du parking et on supprime la voiture
        for(SuperHero v : p1.getVoitures()){
        	v.setParking(null);
        	em.remove(v);
        }
        //On supprime la voiture
        em.remove(p1);
        tx.commit();
        
        Parking p5 = em.find(Parking.class, 2);
        
        List<SuperHero> l5 = p5.getVoitures();
        System.out.println("---------------------------------------");
        System.out.println("Voitures du Parking p5 : " + p5.getNom());
        System.out.println("---------------------------------------");
        for(SuperHero v : l5){
        	System.out.println(v.getMarque() + " " + v.getNom());
        }
        
	}

}
