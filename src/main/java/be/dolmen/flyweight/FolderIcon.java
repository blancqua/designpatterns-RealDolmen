package be.dolmen.flyweight;

import javax.swing.ImageIcon;

public class FolderIcon extends AbstractIcon {

    private ImageIcon iconUnsel = new ImageIcon(FolderIcon.class.getResource("/images/folder.png"));
    private ImageIcon iconSel = new ImageIcon(FolderIcon.class.getResource("/images/folder_open.png"));

    @Override
    protected ImageIcon icon(boolean selected) {
        return selected ? iconSel : iconUnsel;
    }

}
