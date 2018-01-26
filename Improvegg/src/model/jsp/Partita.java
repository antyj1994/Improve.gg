package model.jsp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Partita {
	
	String gameMode;
	String result;
	long gameDuration;
	String champName;
	int champLevel;
	String kda;
	
	String champUrl;
	String champ;
	
	
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
	String spell1;
	String spell2;
	int cs;
	int visionScore;
	String lane;
	
	ArrayList<String> champs;
	ArrayList<String> champs2;
	
	public Partita() {
	}
	
	
	
	public List<String> getChamps() {
		return champs;
	}

	public List<String> getChamps2() {
		return champs2;
	}

	public void setChamps(List<String> champs) {
		int cont = 0;
		ArrayList<String> temp = new ArrayList<>();
		ArrayList<String> temp2 = new ArrayList<>();
		for (Iterator<String> iterator = champs.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			if (cont <= (champs.size()/2-1) && string != null) {
				temp.add(string);
			}
			else if (string != null){
				temp2.add(string);
			}
			cont++;
		}
		this.champs = temp;
		this.champs2 = temp2;
	}

	public String getChamp() {
		return champ;		
	}
	
	public void setChamp(String champ) {
		this.champ=champ;
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

	public String getSpell1() {
		return spell1;
	}

	public void setSpell1(String spell1) {
		this.spell1 = spell1;
	}

	public String getSpell2() {
		return spell2;
	}

	public void setSpell2(String spell2) {
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
