package be.dolmen.bridge;

// CONCRETE-IMPLEMENTOR
public class BMPFormat extends ImageFormat {

    @Override
    public void export(Shape shape) {
        System.out.println("BMP export " + shape.draw());
    }

}
