package be.dolmen.bridge;

public enum ImageType {

    PNG(new PNGExporter()),
    BMP(new BMPExporter()),
    SVG(new SVGExporter()),
    WebP(new WebPExporter());

    private final ImageExporter exporter;

    private ImageType(ImageExporter exporter) {
        this.exporter = exporter;
    }

    public void export(Shape shape) {
        exporter.export(shape);
    }

}
