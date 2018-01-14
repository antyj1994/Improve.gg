package persistence.dao;


import java.util.List;

import model.Rune;

public interface RuneDao {
	
	public void save(Rune rune);  // Create
	public Rune findByPrimaryKey(long id);     // Retrieve
	public List<Rune> findAll();       
	public void update(Rune rune); //Update
	public void delete(Rune rune); //Delete	

}
