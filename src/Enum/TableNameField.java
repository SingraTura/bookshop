package Enum;

public enum TableNameField {
	tittle(0), isbn(1), author(2), 
	format(3), theme(4), state(5), 
	numPag(6), price(7), amount(8);
	
	private int value;
	
	TableNameField(int value) {
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
}
