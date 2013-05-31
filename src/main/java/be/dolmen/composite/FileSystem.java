package be.dolmen.composite;

public class FileSystem {

    private FileSystemEntry root;

    public FileSystem(FileSystemEntry root) {
        this.root = root;
    }

    public int totalSize() {
        return root.totalSize();
    }

    public int countFiles() {
        return root.countFiles();
    }

    public int countDirs() {
        return root.countDirs();
    }

}
