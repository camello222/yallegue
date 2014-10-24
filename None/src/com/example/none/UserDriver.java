package com.example.none;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class UserDriver {
	private static User User;
	private static Position userPosition;
	private static final String UserTable="users";
	private static final String RoomTable="rooms";
	public static void login(String name, String password) throws Exception{
		MySQLAccess.connect();
		setUser(MySQLAccess.getUser(name, password, UserTable));
		setMemberRooms(MySQLAccess.getUserRooms(User, RoomTable));
		MySQLAccess.close();
	}
	
	private static void setMemberRooms(ResultSet rooms) throws SQLException {
		// TODO Auto-generated method stub
		while(rooms.next()){
			Position roomPosition = new Position(rooms.getDouble("latitud"), rooms.getDouble("longitud"));
			Room room = new Room(roomPosition,rooms.getString("nombre"),rooms.getDouble("radio"));
			User.addMemberRoom(room);
		}
	}

	public static void updatePosition(Position position) throws Exception{
		MySQLAccess.connect();
		userPosition = position;
		User.setLatitud(position.getLatitud());
		User.setLongitud(position.getLongitud());
		MySQLAccess.updateUser(User, UserTable); 
		
		MySQLAccess.close();
	}
	public static float checkDistances(){
		for(Room a: User.getMemberRooms()){
			return LocationChecker.getDistance(userPosition,a.getPosition());
		}
		return 1.0f;
	}
	

	public static User getUser() {
		return User;
	}

	private static void setUser(ResultSet resultSet) throws SQLException, Exception {
		 if(resultSet.next()){
			  String user = resultSet.getString("name");
	          double latitud = resultSet.getDouble("latitud");
	          double longitud = resultSet.getDouble("longitud");
	          User = new User(resultSet.getInt("id"),user, latitud, longitud);
		  }else{
			  throw new Exception("wrong credentials");
		  }
	}
	
	

	
	
}
