package persistence;

import persistence.dao.*;

class PostgresDAOFactory extends DAOFactory {

	private static  DataSource dataSource;

	static {
		try {
			Class.forName("org.postgresql.Driver").getConstructor().newInstance();
			//questi vanno messi in file di configurazione!!!	
			//dataSource=new DataSource("jdbc:postgresql://52.39.164.176:5432/xx","xx","p@xx");
			dataSource = new DataSource("jdbc:postgresql://horton.elephantsql.com:5432/njggtfej", "njggtfej","QgLyoMomCLcGAAbs9y3pCNNaTv1K9ADP");
			//dataSource= new DataSource("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}

	@Override
	public AccountDao getAccountDAO() {
		return new AccountDaoJDBC(dataSource);
	}

	@Override
	public ChampionDao getChampionDAO() {
		return new ChampionDaoJDBC(dataSource);
	}
	
	@Override
	public ItemDao getItemDAO() {
		return new ItemDaoJDBC(dataSource);
	}
	
	@Override
	public RuneDao getRuneDAO() {
		return new RuneDaoJDBC(dataSource);
	}
	
	@Override
	public SkillDao getSkillDAO() {
		return new SkillDaoJDBC(dataSource);
	}
	
	@Override
	public SpellDao getSpellDAO() {
		return new SpellDaoJDBC(dataSource);
	}
	
	@Override
	public MiscDao getMiscDAO() {
		return new MiscDaoJDBC(dataSource);
		
	}
	
	@Override
	public FavouriteDao getFavouriteDAO() {
		return new FavouriteDaoJDBC(dataSource);
		
	}
	
	@Override
	public UtilDao getUtilDAO(){
		return new UtilDao(dataSource);
	}
}
