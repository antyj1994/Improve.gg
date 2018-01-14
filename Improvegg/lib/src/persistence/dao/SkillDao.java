package persistence.dao;


import java.util.List;

import model.Skill;


public interface SkillDao {

	public void save(Skill skill);  // Create
	public Skill findByPrimaryKey(long id);     // Retrieve
	public List<Skill> findAll();       
	public void update(Skill skill); //Update
	public void delete(Skill skill); //Delete	
}
