import java.util.Date;


public class Square implements Shape
{
	private double lengthOfSide;
	private Point originPoint;
	private Date timestamp;
	
	//parameterized constructor to initialize the origin point and length of side of square
	public Square(Point originPoint, double lengthOfSide)
	{
		this.lengthOfSide = lengthOfSide;
		this.originPoint = originPoint;
		timestamp = new Date();
	}

	
	/*
	 * getArea returns the area of the square
	 */
	@Override
	public double getArea() {
	
		return Math.pow(lengthOfSide, 2);
		
	}

	/*
	 *getPerimeter method returns the perimeter of the square
	 */
	@Override
	public double getPerimeter() {
		
		return 4*lengthOfSide;
		
	}

	/*
	 * getOrigin method returns the object of Point class which contains the origin of the square
	 */
	@Override
	public Point getOrigin() {
		
		return originPoint;
		
	}

	/*
	 * isPointEnclosed method checks for the point is inside the square or not
	 * @param requires the point to be tested
	 * @returns true if point is inside the square otherwise false if not
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		
		if(point.getxPoint() >= originPoint.getxPoint() && point.getxPoint() <= (lengthOfSide+originPoint.getxPoint()) 
				&& point.getyPoint() >= originPoint.getyPoint() && point.getyPoint() <= (lengthOfSide+originPoint.getyPoint()))
			return true;
		
		return false;
		
	}

	/*
	 *getTimeStamp method returns the time stamp in which the square is added to the screen
	 */
	@Override
	public Date getTimeStamp() {
		
		return timestamp;
	}

	/*
	 *getShape method returns the type of shape like square
	 */
	@Override
	public VariousShape getShape() {
		
		return Shape.VariousShape.Square;
		
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
