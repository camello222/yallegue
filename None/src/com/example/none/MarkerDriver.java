package com.example.none;

import java.sql.ResultSet;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MarkerDriver {

	public static void showUsers() throws Exception {
		// TODO Auto-generated method stub
		 MySQLAccess.connect();
		 MarkerOptions marker;
	        ResultSet results = MySQLAccess.getUsers("users");
	        while (results.next()) {
	            // it is possible to get the columns via name
	            // also possible to get the columns via the column number
	            // which starts at 1
	            // e.g., resultSet.getSTring(2);
	            String user = results.getString("name");
	            double latitud = results.getDouble("latitud");
	            double longitud = results.getDouble("longitud");
	            marker = new MarkerOptions()
		        .position(new LatLng(latitud, longitud))
		        .title(user)
		        .draggable(true);
		        // adding marker
		        MapManager.addMarker(marker);
	          }
	        MySQLAccess.close();
	}

	public static void showRooms(User user) throws Exception {
		// TODO Auto-generated method stub
		 MySQLAccess.connect();
		 MarkerOptions marker;
	        ResultSet results = MySQLAccess.getUserRooms(user, "rooms");
	        while (results.next()) {
	            // it is possible to get the columns via name
	            // also possible to get the columns via the column number
	            // which starts at 1
	            // e.g., resultSet.getSTring(2);
	            String nombre = results.getString("nombre");
	            double latitud = results.getDouble("latitud");
	            double longitud = results.getDouble("longitud");
	            marker = new MarkerOptions()
		        .position(new LatLng(latitud, longitud))
		        .title(nombre)
		        .draggable(true) 
		        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
		        // adding marker 
		        MapManager.addMarker(marker);
	          }
	        MySQLAccess.close();
	}
	
}
