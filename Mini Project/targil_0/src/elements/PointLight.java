package elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light implements LightSource {
	protected Point3D position;
	protected double Kc;
	protected double Kj;
	protected double Kq;

	public PointLight() {
		// color=color.black;
		position = new Point3D();
		Kc = 0.01;
		Kj = 0.01;
		Kq = 0.01;
	}

	public PointLight(Color color, Point3D position, double kc, double kj, double kq) {
		this.color = color;
		this.position = new Point3D(position);
		this.Kc = kc;
		this.Kj = kj;
		this.Kq = kq;
	}

	public Point3D getPosition() {
		return position;
	}

	public void setPosition(Point3D position) {
		this.position = position;
	}

	public double getKc() {
		return Kc;
	}

	public void setKc(double kc) {
		Kc = kc;
	}

	public double getKj() {
		return Kj;
	}

	public void setKj(double kj) {
		Kj = kj;
	}

	public double getKq() {
		return Kq;
	}

	public void setKq(double kq) {
		Kq = kq;
	}

	@Override
	public Color getIntensity() {
		return color;
	}

	public Color getIntensity(Point3D point) {
		
		double d = getPosition().distance(point);
		double K = (getKc()+ getKj() *d + getKq() * Math.pow(d, 2));
		if(K<0)
			K*=-1;
		return new Color(((int) (color.getRed() / K)), ((int) (color.getGreen() / K)), ((int) (color.getBlue() / K)));
	}

	@Override
	public Vector getL(Point3D p) {
		// TODO Auto-generated method stub
		Vector L = new Vector(position);
		L.getHead().subtract(p);
		return L;
	}
}
