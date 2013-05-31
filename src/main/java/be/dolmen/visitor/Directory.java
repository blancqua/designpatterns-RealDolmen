package be.dolmen.visitor;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

public class Directory extends FileSystemEntry {

    private final Set<FileSystemEntry> entries = newHashSet();

    public Directory(String name) {
        super(name);
    }

    @Override
    void accept(FileSystemVisitor visitor) {
        visitor.visitDirectory(this);

        for (FileSystemEntry entry : entries) {
            entry.accept(visitor);
        }
    }

}
