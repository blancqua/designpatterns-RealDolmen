package be.dolmen.flyweight;


import javax.swing.ImageIcon;

public class UnknownIcon extends AbstractIcon {

    private ImageIcon icon = new ImageIcon(UnknownIcon.class.getResource("/images/unknown.png"));

    @Override
    protected ImageIcon icon(boolean selected) {
        return icon;
    }

}
