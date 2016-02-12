package GE.shuhaliia.listeners;



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.UIManager;

import GE.shuhaliia.controller.Controller;
import GE.shuhaliia.model.Model;
import GE.shuhaliia.view.draw.DrawPanel;
import GE.shuhaliia.view.draw.shapes.CurveLine;
import GE.shuhaliia.view.draw.shapes.Eraser;
import GE.shuhaliia.view.draw.shapes.MyFillOval;
import GE.shuhaliia.view.draw.shapes.Graphic;
import GE.shuhaliia.view.draw.shapes.Line;
import GE.shuhaliia.view.draw.shapes.MyFillRectangle;
import GE.shuhaliia.view.draw.shapes.MyOval;
import GE.shuhaliia.view.draw.shapes.PictureComposite;
import GE.shuhaliia.view.draw.shapes.MyRectangle;
import GE.shuhaliia.view.draw.shapes.Text;
import GE.shuhaliia.view.draw.shapes.ColorPicker;
public class DrawPanelListeners implements MouseListener, MouseMotionListener{
	
	private Model model;
	private Controller controller;

	private DrawPanel panel;
	private Graphic graphic;

	public DrawPanelListeners(DrawPanel panel, Model model, Controller controller) {
		this.panel = panel;
		this.model = model;
		this.controller = controller;		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		model.getDrawPanel().setmouseWasPressed(true);
	
		int x = e.getX();
		int y = e.getY();
		int x2 = e.getX()+1;
		int y2 = e.getY()+1;
			
		if(new MyOval(y2, y2, y2, y2, model) instanceof Graphic)
		
		
		 if(model.getGraphicString().equals("text")){							//+

			if(model.getGraphic()!=null){
				transformTextAreaToString();
				graphic = new Text(x, y, x2, y2, model);
			}
			else{
				model.clearMessage();
				graphic = new Text(x, y, x2, y2, model);
			}
		}
		
		 else if(model.getGraphicString().equals("line")){								///+	
			 if(model.getGraphic()!=null){
				 transformTextAreaToString();
			 }
			graphic = new Line(x, y, x2, y2, model);	
		}
		
		else if(model.getGraphicString().equals("rectangle")){						//+
			 if(model.getGraphic()!=null){
				 transformTextAreaToString();
			 }
			graphic = new MyRectangle(x, y, x2, y2, model);	
		}
		
		else if(model.getGraphicString().equals("fillRectangle")){					//+
			 if(model.getGraphic()!=null){
				 transformTextAreaToString();
			 }
			graphic = new MyFillRectangle(x, y, x2, y2, model);			
		}
		
		else if(model.getGraphicString().equals("oval")){							//+
			 if(model.getGraphic()!=null){
				 transformTextAreaToString();
			 }
			graphic = new MyOval(x, y, x2, y2, model);	
		}
		else if(model.getGraphicString().equals("fillOval")){						//+
			 if(model.getGraphic()!=null){
				 transformTextAreaToString();
			 }
			graphic = new MyFillOval(x, y, x2, y2, model);	
		}
		else if(model.getGraphicString().equals("curveLine")){						//+
			 if(model.getGraphic()!=null){
				 transformTextAreaToString();
			 }
			graphic = new CurveLine(x, y, x2, y2, model);
		}
		
		else if (model.getGraphicString().equals("eraser")){						//+
			 if(model.getGraphic()!=null){
				 transformTextAreaToString();
			 }
			graphic = new Eraser(x, y, x2, y2, model);
		}
		
		else if(model.getGraphicString().equals("colorPicker")){					//+
				
			 if(model.getGraphic()!=null){
				 transformTextAreaToString();
			 }
			 	graphic = new ColorPicker(x, y, x2, y2, model);
				model.setAbilityCreateImage(true);
				model.getDrawPanel().updateDrawPanel();
		}
		 
		else if(model.getGraphicString().equals("fill")){	
			
		}

		
		model.setGraphic(graphic);
		model.getDrawPanel().removeTextArea();
		
	}
		


	@Override
	public void mouseReleased(MouseEvent e) {
		
	if(model.getGraphic().getClass()!=Text.class)model.getDrawPanel().requestFocus();
		
		
		
		if(model.getGraphic().isVisible() && model.getGraphic().getClass()!=Text.class){
			PictureComposite pictureComposite = model.getPictureComposite();
			Graphic graphic = null;
			
			try {
				graphic = model.getGraphic().clone();
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

				pictureComposite.add(graphic);
			
				model.getCcommandInvoker().invoke("draw");
				model.setGraphic(null);
		}
		else if(model.getGraphic().getClass()==ColorPicker.class){
			model.setGraphic(null);
		}
		

	}
	@Override
	public void mouseDragged(MouseEvent e) {
				
	if(model.getGraphic().getClass()!=ColorPicker.class){
		controller.setX2Y2(e.getX(), e.getY());
	}		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {	
	}


	@Override
	public void mouseEntered(MouseEvent e) {	
	}


	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	public void transformTextAreaToString(){
		PictureComposite pc = model.getPictureComposite();
		model.getGraphic().setAddToComposite(true);
		try {
			pc.add(model.getGraphic().clone());
		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		model.clearMessage();
		model.getCcommandInvoker().invoke("draw");
		model.setGraphic(null);
	}
	}