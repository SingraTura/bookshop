package command.commandGetter;

import accessData.GetterDAO;
import command.Commandable;

public interface Getteable extends Commandable{
	GetterDAO getterInstance();
	Object translate(String data);
}
