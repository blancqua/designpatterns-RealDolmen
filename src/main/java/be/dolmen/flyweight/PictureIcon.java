package be.dolmen.flyweight;

import java.awt.*;
import javax.swing.*;
import java.net.URL;

public class PictureIcon extends AbstractIcon {

    private final int H = 48;
    private ImageIcon icon;


    // COMPLETE.


    public void draw(Graphics g, int tx, int ty, String name, boolean sel) {
        //g.clearRect(tx, ty, icon.getIconWidth(), icon.getIconHeight());
	icon.paintIcon(null, g, tx, ty);
        g.drawString(name, tx, ty + H + 15);  //title
    }
}
