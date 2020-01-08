package command;

import java.util.HashMap;

public interface Commandable {
	Object execute (HashMap<String, String> order);
}
