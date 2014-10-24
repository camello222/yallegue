package com.example.none;

public class Room {
	private String name;
	private double radio;
	private Position myPosition;
	
	public Room (Position pos, String name, double d)
	{
		this.myPosition = pos;
		this.name= name;
		this.radio= d;
	}
	
	public void setName(String name)
	{
		this.name= name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setRadio(float radio)
	{
		this.radio= radio;
	}
	
	public double getRadio()
	{
		return this.radio;
	}
	
	public void setPosition(Position pos)
	{
		this.myPosition = pos;
	}
	
	public Position getPosition()
	{
		return this.myPosition;
	}
	
	
}