package GE.shuhaliia.view.toolBarButtons;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import GE.shuhaliia.controller.Controller;
import GE.shuhaliia.model.Model;


public class ToolBarColorAndWeight extends JToolBar implements ActionListener, ChangeListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 103053384551112397L;
	
	private Controller controler;
	private Model model;
	
	private RoundButton colorChooserBtn;
	private JSlider weight;
	private JPanel panel;
	private JLabel label;
	
	public ToolBarColorAndWeight(Controller controller, Model model){
		this.controler = controller;
		this.model = model;
		
		panel = new JPanel();
		label = new JLabel();
		add(panel);
		
		setFloatable(false);

		colorChooserBtn = new RoundButton("Color");
		colorChooserBtn.setBackground(model.getColor());
		colorChooserBtn.addActionListener(this);

		// horizontal, from 0 to 10, start position 1
		weight = new JSlider(JSlider.HORIZONTAL, 0, 10, 1);
		weight.setMajorTickSpacing(1);// метка 1 2 3...если ставить 2 например то метка 2 4 6
		weight.setMinorTickSpacing(100);
		weight.setPaintLabels(true);
		weight.setPaintTicks(true);
		weight.addChangeListener(this);
				
		panel.add(colorChooserBtn);
		panel.add(weight);
		panel.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color initialcolor = model.getColor(); 
		Color color = JColorChooser.showDialog(this,"Select a color",initialcolor);
		if(color!=null){
				model.setColor(color);
				colorChooserBtn.setBackground(color);	
		}
		}
	@Override
	public void stateChanged(ChangeEvent arg0) {
		JSlider sl = (JSlider) arg0.getSource();
		int weight = sl.getValue();
		model.setWeight(weight);
	}  
	
	public void updateColor(){
		colorChooserBtn.setBackground(model.getColor());	
	}	
	}