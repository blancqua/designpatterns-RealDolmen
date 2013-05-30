package be.dolmen.bridge;

// CONCRETE-IMPLEMENTOR
public class WebPExporter extends ImageExporter {

    @Override
    public void export(Shape shape) {
        System.out.println("WebP export " + shape.draw());
    }

}
