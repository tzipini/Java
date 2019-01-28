package primitives;

public class Point3D extends Point2D {

	private Coordinate z;

	// ***************** Constructors ********************** //
	public Point3D() {
		super();
		z = new Coordinate();
	}

	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		super(x, y);
		this.z = new Coordinate(z);

	}

	public Point3D(double x, double y, double z) {
		super(x, y);
		this.z = new Coordinate(z);
	}

	public Point3D(Point3D point3D) {
		super(point3D.getX(), point3D.getY());
		this.z = new Coordinate(point3D.z);
	}

	// ***************** Getters/Setters ********************** //
	public Coordinate getZ() {
		return z;
	}

	public void setZ(Coordinate z) {
		this.z = z;
	}

	// ***************** Administration ******************** //
	public int compareTo(Point3D point3D) {
		if ((super.compareTo(point3D) == 0) && (this.getZ().compareTo(point3D.getZ()) == 0))
			return 0;
		else
			return -1;
		// return z.compareTo(point3D.getZ()==0)
	}

	@Override
	public String toString() {
		return super.toString() + "Z:" + z;
	}

	// ***************** Operations ******************** //
	public void add(Point3D point3D) {

		this.getX().setCoordinate(this.getX().getCoordinate() + point3D.getX().getCoordinate());
		this.getY().setCoordinate(this.getY().getCoordinate() + point3D.getY().getCoordinate());
		this.z.setCoordinate(this.z.getCoordinate() + point3D.z.getCoordinate());
	}

	public void subtract(Point3D point3D) {

		this.getX().setCoordinate(this.getX().getCoordinate() - point3D.getX().getCoordinate());
		this.getY().setCoordinate(this.getY().getCoordinate() - point3D.getY().getCoordinate());
		this.z.setCoordinate(this.z.getCoordinate() - point3D.z.getCoordinate());
	}

	public double distance(Point3D point3D) {
		return Math.pow(Math.pow(this.getX().getCoordinate() - point3D.getX().getCoordinate(), 2)
				+ Math.pow(this.getY().getCoordinate() - point3D.getY().getCoordinate(), 2)
				+ Math.pow(this.z.getCoordinate() - point3D.z.getCoordinate(), 2), 0.5);
	}

	public void mult(double s) {
		x.setCoordinate(x.getCoordinate() * s);
		y.setCoordinate(y.getCoordinate() * s);
		z.setCoordinate(z.getCoordinate() * s);
	}
}
