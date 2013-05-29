package be.dolmen.proxy;

import java.util.Date;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MapTest extends TestCase {

    private String fileName;
    private final int COUNT = 100000;

    public MapTest(String name) {
        super(name);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(MapTest.class);
        return suite;
    }

    @Override
    public void setUp() throws Exception {
        String sep = System.getProperty("file.separator");
        if (sep.equals("/")) {
            // assume we are on Unix.
            fileName = "/tmp/key_values";
        } // end of if (sep.equals("/"))
        else {
            fileName = "C:\\TEMP\\key_values.txt";
        } // end of else
    }

    public void test1() throws Exception {
        AbstractMap map = new Map(fileName);
    }

    public void test2() throws Exception {
        String value = "Dolmen";
        AbstractMap map = new Map(fileName);
        map.add("name", value);
        String result = map.find("name");
        assertEquals(value, result);
    }

    public void test3() throws Exception {
        // Performance test.
        String value = "Dolmen";
        AbstractMap map = new Map(fileName);
        map.add("name", value);
        System.out.println("\nStarting loop at: " + new Date().toString());
        for (int i = 0; i < COUNT; i++) {
            map.find("name");
        } // end of for (int i = 0; i < COUNT; i++)
        System.out.println("Finished loop at: " + new Date().toString());
    }

    @Override
    public void tearDown() throws Exception {
        //
    }
}
