package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



import model.Rune;

import persistence.dao.RuneDao;


public class RuneDaoJDBC implements RuneDao {
	
	private DataSource dataSource;

	public RuneDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Rune rune) {
		Connection connection = this.dataSource.getConnection();
		try {		
			String insert = "insert into rune(id, nome, url) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, rune.getId());
			statement.setString(2, rune.getNome());	
			statement.setString(3, rune.getUrl());
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
	public Rune findByPrimaryKey(long id) {
		Connection connection = this.dataSource.getConnection();
		Rune rune = null;
		try {
			PreparedStatement statement;
			String query = "select * from rune where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				rune = new Rune();
				rune.setId(result.getInt("id"));				
				rune.setNome(result.getString("nome"));
				rune.setUrl(result.getString("url"));
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
		return rune;
	}
	
	
	@Override
	public List<Rune> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Rune> runes = new LinkedList<>();
		try {
			Rune rune;
			PreparedStatement statement;
			String query = "select * from rune";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				rune = new Rune();
				rune.setId(result.getInt("id"));				
				rune.setNome(result.getString("nome"));
				rune.setUrl(result.getString("url"));
				runes.add(rune);
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
		return runes;
	}

	@Override
	public void update(Rune rune) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update rune SET id = ?, nome = ?, url = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, rune.getId());
			statement.setString(2, rune.getNome());
			statement.setString(3,  rune.getUrl());
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
	public void delete(Rune rune) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM rune WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, rune.getId());
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
