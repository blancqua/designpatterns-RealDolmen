package be.dolmen.flyweight;

import static be.dolmen.flyweight.IconFactory.iconFactory;
import static com.google.common.collect.Lists.newArrayList;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class FlyweightDemo extends JFrame implements MouseMotionListener {

    private List<Item> items;
    private final int Top = 30, Left = 30;
    private final int W = 50, H = 30;
    private final int VSpace = 80, HSpace = 70, HCount = 3;
    private String selectedName = "";

    private class Item {
        String type;
        String name;
        AbstractIcon icon;

        Item(String type, String name, AbstractIcon icon) {
            this.type = type;
            this.name = name;
            this.icon = icon;
        }
    }

    public FlyweightDemo() {
        super("Flyweight Demo");
        setSize(new Dimension(250, 300));
        JPanel jp = new JPanel();
        getContentPane().add(jp, BorderLayout.CENTER);
        addMouseMotionListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        loadItems();
        setVisible(true);
    }

    private void loadItems() {
        items = newArrayList();
        items.add(new Item("dir", "Folder1", iconFactory().createIcon("dir")));
        items.add(new Item("dir", "Folder2", iconFactory().createIcon("dir")));
        items.add(new Item("dir", "Folder3", iconFactory().createIcon("dir")));
        items.add(new Item("dir", "Folder4", iconFactory().createIcon("dir")));
        items.add(new Item("dir", "Folder5", iconFactory().createIcon("dir")));
        items.add(new Item("java", "Abc1.java", iconFactory().createIcon("java")));
        items.add(new Item("java", "Abc2.java", iconFactory().createIcon("java")));
        items.add(new Item("pdf", "Pdf1.java", iconFactory().createIcon("pdf")));
        items.add(new Item("pdf", "Pdf2.java", iconFactory().createIcon("pdf")));
        items.add(new Item("txt", "Text1.java", iconFactory().createIcon("txt")));
        items.add(new Item("txt", "Text2.java", iconFactory().createIcon("txt")));
        items.add(new Item("picture", "Picture.png", iconFactory().createIcon("picture")));
        items.add(new Item("html", "index.html", iconFactory().createIcon("html"))); // unknown
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //Folder f;
        int j = 0; //count number in row
        int row = Top; //start in upper left
        int x = Left;
        //go through all the items
        for (Item item : items) {
            // Get next item, and draw its icon and name:
            item.icon.draw(g, x, row, item.name, item.name.equals(selectedName));

            // Recalculation of part of the extrinsic state:
            x = x + HSpace; //change to next posn
            j++;
            if (j >= HCount) { //reset for next row
                j = 0;
                row += VSpace;
                x = Left;
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int j = 0; //count number in row
        int row = Top; //start in upper left
        int x = Left;
        //go through all the items
        for (int i = 0; i < items.size(); i++) {
            //see if this item area contains the mouse
            Rectangle r = new Rectangle(x, row, W, H);
            if (r.contains(e.getX(), e.getY())) {
                String currentName = items.get(i).name;
                if (selectedName == null || !selectedName.equals(currentName)) {
                    selectedName = currentName;
                    repaint();
                }
            }
            x = x + HSpace; //change to next posn
            j++;
            if (j >= HCount) { //reset for next row
                j = 0;
                row += VSpace;
                x = Left;
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    public static void main(String[] args) {
        new FlyweightDemo();
    }
}