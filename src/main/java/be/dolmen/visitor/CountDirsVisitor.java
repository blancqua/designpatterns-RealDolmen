package be.dolmen.visitor;

class CountDirsVisitor implements FileSystemVisitor {

    private int nrOfDirs;

    @Override
    public void visitFile(File file) {}

    @Override
    public void visitDirectory(Directory directory) {
        nrOfDirs += 1;
    }

    int nrOfDirs() {
        return nrOfDirs;
    }

}
