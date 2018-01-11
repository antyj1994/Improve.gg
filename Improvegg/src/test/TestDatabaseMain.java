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

		Account account1 = new Account("Michele","michele123");
		Account account2 = new Account("Michelino","michele1234");
		Account account3 = new Account("Minchiele","michele12345");
		
		Champion champion1 = new Champion(11, "Alistar");
		
		accountDao.save(account1);
		accountDao.save(account2);
		accountDao.save(account3);
		
		championDao.save(champion1);
		
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

	}

}
