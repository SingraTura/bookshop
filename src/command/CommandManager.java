package command;

import java.util.HashMap;

import command.commandGetter.GetterAllFieldsWithoutFilter;

public class CommandManager {

    private static CommandManager commandManager;

    private static final HashMap<String, Class<? extends Commandable>> COMMANDS = new HashMap<String, Class<? extends Commandable>>();

    private CommandManager() {
        registCommand(GetterAllFieldsWithoutFilter.COMMAND_NAME, GetterAllFieldsWithoutFilter.class);
    }

    public static synchronized CommandManager getIntance() {
        if (commandManager == null) {
            commandManager = new CommandManager();
        }
        return commandManager;
    }

    public Commandable getValidate(String commandName) {
        try{
            return COMMANDS.get(commandName.toUpperCase()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void registCommand(String commandName,
                              Class<? extends Commandable> validate) {
    	COMMANDS.put(commandName.toUpperCase(), validate);
    }
}
