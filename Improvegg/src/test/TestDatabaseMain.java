package test;

import persistence.DAOFactory;
import persistence.UtilDao;
import persistence.dao.*;
import model.*;

public class TestDatabaseMain {

	public static void main(String[] args) {

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		UtilDao util = factory.getUtilDAO();
		util.dropDatabase();
		util.createDatabase();
		
		AccountDao accountDao = factory.getAccountDAO();
		ChampionDao championDao = factory.getChampionDAO();
		ItemDao itemDao = factory.getItemDAO();
		RuneDao runeDao = factory.getRuneDAO();
		SpellDao spellDao = factory.getSpellDAO();
		SkillDao skillDao = factory.getSkillDAO();
		MiscDao miscDao = factory.getMiscDAO();

		Account account1 = new Account("Michele","michele123");
		Account account2 = new Account("Michelino","michele1234");
		Account account3 = new Account("Minchiele","michele12345");
		Account account4 = new Account("Robo", "ech");
		
		Champion champion1 = new Champion(12, "Alistar");
		
		Item item1= new Item(1, "Test");
		
		Rune rune1= new Rune(1, "Test");
		
		Spell spell1=new Spell (1, "Test");
		
		Skill skill1= new Skill (1, "Test");
	
		Misc misc1= new Misc (1, "test");
		
		
		accountDao.save(account1);
		accountDao.save(account2);
		accountDao.save(account3);
		accountDao.save(account4);
		
		championDao.save(champion1);
		
		itemDao.save(item1);
		
		runeDao.save(rune1);
		
		spellDao.save(spell1);
		
		skillDao.save(skill1);
		
		miscDao.save(misc1);
		
		System.out.println("Retrieve all accounts");
		for(Account a : accountDao.findAll()) {
			System.out.println(a.getNome());
			System.out.println(".-.-.-.");
		}
		
		System.out.println("Retrieve all champions");
		for(Champion a : championDao.findAll()) {
			System.out.println(a.getNome());
			System.out.println(".-.-.-.");
		}
		
		System.out.println("Retrieve all items");
		for(Item a : itemDao.findAll()) {
			System.out.println(a.getNome());
			System.out.println(".-.-.-.");
		}
		
		System.out.println("Retrieve all runes");
		for(Rune a : runeDao.findAll()) {
			System.out.println(a.getNome());
			System.out.println(".-.-.-.");
		}

		System.out.println("Retrieve all skills");
		for(Skill a : skillDao.findAll()) {
			System.out.println(a.getNome());
			System.out.println(".-.-.-.");
		}
		
		System.out.println("Retrieve all spells");
		for(Spell a : spellDao.findAll()) {
			System.out.println(a.getNome());
			System.out.println(".-.-.-.");
		}
		
		System.out.println("Retrieve all miscellaneous");
		for(Misc a : miscDao.findAll()) {
			System.out.println(a.getNome());
			System.out.println(".-.-.-.");
		}


		
	}
	//prova

}
