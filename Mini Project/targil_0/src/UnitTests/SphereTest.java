package UnitTests;


import static org.junit.Assert.*;

import org.junit.Test;

import elements.Camera;
import geometries.Sphere;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertSame;
//import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class SphereTest {
	/**** Sphere test ****/ 
     	@Test
	    public void testIntersectionPoints(){ 
		final int WIDTH  = 3;  
		final int HEIGHT = 3; 
		Ray[][] rays = new Ray [HEIGHT][WIDTH];
		Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),new Vector (0.0, 1.0, 0.0),new Vector (0.0, 0.0, -1.0));
		Sphere sphere  = new Sphere(1, new Point3D(0.0, 0.0, -3.0)); 
		Sphere sphere2 = new Sphere(10, new Point3D(0.0, 0.0, -3.0));  
		// Only the center ray intersect the sphere in two locations  
		List<Point3D> intersectionPointsSphere = new ArrayList<Point3D>(); 
		// The sphere encapsulates the view plane - all rays intersect with the sphere once
		List<Point3D> intersectionPointsSphere2 = new ArrayList<Point3D>();  
		System.out.println("Camera:\n" + camera);   
		for (int i = 0; i < HEIGHT; i++){  
			for (int j = 0; j < WIDTH; j++)  { 
				rays[i][j] = camera.constructRayThroughPixel(   
						WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);  
				List<Point3D> rayIntersectionPoints  = sphere. FindIntersections(rays[i][j]); 
				List<Point3D> rayIntersectionPoints2 = sphere2.FindIntersections(rays[i][j]);  
				for (Point3D iPoint: rayIntersectionPoints)     
					intersectionPointsSphere.add(iPoint);   
				for (Point3D iPoint: rayIntersectionPoints2)   
					intersectionPointsSphere2.add(iPoint); 
				} 
		}
			assertTrue(intersectionPointsSphere. size() == 2);  
			assertTrue(intersectionPointsSphere2.size() == 9);
			System.out.println("Intersection Points:");
			for (Point3D iPoint: intersectionPointsSphere) 
			{  
				
				assertTrue(iPoint.compareTo(new Point3D(0.0, 0.0, -2.0)) == 0 || iPoint.compareTo(new Point3D(0.0, 0.0, -4.0)) == 0);
				System.out.println(iPoint);
			}
			for (Point3D iPoint: intersectionPointsSphere2) 
			{  
				
				
				System.out.println(iPoint);
			}
		
	}
	/*
	@Test
	public void testFindIntersections() throws Exception 
	{
		//No intersections
		Point3D poi=new Point3D(0,0,-400);
		Point3D po=new Point3D(0,0,0);
		double num=(long)Math.pow((double)1/3, 0.5);
		Vector v=new Vector(num,-1*num,-1*num);
		Sphere s=new Sphere(200,poi);
		Ray ra=new Ray(po,v);
		try{
		assertTrue(s.FindIntersections(ra).size()==0);
		}
		catch(Exception e)
	    {
		   System.out.println(e);
		}
		
	}

	private static final double delta=1e-15;

	@Test
	public void testFindIntersections2() throws Exception 
	{
		
		//2 intersections
		Sphere sp=new Sphere(1.5,new Point3D(1,1,1));
		List<Point3D>  listPointAns=new ArrayList<Point3D>();
        double num=1.5-(double)Math.pow(1.5, 0.5);
        listPointAns.add(new Point3D(num*0.5,num*0.5,num*0.5));
        num=1.5+(double)Math.pow(1.5, 0.5);
        listPointAns.add(new Point3D(num*0.5,num*0.5,num*0.5));
        List<Point3D> listPoint=new ArrayList<Point3D>();
        try{
        listPoint= sp.FindIntersections(new Ray(new Point3D(0,0,0),new Vector(0.5,0.5,0.5)));
        }
        catch(Exception e)
	    {
		   System.out.println(e);
		}
        //assertEquals(0, listPointAns.get(0).compareTo(listPoint.get(0)), delta);//Maybe we don't need delta
        assertEquals(listPointAns.get(0).getX().getCoordinate(),listPoint.get(0).getX().getCoordinate() ,delta);
        assertEquals(listPointAns.get(0).getY().getCoordinate(),listPoint.get(0).getY().getCoordinate() ,delta);
        assertEquals(listPointAns.get(0).getZ().getCoordinate(),listPoint.get(0).getZ().getCoordinate() ,delta);
        assertEquals(listPointAns.get(1).getX().getCoordinate(),listPoint.get(1).getX().getCoordinate() ,delta);
        assertEquals(listPointAns.get(1).getY().getCoordinate(),listPoint.get(1).getY().getCoordinate() ,delta);
        assertEquals(listPointAns.get(1).getZ().getCoordinate(),listPoint.get(1).getZ().getCoordinate() ,delta);
	}
*/
}
