package control.controllersParaUiGraphic;

import java.util.HashMap;

import control.paraUis.ParaUiAddAuthor;


public class ControllerParaUiAddAutorGraphic {
	private ParaUiAddAuthor paraUiAddAuthor;
	
	public ControllerParaUiAddAutorGraphic(ParaUiAddAuthor paraUiAddAuthor) {
		super();
		this.paraUiAddAuthor=paraUiAddAuthor;
		
	}
	
	public HashMap<String, String> createMapAuthor()
	{
		String name= this.paraUiAddAuthor.getTextName().getText();
		String surname= this.paraUiAddAuthor.getTextSurname().getText();
		String nationality= this.paraUiAddAuthor.getTextNationality().getText();
		String theme= this.paraUiAddAuthor.getCmbGenderAuthor().getSelectedItem().toString();
		HashMap<String, String> authorHashMap = new HashMap<String, String>();
		
		authorHashMap.put("Name",name);
		authorHashMap.put("Surname", surname);
		authorHashMap.put("Nationality", nationality);
		authorHashMap.put("Theme", theme);
		
		return authorHashMap;
	}
	public void clear() {
		this.paraUiAddAuthor.getTextName().setText("");
		this.paraUiAddAuthor.getTextNationality().setText("");
		this.paraUiAddAuthor.getTextSurname().setText("");
	}
}
