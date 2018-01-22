package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Spell;

import persistence.dao.SpellDao;
public class SpellDaoJDBC implements SpellDao{
	
	private DataSource dataSource;

	public SpellDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Spell spell) {
		Connection connection = this.dataSource.getConnection();
		try {		
			String insert = "insert into spell(id, nome, url, tooltip) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, spell.getId());
			statement.setString(2, spell.getNome());		
			statement.setString(3, spell.getUrl());
			statement.setString(4, spell.getTooltip());
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
	public Spell findByPrimaryKey(long id) {
		Connection connection = this.dataSource.getConnection();
		Spell spell = null;
		try {
			PreparedStatement statement;
			String query = "select * from spell where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				spell = new Spell();
				spell.setId(result.getInt("id"));				
				spell.setNome(result.getString("nome"));
				spell.setUrl(result.getString("url"));
				spell.setTooltip(result.getString("tooltip"));
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
		return spell;
	}
	
	
	@Override
	public List<Spell> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Spell> spells = new LinkedList<>();
		try {
			Spell spell;
			PreparedStatement statement;
			String query = "select * from spell";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				spell = new Spell();
				spell.setId(result.getInt("id"));				
				spell.setNome(result.getString("nome"));
				spell.setUrl(result.getString("url"));
				spell.setTooltip(result.getString("tooltip"));
				spells.add(spell);
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
		return spells;
	}

	@Override
	public void update(Spell spell) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update spell SET id = ?, nome = ?, url = ?, tooltip = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, spell.getId());
			statement.setString(2, spell.getNome());
			statement.setString(3, spell.getUrl());
			statement.setString(4, spell.getTooltip());
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
	public void delete(Spell spell) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM spell WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, spell.getId());
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
