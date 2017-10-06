package app.hm.main;

import java.util.List;
import java.util.Scanner;

import app.hm.entities.Parking;
import app.hm.entities.SuperHero;
import app.hm.service.ParkingService;
import app.hm.service.ParkingServiceImpl;
import app.hm.service.VoitureService;
import app.hm.service.VoitureServiceImpl;

public class MainMVC {

	private static ParkingService parkingService = ParkingServiceImpl.getInstance();
	private static VoitureService voitureService = VoitureServiceImpl.getInstance();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean encore = true;
		while(encore){		
			System.out.println("-----------------------------------------");
			System.out.println("|              CONSOLE                  |");
			System.out.println("-----------------------------------------");
			System.out.println("Que voulez-vous faire ?");
			System.out.println("Ajouter un Parking (P)");
			System.out.println("Ajouter une Voiture (V)");
			System.out.println("Attribuer une Voiture à un Parking (A)");
			System.out.println("Afficher la liste des voitures présent dans un parking donné (G)");
			System.out.println("Liste de parking sans voitures (S)");
			System.out.println("Pour quitter (Q)");
			char answer = sc.next().charAt(0);
			
			switch (answer) {
			case 'P':
				addParking(sc);
				break;
			case 'V':
				addVoiture(sc);
				break;
			case 'A':
				assocVP(sc);
				break;
			case 'S':
				listSV(sc);
				break;
			case 'G':
				listPG(sc);
				break;
			case 'Q':
				sc.close();
				encore = false;
				break;
			default:
				break;
			}
		}
		
	}
	
	private static void listPG(Scanner sc) {
		System.out.println("Sélectionnez votre parking parmis les parkings suivants :");
		int cpt = 1;
		
		//On récupère et on affiche la liste de parking
		List<Parking> parkings = parkingService.getAll();
		if(parkings.size() != 0 ){
			for(Parking p : parkings){
				System.out.println(cpt++ + " - " + p.getNom() + " " + p.getAdresse());
			}
			
			//On récupère le parking sélectionné
			Parking pSelect = parkings.get(sc.nextInt() - 1);
			cpt = 1;
			for(SuperHero v : pSelect.getVoitures()){
				System.out.println(cpt++ + " - " + v.getMarque() + " " + v.getNom());
			}
		}else{
			System.out.println(" / \\    Aucun parking");
			System.out.println("/ ! \\   dans la BDD !");
		}
		
	}

	private static void listSV(Scanner sc) {
		List<Parking> parkings = parkingService.getAllWithoutVoiture();
		System.out.println("Liste des parkings sans voitures");
		int compteur = 1;
		if(parkings.size() == 0){
			System.out.println("Aucun parking vide !");
		}else{
			for(Parking p : parkings){
				System.out.println(compteur++ + " - Nom = " + p.getNom() + " | Adresse = " + p.getAdresse());;
			}
		}
		
	}

	private static void assocVP(Scanner sc) {
		Integer cpt = 1;
		System.out.println("Sélectionnez votre voiture parmis les voitures suivantes(Sans Parking) :");

		//On récupère et on affiche la liste de voiture
		List<SuperHero> voitures = voitureService.getAllWithoutParking();
		
		//Si la liste de voiture n'est pas vide
		if(voitures.size() != 0){
			for(SuperHero v : voitures){
				System.out.println(cpt++ + " - " + v.getMarque() + " " + v.getNom());
			}
			
			//On récupère la voiture sélectionnée
			SuperHero vSelect = voitures.get(sc.nextInt() - 1);
			
			System.out.println("Sélectionnez votre parking parmis les parkings suivants :");
			cpt = 1;
			
			//On récupère et on affiche la liste de parking
			List<Parking> parkings = parkingService.getAll();
			if(parkings.size() != 0 ){
				for(Parking p : parkings){
					System.out.println(cpt++ + " - " + p.getNom() + " " + p.getAdresse());
				}
				
				//On récupère la voiture sélectionnée
				Parking pSelect = parkings.get(sc.nextInt() - 1);
				
				//On attribut le parking à la voiture
				vSelect.setParking(pSelect);
				
				//On enregistre la voiture
				voitureService.saveOrUpdate(vSelect);							
			}else{
				System.out.println(" / \\    Aucun parking");
				System.out.println("/ ! \\   dans la BDD !");
			}
		}else{
			System.out.println(" / \\    Aucune voiture sans parking");
			System.out.println("/ ! \\    	 dans la BDD !");
		}
	}

	private static void addVoiture(Scanner sc) {
		System.out.println("Entrez la marque de la voiture");
		String marque = sc.next();
		System.out.println("Entrez le modèle de la voiture");
		String nom = sc.next();
		SuperHero v = new SuperHero(nom,marque);
		voitureService.saveOrUpdate(v);
	}


	private static void addParking(Scanner sc) {
		System.out.println("Entrez le nom du parking");
	    String nom = sc.next();
	    System.out.println("Entrez l'adresse du parking");
	    String adr = sc.next();
	    Parking p = new Parking(nom, adr);
	    System.out.println("Mon parking : " + nom + " " + adr);
	    parkingService.saveOrUpdate(p);
	}
	
}
