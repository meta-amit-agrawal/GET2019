import java.util.Comparator;
import java.util.Date;


public class Sorting 
{
	// sorts the list with comparing the area of the two shapes
	public static Comparator<Shape> areaComparator = new Comparator<Shape>() {

		@Override
		public int compare(Shape o1, Shape o2) {
			double area1 = o1.getArea();
			double area2 = o2.getArea();
			
			if(area1 > area2)
				return 1;
			else if(area1 < area2)
				return -1;
			else
				return 0;
		}
		
	};
	
	
	//sorts the list with comparing the perimeter of the two shapes
	public static Comparator<Shape> perimeterComparator = new Comparator<Shape>() {

		@Override
		public int compare(Shape o1, Shape o2) {
			double peri1 = o1.getPerimeter();
			double peri2 = o2.getPerimeter();
			
			if(peri1 > peri2)
				return 1;
			else if(peri1 < peri2)
				return -1;
			else
				return 0;
		}
		
	};
	
	//sorts the list with comparing the timestamp of the shapes
	public static Comparator<Shape> timestampComparator = new Comparator<Shape>() {

		@Override
		public int compare(Shape o1, Shape o2) {
			Date time1 = o1.getTimeStamp();
			Date time2 = o2.getTimeStamp();
			
			if(time1.after(time2))
				return -1;
			else if(time1.before(time2))
				return 1;
			else
				return 0;
				
		}
		
	};
	
	//sorts the list with comparing the distance between the two origin of screen and shape
	public static Comparator<Shape> originDistanceComparator = new Comparator<Shape>() {

		@Override
		public int compare(Shape o1, Shape o2) {
			double distance1 = o1.originDistance();
			double distance2 = o2.originDistance();
			
			if(distance1 > distance2)
				return 1;
			else if(distance1 < distance2)
				return -1;
			else
				return 0;
				
		}
		
	};
}
