package GE.shuhaliia.view.toolBarButtons;



import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconButton extends JButton{

	private static final long serialVersionUID = 2616721638107192856L;

	public IconButton(String pathToIcon){	
		super(new ImageIcon(pathToIcon));
		setBorderPainted(false);
	}
}
