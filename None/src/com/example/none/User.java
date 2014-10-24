package com.example.none;

import java.util.ArrayList;

public class User{

	private int id;
	private String name;
	private double latitud;
	private double longitud;
	private boolean active;
	private ArrayList<Room> myRooms; //Cuartos que yo administro
	private ArrayList<Room> memberRooms; //Cuartos a los que pertenezco
	
	public User(int id, String name, double Latitud, double Longitud){
		this.id = id;
		this.name = name;
		latitud = Latitud;
		longitud = Longitud;
		myRooms = new ArrayList<Room>();
		memberRooms = new ArrayList<Room>();
	}
	
	public ArrayList<Room> getMyRooms() {
		return myRooms;
	}

	public void setMyRooms(ArrayList<Room> myRooms) {
		this.myRooms = myRooms;
	}

	public ArrayList<Room> getMemberRooms() {
		return memberRooms;
	}

	public void setMemberRooms(ArrayList<Room> memberRooms) {
		this.memberRooms = memberRooms;
	}

	public void addOwnedRoom(Room room){
		myRooms.add(room);
	}
	
	public void addMemberRoom(Room room){
		memberRooms.add(room);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public double getLalitud()
	{
		return this.latitud;
	}
	
	public double getLongitud()
	{
		return this.longitud;
	}
	
	public boolean getActive()
	{
		return this.active;
	}
	
	public void setName(String name)
	{
		this.name= name;
	}
	
	public void setLatitud(double latitud)
	{
		this.latitud= latitud;
	}
	
	public void setLongitud (double longitud)
	{
		this.longitud= longitud;
	}
	
	public void setActive (boolean active)
	{
		this.active= active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}