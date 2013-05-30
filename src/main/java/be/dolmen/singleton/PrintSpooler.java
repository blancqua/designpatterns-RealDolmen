package be.dolmen.singleton;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;
import java.util.UUID;

// SINGLETON
public class PrintSpooler {

    private static PrintSpooler PRINT_SPOOLER;

    private final Map<UUID, Printer> registeredPrinters = newHashMap();

    private PrintSpooler() {}

    public static synchronized PrintSpooler printSpooler() {
        if (PRINT_SPOOLER == null) {
            PRINT_SPOOLER = new PrintSpooler();
        }

        return PRINT_SPOOLER;
    }

    public synchronized void register(Printer... printers) {
        for (Printer printer : printers) {
            registeredPrinters.put(printer.getId(), printer);
        }
    }

    public synchronized void dispatch(PrintJob printJob) {
        printer(printJob.getPrinterId()).print(printJob.getDocument());
    }

    private Printer printer(UUID printerId) {
        Printer printer = registeredPrinters.get(printerId);
        if (printer != null) {
            return printer;
        }

        throw new IllegalStateException("No printer found with id " + printerId);
    }

}
