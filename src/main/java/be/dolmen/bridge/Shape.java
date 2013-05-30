package be.dolmen.bridge;

// ABSTRACTION
public abstract class Shape {

    public void save() {
        ImageFormat.getDefault().export(this);
    }

    abstract String draw();

}
