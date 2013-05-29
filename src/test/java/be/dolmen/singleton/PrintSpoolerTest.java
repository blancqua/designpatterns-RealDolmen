package be.dolmen.singleton;

import static be.dolmen.singleton.PrintSpooler.printSpooler;
import static java.util.UUID.randomUUID;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.reflect.core.Reflection.field;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import be.dolmen.AbstractTest;

public class PrintSpoolerTest extends AbstractTest {

    private static final String DOCUMENT = "document";
    private static final UUID PRINTER_ID = randomUUID();
    private static final PrintJob PRINT_JOB = new PrintJob(PRINTER_ID, DOCUMENT);

    @Mock
    private Printer printer;

    @Before
    public void setUp() {
        when(printer.getId()).thenReturn(PRINTER_ID);
    }

    @Before
    public void unregisterPrinters() {
        field("registeredPrinters").ofType(Map.class).in(printSpooler()).get().clear();
    }

    @Test
    public void isSingleTon() throws Exception {
        PrintSpooler actual = printSpooler();

        assertThat(actual).isNotNull();
        assertThat(actual).isEqualTo(printSpooler());
    }

    @Test
    public void print_whenRegistered() throws Exception {
        printSpooler().register(printer);
        printSpooler().dispatch(PRINT_JOB);

        verify(printer).print(DOCUMENT);
    }

    @Test(expected = IllegalStateException.class)
    public void print_whenNotRegistered() throws Exception {
        printSpooler().dispatch(PRINT_JOB);
    }

}
