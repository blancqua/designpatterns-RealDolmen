package be.dolmen.flyweight;

import javax.swing.ImageIcon;

public class TextIcon extends AbstractIcon {

    private ImageIcon icon = new ImageIcon(PictureIcon.class.getResource("/images/txt.png"));

    @Override
    protected ImageIcon icon(boolean selected) {
        return icon;
    }
}
