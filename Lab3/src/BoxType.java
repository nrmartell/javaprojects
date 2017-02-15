
public class BoxType {

	// Dimensions of the box
	private double length, width, height;
	
	// constructor to initialize the BoxType object.

	public BoxType(double l, double w, double h)
	{
		this.length = l;
		this.width  = w;
		this.height = h;
	}
	
	//This function is used to compute and return the volume of the box.

	 //@return volume : Volume of the box

	public double getVolume()
	{
		double volume = this.length * this.width * this.height;
		return volume;
	}
	
	public boolean fitsInBoxType(Basketball ball)
	{
		double ballVolume = ball.getVolume();
		double boxVolume = this.getVolume();
		double diameter = ball.getDiameter();
		
		
		
		if( diameter > this.length || diameter > this.length || diameter > this.width ){
			return false;
		}
		else{
			return true;
		}
		

	}
	
	// This function returns the empty space left after fitting a basketball

	public double emptySpace(Basketball ball)
	{
		double ballVolume = ball.getVolume();
		double boxVolume = this.getVolume();
		
		return (boxVolume - ballVolume);
		
		
		
	}
	
	// Getter functions
	public double getLength()
	{
		return this.length;
	}
	
	public double getWidth()
	{
		return this.width;
	}
	
	public double getHeight()
	{
		return this.height;
	}
}