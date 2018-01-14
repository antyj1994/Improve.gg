package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Champion;
import model.Favourite;
import persistence.dao.FavouriteDao;

public class FavouriteDaoJDBC implements FavouriteDao{

	private DataSource dataSource;

	public FavouriteDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Favourite name) {
		Connection connection = this.dataSource.getConnection();
		try {		
			String insert = "insert into favourite(nome, account) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, name.getNome());
			statement.setString(2, name.getAccount());			
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
	public List<Favourite> findByAccount(String account) {
		Connection connection = this.dataSource.getConnection();
		List<Favourite> champions = new LinkedList<>();
		try {
			Favourite champion = null;
			PreparedStatement statement;
			String query = "select * from favourite where account = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, account);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				champion = new Favourite();
				champion.setNome(result.getString("nome"));				
				champion.setAccount(result.getString("account"));
				champions.add(champion);
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
		return champions;
	}

	@Override
	public List<Favourite> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Favourite> champions = new LinkedList<>();
		try {
			Favourite champion = null;
			PreparedStatement statement;
			String query = "select * from favourite";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				champion = new Favourite();
				champion.setNome(result.getString("nome"));				
				champion.setAccount(result.getString("account"));
				champions.add(champion);
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
		return champions;
	}

	@Override
	public void update(Favourite name) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update favourite SET nome = ?, account = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, name.getNome());
			statement.setString(2, name.getAccount());
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
	public void delete(Favourite name) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM favourite WHERE nome = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, name.getNome());
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
