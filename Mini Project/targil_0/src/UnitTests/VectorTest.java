package UnitTests ;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Vector;

public class VectorTest {

	@Test
	public void testCrossProduct() {
		Vector vector=new Vector(2,3,4);
		Vector vector1=new Vector(3,-2,0);
		Vector vector2=new Vector(-8,-12,13);
		System.out.println(vector1.crossProduct(vector));
		assertTrue(vector1.crossProduct(vector).compareTo(vector2) == 0);
	}

	@Test
	public void testSubtract() {
		Vector vector=new Vector(2,3,4);
		Vector vector1=new Vector(3,5,9);
		Vector vector2=new Vector(1,2,5);
		vector1.subtract(vector);
		assertTrue(vector1.compareTo(vector2) == 0 );
	}
	@Test
	public void  testScaling(){
		Vector vector=new Vector(2,2,2);
		Vector vector1=new Vector(4,4,4);
		vector.scale(2);
		assertTrue(vector.compareTo(vector1) == 0 );
		
	}
	
	@Test
	public void testAdd() {
		Vector vector=new Vector(2,3,4);
		Vector vector1=new Vector(2,5,9);
		Vector vector2=new Vector(4,8,13);
		vector.add(vector1);
		assertTrue(vector.compareTo(vector2) == 0 );
		
	}
	@Test
	public void testNormalize() {
		Vector vector1=new Vector(2,2,1);
		//Vector vector=new Vector(0,0,0);
		Vector vector2=new Vector(2.0/3,2.0/3,1.0/3);
		try{
		 vector1.normalize();
		}
		catch(Exception e){
			System.out.println(e);
			
		}
		assertTrue(vector1.compareTo(vector2) == 0 );
	}
	@Test
	public void testLength() {
		Vector vector1=new Vector(2,2,1);
		double length=vector1.length();
		assertEquals(length,3,0);	
	}
	@Test
	public void testDotProduct() {
		Vector vector=new Vector(2,2,1);
		Vector vector1=new Vector(4,4,2);
		double dotProduct=vector.dotProduct(vector1);
		assertEquals (dotProduct,18,0);
	}
	@Test
	public void testDitance() {
		Vector vector=new Vector(2,3,4);
		Vector vector1=new Vector(2,5,9);
		System.out.println(vector.getHead().distance(vector1.getHead()));
		assertEquals(vector.getHead().distance(vector1.getHead())==5.3 ,0.5);
		
	}
}
