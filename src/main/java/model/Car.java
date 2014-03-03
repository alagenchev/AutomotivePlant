package model;

public class Car {
	
	private String color;
	
	private Wheel[] wheels;

	public Wheel[] getWheels() {
		return wheels;
	}

	public void setWheels(Wheel[] wheels) {
		this.wheels = wheels;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
