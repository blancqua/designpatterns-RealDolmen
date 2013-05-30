package be.dolmen.composite;

import static be.dolmen.mapreduce.Reducer.sum;
import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import com.google.common.base.Function;

public class Directory extends FileSystemEntry {

    private final Set<FileSystemEntry> entries = newHashSet();

    public Directory(String name) {
        super(name);
    }

    @Override
    public int countFiles() {
        return sum(transform(entries, nrOfFiles()));
    }

    @Override
    public int countDirs() {
        return sum(transform(entries, nrOfDirs())) + 1;
    }

    @Override
    public int totalSize() {
        return sum(transform(entries, toTotalSize()));
    }

    private Function<FileSystemEntry, Integer> nrOfFiles() {
        return new Function<FileSystemEntry, Integer> () {
            @Override
            public Integer apply(FileSystemEntry input) {
                return input.countFiles();
            }
        };
    }

    private Function<FileSystemEntry, Integer> nrOfDirs() {
        return new Function<FileSystemEntry, Integer> () {
            @Override
            public Integer apply(FileSystemEntry input) {
                return input.countDirs();
            }
        };
    }

    private Function<FileSystemEntry, Integer> toTotalSize() {
        return new Function<FileSystemEntry, Integer> () {
            @Override
            public Integer apply(FileSystemEntry input) {
                return input.totalSize();
            }
        };
    }

}
