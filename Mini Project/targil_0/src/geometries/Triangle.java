package geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Triangle extends Geometry implements FlatGeometry {
	private Point3D p1;
	private Point3D p2;
	private Point3D p3;

	// ***************** Constructors ********************** //
	public Triangle() {
		super();
		p1 = new Point3D();
		p2 = new Point3D();
		p3 = new Point3D();
	}

	public Triangle(Triangle triangle) {
		super(triangle.emmission);
		this.p1 = new Point3D(triangle.getP1());
		this.p2 = new Point3D(triangle.getP2());
		this.p3 = new Point3D(triangle.getP3());
	}

	public Triangle(Point3D p1, Point3D p2, Point3D p3, Color emmission) {
		super(emmission);
		this.p1 = new Point3D(p1);
		this.p2 = new Point3D(p2);
		this.p3 = new Point3D(p3);
	}

	public Triangle(Point3D p1, Point3D p2, Point3D p3) {
		this.emmission = new Color(0, 0, 0);
		this.p1 = new Point3D(p1);
		this.p2 = new Point3D(p2);
		this.p3 = new Point3D(p3);
	}

	// ***************** Getters/Setters ********************** //
	public Point3D getP1() {
		return new Point3D(p1);
	}

	public void setP1(Point3D p1) {
		this.p1 = p1;
	}

	public Point3D getP2() {
		return new Point3D(p2);
	}

	public void setP2(Point3D p2) {
		this.p2 = p2;
	}

	public Point3D getP3() {
		return new Point3D(p3);
	}

	public void setP3(Point3D p3) {
		this.p3 = p3;
	}

	// ***************** Administration ******************** //
	@Override
	public String toString() {
		return "P1: " + p1 + " P2: " + p2 + " P3: " + p3;
	}

	// ***************** Operations ******************** //
	public Vector getNormal(Point3D point) throws Exception {
		Vector U = new Vector(p2);
		Vector V = new Vector(p3);
		U.getHead().subtract(p1);
		V.getHead().subtract(p1);
		Vector uProductV = new Vector(U.crossProduct(V));
		uProductV.normalize();
		// uProductV.scale(-1);//לשאול
		return uProductV;
	}

	public List<Point3D> FindIntersections(Ray ray) throws Exception {

		Vector N = new Vector(getNormal(null));
		Plane plane = new Plane(N, p1);
		if (plane.FindIntersections(ray).size() == 0) {
			return plane.FindIntersections(ray);
		}

		Point3D p = new Point3D(plane.FindIntersections(ray).get(0));

		Point3D T1 = new Point3D(p1);
		Point3D T2 = new Point3D(p2);
		Point3D T3 = new Point3D(p3);

		T1.subtract(ray.getPoo());
		T2.subtract(ray.getPoo());
		T3.subtract(ray.getPoo());

		Vector v1 = new Vector(T1);// v1=T1-p0
		Vector v2 = new Vector(T2);// v2=T2-p0
		Vector v3 = new Vector(T3);// v3=T3-p0

		/*
		 * Vector N1=new Vector(v1.crossProduct(v2)); N1.normalize(); Vector
		 * N2=new Vector(v2.crossProduct(v3)); N2.normalize(); Vector N3=new
		 * Vector(v3.crossProduct(v1)); N3.normalize();
		 */

		Vector N1 = new Vector(v2.crossProduct(v1));
		N1.normalize();
		Vector N2 = new Vector(v1.crossProduct(v3));
		N2.normalize();
		Vector N3 = new Vector(v3.crossProduct(v2));
		N3.normalize();

		Point3D pTemp = new Point3D(p);
		pTemp.subtract(ray.getPoo());
		Vector p_p0 = new Vector(pTemp);
		double s1 = p_p0.dotProduct(N1);
		double s2 = p_p0.dotProduct(N2);
		double s3 = p_p0.dotProduct(N3);
		ArrayList<Point3D> IntersectionsList = new ArrayList<Point3D>();
		ArrayList<Point3D> IntersectionsList2 = new ArrayList<Point3D>();
		if (s1 >= 0 && s2 >= 0 && s3 >= 0 || s1 <= 0 && s2 <= 0 && s3 <= 0) {

			IntersectionsList.add(p);
			return IntersectionsList;

		}
		return IntersectionsList2;
	}
}
