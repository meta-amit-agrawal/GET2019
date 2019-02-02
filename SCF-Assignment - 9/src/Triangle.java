import java.util.Date;


public class Triangle implements Shape
{
	
	private double base;
	private double height;
	private double hypotenuse;
	private Point originPoint;
	private Date timestamp;
	
	//parameterized constructor to initialize the origin point , base and height of the triangle
	public Triangle(Point originPoint , double sideA , double sideB )
	{
		base = sideA;
		height = sideB;
		this.originPoint = originPoint;
		timestamp = new Date();
		hypotenuse = Math.sqrt(  Math.pow(base, 2) + Math.pow(height, 2) );
	}
	
	/*
	 * getArea returns the area of the triangle
	 */
	@Override
	public double getArea() {
		
		return 0.5*base*height;
		
	}

	/*
	 *getPerimeter method returns the perimeter of the triangle
	 */
	@Override
	public double getPerimeter() {
		
		return base + height + hypotenuse;
		
	}

	/*
	 * getOrigin method returns the object of Point class which contains the origin of the triangle
	 */
	@Override
	public Point getOrigin() {
		
		return originPoint;
		
	}

	/*
	 * isPointEnclosed method checks for the point is inside the triangle or not
	 * @param requires the point to be tested
	 * @returns true if point is inside the triangle otherwise false if not
	 */
	@Override
	public boolean isPointEnclosed(Point point) {
		
		Point point1,point2,point3;
		point1=originPoint;
        point2=new Point(originPoint.getxPoint()+base,originPoint.getyPoint());
        point3=new Point(originPoint.getxPoint(),originPoint.getyPoint()+height);
        double subArea1,subArea2,subArea3;
        
        double x1,x2,x3,y1,y2,y3,x,y;
        x=point.getxPoint();
        y=point.getyPoint();
        x1= point1.getxPoint();
        y1=point1.getyPoint();
        x2= point2.getxPoint();
        y2=point2.getyPoint();
        x3= point3.getxPoint();
        y3=point3.getyPoint();
        
        //calculating area of the sub triangles formed by joining the coordinates of the triangle  
        subArea1=subArea(x1 , x2 , x , y1 , y2 , y );
        subArea2=subArea(x2 , x3 , x , y2 , y3 , y );
        subArea3=subArea(x1 , x3 , x , y1 , y3 , y);
		
		
		return (getArea()==subArea1+subArea2+subArea3);
		
	}
	
	/*
	 * private helper method to calculate the area of the sub triangles formed
	 */
	private double subArea(double x1 , double x2 , double x3 , double y1 , double y2 , double y3)
	{
		return Math.abs((x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))/2);
	}

	/*
	 *getTimeStamp method returns the time stamp in which the triangle is added to the screen
	 */
	@Override
	public Date getTimeStamp() {
		
		return timestamp;
		
	}

	/*
	 *getShape method returns the type of shape like triangle
	 */
	@Override
	public VariousShape getShape() {
		
		return Shape.VariousShape.Triangle;
		
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
