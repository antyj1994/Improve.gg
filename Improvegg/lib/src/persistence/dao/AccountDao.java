package persistence.dao;

import java.util.List;
import model.Account;
import persistence.AccountCredenziali;

public interface AccountDao {

	public void save(Account account);  // Create
	public Account findByPrimaryKey(String name);     // Retrieve
	public List<Account> findAll();       
	public void update(Account account); //Update
	public void delete(Account account); //Delete	
	
	public void setPassword(Account studente, String password);
	public AccountCredenziali findByPrimaryKeyCredential(String nome);     // Retrieve
}
