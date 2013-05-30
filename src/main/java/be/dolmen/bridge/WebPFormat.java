package be.dolmen.bridge;

// CONCRETE-IMPLEMENTOR
public class WebPFormat extends ImageFormat {

    @Override
    public void export(Shape shape) {
        System.out.println("WebP export " + shape.draw());
    }

}
