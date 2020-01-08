package view;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;

public class UILibraryAddBook extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textISBN;
	private JTextField textTittle;
	private JTextField textPrice;
	private JButton btnAddBook;
	private JComboBox<String> cmbAuthor;
	private JButton btnAddAuthor;
	private JComboBox<String> cmbGender;
	private JComboBox<String> cmbFormat;
	private JComboBox<String> cmbState;
	private JTextField textNumPag;
	private ArrayList<JButton> jButtons = new ArrayList<JButton>();
	private ArrayList<JComboBox<String>> jComboBoxs = new ArrayList<JComboBox<String>>();
	private ArrayList<JTextField> jTextFields = new ArrayList<JTextField>();
	private ArrayList<JLabel> jLabels = new ArrayList<JLabel>();
	
	
	private Editor editor;
	private JButton btnClose;
	private JButton btnAddFormat;
	private JButton btnAddState;
	private JButton btnAddTheme;
	public UILibraryAddBook() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 572, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		this.editor=Editor.instance();
		this.editor.editJPane(contentPane);
		
		this.initComponent();
		
	}
	private void initComponent() {
		this.initCmb();
		this.initLabel();
		this.initJField();
		this.initBtn();
		
	}
	private void initBtn() {
		btnAddAuthor = new JButton("New Author");
		GridBagConstraints gbc_btnAddAuthor = new GridBagConstraints();
		gbc_btnAddAuthor.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddAuthor.gridx = 7;
		gbc_btnAddAuthor.gridy = 7;
		contentPane.add(btnAddAuthor, gbc_btnAddAuthor);
		this.jButtons.add(btnAddAuthor);
		
		btnAddState = new JButton("+");
		GridBagConstraints gbc_btnAddState = new GridBagConstraints();
		gbc_btnAddState.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddState.gridx = 8;
		gbc_btnAddState.gridy = 12;
		contentPane.add(btnAddState, gbc_btnAddState);
		this.jButtons.add(btnAddState);
		
		btnClose = new JButton("Cancel");
		GridBagConstraints gbc_btnClose = new GridBagConstraints();
		gbc_btnClose.insets = new Insets(0, 0, 0, 5);
		gbc_btnClose.gridx = 1;
		gbc_btnClose.gridy = 18;
		contentPane.add(btnClose, gbc_btnClose);
		this.jButtons.add(btnClose);
		
		btnAddTheme = new JButton("+");
		GridBagConstraints gbc_btnAddTheme = new GridBagConstraints();
		gbc_btnAddTheme.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddTheme.gridx = 8;
		gbc_btnAddTheme.gridy = 10;
		contentPane.add(btnAddTheme, gbc_btnAddTheme);
		this.jButtons.add(btnAddTheme);
		
		btnAddFormat = new JButton("+");
		GridBagConstraints gbc_btnAddFormat = new GridBagConstraints();
		gbc_btnAddFormat.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddFormat.gridx = 8;
		gbc_btnAddFormat.gridy = 11;
		contentPane.add(btnAddFormat, gbc_btnAddFormat);
		this.jButtons.add(btnAddFormat);
		
		btnAddBook = new JButton("AddBook");
		GridBagConstraints gbc_btnAddBook = new GridBagConstraints();
		gbc_btnAddBook.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddBook.gridx = 7;
		gbc_btnAddBook.gridy = 18;
		contentPane.add(btnAddBook, gbc_btnAddBook);
		this.jButtons.add(btnAddBook);


		this.getEditor().editButton(this.jButtons);
	}
	private void initJField() {
		textISBN = new JTextField();
		GridBagConstraints gbc_textISBN = new GridBagConstraints();
		gbc_textISBN.insets = new Insets(0, 0, 5, 5);
		gbc_textISBN.fill = GridBagConstraints.HORIZONTAL;
		gbc_textISBN.gridx = 7;
		gbc_textISBN.gridy = 1;
		contentPane.add(textISBN, gbc_textISBN);
		textISBN.setColumns(10);
		this.onlyNumber(textISBN);
		
		textTittle = new JTextField();
		GridBagConstraints gbc_textTittle = new GridBagConstraints();
		gbc_textTittle.insets = new Insets(0, 0, 5, 5);
		gbc_textTittle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTittle.gridx = 7;
		gbc_textTittle.gridy = 2;
		contentPane.add(textTittle, gbc_textTittle);
		textTittle.setColumns(10);
		
		textPrice = new JTextField();
		GridBagConstraints gbc_textPrice = new GridBagConstraints();
		gbc_textPrice.insets = new Insets(0, 0, 5, 5);
		gbc_textPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPrice.gridx = 7;
		gbc_textPrice.gridy = 3;
		contentPane.add(textPrice, gbc_textPrice);
		textPrice.setColumns(10);
		this.onlyNumber(textPrice);
		
		textNumPag = new JTextField();
		GridBagConstraints gbc_textNumPag = new GridBagConstraints();
		gbc_textNumPag.insets = new Insets(0, 0, 5, 5);
		gbc_textNumPag.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNumPag.gridx = 7;
		gbc_textNumPag.gridy = 4;
		contentPane.add(textNumPag, gbc_textNumPag);
		
		textNumPag.setColumns(10);
		this.onlyNumber(textNumPag);
		
		this.jTextFields.add(textISBN);
		this.jTextFields.add(textNumPag);
		this.jTextFields.add(textPrice);
		this.jTextFields.add(textTittle);
		
		this.editor.editJTextField(jTextFields);
	}
	private void initLabel() {
		JLabel lblTittle = new JLabel("Tittle:");
		GridBagConstraints gbc_lblTittle = new GridBagConstraints();
		gbc_lblTittle.gridwidth = 4;
		gbc_lblTittle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTittle.gridx = 1;
		gbc_lblTittle.gridy = 2;
		contentPane.add(lblTittle, gbc_lblTittle);
		
		JLabel lblGender = new JLabel("Gender:");
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.gridwidth = 3;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 2;
		gbc_lblGender.gridy = 10;
		contentPane.add(lblGender, gbc_lblGender);
		
		JLabel lblPrice = new JLabel("Price:");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.gridwidth = 4;
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 1;
		gbc_lblPrice.gridy = 3;
		contentPane.add(lblPrice, gbc_lblPrice);
		
		JLabel lblIsbn = new JLabel("ISBN:");
		GridBagConstraints gbc_lblIsbn = new GridBagConstraints();
		gbc_lblIsbn.gridwidth = 4;
		gbc_lblIsbn.insets = new Insets(0, 0, 5, 5);
		gbc_lblIsbn.gridx = 1;
		gbc_lblIsbn.gridy = 1;
		contentPane.add(lblIsbn, gbc_lblIsbn);
		
		JLabel lblAutor = new JLabel("Autor:");
		GridBagConstraints gbc_lblAutor = new GridBagConstraints();
		gbc_lblAutor.gridwidth = 2;
		gbc_lblAutor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAutor.gridx = 0;
		gbc_lblAutor.gridy = 6;
		contentPane.add(lblAutor, gbc_lblAutor);
		
		JLabel lblNpages = new JLabel("N\u00BAPages");
		GridBagConstraints gbc_lblNpages = new GridBagConstraints();
		gbc_lblNpages.gridwidth = 4;
		gbc_lblNpages.insets = new Insets(0, 0, 5, 5);
		gbc_lblNpages.gridx = 1;
		gbc_lblNpages.gridy = 4;
		contentPane.add(lblNpages, gbc_lblNpages);
		
		JLabel lblFormat = new JLabel("Format:");
		GridBagConstraints gbc_lblFormat = new GridBagConstraints();
		gbc_lblFormat.gridwidth = 3;
		gbc_lblFormat.insets = new Insets(0, 0, 5, 5);
		gbc_lblFormat.gridx = 2;
		gbc_lblFormat.gridy = 11;
		contentPane.add(lblFormat, gbc_lblFormat);
		
		JLabel lblState = new JLabel("State:");
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.gridwidth = 3;
		gbc_lblState.insets = new Insets(0, 0, 5, 5);
		gbc_lblState.gridx = 2;
		gbc_lblState.gridy = 12;
		contentPane.add(lblState, gbc_lblState);
		
		JLabel[] labels = {lblTittle, lblGender, lblPrice, lblIsbn,
				lblAutor,lblNpages,lblFormat,lblState};
		for (JLabel jLabel : labels) {
			this.jLabels.add(jLabel);
		}
		this.editor.editLabel(jLabels);
	}
	private void initCmb() {
		cmbAuthor = new JComboBox<String>();
		GridBagConstraints gbc_cmbAuthor = new GridBagConstraints();
		gbc_cmbAuthor.gridwidth = 6;
		gbc_cmbAuthor.insets = new Insets(0, 0, 5, 5);
		gbc_cmbAuthor.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbAuthor.gridx = 1;
		gbc_cmbAuthor.gridy = 7;
		contentPane.add(cmbAuthor, gbc_cmbAuthor);
		
		
		cmbState = new JComboBox<String>();
		GridBagConstraints gbc_cmbState = new GridBagConstraints();
		gbc_cmbState.insets = new Insets(0, 0, 5, 5);
		gbc_cmbState.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbState.gridx = 7;
		gbc_cmbState.gridy = 12;
		contentPane.add(cmbState, gbc_cmbState);
		
		cmbFormat = new JComboBox<String>();
		GridBagConstraints gbc_cmbFormat = new GridBagConstraints();
		gbc_cmbFormat.insets = new Insets(0, 0, 5, 5);
		gbc_cmbFormat.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbFormat.gridx = 7;
		gbc_cmbFormat.gridy = 11;
		contentPane.add(cmbFormat, gbc_cmbFormat);

		cmbGender = new JComboBox<String>();
		GridBagConstraints gbc_cmbGender = new GridBagConstraints();
		gbc_cmbGender.insets = new Insets(0, 0, 5, 5);
		gbc_cmbGender.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbGender.gridx = 7;
		gbc_cmbGender.gridy = 10;
		contentPane.add(cmbGender, gbc_cmbGender);
		
		this.jComboBoxs.add(cmbAuthor);
		this.jComboBoxs.add(cmbState);
		this.jComboBoxs.add(cmbFormat);
		this.jComboBoxs.add(cmbGender);
		
		this.editor.editCombo(this.jComboBoxs);
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
	public JPanel getContentPane() {
		return contentPane;
	}
	public JTextField getTextISBN() {
		return textISBN;
	}
	public JTextField getTextTittle() {
		return textTittle;
	}
	public JTextField getTextPrice() {
		return textPrice;
	}
	public JButton getBtnAddBook() {
		return btnAddBook;
	}
	public JComboBox<String> getCmbAuthor() {
		return cmbAuthor;
	}
	public JButton getBtnAddAuthor() {
		return btnAddAuthor;
	}
	public JComboBox<String> getCmbGender() {
		return cmbGender;
	}
	public JComboBox<String> getCmbFormat() {
		return cmbFormat;
	}
	public JComboBox<String> getCmbState() {
		return cmbState;
	}
	public JTextField getTextNumPag() {
		return textNumPag;
	}
	public Editor getEditor() {
		return editor;
	}
	public JButton getBtnClose() {
		return btnClose;
	}
	public JButton getBtnAddFormat() {
		return btnAddFormat;
	}
	public JButton getBtnAddState() {
		return btnAddState;
	}
	public JButton getBtnAddTheme() {
		return btnAddTheme;
	}
	

}
