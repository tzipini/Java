package UnitTests;

import static org.junit.Assert.*;


import org.junit.Test;

import elements.Camera;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import scene.Scene;

public class CameraTests {

	/*** Camera test 
	 * @throws Exception ***/
	@Test
	public void testRaysConstruction() throws Exception{  
		final int WIDTH  = 3;  
		final int HEIGHT = 3;
		Point3D[][] screen = new Point3D [HEIGHT][WIDTH]; 
		Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),new Vector (0.0, 1.0, 0.0),new Vector (0.0, 0.0, -1.0));
		System.out.println("Camera:\n" + camera); 
		for (int i = 0; i < HEIGHT; i++) 
		{   
			for (int j = 0; j < WIDTH; j++) 
			{       
				Ray ray = camera.constructRayThroughPixel(WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);
				screen[i][j] = ray.getPoo();
				System.out.print(screen[i][j]);
				System.out.println(ray.getDirection());
				// Checking z-coordinate   
				assertTrue(Double.compare(screen[i][j].getZ().getCoordinate(), -1.0) == 0);       
				// Checking all options 
				double x = screen[i][j].getX().getCoordinate();
				double y = screen[i][j].getX().getCoordinate();
				if (Double.compare(x, 3) == 0 || Double.compare(x, 0) == 0 || Double.compare(x, -3) == 0){      
					if (Double.compare(y, 3) == 0 || Double.compare(y, 0) == 0 ||  Double.compare(y, -3) == 0){
						assertTrue(true); 
						}                     
					else    
						fail("Wrong y coordinate");  
	     }
		else    
		fail("Wrong x coordinate");  
		} 
			System.out.println("---");
		}
	} 

	@Test
	public void testConstructRayThrowAPixel() {
		
		Point3D p=new Point3D(1,2,3);
		Vector vup=new Vector(2,3,4);
		Vector vto=new Vector(3,-2,0);
		Camera camera=new Camera(p,vup,vto);
		Ray ray = new Ray();
		try {
			ray = new Ray(camera.constructRayThroughPixel(50, 50, 20,20, 1, 500, 500));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Point3D p1=new Point3D(454,675,-402);
		//System.out.println("hjhj"+ray.getPoo());
		//Vector vector=new Vector(0.4995963282558545,0.7422258916472186,-0.4466589689704659);
		assertTrue(ray.getPoo().compareTo(p1)==0 );//&& ray.getDirection().compareTo(vector)==0);
	
	}
	
}
	



