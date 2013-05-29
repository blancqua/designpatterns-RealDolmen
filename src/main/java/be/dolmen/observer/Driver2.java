package be.dolmen.observer;

class Driver2 {
  public static void main(String args[]) throws InterruptedException{
      Person p = new Person();
      p.setForename("Fred");
      p.setSurname("Bloggs");
      p.setAge(23);
      PDemoSwing pfr = new PDemoSwing("Person GUI");
      //PDemoSwing pfr = new PDemoSwing("Person GUI",p);
      pfr.setLocation(200,200);
      pfr.setVisible(true);
      AgeSlider asl = new AgeSlider("Person Age",p);
      asl.setLocation(400,400);
      asl.setVisible(true);
      System.out.println("Slight delay - then change the age");
      Thread.sleep(2000);
      p.setAge(32);
      System.out.println("Slight delay - then change the forename");
      Thread.sleep(2000);
      p.setForename("Freda");
      System.out.println("Slight delay - then change the surname");
      Thread.sleep(2000);
      p.setSurname("Bloggetta");
  }
}

