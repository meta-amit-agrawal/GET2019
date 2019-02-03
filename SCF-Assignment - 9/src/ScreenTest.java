import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class ScreenTest 
{
	Screen screen = new Screen(100, 100);
	
	@Test
	public void testCaseScreen()
	{
		
		//test case of adding a shape to a screen
		List<Integer> parameter = new ArrayList<Integer>();
		parameter.add(4);
		Point p  = new Point(3,5);
		try {
			assertTrue(screen.addShape("Circle", p, parameter));
		} 
		catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		parameter.clear();
		
		
		
		//test case of adding a shape to a screen		
		parameter.add(4);
		parameter.add(2);
		Point p2  = new Point(4,5);
		try {	
			assertTrue(screen.addShape("Rectangle", p2, parameter));
		} 
		catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		parameter.clear();
		
		
		
		//test case of adding a shape to a screen	
		parameter.add(4);
		Point p3  = new Point(5,5);
		try {	
			assertTrue(screen.addShape("Square", p3, parameter));
		} 
		catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		parameter.clear();
		
		
		
		//test case of adding a shape to a screen	
		parameter.add(4);
		parameter.add(3);
		Point p6  = new Point(4,3);
		try {	
			assertTrue(screen.addShape("Triangle", p6, parameter));
		} 
		catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		parameter.clear();
		
		
		
		//negative test case of adding a shape to a screen	
		parameter.add(4);
		Point p4  = new Point(6,3);
		try {	
			assertTrue(screen.addShape("Triangle", p4, parameter));
		} 
		catch (Exception e) {		
			System.out.println(e.getMessage());		//error message will be shown about incomplete parameters
		}
		parameter.clear();
		
		
		
		//negative test case of adding a shape to a screen
		parameter.add(2);
		Point p1 = new Point(110,200);
		try {
			assertTrue(screen.addShape("Rectangle", p1, parameter));
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());			//error message will be shown about screen range
		}
		parameter.clear();
		
		
		
		//test case to delete the shape at a particular position
		try {
			assertTrue(screen.deleteShape("Square", p3));
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		//negative test case to delete the shape at a particular position
		try {
			assertTrue(screen.deleteShape("Triangle", p2));
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());		//error message will be shown that shape not found at the given origin point
		}
		
		
		
		//test case to delete all shape of a particular type 
		try {
			assertTrue(screen.deleteAllShape("Rectangle"));
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		//test case to sort the list according to the area of the figure
		try {
			List<Shape> result = screen.sortList("area");
			for(int i=0;i<result.size();i++)
				System.out.println(result.get(i).getShape()+"  "+result.get(i).getArea());
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		//test case to sort the list according to the perimeter of the figure
		try {
			List<Shape> result = screen.sortList("perimeter");
			for(int i=0;i<result.size();i++)
				System.out.println(result.get(i).getShape()+"  "+result.get(i).getArea());
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		//test case to sort the list according to the origin distance of the figure
		try {
			List<Shape> result = screen.sortList("origin");
			for(int i=0;i<result.size();i++)
				System.out.println(result.get(i).getShape()+"  "+result.get(i).getArea());
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		//test case to sort the list according to the time stamp of the figure
		try {
			List<Shape> result = screen.sortList("timestamp");
			for(int i=0;i<result.size();i++)
				System.out.println(result.get(i).getShape()+"  "+result.get(i).getArea());
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		//negative test case to sort the list
		try {
			List<Shape> result = screen.sortList("");
			for(int i=0;i<result.size();i++)
				System.out.println(result.get(i).getShape()+"  "+result.get(i).getArea());
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());		//error message will be printed
		}
		
	}
}