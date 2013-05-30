package be.dolmen.bridge;

// CONCRETE-IMPLEMENTOR
public class PNGFormat extends ImageFormat {

    @Override
    public void export(Shape shape) {
        System.out.println("PNG export " + shape.draw());
    }

}
