package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Misc;

import persistence.dao.MiscDao;

public class MiscDaoJDBC implements MiscDao {

	private DataSource dataSource;

	public MiscDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Misc misc) {
		Connection connection = this.dataSource.getConnection();
		try {		
			String insert = "insert into misc(id, nome, url) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, misc.getId());
			statement.setString(2, misc.getNome());	
			statement.setString(3, misc.getUrl());
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
	public Misc findByPrimaryKey(long id) {
		Connection connection = this.dataSource.getConnection();
		Misc misc = null;
		try {
			PreparedStatement statement;
			String query = "select * from misc where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				misc = new Misc();
				misc.setId(result.getInt("id"));				
				misc.setNome(result.getString("nome"));
				misc.setUrl(result.getString("url"));
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
		return misc;
	}
	
	
	@Override
	public List<Misc> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Misc> miscs = new LinkedList<>();
		try {
			Misc misc;
			PreparedStatement statement;
			String query = "select * from misc";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				misc = new Misc();
				misc.setId(result.getInt("id"));				
				misc.setNome(result.getString("nome"));
				misc.setUrl(result.getString("url"));
				miscs.add(misc);
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
		return miscs;
	}

	@Override
	public void update(Misc misc) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update misc SET id = ?, nome = ?, url = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, misc.getId());
			statement.setString(2, misc.getNome());
			statement.setString(3, misc.getUrl());
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
	public void delete(Misc misc) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM misc WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, misc.getId());
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
