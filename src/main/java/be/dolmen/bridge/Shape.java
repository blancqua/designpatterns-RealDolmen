package be.dolmen.bridge;

// ABSTRACTION
public abstract class Shape {

    // bridge pattern says that there has to be a hard reference between abstraction and implementor
    // notice the difference with strategy pattern, which is not a structural pattern, but a behavioral
    private ImageExporter exporter;

    public void save() {
        exporter.export(this);
    }

    public void setImageType(ImageType imageType) {
        this.exporter = imageType.getExporter();
    }

    abstract String draw();

}
