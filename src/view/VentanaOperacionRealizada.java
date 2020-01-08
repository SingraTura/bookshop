package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaOperacionRealizada extends JDialog{
	private static final long serialVersionUID = -8805317991805543482L;
	private JLabel lblInfo;
	public VentanaOperacionRealizada() {
		setForeground(Color.WHITE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setModal(true);
		
		JLabel lblRealizada = new JLabel("Operacion realizada correctamente");
		lblRealizada.setIcon(new ImageIcon(VentanaOperacionRealizada.class.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-information.png")));
		lblRealizada.setHorizontalAlignment(SwingConstants.CENTER);
		lblRealizada.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblRealizada, BorderLayout.CENTER);
		
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
