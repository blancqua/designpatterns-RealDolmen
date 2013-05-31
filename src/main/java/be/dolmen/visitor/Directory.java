package be.dolmen.visitor;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

public class Directory extends FileSystemEntry {

    private final Set<FileSystemEntry> entries = newHashSet();

    public Directory(String name) {
        this(null, name);
    }

    public Directory(FileSystemEntry parent, String name) {
        super(parent, name);
    }

    @Override
    void add(FileSystemEntry entry) {
        entries.add(entry);
    }

    @Override
    void accept(FileSystemVisitor visitor) {
        visitor.visitDirectory(this);

        for (FileSystemEntry entry : entries) {
            entry.accept(visitor);
        }
    }

}
