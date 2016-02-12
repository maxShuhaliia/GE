package GE.shuhaliia.command;

public class RedoCommand extends Command {

	public RedoCommand(CommandMgr commandMgr){
		this.commandMgr = commandMgr;
	}
	
	
	@Override
	public void execute() {
		commandMgr.redo();
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUndoable() {
		// TODO Auto-generated method stub
		return false;
	}

}
