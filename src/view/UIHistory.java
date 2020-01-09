package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;

public class UIHistory extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableBook;
	private JScrollPane scrollPaneTable ;
	private ArrayList<JLabel>labels = new ArrayList<JLabel>();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private Editor editor;
	private JDateChooser dateBegin;
	private JDateChooser dateEnd;
	private JButton btnFilter;
	private JButton btnBestSeller;
	
	public UIHistory() {
		this.editor = Editor.instance();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		initScrollPane();
	}
	private void initScrollPane() {
		
		
		contentPane.setLayout(null);
		scrollPaneTable = new JScrollPane();
		scrollPaneTable.setBounds(32, 78, 722, 299);
		this.tableBook = new JTable();
		this.getScrollPaneTable().setViewportView(tableBook);
		this.contentPane.add(scrollPaneTable);

		addLabel();
		addCalendar();
		addButtons();
		
		editComponent();
	}
	private void editComponent() {
		this.editor.editJPane(getContentPane());
		this.editor.editLabel(this.labels);
		this.editor.editButton(this.buttons);
		
	}
	private void addButtons() {
		btnBestSeller = new JButton("Best seller");
		btnBestSeller.setBounds(618, 38, 139, 37);
		contentPane.add(btnBestSeller);
		
		btnFilter = new JButton("Filter");
		btnFilter.setBounds(358, 38, 151, 37);
		contentPane.add(btnFilter);
		
		this.buttons.add(btnBestSeller);
		this.buttons.add(btnFilter);
	}
	private void addCalendar() {
		dateBegin = new JDateChooser();
		dateBegin.setBounds(34, 50, 136, 25);
		contentPane.add(dateBegin);
		Calendar c = Calendar.getInstance();
		
		dateEnd = new JDateChooser(c.getTime());
		dateEnd.setBounds(198, 50, 136, 25);
		contentPane.add(dateEnd);
	}
	private void addLabel() {
		JLabel lblBegin = new JLabel("Begin date");
		lblBegin.setBounds(32, 25, 146, 25);
		contentPane.add(lblBegin);
		
		JLabel lblEnd = new JLabel("End date");
		lblEnd.setBounds(200, 25, 146, 25);
		contentPane.add(lblEnd);
		
		labels.add(lblBegin);
		labels.add(lblEnd);
		
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
	public JDateChooser getDateBegin() {
		return dateBegin;
	}
	public void setDateBegin(JDateChooser dateBegin) {
		this.dateBegin = dateBegin;
	}
	public JDateChooser getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(JDateChooser dateEnd) {
		this.dateEnd = dateEnd;
	}
	public JButton getBtnFilter() {
		return btnFilter;
	}
	public void setBtnFilter(JButton btnFilter) {
		this.btnFilter = btnFilter;
	}
	public JButton getBtnBestSeller() {
		return btnBestSeller;
	}
	public void setBtnBestSeller(JButton btnBestSeller) {
		this.btnBestSeller = btnBestSeller;
	}
	public void setTableBook(JTable tableBook) {
		this.tableBook = tableBook;
	}
	
}
