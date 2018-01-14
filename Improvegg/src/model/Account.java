package model;

public class Account {
	
	private String nome;
	private String password;
	
	public Account() {}
	
	public Account(String nome, String password) {
		this.nome = nome;
		this.password = password;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Account [nome=" + nome + ", password=" + password + "]";
	}
	
}
