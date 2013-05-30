package be.dolmen.composite;

public abstract class FileSystemEntry {

    private final String name;

    public FileSystemEntry(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public int totalSize();
    abstract public int countFiles();
    abstract public int countDirs();

}
