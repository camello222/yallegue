package com.example.none;

import android.location.Location;

public final class LocationChecker {

	public static float getDistance(Position origen, Position destino){
//		double oL = origen.getLatitud();
//		double dL = destino.getLatitud();
//		double oR = Math.toRadians(Math.toDegrees(destino.getLatitud()) - Math.toDegrees(origen.getLatitud()));
//		double dR = Math.toRadians(Math.toDegrees(destino.getLongitud()) - Math.toDegrees(origen.getLongitud()));
//		
//		double a = Math.sin(oR/2.0)*Math.sin(oR/2.0) +  Math.cos(oL)*Math.cos(dL) +  Math.sin(dR/2.0)*Math.sin(dR/2.0);
//		
//		double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
//		
//		double d = 6371.0*c;
		float[] results = new float[1];
		Location.distanceBetween(origen.getLatitud(), origen.getLongitud(), destino.getLatitud(), destino.getLongitud(), results);
		return results[0]/1000f;
		
	}
	
}
