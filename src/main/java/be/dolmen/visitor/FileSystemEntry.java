package be.dolmen.visitor;

public abstract class FileSystemEntry {

    private FileSystemEntry parent;
    private final String name;

    public FileSystemEntry(FileSystemEntry parent, String name) {
        this.parent = parent;
        this.name = name;

        if (parent != null) {
            parent.add(this);
        }
    }

    public FileSystemEntry getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    abstract void add(FileSystemEntry entry);
    abstract void accept(FileSystemVisitor visitor);

}
