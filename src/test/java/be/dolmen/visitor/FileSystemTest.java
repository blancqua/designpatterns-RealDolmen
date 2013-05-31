package be.dolmen.visitor;

import org.junit.Before;
import org.junit.Test;
import org.unitils.inject.annotation.TestedObject;

public class FileSystemTest {

    @TestedObject
    private FileSystem fileSystem;

    @Before
    public void setUp() {
        Directory root = new Directory("root");
        Directory subdir1 = new Directory(root, "subdir1");
        Directory subdir2 = new Directory(root, "subdir2");
        new File(subdir1, "file1", 1);
        new File(subdir2, "file2", 2);
        new File(root, "file3", 3);
        new File(root, "file4", 4);

        fileSystem = new FileSystem(root);
    }

    @Test
    public void dir() throws Exception {
        fileSystem.dir();
    }
}
