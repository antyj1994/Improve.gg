package model.jsp;

public class Partita {
	
	String gameMode;
	String champName;
	String kda;
	
	public Partita(String gameMode, String champName, String kda) {
		super();
		this.gameMode = gameMode;
		this.champName = champName;
		this.kda = kda;
	}
	
	public String getGameMode() {
		return gameMode;
	}
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	
	public String getChampName() {
		return champName;
	}
	public void setChampName(String champName) {
		this.champName = champName;
	}
	
	public String getKda() {
		return kda;
	}
	public void setKda(String kda) {
		this.kda = kda;
	}

	@Override
	public String toString() {
		return "Partita [gameMode=" + gameMode + ", champName=" + champName + ", kda=" + kda + "]";
	}
	
}
