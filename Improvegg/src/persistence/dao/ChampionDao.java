package persistence.dao;

import java.util.List;
import model.Champion;

public interface ChampionDao {
	
	public void save(Champion champion);  // Create
	public Champion findByPrimaryKey(long id);     // Retrieve
	public List<Champion> findAll();       
	public void update(Champion champion); //Update
	public void delete(Champion champion); //Delete	
	
	
}
