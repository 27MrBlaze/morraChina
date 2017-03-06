package morraChina;

import java.io.IOException;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



		public class Main {
			private static JFrame frmMorraCinese;
	        public static void main(String[] args) throws IOException {
	        	
	        	EventQueue.invokeLater(new Runnable() {
	    			public void run() {
	    				try {
	    					Main window = new Main();
	    					window.frmMorraCinese.setVisible(true);
	    				} catch (Exception e) {
	    					e.printStackTrace();
	    				}
	    			}
	    		});                	                	                
	                }//main

	        /**
	    	 * Create the application.
	    	 */
	    	public Main() {
	    		initialize();
	    	}

	    	/**
	    	 * Initialize the contents of the frame.
	    	 */
	    	private void initialize() {
	    		frmMorraCinese = new JFrame();
	    		frmMorraCinese.setResizable(true);
	    		frmMorraCinese.setTitle("Morra Cinese");
	    		frmMorraCinese.setBounds(100, 100, 450, 500);
	    		frmMorraCinese.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		frmMorraCinese.getContentPane().setLayout(new FlowLayout());
	    		
	    		JButton btnPCvsPC = new JButton("PC vs PC");
	    		btnPCvsPC.setBackground(Color.CYAN);
	    		btnPCvsPC.setToolTipText("");
	    		btnPCvsPC.setFont(new Font("Tahoma", Font.PLAIN, 23));
	    		frmMorraCinese.getContentPane().add(btnPCvsPC);
	    		
	    		JButton btnUMANOvsPC = new JButton("PC vs Umano");
	    		btnUMANOvsPC.setBackground(Color.CYAN);
	    		btnUMANOvsPC.setToolTipText("");
	    		btnUMANOvsPC.setFont(new Font("Tahoma", Font.PLAIN, 23));
	    		frmMorraCinese.getContentPane().add(btnUMANOvsPC);
	    		
	    		JLabel lblgame = new JLabel("Inserisci numero di partite: ");
	    		JTextField txtField = new JTextField(3);
	    		frmMorraCinese.getContentPane().add(lblgame);
	    		frmMorraCinese.getContentPane().add(txtField);	    		 
	    		
	    		JTextArea txtArea = new JTextArea(5, 30);
	    		JScrollPane scrollPane = new JScrollPane(txtArea); 
	    		txtArea.setEditable(false);
	    		frmMorraCinese.getContentPane().add(txtArea);
	    		
	    		JLabel lblchoose = new JLabel("Inserire mossa: ");
			    JTextField txtChoose = new JTextField(10);
			    frmMorraCinese.getContentPane().add(lblchoose);
			    frmMorraCinese.getContentPane().add(txtChoose);
	    		
	    		btnPCvsPC.addActionListener(new ActionListener() {
	    			
	    			public void actionPerformed(ActionEvent arg0) {
	    					
	    				int Nmatch = Integer.parseInt(txtField.getText());
	    				txtArea.setText("");
	    				if(Nmatch%2==1){
	    					PCvsPC(Nmatch, txtArea);
	    					btnPCvsPC.setEnabled(false);
	    					}
	    				else
	    					JOptionPane.showMessageDialog(frmMorraCinese, "Inserire numero dispari!");	
	    			
	    			}
	    		});
	    		
	    		btnUMANOvsPC.addActionListener(new ActionListener() {
	    			
	    			public void actionPerformed(ActionEvent arg0) {
	    				int Nmatch = Integer.parseInt(txtField.getText());
	    				txtArea.setText("");
	    				if(Nmatch%2==1){
	    					UMANOvsPC(Nmatch, txtArea, txtChoose);	    				
		    				btnUMANOvsPC.setEnabled(false);
	    					}
	    				else
	    					JOptionPane.showMessageDialog(frmMorraCinese, "Inserire numero dispari!");
	    				
	    			}
	    		});
	    	}	        
	        
	        
			private static void PCvsPC(int Npartite, JTextArea txtArea) {
			
				
				
				for(int i=0;i<Npartite;i++){
					GameMaster game = new GameMaster();
					String vincitore = game.play();
					String p1=game.estraction(game.playOne);
					String p2=game.estraction(game.playTwo);	

		    		
		    		txtArea.append("Giocatore 1 ha giocato: "+p1+"\n");
		    		txtArea.append("Giocatore 2 ha giocato: "+p2+"\n");
		    		txtArea.append(vincitore+"\n");
		    		
				}
				
			}

			private static void UMANOvsPC(int Npartite, JTextArea txtArea, JTextField txtChoose) {
		       
		        String p1, p2;
		        Player umano = new Player("umano");
		        Player artificial_intelligence = new Player("bot");
		       
		        for(int i=0;i<Npartite;i++){

		        		txtArea.append("Turno: "+(i+1)+"\n");

		                String input = txtChoose.getText();
		                p1 = umano.gioca(input);
		                p2 = artificial_intelligence.gioca();
		   
		                txtArea.append("L'uomo ha giocato: "+ p1+"\n");
		                txtArea.append("Il bot ha giocato "+p2+"\n");
		               
		                if(p1.equals(p2)){
		                	txtArea.append("PAREGGIO"+"\n");
		                }
		               
		                /*se metti sasso*/
		                if(p1.equals("sasso"))
		                { //giocatore umano
		                       
		                	 	if(p2.equals("forbice"))
		                	 		txtArea.append("Hai Vinto!"+"\n");
		                        if(p2.equals("carta")) 
		                        	txtArea.append("Hai Perso!"+"\n");
		                }
		               
		                /*Se metti carta*/
		                if(p1.equals("carta"))
		                {
		                        if(p2.equals("sasso"))
		                        	txtArea.append("Hai Vinto!"+"\n");
		                        if(p2.equals("forbice")) 
		                        	txtArea.append("Hai Perso!"+"\n");
		                }              
		               
		                /*Se metti forbice*/
		                if(p1.equals("forbice"))
		                {
		                        if(p2.equals("carta"))
		                        	txtArea.append("Hai Vinto!"+"\n");
		                        if(p2.equals("sasso")) 
		                        	txtArea.append("Hai Perso!"+"\n");
		                        }
		        }
		       
		       
				
			}
	}//class






	

