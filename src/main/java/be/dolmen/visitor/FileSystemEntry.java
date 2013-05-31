package be.dolmen.visitor;

public abstract class FileSystemEntry {

    private final String name;

    public FileSystemEntry(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract void accept(FileSystemVisitor visitor);

}
