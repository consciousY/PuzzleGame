

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;



public class Homeview extends JFrame{
	JLabel p;
	
	public Homeview(){
		
		//w.setUndecorated(true);
		setSize(500,480);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Tahmid\\Downloads\\gameon.png")));
		setLayout(new FlowLayout());
		p=new JLabel();
		add(p);
		Menu m=new Menu();
		setSize(500,500);
		
		
//		Timer tm=new Timer(7,this);
//		int time=0;
//		private JProgressBar progressBar;
//		private JLabel loadingLabel;
//		public void actionPerformed(ActionEvent e) {
//			if(time!=110) {
//				 time++;
//				 progressBar.setValue(time);
//				 loadingLabel.setText(time+"%");
//			}
//			else {
//				tm.stop();
//				//JOptionPane.showMessageDialog(null,"Null");
//				MainFrame mf=new MainFrame();
//				mf.setVisible(true);
//				dispose();
//			}
//		}
		
	}
	/*public static void main(String args[]) {
		new Homeview();
		PuzzleGame p=new PuzzleGame();
	}*/

}
//C:\Users\Tahmid\eclipse-workspace\Learning with Fun\images