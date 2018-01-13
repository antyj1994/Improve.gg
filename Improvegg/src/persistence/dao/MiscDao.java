package persistence.dao;


import java.util.List;

import model.Misc;

public interface MiscDao {

	public void save(Misc misc);  // Create
	public Misc findByPrimaryKey(long id);     // Retrieve
	public List<Misc> findAll();       
	public void update(Misc misc); //Update
	public void delete(Misc misc); //Delete	
}
