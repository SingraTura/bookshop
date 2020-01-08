package command.commandGetter;

import java.util.HashMap;



public class CommandManagerGetter {
	private static CommandManagerGetter commandManagerGetter;

    private static final HashMap<String, Class<? extends Getteable>> COMMANDS = new HashMap<String, Class<? extends Getteable>>();

    private CommandManagerGetter() {
        registCommand(GetterAllFieldsWithFilter.COMMAND_NAME, GetterAllFieldsWithFilter.class);
        registCommand(GetterAllFieldsWithoutFilter.COMMAND_NAME, GetterAllFieldsWithoutFilter.class);
        registCommand(GetterBookData.COMMAND_NAME, GetterBookData.class);
        registCommand(GetterDataTableBook.COMMAND_NAME, GetterDataTableBook.class);
        registCommand(GetterOneFieldWithFilter.COMMAND_NAME, GetterOneFieldWithFilter.class);
        registCommand(GetterDataTableHistory.COMMAND_NAME, GetterDataTableHistory.class);
    }

    public static synchronized CommandManagerGetter getIntance() {
        if (commandManagerGetter == null) {
        	commandManagerGetter = new CommandManagerGetter();
        }
        return commandManagerGetter;
    }

    public Getteable getCommand(String commandName) {
        try{
            return COMMANDS.get(commandName.toUpperCase()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void registCommand(String commandName,
                              Class<? extends Getteable> validate) {
    	COMMANDS.put(commandName.toUpperCase(), validate);
    }
}
