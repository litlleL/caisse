package caisseProjectController;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import caisseProjectView.CaisseDatabaseInfoView;
import caisseProjectView.CaisseLogView;

public class CaisseController {

	private JFrame frame;
	private boolean databaseInitialized = false;
	private InputStream input = null;
	private CaisseDatabaseAccessController connection = null;
	private Properties propriete;
	
	private String username;
	private String pass;
	private String server;
	private String databaseName;
	
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
		init();
	}
	
	public void init() {
		initializeInterface();
		if(!initializeDatabase()){
			frame.setBounds(100, 100, 460, 400);
			frame.setResizable(false);
			frame.add(new CaisseDatabaseInfoView());
		}else{
			frame.setBounds(100, 100, 1600, 900);
			frame.setResizable(false);
			frame.add(new CaisseLogView());
		}
	}

	private boolean initializeDatabase() {
		databaseInitialized = true;
		
		try {

			Properties propriete = load("res/config.db");
			username = propriete.getProperty("username","vide");
			pass = propriete.getProperty("password","vide");
			databaseName = propriete.getProperty("databaseName","vide");
			server = propriete.getProperty("server","vide");
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Impossible de retrouver le fichier de config \n Veuillez vérifier si il existe.", "database access error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			databaseInitialized = false;
		}
		
		setConnection(new CaisseDatabaseAccessController(username, pass, server, databaseName));
		return databaseInitialized;
	}
	
	private void setConnection(CaisseDatabaseAccessController connection) {
			this.connection = connection;
	}

	public static Properties load(String filename) throws IOException, FileNotFoundException{
		Properties properties = new Properties();
		
		FileInputStream input = new FileInputStream(filename);
		System.out.println(filename);
		try{
			properties.load(input);
			return properties;
		}finally{
			input.close();
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeInterface() {
		frame = new JFrame();
		frame.setTitle("Caisse Enregistreuse");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
