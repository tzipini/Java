package primitives;

public class Ray implements Comparable<Ray> {
	private Point3D poo;
	// Ray direction
	private Vector direction;
	// ***************** Constructors ********************** //
	public Ray(){
		poo=new Point3D();
		// Ray direction
	    direction=new Vector();
	}
	public Ray(Ray ray){
		this.poo=new Point3D(ray.getPoo());
		this.direction=new Vector(ray.getDirection());
	}
	public Ray(Point3D poo, Vector direction){
		 this.poo=new Point3D(poo);
		 this.direction=new Vector(direction);
	}
	// ***************** Getters/Setters ********************** //
	public Point3D getPoo() {
		return poo;
	}
	public void setPoo(Point3D poo) {
		this.poo = poo;
	}
	public Vector getDirection() {
		return direction;
	}
	public void setDirection(Vector direction) {
		this.direction = direction;
	}
	public int compareTo(Ray ray) {
		// TODO Auto-generated method stub
		if(this.poo.compareTo(ray.poo)==0 &&this.direction.compareTo(ray.direction)==0)
		return 0;
		else
			return -1;
	
	}
	@Override
	  public String toString(){
	    	return "Point"+poo+"Direction"+direction;
	    }

}
