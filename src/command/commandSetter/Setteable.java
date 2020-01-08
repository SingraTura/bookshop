package command.commandSetter;

import accessData.SetterDAO;
import command.Commandable;

public interface Setteable extends Commandable{
	SetterDAO setterInstance ();
}
