package be.dolmen.bridge;

// ABSTRACTION
public abstract class Shape {

    // bridge pattern says that there has to be a hard reference between abstraction and implementor
    // notice the difference with strategy pattern, which is not a structural pattern, but a behavioral
    private ImageType imageType;

    public void save() {
        imageType.export(this);
    }

    public void setImageType(ImageType imageType) {
        this.imageType = imageType;
    }

    abstract String draw();

}
