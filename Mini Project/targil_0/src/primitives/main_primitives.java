/*
 Shiri Katz 208641639þ.
 Elinor Chayoun 320519838. 
*/
package primitives;

public class main_primitives {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coordinate coordinate = new Coordinate(3);
		Coordinate coordinate1 = new Coordinate(2);
		Point2D point2D = new Point2D(3, 4);
		Point2D point2D1 = new Point2D(2, 5);
		Point3D point3D = new Point3D(5, 6, 7);
		Vector vector = new Vector(point3D);
		Vector vector1 = new Vector(8, 3, 10);
		System.out.println(coordinate.toString());
		coordinate.add(coordinate1);
		System.out.println("the sum of the two coordinates is: " + coordinate);
		if (point2D.compareTo(point2D1) == 0)
			System.out.println("the points are the same");
		else
			System.out.println("the points are'nt the same");
		System.out.println("the length of the vector is: " + vector.length());
		System.out.println("the dotProduct is: " + vector.dotProduct(new Vector(5, 6, 0)));
		vector1.scale(5);
		System.out.println("the vector scaled with 5: " + vector1);
		if (vector1.compareTo(vector) == 0)
			System.out.println("the vectors are the same");
		else
			System.out.println("the vectors aren't the same");
		vector.subtract(vector1);
		System.out.println("the vector after the subtract: " + vector);
		System.out.println("the cross product of the two vectors is: " + vector.crossProduct(vector));
		try {
			vector1.normalize();
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("the vector after normalized: " + vector1);
		System.out.println("the length of the vector after normalized is:" + (int) vector1.length());
	}
}
/*
 * coordinate 3.0 the sum of the two coordinates is: coordinate 5.0 the points
 * are'nt the same the length of the vector is: 10.488088481701515 the
 * dotProduct is: 61.0 the vector scaled with 5: x: coordinate 40.0 y:
 * coordinate 15.0 z: coordinate 50.0 the vectors aren't the same the vector
 * after the subtract: x: coordinate -35.0 y: coordinate -9.0 z: coordinate
 * -43.0 the cross product of the two vectors is: x: coordinate 0.0 y:
 * coordinate -0.0 z: coordinate 0.0 the vector after normalized: x: coordinate
 * 0.6082287370157644 y: coordinate 0.22808577638091165 z: coordinate
 * 0.7602859212697055 the length of the vector after normalized is:1
 * 
 */