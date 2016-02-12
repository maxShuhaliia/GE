package GE.shuhaliia.command;


public abstract class Command implements Cloneable {
		


	public CommandMgr commandMgr;
	
	public abstract void execute();
	
	public abstract void undo();
	
	public abstract void redo();
	
	public abstract boolean isUndoable();
	

	public CommandMgr getCommandMgr() {
		return commandMgr;
	}

	public void setCommandMgr(CommandMgr commandMgr) {
		this.commandMgr = commandMgr;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
