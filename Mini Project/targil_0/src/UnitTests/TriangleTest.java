package UnitTests;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import geometries.Triangle;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;

import elements.Camera;

public class TriangleTest {
	
	
	/*** Triangle test 
	 * @throws Exception ***/
	@Test 
	public void TriangleIntersectionPointsTest() throws Exception{
		final int WIDTH  = 3; 
		final int HEIGHT = 3;
		Ray[][] rays = new Ray [HEIGHT][WIDTH];
		Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),new Vector (0.0, 1.0, 0.0),new Vector (0.0, 0.0, -1.0)); 
	 
	 Triangle triangle = new Triangle(new Point3D( 0, 1, -2), new Point3D( 1, -1, -2),new Point3D(-1, -1, -2)); 
	 
	 Triangle triangle2 = new Triangle(new Point3D( 0,  10, -2),new Point3D( 1, -1, -2),new Point3D(-1, -1, -2)); 
	 
	 List<Point3D> intersectionPointsTriangle = new ArrayList<Point3D>();
	 List<Point3D> intersectionPointsTriangle2 = new ArrayList<Point3D>();
	 System.out.println("Camera:\n" + camera);  for (int i = 0; i < HEIGHT; i++)  { 
		 for (int j = 0; j < WIDTH; j++)   { 
			 rays[i][j] = camera.constructRayThroughPixel (WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);  
			 List<Point3D> rayIntersectionPoints = triangle. FindIntersections(rays[i][j]);   
			 List<Point3D> rayIntersectionPoints2 = triangle2.FindIntersections(rays[i][j]);  
			 for (Point3D iPoint: rayIntersectionPoints)    
				 intersectionPointsTriangle.add(iPoint);   
			 for (Point3D iPoint: rayIntersectionPoints2)   
				 intersectionPointsTriangle2.add(iPoint);   
			 }
		 }  
	 assertTrue(intersectionPointsTriangle. size() == 1);
	 assertTrue(intersectionPointsTriangle2.size() == 2);
	 System.out.println("Intersection Points:");
	 for (Point3D iPoint: intersectionPointsTriangle)
		 System.out.println(iPoint); 
	     System.out.println("--"); 
		 for (Point3D iPoint: intersectionPointsTriangle2)   
			 System.out.println(iPoint); 
		 } 
		
	
	
	private static final double delta=1e-15;
	@Test
	public void testFindIntersections() throws Exception {
		//Point3D p=new Point3D(0,0,0);
		Triangle t=new Triangle(new Point3D(1,2,3),new Point3D(1,4,4),new Point3D(3,5,6));
		List<Point3D> listAns=new ArrayList<Point3D>();
		Ray r= new Ray(new Point3D(1,1,1),new Vector(1.5,3,1.5));
		try{
			listAns=t.FindIntersections(r);
			 System.out.println(listAns.toString());
		}
		catch(Exception e)
	    {
		   System.out.println(e);
		}
	    assertTrue(listAns.size()==0);//the list returns (1,1,1)

		listAns=new ArrayList<Point3D>();
		listAns.add(new Point3D(-1,5,3));
		List<Point3D> listPoint= t.FindIntersections(r);
		try{
	    //assertTrue( listAns.get(0).compareTo(listPoint.get(0))==0);
			assertEquals(0,listAns.get(0).compareTo(listPoint.get(0)),delta);
		}
		catch(Exception e)
	    {
		   System.out.println(e);
		}
	
	}	
}

