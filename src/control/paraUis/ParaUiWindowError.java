package control.paraUis;

import java.awt.Font;

import javax.swing.SwingConstants;

import view.WindowError;

public class ParaUiWindowError extends WindowError{
	private static final long serialVersionUID = 1L;
	public ParaUiWindowError(String error) {
		super();
		getLblInfo().setText(error);
		getLblInfo().setHorizontalAlignment(SwingConstants.CENTER);
		getLblInfo().setFont(new Font("Tahoma", Font.BOLD, 11));
	}
}
