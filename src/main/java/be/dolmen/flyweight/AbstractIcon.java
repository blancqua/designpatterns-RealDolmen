package be.dolmen.flyweight;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public abstract class AbstractIcon {

    private final int H = 48;

    public void draw(Graphics g, int tx, int ty, String name, boolean sel) {
        ImageIcon icon = icon(sel);

        g.clearRect(tx, ty, icon.getIconWidth(), icon.getIconHeight());
        icon.paintIcon(null, g, tx, ty);
        g.drawString(name, tx, ty + H + 15);
    }

    abstract protected ImageIcon icon(boolean selected);
}
