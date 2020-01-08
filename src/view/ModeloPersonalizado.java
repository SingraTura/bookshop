package view;

import javax.swing.table.DefaultTableModel;

public class ModeloPersonalizado extends DefaultTableModel{
	String[] titulos;
	Object[][] datos;
	
	/**
	 * Determina el modelo con el que se va a construir la tabla
	 * @param datos
	 * @param titulos
	 */
	public ModeloPersonalizado(Object[][] datos, String[] titulos) {
		super();
		this.titulos=titulos;
		this.datos=datos;
		setDataVector(datos, titulos);
	}
	
}
