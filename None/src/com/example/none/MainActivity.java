package com.example.none;

import java.sql.ResultSet;

import com.google.android.gms.maps.model.LatLng;


import android.support.v4.app.FragmentActivity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
//import com.google.android.maps.MapView;



public class MainActivity extends FragmentActivity implements LocationListener {
	private LocationManager locationManager;
	private String provider;
	private Position position;
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textView1);
		Toast.makeText(getApplicationContext(), "Bienvenido " + UserDriver.getUser().getName(),
				 Toast.LENGTH_LONG).show();
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		// Define the criteria how to select the locatioin provider -> use
		// default
		Criteria criteria = new Criteria();
		provider = locationManager.getBestProvider(criteria, false);
		Location location = locationManager.getLastKnownLocation(provider);
		position = new Position(location.getLatitude(), location.getLongitude());
		// Initialize the location fields
		if (location != null) {
			System.out.println("Provider " + provider + " has been selected.");
			onLocationChanged(location);
		}
		try {
			MapManager.setMyActivity(this);
            MapManager.createMap();
	        // create marker
//	        MarkerOptions marker = new MarkerOptions()
//	        .position(new LatLng(position.getLatitud(), position.getLongitud()))
//	        .title(UserDriver.getUser().getName())
//	        .draggable(true);
//	        // adding marker
//	        MapManager.addMarker(marker);
	       MarkerDriver.showUsers();
	       MarkerDriver.showRooms(UserDriver.getUser());
        } catch (Exception e) {
            e.printStackTrace();
        }

	}


 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
        position.setLatitud(location.getLatitude());
        position.setLongitud(location.getLongitude());
        try {
			UserDriver.updatePosition(position);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Toast.makeText(getApplicationContext(), e.toString(),
					 Toast.LENGTH_LONG).show();
		}  
        textView.setText(""+UserDriver.checkDistances());
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Enabled new provider " + provider,
				Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Disabled provider " + provider,
				Toast.LENGTH_SHORT).show();

	}
	 /* Request updates at startup */
	  @Override
	  protected void onResume() {
	    super.onResume();
	    locationManager.requestLocationUpdates(provider, 400, 1, this);
        //initilizeMap();
	  }

	  /* Remove the locationlistener updates when Activity is paused */
	  @Override
	  protected void onPause() {
	    super.onPause();
	    locationManager.removeUpdates(this);
	  }
	
}
