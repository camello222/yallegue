package com.example.none;

import android.location.Location;


public class Position{
	private double Latitud;
	private double Longitud;
	public Position(double latitud, double longitud) {
		super();
		Latitud = latitud;
		Longitud = longitud;
	}
	public double getLatitud() {
		return Latitud;
	}
	public void setLatitud(double latitud) {
		Latitud = latitud;
	}
	public double getLongitud() {
		return Longitud;
	}
	public void setLongitud(double longitud) {
		Longitud = longitud;
	}
	
}
