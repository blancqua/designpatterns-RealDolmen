package be.dolmen.bridge;

// CONCRETE-IMPLEMENTOR
public class PNGExporter extends ImageExporter {

    @Override
    public void export(Shape shape) {
        System.out.println("PNG export " + shape.draw());
    }

}
