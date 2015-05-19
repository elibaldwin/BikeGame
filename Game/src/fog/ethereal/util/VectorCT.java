package fog.ethereal.util;
/**
 * Vector for cartesian coordinate system; 
 * origin(0, 0) as 'tail' of vector with (x, y) coordinates of head.
 */
public class VectorCT {
	private double x;
	private double y;
	
	public VectorCT(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public static VectorMD toMD(VectorCT ct) {
		double m;
		double d;
		m = Math.sqrt(ct.getX() * ct.getX() + ct.getY() * ct.getY());
		d = Math.toRadians(Math.atan2(ct.getX(), ct.getY()));
		VectorMD md = new VectorMD(m, d);
		return md;
	}
	
	public VectorCT subtract(VectorCT other) {
		return new VectorCT(other.getX() - x, other.getY() - y);
	}
	
	public VectorCT unit() {
		double scal = Math.sqrt(x * x + y * y);
		double newx = x / scal;
		double newy = y / scal;
		return new VectorCT(newx, newy);
	}
	
	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double dot(VectorCT other) {
		return x * other.getX() + y * other.getY();
	}
	
	public void mult(double scalar) {
		x *= scalar;
		y *= scalar;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}
