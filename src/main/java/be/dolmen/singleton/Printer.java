package be.dolmen.singleton;

import java.util.UUID;

public abstract class Printer {

    private final UUID id = UUID.randomUUID();

    public UUID getId() {
        return id;
    }

    abstract void print(String document);

}
