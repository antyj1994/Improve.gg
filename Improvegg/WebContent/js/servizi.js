function Partita(gameMode, champName, kda){
	this.gameMode = gameMode;
	this.champName = champName;
	this.kda = kda;
	
	this.info = function(){
		return this.gameMode + ", " + this.champName + ", " + this.kda;
	}
}