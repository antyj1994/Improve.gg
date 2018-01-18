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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favourite other = (Favourite) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
