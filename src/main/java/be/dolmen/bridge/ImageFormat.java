package be.dolmen.bridge;

// IMPLEMENTOR
public abstract class ImageFormat {

    private static final ImageFormat DEFAULT = new BMPFormat();

    public static ImageFormat getDefault() {
        return DEFAULT;
    }

    abstract public void export(Shape shape);

}
