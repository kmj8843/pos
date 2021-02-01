package PBL;
	import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;	
	
public class CafeMusic extends Thread{
		
		private Player player;
		private boolean isLoop;
		private File file;										
		private FileInputStream fis;							
		private BufferedInputStream bis;						
		
		public CafeMusic(String name, boolean isLoop) {
			try {												
				this.isLoop = isLoop;
				file = new File(PBL.class.getResource("../music_cafe/"+name).toURI());	
				fis = new FileInputStream(file);										
				bis = new BufferedInputStream(fis);										
				player = new Player(bis);												
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		public int getTime() {				
			if(player == null)
				return 0;
			return player.getPosition();
		}
		
		
		@Override
		public void run() {	
			try {
				do {
					player.play();								
					fis = new FileInputStream(file);			
					bis = new BufferedInputStream(fis);			
					player = new Player(bis);
				}while(isLoop);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}//class Music

