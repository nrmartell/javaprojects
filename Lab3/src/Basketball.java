// Class implementing Basketball.

public class Basketball {
	
	// Radius of this basketball
	private double radius;
	
	//  constructor for basketball object.
	 //  val : Used to set up the radius of the basketball
	
	public Basketball(double val)
	{
		this.radius = val;
	}
	
	//  returns the volume of the basketball.

	public double getVolume()
	{
		double volume = (4.0 / 3.0) * Math.PI * Math.pow(this.radius, 3);
		return volume;
	}
	
	public double getDiameter()
	{
		double diameter = 2* this.radius;
		return diameter;
	}
	//Getter function for the radius of the ball.
	
	public double getRadius()
	{
		return this.radius;
	}
}