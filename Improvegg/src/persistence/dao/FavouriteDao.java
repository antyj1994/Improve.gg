package persistence.dao;

import java.util.List;

import model.Favourite;
import persistence.AccountCredenziali;

public interface FavouriteDao {
	
	public void save(Favourite name);  // Create
	public List<Favourite> findByAccount(String account);     // Retrieve
	public List<Favourite> findAll();   //Retrieve All
	public void update(Favourite name); //Update
	public void delete(Favourite name); //Delete	     
	
}
