package be.dolmen.observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PDemoSwing extends JFrame implements ActionListener
{


    protected JButton qbutton;
    protected JPanel panel1, panel2, panel3;
    protected JLabel lb,fnl,snl,al;
    protected JMenuBar menubar1;
    protected JMenu menu1;
    protected JMenuItem about;
    
    protected Person aperson;
    
    public PDemoSwing(String title) {
	super(title);
	
	aperson = new Person("Ivor", "Pattern", 34);
	
	menubar1 = new JMenuBar();
	
	// add MenuBar to Frame
	this.setJMenuBar(menubar1);
	
	menu1 = new JMenu("Info");
	
	about = new JMenuItem("About");
	about.addActionListener(this);
	menu1.add(about);
	
	menubar1.add(menu1);
	
	qbutton = new JButton("Quit");
	qbutton.addActionListener(this);
	
	lb = new JLabel("Person Details");
	fnl = new JLabel("Forename: " + aperson.getForename());
	snl = new JLabel("Surname: " + aperson.getSurname());
	al = new JLabel("Age: " + aperson.getAge());
	
	panel1 = new JPanel();
	
	panel2 = new JPanel();
	panel2.setLayout(new GridLayout(3,1)); 
	
	
	panel1.add(qbutton);
	
	panel2.add(fnl);
	panel2.add(snl);
	panel2.add(al);
	
	
	this.getContentPane().add("North",lb);
	this.getContentPane().add("South",panel1);
	this.getContentPane().add("Center",panel2);
	this.pack();
    }
    
    public void actionPerformed(ActionEvent event) {
	if (event.getSource() == qbutton)
	    {
		this.dispose();
		System.exit(0);
	    }
	else if (event.getSource() == about)
	    {
		lb.setText("GUI for Person");
	    }
    }
    
    public static void main(String args[]) {
	PDemoSwing pfr = new PDemoSwing("Person GUI");
	pfr.setLocation(200,200);
	pfr.setVisible(true);
    }
    
}



