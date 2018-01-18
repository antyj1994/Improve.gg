package model.jsp;

public class Partita {
	
	String gameMode;
	String result;
	long gameDuration;
	String champName;
	int champLevel;
	String kda;
	int item0;
	int item1;
	int item2;
	int item3;
	int item4;
	int item5;
	float golds;
	int spell1;
	int spell2;
	int cs;
	int visionScore;
	
	public Partita() {
	}
	
	public int getChampLevel() {
		return champLevel;
	}

	public void setChampLevel(int champLevel) {
		this.champLevel = champLevel;
	}

	public float getGolds() {
		return golds;
	}

	public void setGolds(int golds) {
		int step = golds / 100;
		this.golds = ((float)step / 10); 
	}

	public int getSpell1() {
		return spell1;
	}

	public void setSpell1(int spell1) {
		this.spell1 = spell1;
	}

	public int getSpell2() {
		return spell2;
	}

	public void setSpell2(int spell2) {
		this.spell2 = spell2;
	}

	public int getCs() {
		return cs;
	}

	public void setCs(int cs) {
		this.cs = cs;
	}

	public int getVisionScore() {
		return visionScore;
	}

	public void setVisionScore(int visionScore) {
		this.visionScore = visionScore;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public long getGameDuration() {
		return gameDuration;
	}
	public void setGameDuration(long gameDuration) {
		this.gameDuration = gameDuration;
	}
	public int getItem0() {
		return item0;
	}
	public void setItem0(int item0) {
		this.item0 = item0;
	}
	public int getItem1() {
		return item1;
	}
	public void setItem1(int item1) {
		this.item1 = item1;
	}
	public int getItem2() {
		return item2;
	}
	public void setItem2(int item2) {
		this.item2 = item2;
	}
	public int getItem3() {
		return item3;
	}
	public void setItem3(int item3) {
		this.item3 = item3;
	}
	public int getItem4() {
		return item4;
	}
	public void setItem4(int item4) {
		this.item4 = item4;
	}
	public int getItem5() {
		return item5;
	}
	public void setItem5(int item5) {
		this.item5 = item5;
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
		return "Partita [gameMode=" + gameMode + ", result=" + result + ", gameDuration=" + gameDuration
				+ ", champName=" + champName + ", kda=" + kda + ", item0=" + item0 + ", item1=" + item1 + ", item2="
				+ item2 + ", item3=" + item3 + ", item4=" + item4 + ", item5=" + item5 + ", golds=" + golds
				+ ", spell1=" + spell1 + ", spell2=" + spell2 + ", cs=" + cs + ", visionScore=" + visionScore + "]";
	}

}
