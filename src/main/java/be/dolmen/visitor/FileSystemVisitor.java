package be.dolmen.visitor;

interface FileSystemVisitor {

    void visitFile(File file);
    void visitDirectory(Directory directory);

}
