package be.dolmen.flyweight;



import javax.swing.ImageIcon;

public class PdfIcon extends AbstractIcon {

    private ImageIcon icon = new ImageIcon(PdfIcon.class.getResource("/images/pdf.png"));

    @Override
    protected ImageIcon icon(boolean selected) {
        return icon;
    }

}
