package be.dolmen.bridge;

// CONCRETE-IMPLEMENTOR
public class SVGFormat extends ImageFormat {

    @Override
    public void export(Shape shape) {
        System.out.println("SVG export " + shape.draw());
    }

}
