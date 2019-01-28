package primitives;

public class Point2D implements Comparable<Point2D> {
	protected Coordinate x;
	protected Coordinate y;

	// ***************** Constructors ********************** //
	public Point2D() {

		x = new Coordinate();
		y = new Coordinate();
	}

	public Point2D(double x, double y) {
		this.x = new Coordinate(x);
		this.y = new Coordinate(y);
	}

	public Point2D(Coordinate x, Coordinate y) {
		this.x = new Coordinate(x);
		this.y = new Coordinate(y);
	}

	public Point2D(Point2D point2D) {
		this.x = new Coordinate(point2D.x);
		this.y = new Coordinate(point2D.y);
	}

	// ***************** Getters/Setters ********************** //
	public Coordinate getX() {
		return x;
	}

	public void setX(Coordinate x) {
		this.x = x;
	}

	public Coordinate getY() {
		return y;
	}

	public void setY(Coordinate y) {
		this.y = y;
	}

	// ***************** Administration ******************** //
	public int compareTo(Point2D point2D) {
		if ((this.x.compareTo(point2D.x) == 0) && (this.y.compareTo(point2D.y) == 0))
			return 0;
		else
			return -1;
	}

	@Override
	public String toString() {
		return "X:" + x + "Y:" + y;
	}
}
