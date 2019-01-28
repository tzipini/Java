package geometries ;
import java.awt.Color;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public abstract class Geometry {
	protected Material material;
	protected Color emmission ;
	
	// ***************** Getters/Setters ********************** // 
	public Geometry(){
		material = new Material();
		this.emmission = new Color(0, 0, 0);
	}
	public Geometry(Color emmission){
		material = new Material();
		this.emmission = emmission;
	}
	public Color getEmmission() {
		return emmission;
	}

	public void setEmmission(Color emmission) {
		this.emmission = emmission;
	}
	public abstract Vector getNormal(Point3D point) throws Exception;

	public abstract List<Point3D> FindIntersections (Ray ray) throws Exception;
	
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	
}
