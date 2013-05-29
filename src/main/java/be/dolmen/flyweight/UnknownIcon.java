package be.dolmen.flyweight;


import java.awt.*;
import javax.swing.*;
import java.net.URL;

public class UnknownIcon extends AbstractIcon {

    private final int H = 48;
    private ImageIcon icon;


    // We make this package-visible so that only the corresponding
    // factory can instantiate us.
    UnknownIcon() {
	URL iconURL =
	    ClassLoader.getSystemResource("images/unknown.png");
	if (iconURL != null) {
	    icon = new ImageIcon(iconURL);
	} else {
	    System.out.println("Icon images/unknown.png not found");
	}
    }

    public void draw(Graphics g, int tx, int ty, String name, boolean sel) {
        //g.clearRect(tx, ty, icon.getIconWidth(), icon.getIconHeight());
	icon.paintIcon(null, g, tx, ty);
        g.drawString(name, tx, ty + H + 15);  //title
    }
}
