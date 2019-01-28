package geometries;
import java.util.ArrayList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Plane extends Geometry implements FlatGeometry {
	private Vector normal;
	private Point3D Q;
	// ***************** Constructors ********************** //
	public Plane(){
		normal=new Vector();
		Q=new Point3D();
	}
	public Plane (Plane plane){
		this.normal=new Vector(plane.getNormal());
		this.Q=new Point3D(plane.getQ());
	}
	public Plane (Vector normal, Point3D q){
		this.normal=new Vector(normal);
		this.Q=new Point3D(q);
	}
	// ***************** Getters/Setters ********************** //
	public Vector getNormal() {
		return new Vector(normal);
	}
	public void setNormal(Vector normal) {
		this.normal = normal;
	}
	public Point3D getQ() {
		return new Point3D(Q);
	}
	public void setQ(Point3D q) {
		Q = q;
	}
	// ***************** Operations ******************** //
	public Vector getNormal(Point3D point) {
		return normal;
	
    }
    
	public List<Point3D> FindIntersections(Ray ray){
		 List<Point3D> IntersectionssList =new ArrayList<Point3D>();
		 Point3D P=new Point3D(ray.getPoo());
		 Point3D distance = new Point3D(ray.getPoo());//P0-Q0
		 distance.subtract(this.Q);
		 Vector vector=new Vector(distance);
		 Vector n = new Vector(normal);
		 n.scale(-1);
		 double mone=n.dotProduct(vector);//-N(P0-Q0)
		 double mechane=normal.dotProduct(ray.getDirection());//N*V
		 Vector v=new Vector(ray.getDirection());
	     double t=(double)mone/mechane;  
		 if(t>0){
			 v.scale(t);
			 P.add(v.getHead());
			 IntersectionssList.add(P);
			
		 }
		
		 return IntersectionssList;
		
	}		
}


