package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource {
  private Vector dirction;
  
  
   public DirectionalLight() {
	   this.color=Color.BLACK;
	   this.dirction=new Vector();
   }
	public DirectionalLight(Color color,Vector dirction){
		this.color=color;
		this.dirction=new Vector(dirction);
		
	}
	public Vector getDirction() {
		return dirction;
	}
	public void setDirction(Vector dirction) {
		this.dirction = dirction;
	}
	@Override
	public Color getIntensity() {
		return color;
	}
	public Color getIntensity(Point3D point) {
		return color;
	}
	@Override
	public Vector getL(Point3D p) {
			// TODO Auto-generated method stub
			Vector L = new Vector(dirction);
			L.getHead().subtract(p);
			return L;
	}

}
