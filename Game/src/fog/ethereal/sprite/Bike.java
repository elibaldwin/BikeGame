package fog.ethereal.sprite;

import java.awt.Point;
import java.io.FileNotFoundException;

import javafx.scene.layout.Pane;
import fog.ethereal.util.Translation;
import fog.ethereal.util.WorldObject;

public class Bike implements WorldObject{
	public static final Point FRONT_WHEEL_POS = new Point(183, 88);
	public static final Point BACK_WHEEL_POS = new Point(34, 88);
	private Frame frame;
	private Wheel front, back;
	private int bikeType;
	private double rot;
	private double rotV;
	private boolean accel, brake, right, left;
	
	public Bike(int type) {
		bikeType = type;
		rot = 0;
		rotV = 0;
		try {
			frame = new Frame(1, this);
			front = new Wheel(1, this, Wheel.FRONT);
			front.setCenter(FRONT_WHEEL_POS);
			back = new Wheel(1, this, Wheel.BACK);
			back.setCenter(BACK_WHEEL_POS);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Translation t) {
		updateRotation();
		frame.update(t);
		front.update(t.move((int)FRONT_WHEEL_POS.getX(), (int)FRONT_WHEEL_POS.getY()));
		back.update(t.move((int)BACK_WHEEL_POS.getX(), (int)BACK_WHEEL_POS.getY()));
	}
	
	public double getRot() {
		return rot;
	}
	
	public void updateRotation() {
		
	}
	
	public void setAccel(boolean accel) {
		this.accel = accel;
	}
	
	public void setBrake(boolean brake) {
		this.brake = brake;
	}
	
	public void setRight(boolean right) {
		this.right = right;
	}
	
	public void setLeft(boolean left) {
		this.left = left;
	}
	
	public boolean getAccel() {
		return accel;
	}
	
	public boolean getBrake() {
		return brake;
	}
	
	public boolean getRight() {
		return right;
	}
	
	public boolean getLeft() {
		return left;
	}
	
	public void addTo(Pane parent) {
		parent.getChildren().addAll(front, back, frame);
	}
}
