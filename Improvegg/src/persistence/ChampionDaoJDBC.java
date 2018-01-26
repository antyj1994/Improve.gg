package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Champion;
import persistence.dao.ChampionDao;

public class ChampionDaoJDBC implements ChampionDao{
	
	private DataSource dataSource;

	public ChampionDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Champion champion) {
		Connection connection = this.dataSource.getConnection();
		try {		
			String insert = "insert into champion(id, nome, url, tooltip) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, champion.getId());
			statement.setString(2, champion.getNome());		
			statement.setString(3, champion.getUrl());
			statement.setString(4, champion.getTooltip());
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
	public Champion findByPrimaryKey(long id) {
		Connection connection = this.dataSource.getConnection();
		Champion champion = null;
		try {
			PreparedStatement statement;
			String query = "select * from champion where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				champion = new Champion();
				champion.setId(result.getInt("id"));				
				champion.setNome(result.getString("nome"));
				champion.setUrl(result.getString("url"));
				champion.setTooltip(result.getString("tooltip"));
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
		return champion;
	}

	@Override
	public List<Champion> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Champion> champions = new LinkedList<>();
		try {
			Champion champion;
			PreparedStatement statement;
			String query = "select * from champion";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				champion = new Champion();
				champion.setId(result.getInt("id"));				
				champion.setNome(result.getString("nome"));
				champion.setUrl(result.getString("url"));
				champion.setTooltip(result.getString("tooltip"));
				champions.add(champion);
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
		return champions;
	}

	@Override
	public void update(Champion champion) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update champion SET id = ?, nome = ?, url = ?, tooltip = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, champion.getId());
			statement.setString(2, champion.getNome());
			statement.setString(3, champion.getUrl());
			statement.setString(4, champion.getTooltip());
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
	public void delete(Champion champion) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM champion WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, champion.getId());
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
