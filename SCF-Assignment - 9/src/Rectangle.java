import java.util.Date;


public class Rectangle implements Shape 
{
	private double length;
	private double height;
	private Point originPoint;
	private Date timestamp;
	
	//parameterized constructor to initialize the origin point, length and breadth of rectangle 
	public Rectangle(Point originPoint , double length , double height)
	{
		this.length = length;
		this.height = height;
		this.originPoint = originPoint;
		timestamp = new Date();
	}
	
	
	/*
	 * getArea returns the area of the Rectangle
	 */
	@Override
	public double getArea() {
		
		return length*height;
		
	}
	
	/*
	 *getPerimeter method returns the perimeter of the rectangle
	 */
	@Override
	public double getPerimeter() {
		
		return 2*(length+height);
		
	}
	
	/*
	 * getOrigin method returns the object of Point class which contains the origin of the rectangle
	 */
	@Override
	public Point getOrigin() {
		
		return originPoint;
		
	}
	
	/*
	 * isPointEnclosed method checks for the point is inside the rectangle or not
	 * @param requires the point to be tested
	 * @returns true if point is inside the rectangle otherwise false if not
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		
		if(point.getxPoint() >= originPoint.getxPoint() && point.getxPoint() <= (length+originPoint.getxPoint()) 
				&& point.getyPoint() >= originPoint.getyPoint() && point.getyPoint() <= (height+originPoint.getyPoint()))
			return true;
		
		return false;
		
	}

	/*
	 *getTimeStamp method returns the time stamp in which the rectangle is added to the screen
	 */
	@Override
	public Date getTimeStamp() {
		
		return timestamp;
	}

	/*
	 *getShape method returns the type of shape like rectangle
	 */
	@Override
	public VariousShape getShape() {
		
		return Shape.VariousShape.Rectangle;
		
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
