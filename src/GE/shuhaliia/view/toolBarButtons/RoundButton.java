package GE.shuhaliia.view.toolBarButtons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

public class RoundButton extends JButton {

	private static final long serialVersionUID = 5624884806588961291L;
	
	public RoundButton(String label) {
	        super(label);
	        //get ovals parameter height and width
	        Dimension size = getPreferredSize();
	        //do equals height=width
	        size.height = size.width;
	        size.width = size.height = Math.max(size.width,size.height);
	        				
	        setPreferredSize(size);
	        setContentAreaFilled(false);
	    }
	    @Override
	    protected void paintComponent(Graphics g) {
	    	
	    	
	    	// if the button has been selected set color LightGray
	        if (getModel().isArmed()) {
	            g.setColor(Color.lightGray);
	        } else {
	        	// if the button hasn't select set color backGround
	            g.setColor(getBackground());
	        }
	        g.fillOval(0, 0, getSize().width - 1,
	                getSize().height - 1 );
	        g.setColor(Color.white);
	        //если не вызвать то не будет лейбла кнопки
	       super.paintComponent(g);
	    }
	    @Override
	    protected void paintBorder(Graphics g) {
	      //  g.setColor(Color.red);
	        g.drawOval(0, 0, getSize().width - 1,
	               getSize().height - 1);  
	    }
}
