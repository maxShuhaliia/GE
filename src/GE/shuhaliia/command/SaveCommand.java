package GE.shuhaliia.command;

public class SaveCommand extends Command {

	
	public SaveCommand(CommandMgr commandMgr){
		super.setCommandMgr(commandMgr);
	}
	
	@Override
	public void execute() {
		//registration operation process
		commandMgr.save(this);

		commandMgr.getModel().setAbilityCreateImage(true);
		commandMgr.getModel().setAbilitySaveImage(true);
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
		return false;
	}

	


}
