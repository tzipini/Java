package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class SpotLight extends PointLight {
	private Vector direction;

	public SpotLight() {
		super();
		this.setDirection(new Vector());

	}

	public SpotLight(Color color, Vector dirction, Point3D position, double kc, double kj, double kq) {
		super(color, position, kc, kj, kq);
		this.setDirection(new Vector(dirction));
	}

	public Vector getDirection() {
		return direction;
	}

	public void setDirection(Vector direction) {
		this.direction = direction;
	}
	public Color getIntensity() {
	  return color;
	}
	
	@Override
	// לבדוק לא גמור!!
	public Color getIntensity(Point3D point) {
		double d = getPosition().distance(point);
		double K = direction.dotProduct(getL(point)) / (getKc() + getKj() * d + getKq() * Math.pow(d, 2));
		if(K<0)
			K*=-1;
		int r = (int)(color.getRed()*K);
		int g = (int)(color.getGreen()*K);
		int b = (int)(color.getBlue()*K);
		if (r > 255)
			r = 255;
		if (g > 255)
			g = 255;
		if (b > 255)
			b = 255;	
		return new Color(r,g,b);
	}
}
