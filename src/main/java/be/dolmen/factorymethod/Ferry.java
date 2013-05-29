package be.dolmen.factorymethod;

import java.io.*;

class Ferry
{
  public static final int PASSENGER_COST = 5;
  public static final int VEHICLE_COST = 50;
  
  private Vehicle[] vehicles;
  private int count;
  private int noBerths;

  public Ferry(int n)
  {
    vehicles = new Vehicle[n];
    count = 0;
    noBerths = n;
  }

  public boolean addVehicle(Vehicle v)
  {
    if (v.getSize() > this.spaceLeft())
      return false;
    else
    {
      vehicles[count] = v;
      count++;
      return true;
    }
  }

  public int spaceLeft()
  {
    int total = 0;
    for (int i=0; i<count; i++)
      total = total + vehicles[i].getSize();
    return noBerths - total;
  }

  public void emptyFerry()
  {
     count = 0;
  }

  public void save() throws Exception
  {
    File f = new File("vehicles.txt");
    FileWriter fout = new FileWriter(f);
    PrintWriter pout = new PrintWriter(fout);
    for (int i=0; (i < count); i++)
    {
      pout.println(vehicles[i].getRegNo()+" "+vehicles[i].getSize()+" "
                    +vehicles[i].getNoPass()+" £"+vehicles[i].getCost());
    }
    fout.close();  
  }

}
