package app.hm.controller;

import app.hm.entities.SuperHero;
import app.hm.service.SuperHeroService;
import app.hm.service.SuperHeroServiceImpl;

public class SuperHeroController {

	private SuperHero superHero;
	private static SuperHeroService superHeroService = SuperHeroServiceImpl.getInstance();

	public String validate(){
		System.out.println("Eau : " + superHero.getCaracteristique().getEau());
		superHeroService.saveOrUpdate(superHero);
		return "SUCCESS";
	}

}
