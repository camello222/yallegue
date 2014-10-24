package com.example.none;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class MySQLAccess {
  private static Connection connect = null;
  private static Statement statement = null;
  private static ResultSet resultSet = null;
  private static String DataBase = "yallegue";
  private static String User ="general";
  private static String Password="general";
  private static String URL ="camello222.no-ip.org";

	public static void setDataBase(String dataBase) {
		DataBase = dataBase;
	}

	public static void setUser(String user) {
		User = user;
	}

	public static void setPassword(String password) {
		Password = password;
	}

	public static void setURL(String uRL) {
		URL = uRL;
	}
	
  public static void connect() throws Exception{
	  try {
	      // this will load the MySQL driver, each DB has its own driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // setup the connection with the DB.
	      connect = DriverManager
	          .getConnection("jdbc:mysql://"+URL +"/"+DataBase,User,Password);
	  } catch (Exception e) {
	      throw e;
	  }
  }

  public static ResultSet getUsers(String tableName) throws Exception{
	  statement = connect.createStatement();
	  // resultSet gets the result of the SQL query
	  resultSet = statement
			  .executeQuery("select * from " + DataBase + "." + tableName);
	  return resultSet;
  }
  
  public static ResultSet getUser(String UserName, String Password, String table) throws Exception{
	  statement = connect.createStatement();
	  // resultSet gets the result of the SQL query
	  resultSet = statement
			  .executeQuery("select * from " + DataBase + "." 
	  + table + " where name=\"" + UserName +"\" AND password =\"" + Password + "\"");
	   return resultSet;
	  
  }
  
  
  public static void readTable(String tableName) throws Exception {
    try {
      connect();
      statement = connect.createStatement();
      // resultSet gets the result of the SQL query
      resultSet = statement
          .executeQuery("select * from " + DataBase + "." + tableName);
      printMetaData(resultSet);
      printResultSet(resultSet);
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }
  }

  private static void printMetaData(ResultSet resultSet) throws SQLException {
    // now get some metadata from the database
    System.out.println("The columns in the table are: ");
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private static void printResultSet(ResultSet resultSet) throws SQLException {
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
  public static void close() {
	  try {
		  resultSet.close();
		  statement.close();
		  connect.close();
	  } catch (SQLException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }
  }

	public static void updateUser(User usr, String usertable) throws SQLException {
		// TODO Auto-generated method stub
		statement = connect.createStatement();
		statement.executeUpdate("update "+ DataBase + "." + "users  set latitud=\"" +usr.getLalitud() 
				+ "\", longitud=\"" + usr.getLongitud() +"\" where id= \"" + usr.getId() + "\"");
	}

	public static ResultSet getUserRooms(User user, String roomtable) throws SQLException {
		statement = connect.createStatement();
		// resultSet gets the result of the SQL query
		resultSet = statement
				.executeQuery("select r.id, r.nombre, r.latitud, r.longitud, r.radio from " + DataBase + "." 
						+ roomtable +" r ," + DataBase + ".roomsxusers ru where r.id = ru.room_id and ru.user_id = \"" 
						+ user.getId() + "\"");
		return resultSet;
	}

} 