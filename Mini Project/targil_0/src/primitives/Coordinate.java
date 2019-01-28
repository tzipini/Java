package primitives;

public class Coordinate implements Comparable<Coordinate> {
	private double coordinate;

	// ***************** Constructors ********************** //
	public Coordinate() {
		coordinate = 0;
	}

	public Coordinate(double coordinate) {
		this.setCoordinate(coordinate);
	}

	public Coordinate(Coordinate coord) {
		setCoordinate(coord.getCoordinate());
	}

	// ***************** Getters/Setters ********************** //
	public double getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(double coordinate) {
		this.coordinate = coordinate;
	}

	// ***************** Administration ******************** //
	public int compareTo(Coordinate coord) {
		if (this.getCoordinate() == coord.getCoordinate())
			return 0;
		if (this.getCoordinate() < coord.getCoordinate())
			return -1;
		else
			return 1;
	}

	public String toString() {
		return coordinate + " ";
	}

	// ***************** Operations ******************** //
	public void add(Coordinate coord) {
		this.setCoordinate(this.getCoordinate() + coord.getCoordinate());
	}

	public void subtract(Coordinate coord) {
		this.setCoordinate(this.getCoordinate() - coord.getCoordinate());
	}
}
