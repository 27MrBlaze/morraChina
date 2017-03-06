package morraChina;

public class GameMaster {
	
	// il game master si occupa di creare i due giocatori e di confrontare i loro risultati, ritornando, una stringa
	// con il nome del giocatore vincente
	
	
	int playOne, playTwo;

	String estraction(int n) {
		String est = "";
		switch (n) {
		case 1 :
			est = "Sasso";
			break;
		case 2 :
			est = "Carta";
			break;
		default :
			est = "Forbice";
		}
		return est;
	}
	
	String play(){
		
		playOne = (int)(Math.random()*3+1);
		playTwo = (int)(Math.random()*3+1);
		
		
		String result = "";
		if (playOne == 1 && playTwo==2){
			result = "Vince Giocatore 2";
		} else if(playOne== 1 && playTwo==3){
			result = "Vince Giocatore 1";
		} else if(playOne== 2 && playTwo==1){
			result = "Vince Giocatore 1";
		} else if(playOne== 2 && playTwo==3){
			result = "Vince Giocatore 2";
		} else if(playOne== 3 && playTwo==2){
			result = "Vince Giocatore 1";
		} else if(playOne== 3 && playTwo==1){
			result = "Vince Giocatore 2";
		} else{
			result = "PAREGGIO";
		}
		return result;
	}
	
}
