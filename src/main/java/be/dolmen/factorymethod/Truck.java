package be.dolmen.factorymethod;

// CONCRETE PRODUCT
class Truck extends Vehicle {

    protected int berths;

    public Truck(int p, String r, int b) {
        super(p, r);
        berths = b;
    }

    @Override
    public int getSize() {
        return berths;
    }

    @Override
    public int getCost() {
        return ((getSize() * Ferry.VEHICLE_COST) + (Ferry.PASSENGER_COST * noPassengers));
    }

}
