package be.dolmen.visitor;

public class FileSystem {

    private FileSystemEntry root;

    public FileSystem(FileSystemEntry root) {
        this.root = root;
    }

    public int totalSize() {
        TotalSizeVisitor visitor = new TotalSizeVisitor();
        root.accept(visitor);
        return visitor.totalSize();
    }

    public int countFiles() {
        CountFilesVisitor visitor = new CountFilesVisitor();
        root.accept(visitor);
        return visitor.nrOfFiles();
    }

    public int countDirs() {
        CountDirsVisitor visitor = new CountDirsVisitor();
        root.accept(visitor);
        return visitor.nrOfDirs();
    }

    public void dir() {
        DirVisitor visitor = new DirVisitor();
        root.accept(visitor);
    }

}
