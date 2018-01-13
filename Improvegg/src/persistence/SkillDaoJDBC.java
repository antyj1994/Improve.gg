package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Skill;

import persistence.dao.SkillDao;

public class SkillDaoJDBC implements SkillDao{
	
	private DataSource dataSource;

	public SkillDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Skill skill) {
		Connection connection = this.dataSource.getConnection();
		try {		
			String insert = "insert into skill(id, nome) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, skill.getId());
			statement.setString(2, skill.getNome());			
			statement.executeUpdate();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException excep) {
					throw new PersistenceException(e.getMessage());
				}
			} 
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		
	}

	@Override
	public Skill findByPrimaryKey(long id) {
		Connection connection = this.dataSource.getConnection();
		Skill skill = null;
		try {
			PreparedStatement statement;
			String query = "select * from skill where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				skill = new Skill();
				skill.setId(result.getInt("id"));				
				skill.setNome(result.getString("nome"));
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}	
		return skill;
	}
	
	
	@Override
	public List<Skill> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Skill> skills = new LinkedList<>();
		try {
			Skill skill;
			PreparedStatement statement;
			String query = "select * from skill";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				skill = new Skill();
				skill.setId(result.getInt("id"));				
				skill.setNome(result.getString("nome"));
				skills.add(skill);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return skills;
	}

	@Override
	public void update(Skill skill) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update skill SET id = ?, nome = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, skill.getId());
			statement.setString(2, skill.getNome());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		
	}
	
	@Override
	public void delete(Skill skill) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM skill WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, skill.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}
	

}
