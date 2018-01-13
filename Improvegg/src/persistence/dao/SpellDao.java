package persistence.dao;


import java.util.List;


import model.Spell;

public interface SpellDao {

	public void save(Spell spell);  // Create
	public Spell findByPrimaryKey(long id);     // Retrieve
	public List<Spell> findAll();       
	public void update(Spell spell); //Update
	public void delete(Spell spell); //Delete	
}
