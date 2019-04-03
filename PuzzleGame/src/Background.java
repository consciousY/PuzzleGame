import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Background extends JFrame{

	JLabel p;
	
	public Background(){
		
		//w.setUndecorated(true);
		setSize(700,700);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Tahmid\\Downloads\\gameon.png")));
		setLayout(new FlowLayout());
		p=new JLabel();
		add(p);
		setSize(700,700);
	}
	/*public static void main(String args[]) {
		new Homeview();
		PuzzleGame p=new PuzzleGame();
	}*/

}
//C:\Users\Tahmid\eclipse-workspace\Learning with Fun\images
