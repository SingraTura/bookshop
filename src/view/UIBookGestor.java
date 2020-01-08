package view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class UIBookGestor extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAddAmount;
	private JTextField txtTittle;
	private JTextField txtISBN;
	private JTextField txtAmount;
	private JButton btnAdd;
	private JButton btnDelete;
	private Editor editor;
	private JComboBox<String> cmbState;
	private JComboBox<String> cmbFormat;
	private JComboBox<String> cmbGender;
	private JComboBox<String> cmbAuthor;
	private JTextField txtNumPages;
	private JTextField txtPrice;
	private JButton btnEdit;
	private JLabel lblTitulo;
	private JLabel lblIsbn;
	private JLabel lblAmount;
	private JLabel lblAuthor;
	private JLabel lblGender;
	private JLabel lblState;
	private JLabel lblFormat;
	private JLabel lblNpag;
	private JLabel lblPrice;
	private ArrayList<JLabel>labels = new ArrayList<JLabel>();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private ArrayList<JTextField> textFieldsPanelOne = new ArrayList<JTextField>();
	private ArrayList<JTextField> textFieldsPanelTwo = new ArrayList<JTextField>();
	private ArrayList<JComboBox<String>> combos = new ArrayList<JComboBox<String>>();
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	
	public UIBookGestor() {
		super();
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 662, 767);
		this.editor = Editor.instance();
		this.initComponent();

	}

	private void initComponent() {
		this.initPanel();
		this.initButton();
		this.initJTextField();
		this.initLabel();
		this.initCombos();
		this.editComponent();
	}

	private void editComponent() {
		this.editor.editJPane(contentPane);
		this.editor.editButton(this.buttons);
		this.editor.editJTextField(this.textFieldsPanelOne);
		this.editor.editJTextField(this.textFieldsPanelTwo);
		for (JTextField text : this.textFieldsPanelOne) {
			text.setEditable(false);
		}
		this.txtAmount.setEditable(false);
		this.txtISBN.setEditable(false);
		this.editor.editCombo(this.combos);
		this.editor.editLabel(this.labels);
	}

	private void initPanel() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow][][][][]", "[][grow][][][][][grow]"));
		
		panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		contentPane.add(panel, "cell 2 0 3 6,grow");
		panel.setLayout(new MigLayout("", "[][][][][][][][grow][][][][][][]", "[][][][][][][][][][][][][][][]"));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(169, 169, 169));
		contentPane.add(panel_1, "cell 2 6 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow]", "[][][][grow]"));

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 248, 255));
		panel_1.add(panel_2, "cell 0 1 2 3,grow");
		panel_2.setLayout(new MigLayout("", "[][][grow][][]", "[][][][][]"));
	}

	private void initCombos() {
		cmbAuthor = new JComboBox<String>();
		panel.add(cmbAuthor, "cell 4 5 9 1,growx");
		cmbGender = new JComboBox<String>();
		panel.add(cmbGender, "cell 4 7 9 1,growx");
		cmbState = new JComboBox<String>();
		panel.add(cmbState, "cell 4 9 9 1,growx");
		cmbFormat = new JComboBox<String>();
		panel.add(cmbFormat, "cell 4 11 9 1,growx");
		this.combos.add(cmbAuthor);
		this.combos.add(cmbGender);
		this.combos.add(cmbState);
		this.combos.add(cmbFormat);
	}

	private void initLabel() {
		lblTitulo = new JLabel("Titulo");
		panel.add(lblTitulo, "cell 0 0");

		lblIsbn = new JLabel("ISBN");
		panel.add(lblIsbn, "cell 0 2");

		lblAuthor = new JLabel("Author");
		panel.add(lblAuthor, "cell 0 5");

		lblGender = new JLabel("Gender");
		panel.add(lblGender, "cell 0 7");

		lblState = new JLabel("State");
		panel.add(lblState, "cell 0 9");

		lblFormat = new JLabel("Format");
		panel.add(lblFormat, "cell 0 11");

		lblNpag = new JLabel("N\u00BAPag");
		panel.add(lblNpag, "cell 0 13");

		lblPrice = new JLabel("Price");
		panel.add(lblPrice, "cell 0 14");
		
		this.labels.add(lblTitulo);
		this.labels.add(lblIsbn);
		this.labels.add(lblAuthor);
		this.labels.add(lblGender);
		this.labels.add(lblState);
		this.labels.add(lblFormat);
		this.labels.add(lblNpag);
		this.labels.add(lblPrice);
		

	}

	private void initJTextField() {
		txtTittle = new JTextField();
		panel.add(txtTittle, "cell 2 0 12 1,growx");
		txtTittle.setColumns(10);

		txtISBN = new JTextField();
		txtISBN.setColumns(10);
		panel.add(txtISBN, "cell 2 2 11 1,growx");

		txtNumPages = new JTextField();
		txtNumPages.setColumns(10);
		this.onlyNumber(txtNumPages);
		panel.add(txtNumPages, "cell 7 13 3 1,growx");

		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		panel.add(txtPrice, "cell 7 14 3 1,growx");
		this.onlyNumber(txtPrice);
				
						lblAmount = new JLabel("Amount");
						panel_2.add(lblAmount, "cell 2 1");
						this.labels.add(lblAmount);
		
				txtAmount = new JTextField();
				panel_2.add(txtAmount, "cell 3 1");
				txtAmount.setColumns(10);
				this.textFieldsPanelTwo.add(txtAmount);
		
		btnDelete = new JButton("Delete");
		panel_2.add(btnDelete, "cell 4 1");
		this.buttons.add(btnDelete);

		txtAddAmount = new JTextField();
		panel_2.add(txtAddAmount, "cell 0 3 5 2,growx");
		txtAddAmount.setColumns(10);
		this.onlyNumber(txtAddAmount);
		
		this.textFieldsPanelOne.add(txtTittle);
		this.textFieldsPanelOne.add(txtNumPages);
		this.textFieldsPanelOne.add(txtPrice);
		this.textFieldsPanelTwo.add(txtAddAmount);
		this.textFieldsPanelTwo.add(txtISBN);
		
		
	}

	private void initButton() {

		btnAdd = new JButton("Add");
		panel_2.add(btnAdd, "cell 0 1,growx");
		
		btnEdit = new JButton("Edit");
		panel.add(btnEdit, "cell 12 14");
		this.buttons.add(btnAdd);
		this.buttons.add(btnEdit);

	}

	public void onlyNumber(Component component) {
		component.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if ((e.getKeyChar() < '0' || e.getKeyChar() > '9')) {
					e.consume();
				}
			}
		});
	}


	public ArrayList<JTextField> getTextFieldsPanelOne() {
		return textFieldsPanelOne;
	}

	public ArrayList<JComboBox<String>> getCombos() {
		return combos;
	}

	public JComboBox<String> getCmbState() {
		return cmbState;
	}

	public JComboBox<String> getCmbFormat() {
		return cmbFormat;
	}

	public JComboBox<String> getCmbGender() {
		return cmbGender;
	}

	public JComboBox<String> getCmbAuthor() {
		return cmbAuthor;
	}

	public JTextField getTxtNumPages() {
		return txtNumPages;
	}

	public JTextField getTxtPrice() {
		return txtPrice;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTxtAddAmount() {
		return txtAddAmount;
	}


	public JTextField getTxtTittle() {
		return txtTittle;
	}

	public JTextField getTxtISBN() {
		return txtISBN;
	}

	public JTextField getTxtAmount() {
		return txtAmount;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public Editor getEditor() {
		return editor;
	}

}
