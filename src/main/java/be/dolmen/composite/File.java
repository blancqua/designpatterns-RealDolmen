package be.dolmen.composite;

public class File extends FileSystemEntry {

    private int size;

    public File(String name, int size) {
        super(name);
        this.size = size;
    }

    @Override
    public int totalSize() {
        return size;
    }

    @Override
    public int countFiles() {
        return 1;
    }

    @Override
    public int countDirs() {
        return 0;
    }

}
