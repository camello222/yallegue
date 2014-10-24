package com.example.none;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccess {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;
  private String DataBase;
  private String User;
  private String Password;

  public void connect() throws Exception{
	  try {
	      // this will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // setup the connection with the DB.
	      DataBase = "yallegue";
	      User ="general";
	      Password="general";
	      connect = DriverManager
	          .getConnection("jdbc:mysql://camello222.no-ip.org/"+DataBase,User,Password);
	  } catch (Exception e) {
	      throw e;
	  }
  }
  
  public void readTable(String tableName) throws Exception {
    try {
      connect();
      statement = connect.createStatement();
      // resultSet gets the result of the SQL query
      resultSet = statement
          .executeQuery("select * from " + DataBase + "." + tableName);
      readMetaData(resultSet);
      readResultSet(resultSet);
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  private void readMetaData(ResultSet resultSet) throws SQLException {
    // now get some metadata from the database
    System.out.println("The columns in the table are: ");
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private void readResultSet(ResultSet resultSet) throws SQLException {
    // resultSet is initialised before the first data set
    while (resultSet.next()) {
      // it is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g., resultSet.getSTring(2);
      String user = resultSet.getString("name");
      String password = resultSet.getString("password");
      String latitud = resultSet.getString("latitud");
      String longitud = resultSet.getString("longitud");
      System.out.println("User: " + user);
      System.out.println("password: " + password);
      System.out.println("latitud: " + latitud);
      System.out.println("longitud: " + longitud);
    }
  }

  // you need to close all three to make sure
  private void close() {
	  try {
		  resultSet.close();
		  statement.close();
		  connect.close();
	  } catch (SQLException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }
  }


  public static void main(String[] args) throws Exception {
	  MySQLAccess dao = new MySQLAccess();
	  dao.readTable("users");
  }

} 