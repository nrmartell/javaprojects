   /*------------------------------------------------------------------------------------
    |  Name: Natalie Martell
    |  Date Modified 2/14/17	
    |  Purpose:  Program is designed to help a company ship basketballs. 
    |  Program will take input from a text file with box dimensions and radii
    |  and then use that data to determine which boxes to use on each size of basketball
    *------------------------------------------------------------------------------------*/
// Class implementing Basketball.

public class Basketball {
	
	// Radius of this basketball
	private double radius;
	
	//  constructor for basketball object.
	 
	
	public Basketball(double rad)
	{
		this.radius = rad;
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