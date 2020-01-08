package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class GestionCeldas extends DefaultTableCellRenderer{
	private Font font;
	private Color colorWhite;
	private Color colorBlack;
	public GestionCeldas() {
		this.font = new Font("Comic Sans MS", Font.BOLD, 10);
		this.colorWhite = new Color(255, 255, 255);
		this.colorBlack = new Color(0, 0, 0);
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {

        
        this.setVisible(true);
		this.setFont(this.font);
		this.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		this.setBackground(Color.BLUE);
		this.setForeground(this.colorBlack);
       
		return this;
	}
}