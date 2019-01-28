package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Camera {
	private Point3D P0;
	private Vector vUp;
	private Vector vToward;
    private	Vector vRight;
	// ***************** Constructors ********************** //
	public Camera(){	
      setP0(new Point3D(0,0,0));
      setvUp(new Vector(0,1,0));
      setvToward(new Vector(0,0,-1));
      setvRight(new Vector(getvToward().crossProduct(getvUp())));

	}
	public Camera (Camera camera){
		this.P0=new Point3D(camera.getP0());
		this.vUp=new Vector(camera.getvUp());
		this.vRight=new Vector(camera.getvRight());
		this.vToward=new Vector(camera.getvToward());
	}
	public Camera (Point3D P0, Vector vUp,Vector vToward ){
		this.P0=new Point3D(P0);
		this.vUp=new Vector(vUp);
		this.vToward=new Vector(vToward);
		this.vRight=new Vector(vToward.crossProduct(vUp));
			
	}
	// ***************** Getters/Setters ********************** //
	public Point3D getP0() {
		return P0;
	}
	public void setP0(Point3D p0) {
		P0 = p0;
	}
	public Vector getvUp() {
		return vUp;
	}
	public void setvUp(Vector vUp) {
		this.vUp = vUp;
	}
	public Vector getvRight() {
		return vRight;
	}
	public void setvRight(Vector vRight) {
		this.vRight = vRight;
	}
	public Vector getvToward() {
		return vToward;
	}
	public void setvToward(Vector vToward) {
		this.vToward = vToward;
	}
	// ***************** Administration ********************** //
	@Override
	public String toString(){
		return "Vto: "   + vToward + "\n" +   "Vup: "   + vUp + "\n" +  "Vright:" + vRight  +  ".";   
	}
	// ***************** Operations ******************** //

	public Ray constructRayThroughPixel(int Nx, int Ny, double x, double y,double screenDist, double screenWidt, double screenHeight){
	 Point3D pc= new Point3D(P0);
	 Vector vTo=new Vector(vToward);
	 vTo.scale(screenDist);
	 pc.add(vTo.getHead());
	 double Rx=screenWidt/Nx;
	 double Ry=screenHeight/Ny;
	 Vector v_Right=new Vector(vRight);
	 v_Right.scale((x-Nx/2.0)*Rx + Rx/2.0);
	 Vector v_Up=new Vector(vUp);
	 v_Up.scale((y-Ny/2.0)*Ry + Ry/2.0);
	 v_Right.subtract(v_Up);
	 Point3D P= new Point3D(pc);
	 P.add(v_Right.getHead());
	// System.out.println("Point"+P);
	 Point3D other_p=new Point3D(P);
	 other_p.subtract(P0);
	 Vector vector=new Vector(other_p);
	 try {
		vector.normalize();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 Ray ray= new Ray(P, vector);
		return ray;
	 }
	
}
