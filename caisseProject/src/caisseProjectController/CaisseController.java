package caisseProjectController;

import java.awt.EventQueue;

import javax.swing.JFrame;

import caisseProjectView.CaisseDatabaseInfoView;
import caisseProjectView.CaisseLogView;

public class CaisseController {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CaisseController window = new CaisseController();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CaisseController() {
		initializeInterface();
		if(!initializeDatabase()){
			frame.add(new CaisseDatabaseInfoView());
		}else{
			frame.add(new CaisseLogView());
		}
	}

	private boolean initializeDatabase() {
		return false;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeInterface() {
		frame = new JFrame();
		frame.setTitle("Caisse Enregistreuse");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
