import java.util.Date;


public class RegularPolygon implements Shape 
{
	
	private double lengthOfSide;
	private double numberOfSide;
	private Point originPoint;
	private Date timestamp;
	
	//parameterized constructor to initialize the origin point, length of side and number of side of regular polygon 
	public RegularPolygon(Point originPoint , double lengthOfSide , double numberOfSide)
	{
		this.originPoint = originPoint;
		this.lengthOfSide = lengthOfSide;
		this.numberOfSide = numberOfSide;
		timestamp = new Date();
	}
	
	
	/*
	 * getArea returns the area of the regular polygon
	 */
	
	@Override
	public double getArea() {
		
		return ((numberOfSide*lengthOfSide* Math.sqrt(3))/4);
		
	}

	/*
	 *getPerimeter method returns the perimeter of the regular polygon
	 */
	@Override
	public double getPerimeter() {
		
		return lengthOfSide*numberOfSide;
		
	}

	/*
	 * getOrigin method returns the object of Point class which contains the origin of the regular polygon
	 */
	@Override
	public Point getOrigin() {
		
		return originPoint;
		
	}

	/*
	 * isPointEnclosed method checks for the point is inside the polygon or not
	 * @param requires the point to be tested
	 * @returns true if point is inside the polygon otherwise false if not
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		
		return false;
		
	}

	/*
	 *getTimeStamp method returns the time stamp in which the polygon is added to the screen
	 */
	@Override
	public Date getTimeStamp() {
		
		return timestamp;
		
	}
	
	/*
	 *getShape method returns the type of shape like polygon
	 */

	@Override
	public VariousShape getShape() {
		
		return Shape.VariousShape.RegularPolygon;
		
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
