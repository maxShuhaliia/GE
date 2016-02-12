package GE.shuhaliia.command;

import java.util.LinkedList;

import GE.shuhaliia.model.Model;

public class CommandMgr {
	private Command command;
	

	private LinkedList<Command> undoCommands = new LinkedList<Command>();
	private LinkedList<Command> doCommands = new LinkedList<Command>();
	private Model model;
	
	public CommandMgr(Model model){
		this.model = model;
	}
	
	
	public void save(Command command){
		recordHisory(command);
	}
	
	public void draw(Command command){
		recordHisory(command);
	}


	
	private void recordHisory(Command command) {
	
		try {
			Command c = (Command) command.clone();
			doCommands.add(c);
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void printHistory(CommandMgr commandMgr){
		System.out.println(commandMgr.doCommands.toString());
	
	}
	
	public Model getModel() {
		return model;
	}
	
	
	public void undo(){

		if(undoable()){
			command = doCommands.removeLast();
			undoCommands.add(command);
			command.undo();
		}
	}
	
	public void redo(){
		if(redoable()){
			command = undoCommands.removeLast();
			doCommands.add(command);
			command.redo();
			model.notifyObserver();
			
			
		}
		
		
	}
	
	
	// ability to do undo operation
	public boolean undoable(){
		if(doCommands.isEmpty()) return false;
		return true;
	}
	
	public boolean redoable(){
		if(undoCommands.isEmpty()) return false;
		return true;
	}
	
	public void clearUndoCommands(){
		if(!undoCommands.isEmpty()) undoCommands.clear();
	}

}
