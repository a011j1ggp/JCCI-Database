package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class AccessLayer {
	
	public static String dbName;
	private static AccessLayer instance;
	private static Connection connection = null;
	private static String rootPass = "";
	public AccessLayer(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/"+(dbName)+"?user=administrator&password=password");
			ResultSet res = connection.createStatement().executeQuery("select `password` from `users` where `id`=1");
			if(res.next())
				rootPass = res.getString(1);
		} catch(SQLException e){
			e.printStackTrace();
		} catch(ClassNotFoundException e){}
	}
	
	public static AccessLayer getInstance(){
		if(instance == null)
			instance = new AccessLayer();
		return instance;
	}
	
	public static boolean success;
	public void prepareConnection(){
		try{
			closeConnection();
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/"+(dbName)+"?user=root&password="+rootPass+"");
		} catch(SQLException e){
			success = false;
		} catch(ClassNotFoundException e){}
	}
	
	public ResultSet executeQuery(String query){
		success = true;
		prepareConnection();
		try {
			Statement statement = connection.createStatement();
			return statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			success = false;
		}
		closeConnection();
		return null;
	}
	
	public void executePreparedStatement(String query){
		prepareConnection();
		try {
			connection.setAutoCommit(false);
			java.sql.PreparedStatement prepStatement = prepareStatement(query);
			prepStatement.executeUpdate();
			prepStatement.close();
			connection.commit();
		} catch (SQLException e) {
			rollback(connection, "Error");
		}
		closeConnection();
	}
	
	public java.sql.PreparedStatement prepareStatement(String query) throws SQLException{
		return connection.prepareStatement(query);
	}
	
	private void rollback(Connection connection, String title) {
		try {
			connection.rollback();
			JOptionPane.showMessageDialog(null, "Error!", "The system has recovered from an unexpected error. Your transaction was not processed.", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error!", "The system failed to recover from an error.", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void addApplicantToDatabase(String tableName, String values){
		prepareConnection();
		try {
			connection.setAutoCommit(false);
			connection.createStatement().executeUpdate("insert into `"+tableName+"` values("+values+");");
			connection.commit();
		} catch (SQLException e) {
			rollback(connection, "Add Patient Error");
		}
		closeConnection();
	}
	
	public void updatePatientInDatabase(String tableName, String values, String condition){
		prepareConnection();
		try{
			connection.setAutoCommit(false);
			connection.createStatement().executeUpdate("UPDATE `"+tableName+"` SET "+values+" where "+condition);
			connection.commit();
		}catch(SQLException e){
			rollback(connection, "Update Patient Error");
		} 
		closeConnection();
	}
	public void updateAccount(String tableName, String values, String condition){
		prepareConnection();
		try{
			connection.setAutoCommit(false);
			connection.createStatement().executeUpdate("UPDATE `"+tableName+"` SET "+values+" where "+condition);
			connection.commit();
		}catch(SQLException e){
			e.printStackTrace();
			rollback(connection, "Update Admin Error");
		} 
		closeConnection();
	}
	
	private void closeConnection() {
		try{
			if (connection!=null)
				connection.close();
		} catch (Exception e) {}
	}
}
