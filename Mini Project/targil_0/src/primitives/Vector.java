package primitives;

public class Vector implements Comparable<Vector>  {
	
	private Point3D head;
	
// ***************** Constructors ********************** //	
	public Vector(){
		head=new Point3D();
	}
	public Vector(Point3D head){
		this.head=new Point3D(head);
		
	}
	public Vector(Vector vector){
		this.head=new Point3D(vector.head);		
	}
	public Vector(double xHead,  double yHead, double zHead){
		
		this.head=new Point3D(xHead,yHead,zHead);	
	}
// ***************** Getters/Setters ********************** //
	public Point3D getHead() {
		return head;
	}
	public void setHead(Point3D head) {
		this.head = head;
	}
// ***************** Administration ******************** // 
    public int compareTo(Vector vector){
       return this.head.compareTo(vector.getHead()); 
    
    }
    @Override
    public String toString(){
    	return "Point"+this.head;
    }
// ***************** Operations ******************** // 
    public void add (Vector vector ){
    	
    	this.head.add(vector.head);
    }
    public void subtract (Vector vector){
    	this.head.subtract(vector.head);
    }
    public void scale(double scalar){
    	this.head.setX(new Coordinate(head.getX().getCoordinate()*scalar));
    	this.head.setY(new Coordinate(head.getY().getCoordinate()*scalar));
    	this.head.setZ(new Coordinate(head.getZ().getCoordinate()*scalar));
    }
    public double dotProduct(Vector vector){
    	double x=this.head.getX().getCoordinate()*vector.head.getX().getCoordinate();
        double y=this.head.getY().getCoordinate()*vector.head.getY().getCoordinate();
    	double z=this.head.getZ().getCoordinate()*vector.head.getZ().getCoordinate();
        return x+y+z;
    }
    public Vector crossProduct(Vector vec){
    	Vector vector=new Vector();  
    	vector.head.setY(new Coordinate(-(this.head.getX().getCoordinate()*vec.head.getZ().getCoordinate()-this.head.getZ().getCoordinate()*vec.head.getX().getCoordinate())));
    	vector.head.setZ(new Coordinate(this.head.getX().getCoordinate()*vec.head.getY().getCoordinate()-this.head.getY().getCoordinate()*vec.head.getX().getCoordinate()));
    	vector.head.setX(new Coordinate(this.head.getY().getCoordinate()*vec.head.getZ().getCoordinate()-this.head.getZ().getCoordinate()*vec.head.getY().getCoordinate()));
    	return vector;
    }
    
    public double length(){
    	return Math.pow( Math.pow(this.head.getX().getCoordinate(), 2)+Math.pow(this.head.getY().getCoordinate(), 2)+Math.pow(this.head.getZ().getCoordinate(), 2), 0.5);
    }
    public void normalize()throws Exception{
    	 double length=this.length();
    	if(length==0)
    	{
    	   throw new Exception("you can'nt dinide by zero");
    	   
    	}
    	else
    	{
       	   this.head.getX().setCoordinate(head.getX().getCoordinate()/length);
    	   this.head.getY().setCoordinate(head.getY().getCoordinate()/length);
    	   this.head.getZ().setCoordinate(head.getZ().getCoordinate()/length);
    	}
    }
}
	
