/*
 Shiri Katz 208641639þ.
 Elinor Chayoun 320519838. 
*/
package geometries;

import primitives.Point3D;

public class main_geometry {

	public static void main(String[] args) {
		//TODO Auto-generated method stub
		Point3D p1=new Point3D(1,2,3);
		Point3D p2=new Point3D(4,5,6);
		Point3D p3=new Point3D(14,7,8);
		Triangle triangle=new Triangle(p1,p2,p3);
		Plane plane=new Plane();
		Sphere sphere=new Sphere(6,p1);
		try{
		System.out.println("the normal of the sphere:"+ plane.getNormal(p3));
		System.out.println("the normal of the sphere:"+ sphere.getNormal(p3));
		System.out.println("the normal of the triangle:"+ triangle.getNormal(p3));
		System.out.println("the length of the triangle:"+(int) triangle.getNormal(p3).length());
		}
		catch(Exception e){
			System.out.println(e);
		}
	
/*the normal of the sphere:x: coordinate 0.0 y: coordinate 0.0 z: coordinate 0.0
the normal of the sphere:x: coordinate 0.8784585919193317 y: coordinate 0.7017124736806661 z: coordinate 0.9756382673283529
the normal of the triangle:x: coordinate 0.5773502691896257 y: coordinate 0.7006490497453706 z: coordinate 0.9571317422988216
the length of the triangle:1
*/
	
 }
}
