package caisseProjectView;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class CaisseDatabaseInfoView extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public CaisseDatabaseInfoView() {
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);

	}

}
