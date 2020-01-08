package view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JDialog;

public class WindowError extends JDialog {
	private static final long serialVersionUID = 585967369870072525L;
	private JLabel lblInfo;
	public WindowError() {
		setLocationRelativeTo(null);
		setForeground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setModal(true);
		
		JLabel lblError = new JLabel("Error");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblError, BorderLayout.CENTER);
		
		lblInfo = new JLabel("");
		getContentPane().add(lblInfo, BorderLayout.SOUTH);
		this.setMinimumSize(new Dimension(300, 150));
		
	}
	public JLabel getLblInfo() {
		return lblInfo;
	}
	public void setLblInfo(JLabel lblInfo) {
		this.lblInfo = lblInfo;
	}
	
}
