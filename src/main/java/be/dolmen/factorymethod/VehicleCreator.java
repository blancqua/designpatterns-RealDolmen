package be.dolmen.factorymethod;

import static be.dolmen.factorymethod.VehicleType.CAR;

// CONCRETE CREATOR
public class VehicleCreator {

    public Vehicle create(VehicleType vehicleType, int noPass, String reg, int berths) {
		if (CAR.equals(vehicleType)) {
			return new Vehicle(noPass, reg);
		}
		return new Truck(noPass, reg, berths);
	}

}
