package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Car;
import model.Wheel;

@Service
public class CarFactory {
	
	@Autowired
	private WheelFactory wheelFactory;
	
	public Car BuildCar() {
		Car newCar = new Car();
		newCar.setColor("Red");
		
		Wheel[] wheels = wheelFactory.BuildWheels();
		newCar.setWheels(wheels);
		return newCar;
	}
}
