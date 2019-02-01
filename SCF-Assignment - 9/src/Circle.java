import java.util.Date;


public class Circle implements Shape 
{
	private double radius;
	private Point originPoint;
	private Date timestamp;
	private double centerX;
	private double centerY;
	
	//parameterized constructor to initialize the origin point and radius of the circle
	public Circle(Point originPoint , double radius)
	{
		this.radius = radius;
		this.originPoint = originPoint;
		timestamp = new Date();
	}
	
	/*
	 * getArea returns the area of the circle
	 */
	
	@Override
	public double getArea() {
		
		return Utility.PI*Math.pow(radius, 2);
		
	}

	/*
	 *getPerimeter method returns the circumference of the circle
	 */
	@Override
	public double getPerimeter() {
		
		return 2*Utility.PI*radius;
		
	}

	/*
	 * getOrigin method returns the object of Point class which contains the origin of the circle
	 */
	@Override
	public Point getOrigin() {

		return originPoint;
		
	}

	
	/*
	 * isPointEnclosed method checks for the point is inside the circle or not
	 * @param requires the point to be tested
	 * @returns true if point is inside the circle otherwise false if not
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		
		double m=0;
		double originX,originY;
		
		originX = originPoint.getxPoint();
		originY = originPoint.getyPoint();
		
		//calculates the center coordinates of circle
		m = Math.sqrt( originX*originX + originY*originY ) + radius;
		
		centerX = (m*originX) / (m-radius);
		centerY = (m*originY) / (m-radius);
		
		double x,y;
		x=point.getxPoint();
		y=point.getyPoint();
		double distance = Math.sqrt( ( (x-centerX)*(x-centerX) ) + ( (y-centerY)*(y-centerY) ) );
		
		if(distance > radius)
			return false;
		
		return true;
		
	}

	/*
	 *getTimeStamp method returns the time stamp in which the circle is added to the screen
	 */
	@Override
	public Date getTimeStamp() {
		
		return timestamp;
		
	}

	/*
	 *getShape method returns the type of shape like circle
	 */
	@Override
	public VariousShape getShape() {

		return Shape.VariousShape.Circle;
	}

	/*
	 * originDistance method calculates the distance between the screen origin and the origin of shape
	 * @return the distance between the two origin
	 */
	@Override
	public double originDistance() {
		
		double x1 = 0;
		double y1 = 0;
		double x2 = originPoint.getxPoint();
		double y2 = originPoint.getyPoint();
		double distance = Math.sqrt( ( (x2-x1)*(x2-x1) ) + ( (y2-y1)*(y2-y1) ) );

		return distance;
		
	}
}
