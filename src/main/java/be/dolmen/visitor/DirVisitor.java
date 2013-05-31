package be.dolmen.visitor;

class DirVisitor implements FileSystemVisitor {

    @Override
    public void visitFile(File file) {
        System.out.println(whiteSpace(file) + "FILE " + file.getName());
    }

    @Override
    public void visitDirectory(Directory directory) {
        System.out.println(whiteSpace(directory) + "DIRECTORY " + directory.getName());
    }

    private String whiteSpace(FileSystemEntry entry) {
        StringBuilder builder = new StringBuilder();

        FileSystemEntry parent = entry.getParent();
        while (parent != null) {
            builder.append("\t");
            parent = parent.getParent();
        }

        return builder.toString();
    }

}
