package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Account;
import persistence.dao.AccountDao;

public class AccountDaoJDBC implements AccountDao{
	
	private DataSource dataSource;

	public AccountDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Account account) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into account(nome, password) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, account.getNome());
			statement.setString(2, account.getPassword());
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
	public Account findByPrimaryKey(String name) {
		Connection connection = this.dataSource.getConnection();
		Account account = null;
		try {
			PreparedStatement statement;
			String query = "select * from account where nome = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				account = new Account();
				account.setNome(result.getString("nome"));				
				account.setPassword(result.getString("password"));
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
		return account;
	}

	@Override
	public List<Account> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Account> accounts = new LinkedList<>();
		try {
			Account account;
			PreparedStatement statement;
			String query = "select * from account";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				account = new Account();
				account.setNome(result.getString("nome"));				
				account.setPassword(result.getString("password"));
				accounts.add(account);
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
		return accounts;
	}

	@Override
	public void update(Account account) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update account SET nome = ?, password = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, account.getNome());
			statement.setString(2, account.getPassword());
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
	public void delete(Account account) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM account WHERE nome = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, account.getNome());
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
	public void setPassword(Account account, String password) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update account SET password = ? WHERE nome = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, password);
			statement.setString(2, account.getNome());
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

	@Override //EQUIVALENTE A FINDBYPRIMARYKEY SERVIRA SOLO IN CASO CAMBIEREMO ALCUNE COSE
	public AccountCredenziali findByPrimaryKeyCredential(String nome) {
		Account stud = findByPrimaryKey(nome);
		AccountCredenziali studCred = null;
		if (stud != null){
			studCred = new AccountCredenziali(dataSource);
			studCred.setNome(stud.getNome());
			studCred.setPassword(stud.getPassword());		
		}
		return studCred;
	}

}
