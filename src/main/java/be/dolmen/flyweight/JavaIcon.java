package be.dolmen.flyweight;


import javax.swing.ImageIcon;

public class JavaIcon extends AbstractIcon {

    private ImageIcon icon = new ImageIcon(JavaIcon.class.getResource("/images/source_java.png"));

    @Override
    protected ImageIcon icon(boolean selected) {
        return icon;
    }

}
