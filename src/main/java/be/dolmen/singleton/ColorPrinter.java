package be.dolmen.singleton;


public class ColorPrinter extends Printer {

    @Override
    public void print(String document) {
        System.err.println(document);
    }

}
