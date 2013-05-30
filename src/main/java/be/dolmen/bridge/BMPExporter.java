package be.dolmen.bridge;

// CONCRETE-IMPLEMENTOR
public class BMPExporter extends ImageExporter {

    @Override
    public void export(Shape shape) {
        System.out.println("BMP export " + shape.draw());
    }

}
