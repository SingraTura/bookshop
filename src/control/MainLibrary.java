package control;

import java.awt.EventQueue;

import javax.swing.UIManager;

import control.paraUis.ParaUiMain;


public class MainLibrary {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					ParaUiMain frame = new ParaUiMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
