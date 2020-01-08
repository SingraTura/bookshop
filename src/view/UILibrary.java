package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JTextField;


import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.util.ArrayList;

public class UILibrary extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPaneTable;
	private JTable tableBook;
	private JButton btnFilet;
	private Editor editor;
	private JTextField textFilter;
	private JMenuItem menuBook_addNewBook;
	private JMenuItem menuBook_gestorBook;
	protected JMenuItem menuAuthor_addNewAuthor;
	private JMenuItem menuTheme_none;
	private JMenuItem menuTheme_blue;
	private JMenuItem menuTheme_red;
	private JMenuItem menuHelp_aboutLibrary;
	private JMenuBar menuBar;
	private ArrayList<JMenu> jMenus = new ArrayList<JMenu>();
	private ArrayList<JMenuItem> jMenuItems = new ArrayList<JMenuItem>();
	private ArrayList<JButton> jButtons = new ArrayList<JButton>();
	private ArrayList<JTextField> jTextFields = new ArrayList<JTextField>();
	private JButton btnHistory;

	public UILibrary() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		this.editor = Editor.instance();
		this.initComponent();
	}

	private void initComponent() {
		contentPane = new JPanel();

		setContentPane(contentPane);

		this.configureGrid();
		this.initMenuBar();
		this.initButton();
		this.initJTextField();
		this.initScrollPane();
		this.eventTheme();
		this.editComponent();
	}

	private void eventTheme() {
		
		this.menuTheme_none.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				editor.setThemeNone();
				editComponent();
			}
		});
		this.menuTheme_blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				editor.setThemeBlue();
				editComponent();
			}
		});
	}

	private void configureGrid() {
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 52, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
	}

	private void initMenuBar() {
		this.menuBar = new JMenuBar();
		this.menuBar.setOpaque(true);
		this.menuBar.setBackground(Color.black);

		setJMenuBar(menuBar);
		JMenu menuBook = new JMenu("Book");
		
		menuBook.setIcon(this.createIcon("/img/book.png"));
		this.jMenus.add(menuBook);
		JMenu menuAuthor = new JMenu("Author");
		menuAuthor.setIcon(this.createIcon("/img/author.png"));
		this.jMenus.add(menuAuthor);
		JMenu menuThemes = new JMenu("Themes");
		menuThemes.setIcon(this.createIcon("/img/theme.png"));
		this.jMenus.add(menuThemes);
		JMenu menuHelp = new JMenu("Help");
		menuHelp.setIcon(this.createIcon("/img/help.png"));
		this.jMenus.add(menuHelp);

		menuBook_addNewBook = new JMenuItem("Add new book");
		menuBook_addNewBook.setIcon(this.createIcon("/img/addBook.png"));
		this.jMenuItems.add(menuBook_addNewBook);
		menuBook_gestorBook = new JMenuItem("Gestor book");
		menuBook_gestorBook.setIcon(this.createIcon("/img/gestorBook.png"));

		this.jMenuItems.add(menuBook_gestorBook);
		menuBook.add(menuBook_addNewBook);
		menuBook.add(menuBook_gestorBook);
		
		menuAuthor_addNewAuthor= new JMenuItem("Add new author");
		menuAuthor_addNewAuthor.setIcon(this.createIcon("/img/addAuthor.png"));
		this.jMenuItems.add(menuAuthor_addNewAuthor);
		menuAuthor.add(menuAuthor_addNewAuthor);
		
		menuTheme_none = new JMenuItem("None");
		menuTheme_none.setIcon(this.createIcon("/img/themeNone.png"));
		this.jMenuItems.add(menuTheme_none);
		menuTheme_blue = new JMenuItem("Blue");
		menuTheme_blue.setIcon(this.createIcon("/img/themeBlue.png"));
		this.jMenuItems.add(menuTheme_blue);
		menuTheme_red = new JMenuItem("Red");
		menuTheme_red.setIcon(this.createIcon("/img/themeRed.png"));
		this.jMenuItems.add(menuTheme_red);
		
		menuThemes.add(menuTheme_none);
		menuThemes.add(menuTheme_blue);
		menuThemes.add(menuTheme_red);
		
		menuHelp_aboutLibrary = new JMenuItem("About library");
		menuHelp_aboutLibrary.setIcon(this.createIcon("/img/about.png"));
		this.jMenuItems.add(menuHelp_aboutLibrary);
		menuHelp.add(menuHelp_aboutLibrary);

		for (JMenu jMenu : jMenus) {
			menuBar.add(jMenu);
		}

	}
	private ImageIcon createIcon(String path) {
		ImageIcon imgStart = new ImageIcon(getClass().getResource(path));
		Image convert = imgStart.getImage();
		Image size = convert.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon img = new ImageIcon(size);
		return img;
	}
	private void initButton() {
		btnFilet = new JButton("Filter");
		GridBagConstraints gbc_btnFilet = new GridBagConstraints();
		gbc_btnFilet.gridheight = 2;
		gbc_btnFilet.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFilet.insets = new Insets(0, 0, 5, 5);
		gbc_btnFilet.gridx = 4;
		gbc_btnFilet.gridy = 0;
		contentPane.add(btnFilet, gbc_btnFilet);
		this.jButtons.add(btnFilet);
		
		btnHistory = new JButton("Change history ");
		GridBagConstraints gbc_btnHistory = new GridBagConstraints();
		gbc_btnHistory.insets = new Insets(0, 0, 5, 5);
		gbc_btnHistory.gridx = 18;
		gbc_btnHistory.gridy = 0;
		contentPane.add(btnHistory, gbc_btnHistory);
		this.jButtons.add(btnHistory);
	}

	private void initJTextField() {
		textFilter = new JTextField();
		GridBagConstraints gbc_textFilter = new GridBagConstraints();
		gbc_textFilter.gridheight = 2;
		gbc_textFilter.gridwidth = 4;
		gbc_textFilter.insets = new Insets(0, 0, 5, 5);
		gbc_textFilter.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFilter.gridx = 0;
		gbc_textFilter.gridy = 0;
		contentPane.add(textFilter, gbc_textFilter);
		textFilter.setColumns(10);
		this.jTextFields.add(textFilter);
	}

	private void initScrollPane() {
		scrollPaneTable = new JScrollPane();
		GridBagConstraints gbc_scrollPaneTable = new GridBagConstraints();
		gbc_scrollPaneTable.gridheight = 9;
		gbc_scrollPaneTable.gridwidth = 20;
		gbc_scrollPaneTable.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTable.gridx = 0;
		gbc_scrollPaneTable.gridy = 2;
		this.tableBook = new JTable();
		this.getScrollPaneTable().setViewportView(tableBook);
		this.contentPane.add(scrollPaneTable, gbc_scrollPaneTable);
	}

	private void editComponent() {
		this.getEditor().editScrollPaneTable(this.scrollPaneTable);
		this.getEditor().editJPane(contentPane);
		this.getEditor().editJTextField(this.jTextFields);
		this.getEditor().editButton(this.jButtons);
		this.getEditor().editMenu(this.jMenus);
		this.getEditor().editMenuItem(this.jMenuItems);
	}

	public JTextField getTextFilter() {
		return textFilter;
	}

	private Editor getEditor() {
		return this.editor;
	}

	public JScrollPane getScrollPaneTable() {
		return scrollPaneTable;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton getBtnHistory() {
		return btnHistory;
	}


	public JTable getTableBook() {
		return tableBook;
	}

	public JButton getBtnFilet() {
		return btnFilet;
	}

	public JMenuItem getMenuBook_addNewBook() {
		return menuBook_addNewBook;
	}

	public JMenuItem getMenuBook_gestorBook() {
		return menuBook_gestorBook;
	}

}
