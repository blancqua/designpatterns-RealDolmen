package be.dolmen.visitor;

public class File extends FileSystemEntry {

    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    void accept(FileSystemVisitor visitor) {
        visitor.visitFile(this);
    }

    int getSize() {
        return size;
    }

}
