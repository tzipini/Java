package geometries;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public abstract class RadialGeometry extends Geometry {
	protected double radius;
	// ***************** Constructors ********************** //
	public RadialGeometry(){
		radius=0;
		this.emmission=new Color(0,0,0);
	}
	public RadialGeometry(double radius,Color emmission){
		this.setRadius(radius);
		this.emmission=emmission;
	}
	// ***************** Getters/Setters ********************** //
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public abstract Vector getNormal(Point3D point) throws Exception;

	
}
