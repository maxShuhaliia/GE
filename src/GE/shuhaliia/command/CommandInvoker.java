package GE.shuhaliia.command;

import java.util.HashMap;
/*
 * this class uses as store commands which can available to invoke , in HashMap 
 * all commands can be invoke using key of HashMap
 * 
 * 
 * */
public class CommandInvoker {
	
	private CommandMgr commandMgr;

	private HashMap<String, Command> commandMap = new HashMap<String, Command>();
	
	public CommandInvoker(CommandMgr commandMgr){
		
		
		commandMap.put("save", new SaveCommand(commandMgr));
		commandMap.put("draw", new DrawCommand(commandMgr));
		commandMap.put("undo", new UndoCommand(commandMgr));
		commandMap.put("redo", new RedoCommand(commandMgr));
		
	
	}
	
	public void invoke(String command){
	
		commandMap.get(command).execute();
		
	}

	
	

}
