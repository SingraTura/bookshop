package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Editor {
	private Font font;
	private Font fontItemMenu;
	private Color colorWhite;
	private Color colorBlack;
	private Color colorDarkGray;
	private Color colorLigthGray;
	private static Editor editor;

	public static Editor instance() {
		if (editor == null)
			editor = new Editor();
		return editor;
	}

	private Editor() {
		this.font = new Font("Comic Sans MS", Font.BOLD, 20);
		this.fontItemMenu = new Font("Comic Sans MS", Font.BOLD, 15);
		this.colorWhite = new Color(255, 255, 255);
		this.colorBlack = new Color(0, 0, 0);
		this.colorDarkGray = Color.DARK_GRAY;
		this.colorLigthGray = Color.LIGHT_GRAY;
	}

	void editButton(JButton button) {
		button.setForeground(this.colorBlack);
		button.setFont(this.font);
		button.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		button.setBackground(this.colorWhite);
	}

	public void editMenu(JMenu menu) {
		menu.setFont(this.font);
		menu.setOpaque(true);
		menu.setForeground(this.colorWhite);
		menu.setBackground(this.colorBlack);
		menu.setMargin(new Insets(0, 20, 0, 20));
	}

	private void editLabel(JLabel label) {
		label.setFont(this.font);
	}

	private void editJTextField(JTextField jTextField) {
		jTextField.setHorizontalAlignment(SwingConstants.CENTER);
		jTextField.setForeground(this.colorWhite);
		jTextField.setFont(this.font);
		jTextField.setBackground(this.colorDarkGray);
	}

	private void editJTextFieldEdit(JTextField jTextField) {
		jTextField.setHorizontalAlignment(SwingConstants.CENTER);
		jTextField.setForeground(this.colorDarkGray);
		jTextField.setFont(this.font);
		jTextField.setBackground(this.colorWhite);
	}

	public void editJPane(JPanel panel) {
		panel.setBackground(this.colorLigthGray);
		panel.setBorder(new LineBorder(this.colorDarkGray, 20, false));
	}

	public void editCombo(JComboBox<String> combo) {
		combo.setForeground(this.colorWhite);
		combo.setFont(this.font);
		combo.setBackground(this.colorDarkGray);
	}

	public void editMenuItem(JMenuItem menu) {
		menu.setFont(this.fontItemMenu);
	}

	public void editMenuItem(ArrayList<JMenuItem> menuItem) {
		for (JMenuItem jMenuItem : menuItem) {
			this.editMenuItem(jMenuItem);
		}
	}

	public void editMenu(ArrayList<JMenu> jMenus) {
		for (JMenu jMenu : jMenus) {
			this.editMenu(jMenu);
		}
	}

	public void editCombo(ArrayList<JComboBox<String>> combos) {
		for (JComboBox<String> jComboBox : combos) {
			this.editCombo(jComboBox);
		}
	}

	public void editButton(ArrayList<JButton> buttons) {
		for (JButton jButton : buttons) {
			this.editButton(jButton);
		}
	}

	public void editLabel(ArrayList<JLabel> jLabels) {
		for (JLabel jLabel : jLabels) {
			this.editLabel(jLabel);
		}
	}

	public void editJTextFieldEdit(ArrayList<JTextField> jTextFields) {
		for (JTextField jTextField : jTextFields) {
			this.editJTextFieldEdit(jTextField);
		}
	}

	public void editJTextField(ArrayList<JTextField> jTextFields) {
		for (JTextField jTextField : jTextFields) {
			this.editJTextField(jTextField);
		}
	}

	public void setFont(String font) {
		this.font = new Font("Roboto", Font.BOLD, 20);
	}

	public void editScrollPaneTable(JScrollPane scrollPaneTable) {

		scrollPaneTable.setBorder(new LineBorder(this.colorBlack, 7));
	}

	public void setThemeNone() {
		this.font = new Font("Comic Sans MS", Font.BOLD, 20);
		this.fontItemMenu = new Font("Comic Sans MS", Font.BOLD, 15);
		this.colorWhite = new Color(255, 255, 255);
		this.colorBlack = new Color(0, 0, 0);
		this.colorDarkGray = Color.DARK_GRAY;
		this.colorLigthGray = Color.LIGHT_GRAY;
	}
	public void setThemeBlue() {
		this.font = new Font("Comic Sans MS", Font.BOLD, 20);
		this.fontItemMenu = new Font("Comic Sans MS", Font.BOLD, 15);
		this.colorWhite = new Color(0, 255, 255);
		this.colorBlack = new Color(0, 0, 255);
		this.colorDarkGray = new Color(0, 76, 153);
		this.colorLigthGray = new Color(0, 102, 204);
	}
	public void setThemeRed() {
		this.font = new Font("Comic Sans MS", Font.BOLD, 20);
		this.fontItemMenu = new Font("Comic Sans MS", Font.BOLD, 15);
		this.colorWhite = new Color(255, 255, 255);
		this.colorBlack = new Color(0, 0, 0);
		this.colorDarkGray = Color.DARK_GRAY;
		this.colorLigthGray = Color.LIGHT_GRAY;
	}
}
