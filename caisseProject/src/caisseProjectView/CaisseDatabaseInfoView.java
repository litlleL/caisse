package caisseProjectView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import caisseProjectView.graphics.JHintPasswordField;
import caisseProjectView.graphics.JHintTextField;

public class CaisseDatabaseInfoView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3308377377793410300L;
	
	private JPanel bloc;
	private JPanel blocEntete;
	private JPanel acces;
	private JLabel titreParametre;
    private JHintTextField username = null;
    private JHintTextField server = null;
    private JHintTextField databaseName = null;
    private JHintPasswordField password = null;
    
    public JButton valide;
    
    private JLabel userName;
    private JLabel passwordLab;
    private JLabel serverName;
    private JLabel database;
    
    private Properties propriete = new Properties();
    OutputStream output = null;
    
	/**
	 * Create the panel.
	 */
	public CaisseDatabaseInfoView() {
		init();
		initializeComponent();
		addComponent();
	}

	private void init() {
		bloc = new JPanel();
		blocEntete = new JPanel();
		titreParametre = new JLabel("Paramètres accès BDD");
		acces = new JPanel();
		
		this.setLayout(new BorderLayout());
		this.bloc.setLayout(new BorderLayout());
		this.blocEntete.setLayout(new BorderLayout());
		this.acces.setLayout(new FlowLayout(FlowLayout.LEADING));
	}

	private void initializeComponent() {
		titreParametre.setFont(new Font("Gill Sans MT",Font.BOLD,30));
		titreParametre.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		userName = new JLabel("Nom d'utilisateur:");
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		userName.setPreferredSize(new Dimension(400,15));
		userName.setForeground(Color.decode("#ffb401"));
		userName.setFont(new Font("Gill Sans MT",Font.BOLD,18));
		
		passwordLab = new JLabel("Mot de Passe:");
		passwordLab.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLab.setPreferredSize(new Dimension(400,15));
		passwordLab.setForeground(Color.decode("#ffb401"));
		passwordLab.setFont(new Font("Gill Sans MT",Font.BOLD,18));
		
		serverName = new JLabel("Serveur:");
		serverName.setHorizontalAlignment(SwingConstants.CENTER);
		serverName.setPreferredSize(new Dimension(400,15));
		serverName.setForeground(Color.decode("#66a8da"));
		serverName.setFont(new Font("Gill Sans MT",Font.BOLD,18));
		
		database = new JLabel("Nom de la base :");
		database.setHorizontalAlignment(SwingConstants.CENTER);
		database.setForeground(Color.decode("#66a8da"));
		database.setPreferredSize(new Dimension(400,15));
		database.setFont(new Font("Gill Sans MT",Font.BOLD,18));
	}
	
	private void addComponent() {
		acces.add(userName);
		acces.add(getJtextUserName());
		acces.add(passwordLab);
		acces.add(getJtextPassword());
		acces.add(serverName);
		acces.add(getJtextServer());
		acces.add(database);
		acces.add(getJtextDatabase());
		
		blocEntete.add(titreParametre,BorderLayout.CENTER);
		
		bloc.add(blocEntete, BorderLayout.NORTH);
		bloc.add(acces,BorderLayout.CENTER);
		bloc.add(getButton(),BorderLayout.SOUTH);
		
		this.add(bloc,BorderLayout.CENTER);
	}
	
	private JTextField getJtextDatabase() {
		if(databaseName == null){
			databaseName = new JHintTextField("nom_base..");
			databaseName.setPreferredSize(new Dimension(435, 30));
			databaseName.setHorizontalAlignment(JTextField.CENTER);
		}
		return databaseName;
	}
	
	private JTextField getJtextServer() {
		if(server == null){
			server = new JHintTextField("mysql.serveur.com ou localhost");
			server.setPreferredSize(new Dimension(435, 30));
			server.setHorizontalAlignment(JTextField.CENTER);
		}
		return server;
	}
	
	private JPasswordField getJtextPassword() {
		   if(password == null){
				password = new JHintPasswordField("mot_de_passe..");
				password.setPreferredSize(new Dimension(435, 30));
				password.setHorizontalAlignment(JTextField.CENTER);
			}
		   return password;
	}
	
	private JTextField getJtextUserName() {
			if(username == null){
				username = new JHintTextField("nom_utilisateur..");
				username.setPreferredSize(new Dimension(435, 30));
				username.setHorizontalAlignment(SwingConstants.CENTER);
			}
			return username;
	}
	
	private JButton getButton() {
		if(valide == null){
			valide = new JButton();
			valide.setFont(new Font("Gill Sans MT", Font.BOLD,40));
			valide.setForeground(Color.WHITE);
			valide.setBackground(Color.BLACK);
			valide.setPreferredSize(new Dimension(0,50));
			valide.setBorder(null);
			valide.setText("Valider");
			valide.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
				}
			});
		}
		valide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
						setBackground(Color.WHITE);
						System.out.println("[Log-DATABASE_INFO]: Informations saisies");
						
						System.out.println("Nom d'utilisateur: "+username.getText());
						System.out.println("Mot de passe: "+String.valueOf(password.getPassword()));
						System.out.println("Serveur: "+server.getText());
						System.out.println("Nom de la base: "+databaseName.getText());
						
						if(!username.isEmpty()&&!String.valueOf(password.getPassword()).isEmpty()&&!server.isEmpty()&&!databaseName.isEmpty()){
							try {
								output = new FileOutputStream("res/config.db");
								propriete.setProperty("username", username.getText());
								propriete.setProperty("password", String.valueOf(password.getPassword()));
								propriete.setProperty("server", server.getText());
								propriete.setProperty("databaseName",databaseName.getText());
								try {
									propriete.store(output, null);
								} catch (IOException e1) {
									e1.printStackTrace();
								}finally {
									if(output != null){
										try {
											output.close();
										} catch (IOException e1) {
											e1.printStackTrace();
										}
									}
								}
								System.out.println("[Log-DATABASE_INFO]: Le fichier \"res/config.db\" a été généré.");
								valide.setForeground(Color.decode("#70db70"));
								valide.setBackground(Color.WHITE);
								valide.setText("Correct");
								//-- restart appli ou 
							} catch (FileNotFoundException e1) {
								System.err.println("[Log-DATABASE_INFO]: Le fichier \"res/config.db\" n'a pas pu être généré.");
								e1.printStackTrace();
							}
						}
						else{
							 JOptionPane optionPane = new JOptionPane("Il y a des informations manquantes",JOptionPane.ERROR_MESSAGE);
							 JDialog dialog = optionPane.createDialog("Attention");
							 dialog.setVisible(true);
						}
			}
		});
		return valide;
	}
}
