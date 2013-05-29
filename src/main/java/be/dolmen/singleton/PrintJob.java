package be.dolmen.singleton;

import java.io.Serializable;
import java.util.UUID;

@SuppressWarnings("serial")
public class PrintJob implements Serializable {

    private final UUID printerId;
    private final String document;

    public PrintJob(UUID printerId, String document) {
        this.printerId = printerId;
        this.document = document;
    }

    public UUID getPrinterId() {
        return printerId;
    }

    public String getDocument() {
        return document;
    }

}
