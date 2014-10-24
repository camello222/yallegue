public class RoomManager {

	private Usuario user;
	private Position position;
	
	public RoomManager(Usuario usr, Position pos){
		addRoom(usr,pos);
	}
	
	public void setPosition(Position pos){
		position=pos;
	}
	
	public Position getPosition(){
		return position;
	}
	
	public void setUser(Usuario usr){
		user=usr;
	}
	
	public Usuario getUser(){
		return user;
	}
		
	public void addRoom(Usuario usr, Position pos){
		user=usr;
		position=pos;
	}
	
	public void removeRoom(Room room){
		
	}
	
}
