package elements;

import java.awt.Color;
import java.awt.color.ColorSpace;

import primitives.Point3D;

public class AmbientLight extends Light {
	private double Ka;
// ***************** Constructors ********************** // 
	public AmbientLight() {
		color = new Color(255,255,255);
		Ka = 0.1;
	}

	public AmbientLight(Color color,double ka) {
	   this.setColor(color);
	   this.setKa(ka);
	}
	public AmbientLight(AmbientLight ambientLight) {
	   this.setColor(ambientLight.color);
	   this.setKa(ambientLight.Ka);
	}
	public AmbientLight(int r,int g,int b) {
		   this.color = new Color(r,g,b);
		   this.setKa(0.1);
		}
// ***************** Getters/Setters ********************** //
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getKa() {
		return Ka;
	}

	public void setKa(double ka) {
		Ka = ka;
	}
// ***************** Operations ******************** //
	public Color getIntensity(){
		return new Color(((int)(color.getRed()*Ka)),((int)(color.getGreen()*Ka)),((int)(color.getBlue()*Ka)));
		  
  }


	

}
