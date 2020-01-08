package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

public class UIAddAtribbutte extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> cmbAtribbute;
	private JTextField txtAtribbute;
	private JButton btnAdd;
	private JButton btnRemove;
	private JLabel lblAtribbute;
	private ArrayList<JButton> jButtons = new ArrayList<JButton>();
	private ArrayList<JComboBox<String>> jComboBoxs = new ArrayList<JComboBox<String>>();
	private ArrayList<JTextField> jTextFields = new ArrayList<JTextField>();
	private ArrayList<JLabel> jLabels = new ArrayList<JLabel>();

	public UIAddAtribbutte() {
		 Editor editor;
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAtribbute = new JLabel("Atribbute");
		lblAtribbute.setBounds(103, 13, 122, 33);
		contentPane.add(lblAtribbute);
		this.jLabels.add(lblAtribbute);
		
		cmbAtribbute = new JComboBox<String>();
		cmbAtribbute.setBounds(44, 59, 138, 34);
		contentPane.add(cmbAtribbute);
		this.jComboBoxs.add(cmbAtribbute);
		
		btnRemove = new JButton("Remove");
		btnRemove.setBounds(209, 59, 97, 36);
		contentPane.add(btnRemove);
		this.jButtons.add(btnRemove);
		
		txtAtribbute = new JTextField();
		txtAtribbute.setBounds(39, 106, 138, 32);
		contentPane.add(txtAtribbute);
		txtAtribbute.setColumns(10);
		this.jTextFields.add(txtAtribbute);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(209, 108, 97, 32);
		contentPane.add(btnAdd);
		this.jButtons.add(btnAdd);
		
		editor = Editor.instance();
		
		editor.editJPane(contentPane);
		editor.editButton(jButtons);
		editor.editCombo(jComboBoxs);
		editor.editJTextField(jTextFields);
		editor.editLabel(jLabels);
	}

	public JComboBox<String> getCmbAtribbute() {
		return cmbAtribbute;
	}

	public JTextField getTxtAtribbute() {
		return txtAtribbute;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnRemove() {
		return btnRemove;
	}

	public JLabel getLblAtribbute() {
		return lblAtribbute;
	}

	public ArrayList<JButton> getjButtons() {
		return jButtons;
	}


	
	
}
