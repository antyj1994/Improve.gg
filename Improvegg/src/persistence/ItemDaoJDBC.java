package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Item;

import persistence.dao.ItemDao;

public class ItemDaoJDBC implements ItemDao{
	
	private DataSource dataSource;

	public ItemDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(Item item) {
		Connection connection = this.dataSource.getConnection();
		try {		
			String insert = "insert into item(id, nome, url) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, item.getId());
			statement.setString(2, item.getNome());		
			statement.setString(3,  item.getUrl());
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
	public Item findByPrimaryKey(long id) {
		Connection connection = this.dataSource.getConnection();
		Item item = null;
		try {
			PreparedStatement statement;
			String query = "select * from item where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				item = new Item();
				item.setId(result.getInt("id"));				
				item.setNome(result.getString("nome"));
				item.setUrl(result.getString("url"));
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
		return item;
	}

	@Override
	public List<Item> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Item> items = new LinkedList<>();
		try {
			Item item;
			PreparedStatement statement;
			String query = "select * from item";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				item = new Item();
				item.setId(result.getInt("id"));				
				item.setNome(result.getString("nome"));
				item.setUrl(result.getString("url"));
				items.add(item);
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
		return items;
	}

	@Override
	public void update(Item item) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update item SET id = ?, nome = ?, url= ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, item.getId());
			statement.setString(2, item.getNome());
			statement.setString(3,  item.getUrl());
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
	public void delete(Item item) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM item WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, item.getId());
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
