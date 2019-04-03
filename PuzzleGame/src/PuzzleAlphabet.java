	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.Font;
	import java.awt.FontMetrics;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.RenderingHints;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.util.Random;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.SwingUtilities;

public class PuzzleAlphabet extends JPanel{
		private int size;
		private int numberTiles;
		private int dimension;
		private static final Color FOREGROUND_COLOR=new Color(239,83,80);
		private static final Random RANDOM=new Random();
		private String tiles[];
		private int tileSize;
		private int freePos;
		private int border;
		private int gridSize;
		private boolean gameOver;
//		private enum STATE{
//			MENU,
//			GAME
//		};
//		private STATE State=STATE.MENU;
//		Menu menu;
		public PuzzleAlphabet(int s,int d,int b) {
			this.size=s;
			dimension=d;
			border=b;
			
			numberTiles=s*(s-1);
			tiles=new String[s*s];
			gridSize=d-2*border;
			tileSize=gridSize/s;
			
			setPreferredSize(new Dimension(dimension,dimension+border));
			setBackground(Color.WHITE);
			setForeground(FOREGROUND_COLOR);
			setFont(new Font("SansSerif",Font.BOLD,60));
			
			gameOver=true;
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent m) {
					if(gameOver==true) {
						
						newGame();
					}
					else {
						int x=m.getX()-border;
						int y=m.getY()-border;
						if(x<0||x>gridSize||y<0||y>gridSize) {
							return;
						}
						int c1=x/tileSize;
						int r1=y/tileSize;
						int c2=freePos%size;
						int r2=freePos/size;
						int cp=r1*size+c1;
						int dir=0;
						if(c1==c2&&Math.abs(r1-r2)>0) {
							dir=(r1-r2)>0?size:-size;
						}
						else if(r1==r2&&Math.abs(c1-c2)>0){
							dir=(c1-c2)>0?1:-1;
						}
						if(dir!=0) {
							do {
								int newfreePos=freePos+dir;
								tiles[freePos]=tiles[newfreePos];
								freePos=newfreePos;
							}
							while(freePos!=cp);
							tiles[freePos]="";
						}
						gameOver=isSolved();
					}
					repaint();
				}
				
			});
			newGame();
		}
		private void reset() {
			int i,j;
			for(i=0,j=65;i<tiles.length;i++,j++) {
				tiles[i]=String.valueOf(j);
			}
			freePos=tiles.length-1;
		}
		private void shuffle() {
			int num,ran;
			String fre;
			num=numberTiles;
			while(num>1) {
				ran=RANDOM.nextInt(num--);
				fre=tiles[ran];
				tiles[ran]=tiles[num];
				tiles[num]=fre;
			}
		}
		private boolean isSolvable() {
			int i,j,count=0;
			for(i=0;i<numberTiles;i++) {
				for(j=0;j<i;j++) {
					if(tiles[j].compareTo(tiles[i])>0) {
						count++;
					}
				}
			}
			return count%2==0;
		}
		private boolean isSolved() {
			int i,j;
			if(tiles[tiles.length-1]!="") {
				return false;
			}
			for(i=numberTiles-1,j=72;i>=0;i--,j--) {
				if(tiles[i]!=String.valueOf(j)) {
					return false;
				}
			}
			return true;
		}
		private void newGame() {
			do {
				reset();
				shuffle();
			}
			while(isSolvable()==false);
			gameOver=false;
		}
		private void drawCenteredString(Graphics2D g,String s,int x,int y) {
			
			FontMetrics fm;
			int a,d;
			fm=g.getFontMetrics();
			a=fm.getAscent();
			d=fm.getDescent();
			g.drawString(s, x+(tileSize-fm.stringWidth(s))/2, y+(a+(tileSize-(a+d))/2));
			
		}
		private void drawGrid(Graphics2D g) {
			int i,r,c,x,y;
			for(i=0;i<tiles.length;i++) {
				c=i%size;
				r=i/size;
				x=border+c*tileSize;
				y=border+r*tileSize;
				if(tiles[i]=="") {
					if(gameOver==true) {
						g.setColor(FOREGROUND_COLOR);
						drawCenteredString(g,"/",x,y);
					}
					continue;
				}
				g.setColor(getForeground());
				g.fillRoundRect(x, y, tileSize, tileSize, 25,25);
				g.setColor(Color.BLACK);
				g.drawRoundRect(x, y, tileSize, tileSize, 25, 25);
				g.setColor(Color.WHITE);
				drawCenteredString(g,String.valueOf(tiles[i]), x, y);
			}
			
		}
		private void drawStartMessage(Graphics2D g) {
			String s;
			if(gameOver==true) {
				g.setFont(getFont().deriveFont(Font.BOLD,18));
				g.setColor(FOREGROUND_COLOR);
				s="New Game";
				g.drawString(s, (getWidth()-g.getFontMetrics().stringWidth(s))/2, getHeight()-border);
			}
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d=(Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			drawGrid(g2d);
			drawStartMessage(g2d);
			
			
		}

		public static void main(String args[]) {
			Homeview h=new Homeview();
			
			SwingUtilities.invokeLater(()->{
				JFrame frame=new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Puzzle Game");
				frame.setResizable(false);
				frame.add(new PuzzleGame(3,550,30),BorderLayout.CENTER);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			});
		}
	

}
