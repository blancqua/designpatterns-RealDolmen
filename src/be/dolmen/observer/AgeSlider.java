package be.dolmen.observer;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AgeSlider extends JFrame implements ActionListener//, Observer
{
    protected JButton qbutton;
    protected JPanel panel1;
    protected JLabel al;
    protected JSlider js;
    
    protected Person aperson;
    
    public AgeSlider(String title, Person p) {
	super(title);

        aperson = p;

        // register as an observer of person
        // p.attach(this);

	qbutton = new JButton("Quit");
	qbutton.addActionListener(this);
	
	al = new JLabel("Age: " + aperson.getAge());
	
	js = new JSlider(0, 100, aperson.getAge());
	js.addChangeListener(new SliderListener());
	panel1 = new JPanel();
	
	panel1.setLayout(new GridLayout(3,1)); 
	
	
	panel1.add(qbutton);
	panel1.add(js);
	panel1.add(al);
	
	this.getContentPane().add("Center",panel1);
	this.pack();
    }

    //inner class to listen to slider
    class SliderListener implements ChangeListener {
	public void stateChanged(ChangeEvent e) {
	    // only one component could have done this 
	    //so get value from slider
	    aperson.setAge(js.getValue());
	}    
    }
    
    public void actionPerformed(ActionEvent event) {
	if (event.getSource() == qbutton) {
	    this.dispose();
	    System.exit(0);
	}
    }
    
    // update slider with changed age value
    public void update() {
        js.setValue(aperson.getAge());
	al.setText("Age: " + aperson.getAge());
    }
}



