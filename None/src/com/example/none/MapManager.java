package com.example.none;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public final class MapManager {
	private static GoogleMap MyMap;
	private static int MapType;
	private static boolean LocationEnabled;
	private static boolean LocationButtonEnabled;
	private static FragmentActivity MyActivity;
	
	public static void createMap(){
		if (MyMap == null) {
            MyMap = ((SupportMapFragment)MyActivity.getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            if (MyMap == null) {
                Toast.makeText(MyActivity.getApplicationContext(),"Map not created", Toast.LENGTH_SHORT).show();
            }
        }
        MyMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        MyMap.setMyLocationEnabled(true);
        MyMap.getUiSettings().setMyLocationButtonEnabled(true);// latitude and longitude
	}
	public static void addMarker(MarkerOptions marker){
		MyMap.addMarker(marker);
	}
	public static int getMapType() {
		return MapType;
	}
	public static void setMapType(int mapType) {
		MapType = mapType;
		MyMap.setMapType(mapType);
	}
	public static boolean isLocationEnabled() {
		return LocationEnabled;
	}
	public static void setLocationEnabled(boolean locationEnabled) {
		LocationEnabled = locationEnabled;
		MyMap.setMyLocationEnabled(locationEnabled);
	}
	public static boolean isLocationButtonEnabled() {
		return LocationButtonEnabled;
	}
	public static void setLocationButtonEnabled(boolean locationButtonEnabled) {
		LocationButtonEnabled = locationButtonEnabled;
		MyMap.getUiSettings().setMyLocationButtonEnabled(true);
	}
	public static Activity getMyActivity() {
		return MyActivity;
	}
	public static void setMyActivity(FragmentActivity myActivity) {
		MyActivity = myActivity;
	}

}
