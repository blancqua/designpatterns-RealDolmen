package be.dolmen.flyweight;

import javax.swing.ImageIcon;

public class PictureIcon extends AbstractIcon {

    private ImageIcon icon = new ImageIcon(PictureIcon.class.getResource("/images/picture.png"));

    @Override
    protected ImageIcon icon(boolean selected) {
        return icon;
    }

}
