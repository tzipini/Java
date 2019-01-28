package primitives;

public class Material {
	private double Kd; // Diffusion attenuation coefficient
	private double Ks; // Secular attenuation coefficient
	private double nShininess;

	// ***************** Constructors ********************** //

	public Material() {
		setKd(0.01);
		setKs(0.01);
		setnShininess(1);
	}

	public Material(Material material) {
		setKd(material.Kd);
		setKs(material.Ks);
		setnShininess(material.nShininess);
	}

	// ***************** Getters/Setters ********************** //
	public double getKd() {
		return Kd;
	}

	public void setKd(double Kd) {
		this.Kd = Kd;
	}

	public double getKs() {
		return Ks;
	}

	public void setKs(double ks) {
		Ks = ks;
	}

	public double getnShininess() {
		return nShininess;
	}

	public void setnShininess(double nShininess) {
		this.nShininess = nShininess;
	}

}
