package be.dolmen.visitor;

class TotalSizeVisitor implements FileSystemVisitor {

    private int totalSize;

    @Override
    public void visitFile(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visitDirectory(Directory directory) {}

    int totalSize() {
        return totalSize;
    }

}
