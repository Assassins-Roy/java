
import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame {
	
	Image ball= Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk= Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
	
	double x=100;
	double y=100;
	double degree = 3.14/3;
	
	public void paint(Graphics g) {
		g.drawImage(desk,0,0,null);
		g.drawImage(ball, (int)x, (int)y, null);
		  x  = x+ 10*Math.cos(degree);
	        y  = y +10*Math.sin(degree); 
	         
	        //碰到上下边界
	        if(y>500-40-30||y<40+40){//500是窗口高度；40是桌子边框，30是球直径；最后一个40是标题栏的高度
	            degree = -degree;
	        }
	         
	        //碰到左右边界
	        if(x<40||x>856-40-30){
	            degree = 3.14 - degree;
	        }
	         
	    }
	
	void launchFrame() {
		setSize(856,500);
		setLocation(50,50);
		setVisible(true);
		
	
	while(true) {
		repaint();
		try {
			Thread.sleep(40);
	}catch(Exception e) {
		e.printStackTrace();
	}	
	}
	}
public static void main(String[] args) {
	System.out.println("i am Roy"); 
	BallGame game=new BallGame();
	game.launchFrame();
	
}



}