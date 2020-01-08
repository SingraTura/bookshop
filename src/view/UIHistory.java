package view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JTable;

public class UIHistory extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableBook;
	private JScrollPane scrollPaneTable ;
	
	public UIHistory() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		initScrollPane();
	}
	private void initScrollPane() {
		scrollPaneTable = new JScrollPane();
		GridBagConstraints gbc_scrollPaneTable = new GridBagConstraints();
		gbc_scrollPaneTable.gridheight = 11;
		gbc_scrollPaneTable.gridwidth = 20;
		gbc_scrollPaneTable.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTable.gridx = 0;
		gbc_scrollPaneTable.gridy = 0;
		this.tableBook = new JTable();
		this.getScrollPaneTable().setViewportView(tableBook);
		this.contentPane.add(scrollPaneTable, gbc_scrollPaneTable);
	}
	public JPanel getContentPane() {
		return contentPane;
	}
	public JTable getTableBook() {
		return tableBook;
	}
	public JScrollPane getScrollPaneTable() {
		return scrollPaneTable;
	}

	
}
