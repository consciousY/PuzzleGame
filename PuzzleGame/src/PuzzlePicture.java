import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PuzzlePicture extends JButton{

	    private boolean isLastButton;

	    public PuzzlePicture() {

	        super();

	        initUI();
	    }

	    public PuzzlePicture(Image image) {

	        super(new ImageIcon(image));

	        initUI();
	    }

	    private void initUI() {

	        isLastButton = false;
	        BorderFactory.createLineBorder(Color.gray);

	        addMouseListener(new MouseAdapter() {

	            @Override
	            public void mouseEntered(MouseEvent e) {
	                setBorder(BorderFactory.createLineBorder(Color.yellow));
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                setBorder(BorderFactory.createLineBorder(Color.gray));
	            }
	        });
	    }

	    public void setLastButton() {
	        
	        isLastButton = true;
	    }

	    public boolean isLastButton() {

	        return isLastButton;
	    }
	}

	
