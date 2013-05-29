package be.dolmen.factorymethod;

public enum VehicleType {

	CAR("Car"),
	TRUCK("Truck");
	
	private final String label;

	private VehicleType(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
	public static VehicleType withLabel(String label) {
		for (VehicleType vehicleType : values()) {
			if (label.equals(vehicleType.getLabel())) {
				return vehicleType;
			}
		}
		
		throw new IllegalArgumentException("No Vehicle with given type " + label);
	}
	
}
