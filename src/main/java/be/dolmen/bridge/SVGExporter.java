package be.dolmen.bridge;

// CONCRETE-IMPLEMENTOR
public class SVGExporter extends ImageExporter {

    @Override
    public void export(Shape shape) {
        System.out.println("SVG export " + shape.draw());
    }

}
