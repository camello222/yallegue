
public class Position {

	private double latitude, longitude;
	
	public Position(double lat, double lon){
		latitude=lat;
		longitude=lon;
	}

	public void setLatitude(double lat){
		latitude=lat;
	}

	public void setLongitude(double lon){
		longitude=lon;
	}
	
	public double getLatitude(){
		return latitude;
	}
	
	public double getLongitude(){
		return longitude;
	}
	
}
