package UnitTests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import elements.AmbientLight;
import elements.Camera;
import geometries.Geometry;
import renderer.Render;
import java.awt.Color;

import org.junit.Test;

import renderer.ImageWriter;


public class WriteImagetTest {
	@Test
	public void test() 
	{
	ImageWriter iw = new ImageWriter("Image1",500,500,1,1);
	for(int i=0; i<500;i++)
	for (int j =0;j<500 ;j++)
	{
	if(i%50==0 || j%50==0)
	iw.writePixel(i, j,Color.pink);
	else
	iw.writePixel(i, j, new Color(150,20,130));
	}
	iw.writeToimage();
	}

   /* @Test
    public void testCalcColor()
    {
        System.out.println("calcColor");
        Render instance = new Render("GridImage",500,500,"my",Color.GREEN,Color.YELLOW,0.7,new ArrayList<Geometry>(),3);
        Color c = instance.getScene().getAmbientlight().getIntensity();
        assertEquals(c.getBlue(),16);
        assertEquals(c.getGreen(),40);
        assertEquals(c.getRed(), 80);
    }*/
//    @Test
//    public void testPrintGrid() {
//        System.out.println("printGrid");
//        //interval = null;
//        Render instance = new Render("GridImage",500,500,"my",new Color(100,50,20),new Color(100,50,20),0.8,new ArrayList<Geometry>(),3);
//        instance.printGrid(50);
//        instance.getImageWriter().writeToimage();
//    }
}
