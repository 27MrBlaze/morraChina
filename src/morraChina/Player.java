package morraChina;

public class Player {
	 static String nome;
     static String[] mossa;
     public Player(String n)
     {
             mossa = new String[] {"", "sasso", "carta", "forbice"};
             nome = n;
     }
    
     public String gioca()
     {
     	return giocaPC();
     }
     
     public String gioca(String com)
     {
     	return giocaUS(com);
     }
    
     public String giocaPC(){
             return mossa[1 + (int)(Math.random()*3)];
     }
    
     public String giocaUS(String input){
             return input;
     }
}
