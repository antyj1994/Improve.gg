package model;

public class Spell {
	
	private int id;
	private String nome;
	private String url;
	
	public Spell() {}
	
	public Spell(int id, String nome, String url) {
		this.id = id;
		this.nome = nome;
		this.url = url;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getUrl() {
		
		return url;
	}
	
	public void setUrl(String url) {
		
		this.url=url;
	}
	
	@Override
	public String toString() {
		return "Spell [id=" + id + ", nome=" + nome + ", url="+ url + "]";
	}

}
