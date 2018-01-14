package persistence.dao;

import java.util.List;
import model.Item;

public interface ItemDao {
	
	public void save(Item item);  // Create
	public Item findByPrimaryKey(long id);     // Retrieve
	public List<Item> findAll();       
	public void update(Item item); //Update
	public void delete(Item item); //Delete	

}
