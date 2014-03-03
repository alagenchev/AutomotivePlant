package services;

import org.springframework.stereotype.Service;

import model.Wheel;

@Service
public class WheelFactory {
	private Wheel buildWheel(int size) {
		Wheel wheel = new Wheel(size);
		return wheel;
	}
	
	public Wheel[] BuildWheels(){
		Wheel newWheel4 = buildWheel(4);
		Wheel newWheel3 = buildWheel(3);
		Wheel newWheel2 = buildWheel(2);
		Wheel newWheel1 = buildWheel(1);
		
		Wheel[] wheels = new Wheel[]{newWheel1, newWheel2, newWheel3, newWheel4};
		
		return wheels;
	}
}
