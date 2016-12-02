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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import caisseProjectView.graphics.JHintPasswordField;
import caisseProjectView.graphics.JHintTextField;

public class CaisseLogView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6116857532030543476L;
	
	private JPanel bloc;
	private JPanel blocEntete;
	private JPanel content;
	private JLabel name;
	
	private JLabel userName;
	private JHintTextField userField = null;
    private JLabel password;
    private JHintPasswordField passwordField = null;
	
	public JButton valide;
	/**
	 * Create the panel.
	 */
	public CaisseLogView() {
		init();
		initializeComponent();
		addComponent();
	}

	private void init() {
		bloc = new JPanel();
		blocEntete = new JPanel();
		name = new JLabel("Trio Grill");
		content = new JPanel();

		this.setLayout(new BorderLayout());
		this.bloc.setLayout(new BorderLayout());
		this.blocEntete.setLayout(new BorderLayout());
		this.content.setLayout(new FlowLayout(FlowLayout.LEADING));
	}

	private void initializeComponent() {
		name.setFont(new Font("Gill Sans MT",Font.BOLD,30));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		
		userName = new JLabel("Utilisateur");
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		userName.setPreferredSize(new Dimension(400,15));
		userName.setForeground(Color.decode("#ffb401"));
		userName.setFont(new Font("Gill Sans MT",Font.BOLD,18));
		
		password = new JLabel("Mot De Passe");
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setPreferredSize(new Dimension(400,15));
		password.setForeground(Color.decode("#ffb401"));
		password.setFont(new Font("Gill Sans MT",Font.BOLD,18));
		
	}

	private void addComponent() {
		blocEntete.add(name, BorderLayout.CENTER);
		
		content.add(userName);
		content.add(getJtextuserField());
		content.add(password);
		content.add(getJtextPassword());
		bloc.add(blocEntete, BorderLayout.NORTH);
		bloc.add(content, BorderLayout.CENTER);
		bloc.add(getButton(),BorderLayout.SOUTH);
		
		this.add(bloc, BorderLayout.CENTER);
	}
	
	private JTextField getJtextuserField() {
		if(userField == null){
			userField = new JHintTextField("nom utilisateur..");
			userField.setPreferredSize(new Dimension(435, 30));
			userField.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return userField;
	}
	
	private JPasswordField getJtextPassword() {
		   if(passwordField == null){
				passwordField = new JHintPasswordField("mot_de_passe..");
				passwordField.setPreferredSize(new Dimension(435, 30));
				passwordField.setHorizontalAlignment(JTextField.CENTER);
			}
		   return passwordField;
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
				
			}
		});
		return valide;
	}

}
