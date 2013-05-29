package be.dolmen.flyweight;

import java.awt.*;
import javax.swing.*;
import java.net.URL;

public class FolderIcon extends AbstractIcon {

    private final int H = 48;
    private ImageIcon iconSel;
    private ImageIcon iconUnsel;

    // We make this package-visible so that only the corresponding
    // factory can instantiate us.
    FolderIcon() {
	URL iconURL =
	    ClassLoader.getSystemResource("images/folder_open.png");
	if (iconURL != null) {
	    iconSel = new ImageIcon(iconURL);
	} else {
	    System.out.println("Icon images/folder_open.png not found");
	}
	iconURL =
	    ClassLoader.getSystemResource("images/folder.png");
	if (iconURL != null) {
	    iconUnsel = new ImageIcon(iconURL);
	} else {
	    System.out.println("Icon images/folder.png not found");
	}
    }

    public void draw(Graphics g, int tx, int ty, String name, boolean sel) {
        g.clearRect(tx, ty, iconSel.getIconWidth(), iconSel.getIconHeight());
        g.clearRect(tx, ty, iconUnsel.getIconWidth(), iconUnsel.getIconHeight());
	if (sel) {
	    iconSel.paintIcon(null, g, tx, ty);
	} else {
	    iconUnsel.paintIcon(null, g, tx, ty);
	}
        g.drawString(name, tx, ty + H + 15);  //title
    }
}
