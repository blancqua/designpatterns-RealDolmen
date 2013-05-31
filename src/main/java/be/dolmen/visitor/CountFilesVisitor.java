package be.dolmen.visitor;

class CountFilesVisitor implements FileSystemVisitor {

    private int nrOfFiles;

    @Override
    public void visitFile(File file) {
        nrOfFiles += 1;
    }

    @Override
    public void visitDirectory(Directory directory) {}

    int nrOfFiles() {
        return nrOfFiles;
    }

}
