package model;

public class Champion {
	
	private int id;
	private String nome;
	private String url;
	private String tooltip;
	
	public Champion() {}
	
	public Champion(int id, String nome, String url, String tooltip) {
		this.id = id;
		this.nome = nome;
		this.url=url;
		this.tooltip=tooltip;
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
	
	
	public String getTooltip() {
		return tooltip;
	}
	public void setTooltip(String tooltip) {
		this.tooltip=tooltip;
	}
	
	@Override
	public String toString() {
		return "Champion [id=" + id + ", nome=" + nome + ", url="+ url + ", tooltip="+tooltip+"]";
	}
	
}