import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractAction;
import javax.swing.Box;

public class Menu extends JPanel{
	boolean started=false;
	public Menu() {
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(Box.createVerticalStrut(280));
		JButton btn=new JButton("START");
		btn.setAlignmentX(CENTER_ALIGNMENT);
		btn.addActionListener(new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		add(btn);
		
		add(Box.createVerticalGlue());
		try {
			URL url=Menu.class.getResource("music1.wav");
			AudioInputStream audio=AudioSystem.getAudioInputStream(url);
			Clip music=AudioSystem.getClip();
			music.open(audio);
			music.loop(-1);
		}
		catch(Exception e) {
			
		}
		
	}
	public void start() {
		removeAll();
		started=true;
		repaint();
	}
//	public void render(Graphics g) {
//		Font fnt=new Font ("arial",Font.BOLD,50);
//		g.setFont(fnt);
//		g.setColor(Color.black);
//		g.drawString("Bunny's Blocks", PuzzleGame.WIDTH/2, 100);
//	}
}
