package model;

public class Item {
	
	
	private int id;
	private String nome;
	
	public Item() {}
	
	public Item(int id, String nome) {
		this.id = id;
		this.nome = nome;
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
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", nome=" + nome + "]";
	}

}
