package command.commandSetter;

import java.util.HashMap;

public class CommandManagerSetter {
	
	private static CommandManagerSetter commandManagerSetter;

    private static final HashMap<String, Class<? extends Setteable>> COMMANDS = new HashMap<String, Class<? extends Setteable>>();

    private CommandManagerSetter() {
        registCommand(SetterAddAuthor.COMMAND_NAME, SetterAddAuthor.class);
        registCommand(SetterModifyBook.COMMAND_NAME, SetterModifyBook.class);
        registCommand(SetterDeleteElementByKey.COMMAND_NAME, SetterDeleteElementByKey.class);
        registCommand(SetterModifyBookAtributte.COMMAND_NAME, SetterModifyBookAtributte.class);
        registCommand(SetterModifyAtributte.COMMAND_NAME, SetterModifyAtributte.class);
    }

    public static synchronized CommandManagerSetter getIntance() {
        if (commandManagerSetter == null) {
        	commandManagerSetter = new CommandManagerSetter();
        }
        return commandManagerSetter;
    }

    public Setteable getCommand(String commandName) {
        try{
            return COMMANDS.get(commandName.toUpperCase()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void registCommand(String commandName,
                              Class<? extends Setteable> validate) {
    	COMMANDS.put(commandName.toUpperCase(), validate);
    }
}
