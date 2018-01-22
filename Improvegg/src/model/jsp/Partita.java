package model.jsp;

public class Partita {
	
	String gameMode;
	String result;
	long gameDuration;
	String champName;
	int champLevel;
	String kda;
	String champUrl;
	String itemUrl0;
	String itemUrl1;
	String itemUrl2;
	String itemUrl3;
	String itemUrl4;
	String itemUrl5;
	String spellUrl1;
	String spellUrl2;
	String runeUrl;
	
	String item0;
	String item1;
	String item2;
	String item3;
	String item4;
	String item5;
	float golds;
	int spell1;
	int spell2;
	int cs;
	int visionScore;
	String lane;
	
	public Partita() {
	}
	
	
	public void setSpellUrl1(String spellUrl1) {
		this.spellUrl1=spellUrl1;
		
	}
	public String getSpellUrl1() {
		return spellUrl1;
	}
	

	public void setSpellUrl2(String spellUrl2) {
		this.spellUrl2=spellUrl2;
		
	}
	public String getSpellUrl2() {
		return spellUrl2;
	}
	
	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}


	public int getChampLevel() {
		return champLevel;
	}

	public void setChampLevel(int champLevel) {
		this.champLevel = champLevel;
	}

	public String getChampUrl() {
		return champUrl;
	}

	public void setChampUrl(String champUrl) {
		this.champUrl = champUrl;
	}
	
	public String getItemUrl0() {
		return itemUrl0;
	}
	
	public void setItemUrl0(String itemUrl0) {
		this.itemUrl0=itemUrl0;
		
	}
	public String getItemUrl1() {
		return itemUrl1;
	}
	
	public void setItemUrl1(String itemUrl1) {
		this.itemUrl1=itemUrl1;
		
	}
	public String getItemUrl2() {
		return itemUrl2;
	}
	
	public void setItemUrl2(String itemUrl2) {
		this.itemUrl2=itemUrl2;
		
	}
	public String getItemUrl3() {
		return itemUrl3;
	}
	
	public void setItemUrl3(String itemUrl3) {
		this.itemUrl3=itemUrl3;
		
	}
	public String getItemUrl4() {
		return itemUrl4;
	}
	
	public void setItemUrl4(String itemUrl4) {
		this.itemUrl4=itemUrl4;
		
	}
	public String getItemUrl5() {
		return itemUrl5;
	}
	
	public void setItemUrl5(String itemUrl5) {
		this.itemUrl5=itemUrl5;
		
	}
	
	public String getRuneUrl() {
		return runeUrl;
	}
	
	public void setRuneUrl(String runeUrl) {
		this.runeUrl=runeUrl;
		
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
	public String getItem0() {
		return item0;
	}
	public void setItem0(String item0) {
		this.item0 = item0;
	}
	public String getItem1() {
		return item1;
	}
	public void setItem1(String item1) {
		this.item1 = item1;
	}
	public String getItem2() {
		return item2;
	}
	public void setItem2(String item2) {
		this.item2 = item2;
	}
	public String getItem3() {
		return item3;
	}
	public void setItem3(String item3) {
		this.item3 = item3;
	}
	public String getItem4() {
		return item4;
	}
	public void setItem4(String item4) {
		this.item4 = item4;
	}
	public String getItem5() {
		return item5;
	}
	public void setItem5(String item5) {
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
