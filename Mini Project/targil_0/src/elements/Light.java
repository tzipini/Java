package elements;

import java.awt.Color;

import primitives.Point3D;

public abstract class Light {
	protected Color color;

// ***************** Getters/Setters ********************** //
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

// ***************** Operations ******************** //
	public abstract Color getIntensity();
}
