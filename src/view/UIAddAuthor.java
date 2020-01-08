package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class UIAddAuthor extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCancel;
	private JComboBox<String> cmbGenderAuthor;
	private JButton btnAdd;
	private JTextField textName;
	private JTextField textSurname;
	private JTextField textNationality;
	private int pX,pY;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private Editor editor;
	public UIAddAuthor() {
		setUndecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(398+1124, 100, 335, 534);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		this.editor=Editor.instance();
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 30, 15));
		this.editor.editJPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Name");
		panel.add(lblNewLabel);
		
		textName = new JTextField();
		panel.add(textName);

		textName.setBorder(new MatteBorder(10, 10, 10, 10, new Color(0,0,39)));
		textName.setColumns(10);
		
		label = new JLabel("");
		panel.add(label);
		
		label_1 = new JLabel("");
		panel.add(label_1);
		
		JLabel lblSurname = new JLabel("Surname");
		panel.add(lblSurname);
		
		textSurname = new JTextField();
		textSurname.setBorder(new MatteBorder(10, 10, 10, 10, new Color(0,0,39)));
		textSurname.setColumns(10);
		panel.add(textSurname);
		
		label_2 = new JLabel("");
		panel.add(label_2);
		
		label_3 = new JLabel("");
		panel.add(label_3);
		
		JLabel lblNationality = new JLabel("Nationality");
		panel.add(lblNationality);
		
		textNationality = new JTextField();
		textNationality.setBorder(new MatteBorder(10, 10, 10, 10, new Color(0,0,39)));
		textNationality.setColumns(10);
		panel.add(textNationality);
		
		label_4 = new JLabel("");
		panel.add(label_4);
		
		label_5 = new JLabel("");
		panel.add(label_5);
		
		JLabel lblNewLabel_1 = new JLabel("Gender");
		panel.add(lblNewLabel_1);
		
		cmbGenderAuthor = new JComboBox<String>();
		panel.add(cmbGenderAuthor);
		
		label_6 = new JLabel("");
		panel.add(label_6);
		
		label_7 = new JLabel("");
		panel.add(label_7);
		
		btnCancel = new JButton("Cancel");
		this.editor.editButton(btnCancel);
		panel.add(btnCancel);
		
		btnAdd = new JButton("Add");
		
		this.editor.editButton(btnAdd);
		panel.add(btnAdd);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pX=e.getX();
				pY=e.getY(); 
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				setLocation(getLocation().x+e.getX()-pX,getLocation().y+e.getY()-pY);
			}
		});
		
//		JLabel[] labels={lblSurname,lblNationality,lblNewLabel, lblNewLabel_1};
//		this.editor.editLabel(labels);
//		
//		JTextField[] jTextFields= {textName,textNationality,textSurname};
//		this.editor.editJTextField(jTextFields);
//		
//		JButton[] buttons= {btnAdd,btnCancel};
//		this.editor.editButton(buttons);
//	
//		JComboBox[] combos= {cmbGenderAuthor};
//		this.editor.editCombo(combos);
	}

	protected JButton getBtnCancel() {
		return btnCancel;
	}

	public JComboBox<String> getCmbGenderAuthor() {
		return cmbGenderAuthor;
	}

	

	public JTextField getTextName() {
		return textName;
	}

	public JTextField getTextSurname() {
		return textSurname;
	}

	public JTextField getTextNationality() {
		return textNationality;
	}

	protected JButton getBtnAdd() {
		return btnAdd;
	}
	
}
