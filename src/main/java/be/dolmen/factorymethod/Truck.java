package be.dolmen.factorymethod;

class Truck extends Vehicle
{ 

  protected int berths;
  
  public Truck(int p, String r, int b)
  {
    super(p, r);
    berths = b ;
  }

  public int getSize()
  {
    return berths;
  }

  public int getCost()
  {
    return ((getSize() * Ferry.VEHICLE_COST) + 
              (Ferry.PASSENGER_COST * noPassengers));
  }
    
}
