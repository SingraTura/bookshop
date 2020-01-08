package control.controllersParaUiGraphic;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import Enum.Procedure;
import control.paraUis.ParaUiGestorBook;
import events.LoadComboBox;

public class ControllerParaUiGestorBookGraphic {
	private ParaUiGestorBook paraUiGestorBook;
	private String isbn;
	public ControllerParaUiGestorBookGraphic(ParaUiGestorBook paraUiGestorBook, String isbn)
	{
		super();
		this.paraUiGestorBook=paraUiGestorBook;
		this.isbn=isbn;
	}
	public void setEditableFields(boolean eventActivo)
	{
		ArrayList<JTextField> txtField=this.paraUiGestorBook.getTextFieldsPanelOne();
		for (JTextField jTextField : txtField) {
			jTextField.setEditable(eventActivo);
		}
		if(eventActivo)
		this.paraUiGestorBook.getEditor().editJTextFieldEdit(txtField);
		else
		this.paraUiGestorBook.getEditor().editJTextField(txtField);
			
	}
	
	public void loadComboBoxes()
	{
		LoadComboBox loader = new LoadComboBox();
		loader.event(this.paraUiGestorBook.getCmbAuthor(), Procedure.getAllAuthor.getSintax());
		loader.event(this.paraUiGestorBook.getCmbFormat(), Procedure.getAllFormat.getSintax());
		loader.event(this.paraUiGestorBook.getCmbGender(), Procedure.getAllTheme.getSintax());
		loader.event(this.paraUiGestorBook.getCmbState(), Procedure.getAllState.getSintax());
	}
	
	public void loadTexts(HashMap<String, String> dataBook)
	{
		this.paraUiGestorBook.getTxtTittle().setText(dataBook.get("Tittle"));
		this.paraUiGestorBook.getTxtISBN().setText(dataBook.get("ISBN"));
		this.paraUiGestorBook.getTxtAmount().setText(dataBook.get("Amount"));
		this.paraUiGestorBook.getTxtPrice().setText(dataBook.get("Price"));
		this.paraUiGestorBook.getTxtNumPages().setText(dataBook.get("NumberOfPages"));
		this.paraUiGestorBook.getTxtAmount().setText(dataBook.get("Amount"));
		
		this.loadComboBoxes(this.paraUiGestorBook.getCmbAuthor(), dataBook.get("Author"));
		this.loadComboBoxes(this.paraUiGestorBook.getCmbFormat(), dataBook.get("Format"));
		this.loadComboBoxes(this.paraUiGestorBook.getCmbGender(), dataBook.get("Theme"));
		this.loadComboBoxes(this.paraUiGestorBook.getCmbState(), dataBook.get("State"));
	}
	private void loadComboBoxes(JComboBox<String> jComboBox, String data) {
		jComboBox.removeAllItems();
		jComboBox.addItem(data);
	}
	public void clear() {
		this.paraUiGestorBook.getTxtAddAmount().setText("");
	}
	public HashMap<String, String> createMapBook()
	{
		String tittle= this.paraUiGestorBook.getTxtTittle().getText();
		String author= this.paraUiGestorBook.getCmbAuthor().getSelectedItem().toString();
		String gender= this.paraUiGestorBook.getCmbGender().getSelectedItem().toString();
		String numPages= this.paraUiGestorBook.getTxtNumPages().getText();
		String iSBN= this.paraUiGestorBook.getTxtISBN().getText();
		String format= this.paraUiGestorBook.getCmbFormat().getSelectedItem().toString();
		String state= this.paraUiGestorBook.getCmbState().getSelectedItem().toString();
		String price= this.paraUiGestorBook.getTxtPrice().getText();
		HashMap<String, String> bookHashMap = new HashMap<String, String>();

		bookHashMap.put("ISBN", iSBN);
		bookHashMap.put("Tittle", tittle);
		bookHashMap.put("Firstname", author.split(" ")[0]);
		bookHashMap.put("Lastname", author.split(" ")[1]);
		bookHashMap.put("NumPages", numPages);
		bookHashMap.put("Format", format);
		bookHashMap.put("State", state);
		bookHashMap.put("Theme", gender);
		bookHashMap.put("Price", price);
		
		return bookHashMap;
	}
	public String getISBN() {
		return isbn;
	}
	public String getAmount() {
		return this.paraUiGestorBook.getTxtAmount().getText();
	}
	public String getAmountAdd() {
		return this.paraUiGestorBook.getTxtAddAmount().getText();
	}
	public void dispose() {
		this.paraUiGestorBook.dispose();
	}
	
	public JButton getBtnEdit() {
		return this.paraUiGestorBook.getBtnEdit();
	}
}
