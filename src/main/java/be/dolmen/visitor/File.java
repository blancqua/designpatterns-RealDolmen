package be.dolmen.visitor;

public class File extends FileSystemEntry {

    private int size;

    public File(FileSystemEntry parent, String name, int size) {
        super(parent, name);
        this.size = size;
    }

    int getSize() {
        return size;
    }

    @Override
    void add(FileSystemEntry entry) {}

    @Override
    void accept(FileSystemVisitor visitor) {
        visitor.visitFile(this);
    }

}
