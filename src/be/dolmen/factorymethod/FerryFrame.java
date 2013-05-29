package be.dolmen.factorymethod;

import java.awt.*;
import java.awt.event.*;

public class FerryFrame extends Frame implements ActionListener, ItemListener
{
  protected Button newVehicle, costButton;
  protected TextField regNo;
  protected Panel panel1,panel2, panel3, panel4, panel5, panel6;
  protected Label spacesLabel, typeLabel, costLabel;
  protected Label regLabel, passLabel, berthsLabel, warning;

  Choice passChoice, berthsChoice;

  CheckboxGroup cbg;
  Checkbox[] checkboxes;

  protected MenuBar menubar1;
  protected Menu menu1;
  protected MenuItem quit;
  protected MenuItem empty;
  protected MenuItem save;

  private Ferry theFerry;

  public FerryFrame(String title, Ferry f)
  {
    super(title);

    theFerry = f;

    menubar1 = new MenuBar();

    setMenuBar(menubar1);

    menu1 = new Menu("Control");

    quit = new MenuItem("Quit");
    quit.addActionListener(this);
    menu1.add(quit);

    empty = new MenuItem("Empty");
    empty.addActionListener(this);
    menu1.add(empty);

    save = new MenuItem("Save");
    save.addActionListener(this);
    menu1.add(save);

    menubar1.add(menu1);

    newVehicle = new Button("Add Vehicle");
    newVehicle.addActionListener(this);

    costButton = new Button("Calculate Cost");
    costButton.addActionListener(this);

    spacesLabel = new Label("Spaces left: " + theFerry.spaceLeft());
    typeLabel = new Label("Type of Vehicle: ");
    costLabel = new Label("Cost is: ");
    regLabel = new Label("Vehicle Registration: ");
    passLabel = new Label("Number of Passengers: ");
    warning = new Label("                 ");
    berthsLabel = new Label("Number of Spaces: ");
    regNo = new TextField(10);
    regNo.addActionListener(this);

    cbg = new CheckboxGroup(); // to make them mutually exclusive
    checkboxes = new Checkbox[2];
    checkboxes[0] = new Checkbox("Car", cbg, true);
    checkboxes[1] = new Checkbox("Truck", cbg, false);

    for (int i = 0 ; i <= 1 ; i++)
       checkboxes[i].addItemListener(this);

    passChoice = new Choice();
    passChoice.addItem("1");
    passChoice.addItem("2");
    passChoice.addItem("3");
    passChoice.addItem("4");
    passChoice.addItemListener(this);

    berthsChoice = new Choice();
    berthsChoice.addItem("2");
    berthsChoice.addItem("3");
    berthsChoice.addItemListener(this);

    panel1 = new Panel();
    panel1.setLayout(new GridLayout(9,1)); 

    panel2 = new Panel();
    panel2.setLayout(new GridLayout(1,2));
    panel2.add(passLabel);
    panel2.add(passChoice);

    panel3 = new Panel();
    panel3.setLayout(new GridLayout(1,2));
    panel3.add(berthsLabel);
    panel3.add(berthsChoice);

    panel5 = new Panel();
    panel5.setLayout(new GridLayout(1,2));
    panel5.add(costLabel);
    panel5.add(costButton);
   
    panel6 = new Panel();
    panel6.setLayout(new GridLayout(1,2));
    panel6.add(regLabel);
    panel6.add(regNo);    

    panel1.add(spacesLabel);
    panel1.add(typeLabel);
    panel1.add(checkboxes[0]);
    panel1.add(checkboxes[1]);
    panel1.add(panel6);
    panel1.add(panel2);
    panel1.add(panel3);
    panel1.add(warning);
    panel1.add(panel5);

    panel4 = new Panel();
    panel4.add(newVehicle);

    this.add("West",panel1);
    this.add("South",panel4);
    this.pack();
    
  }

  public void actionPerformed(ActionEvent event)
  {
     if (event.getSource() == newVehicle)
     {
       Vehicle v = null;
       boolean added = false;
       int berths = 0;
       // get details and add a vehicle
       String reg = regNo.getText();
       int noPass = Integer.parseInt(passChoice.getSelectedItem());

       if (cbg.getSelectedCheckbox() == checkboxes[0])
       {
         v = new Vehicle(noPass, reg);
         added = theFerry.addVehicle(v);
       }
       else
       {
         berths = Integer.parseInt(berthsChoice.getSelectedItem());
         v = new Truck(noPass, reg, berths);
         added = theFerry.addVehicle(v);
       }
       if (added)
         warning.setText("Vehicle added successfully");
       else
         warning.setText("Not added - not enough room");

       spacesLabel.setText("Spaces left: "+theFerry.spaceLeft());
       cbg.setSelectedCheckbox(checkboxes[0]);
       passChoice.select(0);
       berthsChoice.select(0);
       costLabel.setText("Cost is: ");
     }
     else if (event.getSource() == costButton)
     {
       Vehicle v = null;
       int berths = 0;
       int cost = 0;
       // get details to cost vehicle
       String reg = regNo.getText();
       int noPass = Integer.parseInt(passChoice.getSelectedItem());

       if (cbg.getSelectedCheckbox() == checkboxes[0])
       {
         v = new Vehicle(noPass, reg);
         costLabel.setText("Cost is: £"+v.getCost());
       }
       else
       {
         berths = Integer.parseInt(berthsChoice.getSelectedItem());
         v = new Truck(noPass, reg, berths);
         costLabel.setText("Cost is: £"+v.getCost());
       }
    }            
    else if (event.getSource() == empty)
    {
       theFerry.emptyFerry();
       spacesLabel.setText("Spaces left: "+theFerry.spaceLeft());
       cbg.setSelectedCheckbox(checkboxes[0]);
       passChoice.select(0);
       berthsChoice.select(0);
    }
    else if (event.getSource() == quit)
    {
       this.dispose();
       System.exit(0);
    }
    else if (event.getSource() == save)
    {
      warning.setText("Saving ... ");
      try // the following sends messsage save to accounts. ignore try-catch
      { 
        theFerry.save();
      }
      catch (Exception e)
      {
          System.out.println(e);
      }
    }
  }

  public void itemStateChanged(ItemEvent event)
  {
// Do nothing
  }

}

