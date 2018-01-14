package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;

public class AccountCredenziali extends Account{
	private DataSource dataSource;

	public AccountCredenziali(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public String getPassword(){						
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from account where nome = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, this.getNome());
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				return result.getString("password");
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
		return null;
	}
}
