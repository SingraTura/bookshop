package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class TableHeadGestor implements TableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
			int column) {
		JComponent jcomponent;
		jcomponent = new JLabel((String) value);
        ((JLabel)jcomponent).setHorizontalAlignment( SwingConstants.CENTER );
        ((JLabel)jcomponent).setSize( 50, jcomponent.getWidth() );   
        ((JLabel)jcomponent).setPreferredSize( new Dimension(6, jcomponent.getWidth())  );
		
        jcomponent.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(0, 0, 0)));
        jcomponent.setOpaque(true);
        jcomponent.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        jcomponent.setBackground( new Color(65,65,65) );
        jcomponent.setForeground(Color.white);
		
		return jcomponent;
	}
	
}
