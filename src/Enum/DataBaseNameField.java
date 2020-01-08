package Enum;

public enum DataBaseNameField {
	tittle(1), isbn(0), author(2), 
	format(5), theme(3), state(6), 
	numPag(4), price(7), amount(8);
	
	private int value;
	
	DataBaseNameField(int value) {
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
}
