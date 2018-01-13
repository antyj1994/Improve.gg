package model;

public class Favourite {
	
	private String nome;
	private String account;
	
	public Favourite() {}
	
	public Favourite(String nome, String account) {
		super();
		this.nome = nome;
		this.account = account;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
}
