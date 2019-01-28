
package geometries;

import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends RadialGeometry{
	private Point3D axisPoint;
	private Vector axisDirection;
	// ***************** Constructors ********************** //
	public Cylinder(){
		super();
		axisPoint=new Point3D();
		axisDirection=new Vector();
	}
	public Cylinder(Cylinder cylinder){
		this.radius=cylinder.radius;
		this.axisDirection=new Vector(cylinder.getAxisDirection());
		this.axisPoint=new Point3D(cylinder.getAxisPoint());
	}
	public Cylinder(double radius, Point3D axisPoint, Vector axisDirection){
		this.radius=radius;
		this.axisDirection=new Vector(axisDirection);
		this.axisPoint=new Point3D(axisPoint);
	}
	// ***************** Getters/Setters ********************** //
	public Point3D getAxisPoint() {
		return axisPoint;
	}
	public void setAxisPoint(Point3D axisPoint) {
		this.axisPoint = axisPoint;
	}
	public Vector getAxisDirection() {
		return axisDirection;
	}
	public void setAxisDirection(Vector axisDirection) {
		this.axisDirection = axisDirection;
	}
	// ***************** Operations ******************** //
	public Vector getNormal(Point3D point)throws Exception{
		return axisDirection;
	}
	public List<Point3D> FindIntersections(Ray ray){
		return null;	
	}

}
