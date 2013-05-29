package be.dolmen.singleton;

import static be.dolmen.singleton.PrintSpooler.printSpooler;

public class PrintClient {

    public static void main(String[] args) {
        BlackAndWhitePrinter blackAndWhitePrinter = new BlackAndWhitePrinter();
        ColorPrinter colorPrinter = new ColorPrinter();

        printSpooler().register(blackAndWhitePrinter);
        printSpooler().register(colorPrinter);

        printSpooler().dispatch(new PrintJob(blackAndWhitePrinter.getId(), "black and white content"));
        printSpooler().dispatch(new PrintJob(colorPrinter.getId(), "color content"));
    }

}
