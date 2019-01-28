package geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Sphere extends RadialGeometry {
	private Point3D center;

	// ***************** Constructors ********************** //
	public Sphere() {
		super();
		center = new Point3D();
	}

	public Sphere(Sphere sphere) {
		super(sphere.radius, sphere.emmission);
		this.center = new Point3D(sphere.getCenter());
	}

	public Sphere(double radius, Point3D center, Color emmission) {
		super(radius, emmission);
		this.center = new Point3D(center);
	}

	public Sphere(double radius, Point3D center) {
		this.radius = radius;
		this.center = new Point3D(center);
		this.emmission = Color.BLACK;
	}

	// ***************** Getters/Setters ********************** //
	public Point3D getCenter() {
		return new Point3D(center);
	}

	public void setCenter(Point3D center) {
		this.center = center;
	}

	// ***************** Operations ******************** //
	public Vector getNormal(Point3D point) throws Exception {
		Vector vector = new Vector(center);
		Vector vector1 = new Vector(point);
		vector1.subtract(vector);
		vector1.normalize();
		return vector1;
	}

	@Override
	public List<Point3D> FindIntersections(Ray ray) {
		ArrayList<Point3D> IntersectionsList = new ArrayList<Point3D>();
		Vector L = new Vector(center);
		L.getHead().subtract(ray.getPoo());
		double tm = L.dotProduct(ray.getDirection());
		double d = Math.sqrt(Math.pow(L.length(), 2) - Math.pow(tm, 2));

		if (radius < d) {
			return IntersectionsList;
		}
		Vector po=new Vector(ray.getPoo());
		po.add(ray.getDirection());
		po.scale(tm);

	    if (d==radius)
	    {
	    	    IntersectionsList.add(po.getHead());
	            return IntersectionsList;
	        }
		  double th = Math.sqrt(Math.pow(radius, 2) - Math.pow(d, 2));
		  double t1 = tm - th;
		  double t2 = tm + th;
		if (t1 > 0) {
			Point3D P1 = new Point3D(ray.getPoo());
			Vector v1 = new Vector(ray.getDirection());
			v1.scale(t1);
			P1.add(v1.getHead());
			IntersectionsList.add(P1);
		}
		if (t2 > 0) {
			Point3D P2 = new Point3D(ray.getPoo());
			Vector v2 = new Vector(ray.getDirection());
			v2.scale(t2);
			P2.add(v2.getHead());
			IntersectionsList.add(P2);
		}
		return IntersectionsList;
	}
}
