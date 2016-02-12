package GE.shuhaliia.command;

import GE.shuhaliia.view.draw.shapes.Graphic;

public class DrawCommand extends Command implements Cloneable{

	private Graphic graphic;
	
	

	public DrawCommand(CommandMgr commandMgr){
		this.commandMgr = commandMgr;
	}
	
	@Override
	public void execute() {
		
		
		
		try {
			this.graphic = 	commandMgr.getModel().getGraphic().clone();	
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		commandMgr.draw(this);
		commandMgr.clearUndoCommands();
		commandMgr.getModel().notifyObserver();
	}
	

	@Override
	public void undo() {
		
		commandMgr.getModel().getPictureComposite().removeLastChild();   // rename remove last 	
		commandMgr.getModel().notifyObserver();
	//	commandMgr.printHistory(commandMgr);
		}
	

	@Override
	public void redo() {
		commandMgr.getModel().getPictureComposite().add(graphic);
		commandMgr.getModel().notifyObserver();
	//	commandMgr.printHistory(commandMgr);
		
	}

	@Override
	public boolean isUndoable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
