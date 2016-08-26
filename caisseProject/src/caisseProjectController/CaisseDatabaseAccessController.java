package caisseProjectController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CaisseDatabaseAccessController {

	private String userName;		/**Pseudo utilisateur pour l'acc�s � la base de donn�e*/
	private String password;		/**Password pour l'acc�s � la base de donn�e*/
	private String serverName;		/**Nom du serveur h�bergeant la base*/
	private String dbName;			/**Nom de la base de donn�e*/
	
	private Connection connector = null;
	
	private int portNumber = 3306;
	
	public CaisseDatabaseAccessController(String username, String pass, String server, String databaseName) {
		this.userName = username;
		this.password = pass;
		this.serverName = server;
		this.dbName = databaseName;
		
		try {
			connector = getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		conn = DriverManager.getConnection("jdbc:mysql://"+ this.serverName + ":" + this.portNumber + "/" + this.dbName,connectionProps);
		return conn;
	}
	
	public boolean executeUpdate(Connection conn, String requete) throws SQLException {
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(requete); // This will throw a SQLException if it fails
	        return true;
	    } catch(SQLException e){
	    	e.printStackTrace();
	    }
		return false;
	}
	
	public ResultSet executeQuery(Connection conn, String command) throws SQLException{
		Statement stmt = null;
		ResultSet query = null;
	    try {
	        stmt = conn.createStatement();
	        query = stmt.executeQuery(command); // This will throw a SQLException if it fails
	        return query;
	    } catch(SQLException e){
	    	e.printStackTrace();
	    }
		return null;
	}
	
	public boolean insertData(String toInsert){
		boolean insertion = false;
		try {
			String insertString = toInsert;
			this.executeUpdate(connector, insertString);
			insertion = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertion;
	}
	
	public ResultSet getRequest(String select){
		ResultSet rs = null;
		try {
			String requestString = select;
			rs = this.executeQuery(connector, requestString);
			while(rs.next()){
				System.out.println(rs.getString("name") + " ");
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return rs;
	}
	
	public boolean update(String upToDate){
		boolean update = false;
		try {
			String updateString = upToDate;
			this.executeUpdate(connector, updateString);
			update = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}

}
