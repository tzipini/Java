package UnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import elements.Camera;
import geometries.Plane;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;


public class PlaneTest {

	@Test
	public void testIntersectionPoints(){ 
		final int WIDTH  = 3;
		final int HEIGHT = 3; 
		Ray[][] rays = new Ray [HEIGHT][WIDTH];
		Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),  new Vector (0.0, 1.0, 0.0), new Vector (0.0, 0.0, -1.0));
		// plane orthogonal to the view plane  
		Plane plane  = new Plane(new Vector(0.0, 0.0, -1.0), new Point3D(0.0, 0.0, -3.0));
		// 45 degrees to the view plane 
		Plane plane2 = new Plane(new Vector(0.0, 0.25, -1.0), new Point3D(0.0, 0.0, -3.0));
		List<Point3D> intersectionPointsPlane = new ArrayList<Point3D>();
		List<Point3D> intersectionPointsPlane2 = new ArrayList<Point3D>();    
		System.out.println("Camera:\n" + camera);    
		for (int i = 0; i < HEIGHT; i++){   
			for (int j = 0; j < WIDTH; j++){        
				rays[i][j] = camera.constructRayThroughPixel( WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);  
				List<Point3D> rayIntersectionPoints  = plane.FindIntersections(rays[i][j]);
				List<Point3D> rayIntersectionPoints2  = plane2.FindIntersections(rays[i][j]);
				for (Point3D iPoint: rayIntersectionPoints)     
					intersectionPointsPlane.add(iPoint);
				for (Point3D iPoint: rayIntersectionPoints2)   
					intersectionPointsPlane2.add(iPoint);  
				}
			}
		assertTrue(intersectionPointsPlane. size() == 9);
		assertTrue(intersectionPointsPlane2.size() == 9);  
		for (Point3D iPoint: intersectionPointsPlane)
			System.out.println(iPoint);  System.out.println("---");  
			for (Point3D iPoint: intersectionPointsPlane2) 
	System.out.println(iPoint);
			}
	}
	/*private static final double delta=1e-15;
	 @Test
	 public void tesIntersectionPoints() {
		 Plane plane=new Plane(new Vector(5,3,1),new Point3D(2,4,3));
		 Ray ray=new Ray(new Point3D(1,2,3),new Vector(4,1,2));
		 List<Point3D> IntersectionssList =new ArrayList<Point3D>();
		 IntersectionssList=plane.FindIntersections(ray);
		 Point3D p=new Point3D(2.76,2.44,3.88);
		 assertEquals(0,IntersectionssList.get(0).compareTo(p),delta);
	 }*/
	/* Plane _plane=new Plane(new Vector(2,4,6),new Point3D(1,2,3));
	    public PlaneTest() {
	    }

    @Test
    public void testSomeMethod() {
    }
      @Test
      public void tesIntersectionPoints() {
    List<Point3D> list_point_ans;
            list_point_ans=new ArrayList<Point3D>();
        list_point_ans.add(new Point3D(2,3,2));
       List<Point3D> list_point= _plane.FindIntersections(new Ray(new Point3D(1,1,1),new Vector(1.5,3,1.5)));
       assertTrue( list_point_ans.get(0).compareTo(list_point.get(0))==0);
       
       
           Plane _plane0=new Plane(new Vector(0,0,0),new Point3D(1,2,3));
           		try {
	    list_point_ans=new ArrayList<Point3D>();
        list_point_ans.add(new Point3D(1,1,1));
        list_point= _plane0.FindIntersections(new Ray(new Point3D(1,1,1),new Vector(1.5,3,1.5)));
     
//fail("Didn't throw divide by zero exception!");
		} catch (ArithmeticException e) {
		assertTrue(true);
		}
		
                        System.out.print(list_point.get(0).toString());
           assertTrue(list_point_ans.get(0).compareTo(list_point.get(0))==0);
    


           	
      }  
      }   */    

